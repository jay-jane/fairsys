Q&A 페이지

<template>
  <section>
    <div class="main">
      <div class="container">
        <h1>기업목록</h1>

        <select v-model="amount" class="view" @change="loglist_view">
          <option value="10">10개씩 보기</option>
          <option value="30">30개씩 보기</option>
          <option value="50">50개씩 보기</option>
          <option value="100">100개씩 보기</option>
        </select>

        <table class="list">
          <thead class="head">
            <tr>
              <th class="q">번호</th>
              <th class="q">회사이름</th>
              <th class="q">신청일자</th>
              <th class="q">승인일자</th>
            </tr>
          </thead>
          <tbody class="body">
            <tr v-for="(item, index) in list" v-bind:key="index">
              <td>{{ item.c_no}}</td>
              <td>{{ item.com_name }}</td>
              <td>{{ item.com_Application_date }}</td>
              <td>{{ item.com_registration_date }}</td>
            </tr>
          </tbody>
        </table>

      <div class="serch_box">

        <select name="" id="">
            <option value="title">회사이름</option>
        </select>

        <input type="text"  >
        <button @click="search($event.target)">검색</button>

      </div>





        <!-- 페이지 이동 -->
      <div class="page">
        <ul>
          <li>
            <!-- 맨앞으로 가기 -->
            <router-link :to="{path: '/18/?page=1&amount='+amount}" @click="goFirstPage">
              <i class="fa fa-angle-double-left" aria-hidden="true">&lt;&lt;</i>
            </router-link>
          </li>

          <!-- 앞으로 가기 -->
            <li style="margin-right:5px;">
              <router-link :to="{path: '/18/?page='+page+'&amount='+amount}" @click="goBeforePage">
                <i class="fa fa-angle-left" aria-hidden="true">&lt;</i>
              </router-link>
            </li>

           <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
          <div v-for="(item, index) in pageList" :key="index" class="page_btn">
            <li v-bind:class="{ 'on' : item === page}">
              <router-link :to="{path: '/18/?page='+page+'&amount='+amount}" @click="thisPage($event.target)">
                {{item}}
              </router-link>
            </li>
          </div>              

          <!-- 뒤로 가기 -->
					<li style="margin-left:5px;">
            <router-link :to="{path: '/18/?page='+page+'&amount='+amount}" @click="goNextPage">
              <i class="fa fa-angle-right" aria-hidden="true">></i>
            </router-link>
          </li>

          <!-- 맨뒤로 가기 -->
					<li>
            <router-link :to="{path: '/18/?page='+realEnd+'&amount='+amount}" @click="goLastPage">
              <i class="fa fa-angle-double-right" aria-hidden="true">>></i>
            </router-link>
          </li>

				</ul>
			</div>

      </div>
    </div>
  </section>
</template>

<script>
import Axios from "axios";

export default {
  name: "App",

  data() {
    return {
      list: "",
      pages: "", //pageVO
      pageList: "", //pageVO.pageList 배열값
      detailNum: "",

      //페이지이동에 필요한 초기값들
      page: 1,
      amount: 10,
      searchTitle: "",
      searchContent: "",
      prev: "",
      pageStart: "",
      pageEnd: "",
      realEnd: "",
    };
  },

  watch: {
    amount: function () {
      this.get();
    },
  },
  methods: {
    logout() {
      location.href = "/3";
    },
    async get() {
      
      let res = await Axios.get(
        "/18/?amount=" +
          this.amount +
          "&page=" +
          this.page +
          "&searchTitle=" +
          this.searchTitle +
          "&searchContent=" +
          this.searchContent
      );
      this.list = res.data.list;
     

      this.pages = res.data.pageVO;
      this.pageList = this.pages.pageList;

      //페이지이동에 필요한 데이터 담기
      this.page = this.pages.page;
      this.searchTitle = this.pages.cri.searchTitle;
      this.searchContent = this.pages.cri.searchContent;
      this.prev = this.pages.prev;
      this.pageStart = this.pages.pageStart;
      this.pageEnd = this.pages.pageEnd;
      this.realEnd = this.pages.realEnd;
    },
    loglist_view() {
      this.amount = this.amount;
    },

    goFirstPage() {
      this.page = 1;
      this.get();
    },

    goBeforePage() {
      if (this.page > 1) {
        this.page = this.page - 1;
      } else {
        alert("첫번째 페이지입니다.");
      }
    },

    thisPage(target) {
      this.page = target.innerHTML;
      this.get();
    },

    goNextPage() {
      if (this.page < this.realEnd) {
        this.page = this.page + 1;
        this.get();
      } else {
        alert("마지막 페이지입니다.");
      }
    },

    goLastPage() {
      this.page = this.realEnd;
      this.get();
    },

    search(target){ //검색버튼 선택

      const userselect = target.previousElementSibling.previousElementSibling.value;
      const usertext = target.previousElementSibling.value;
      
      if(userselect === "title"){
        this.searchTitle = usertext;
        this.get();
      }
      

    }
  },
  mounted() {
    this.get();
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap");
* {
  padding: 0;
  margin: 0;
  font-family: "Noto Sans KR", sans-serif;
  text-decoration: none;
  box-sizing: border-box;
}

.main {
  margin: 100px 0 0 0;
  /* padding: 30px; */
}

.container {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
}

.container select {
  float: left;
  margin: 10px 0;
}

.searchBox {
  float: right;
  margin: 10px 0;
}

.list {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
}

.head {
  background-color: #263238;
  text-align: center;
}

.q {
  color: #f9f9f9;
}
.head th {
  padding: 1em;
}

.body tr:nth-child(even) {
  background-color: #f9f9f9;
}

.body td {
  padding: 1em;
  text-align: center;
  border-bottom: 1px solid #ddd;
}

.body td a {
  color: #333;
  text-decoration: none;
}

.body td a:hover {
  text-decoration: underline;
}

.page {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}

.page ul {
  display: flex;
  align-items: center;
  list-style: none;
}

.page li {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  font-size: 14px;
  margin: 0 5px;
  cursor: pointer;
  background-color: #fff;
  border: 1px solid #ccc;
}

.page li.on {
  font-weight: bold;
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
}

.page i {
  font-size: 14px;
  margin: 0;
  padding: 0;
  line-height: 1;
}

.page_btn {
  display: flex;
  justify-content: center;
  align-items: center;
}



  .serch_box{
    margin-top: 20px;
    display: flex;
    justify-content: space-around;
  }

  .serch_box select,input,button{
    padding: 5px;
    margin: 5px;
  }

  .serch_box input{
    width: 50%;
    border-radius: 35px;
    border: 1px solid #ddd;
  }

  .serch_box button {
    width: 10%;
    background-color: orange;
    border: none;
    color: white;
    font-size: 16px;
  }

</style>
