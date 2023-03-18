<!-- Q&A 페이지 -->

<template>
  <div class="black-bg" v-if="모달창열렸니 == true">
    <div class="white-bg">
      <table>
        <thead>
          <tr>
            <th class="jb-th-1">번호</th>
            <th class="jb-th-2">회사이름</th>
          </tr>
        </thead>
        <tr v-for="(item, index) in list" :key="index">
          <td>{{ item.com_ceo }}</td>
          <td>{{ item.com_postcode }}</td>
        </tr>
      </table>
      <button @click="모달창열렸니 = false">닫기</button>
    </div>
  </div>

  <section>
    <div class="main">
      <div class="container">
        <h3>기업관리</h3>

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
              <th class="q">인가</th>
            </tr>
          </thead>
          <tbody class="body">
            <tr v-for="(item, index) in list" v-bind:key="index">
              <td>{{item.c_no}}</td>
              <td>
                <a @click="모달창열렸니 = true">{{ item.com_name }}</a>
              </td>
              <td class="date">{{ item.com_Application_date }}</td>
              <td>
                <button class="btn" @click="yesbtn(item.com_id)">승인</button>
                <div class="space"></div>
                <button @click="nobtn(item.com_id)">거절</button>
              </td>
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
            <router-link :to="{path: '/19/?page=1&amount='+amount}" @click="goFirstPage">
              <i class="fa fa-angle-double-left" aria-hidden="true">&lt;&lt;</i>
            </router-link>
          </li>

          <!-- 앞으로 가기 -->
            <li style="margin-right:5px;">
              <router-link :to="{path: '/19?page='+page+'&amount='+amount}" @click="goBeforePage">
                <i class="fa fa-angle-left" aria-hidden="true">&lt;</i>
              </router-link>
            </li>

           <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
          <div v-for="(item, index) in pageList" :key="index" class="page_btn">
            <li v-bind:class="{ 'on' : item === page}">
              <router-link :to="{path: '/19?page='+page+'&amount='+amount}" @click="thisPage($event.target)">
                {{item}}
              </router-link>
            </li>
          </div>              

          <!-- 뒤로 가기 -->
					<li style="margin-left:5px;">
            <router-link :to="{path: '/19?page='+page+'&amount='+amount}" @click="goNextPage">
              <i class="fa fa-angle-right" aria-hidden="true">></i>
            </router-link>
          </li>

          <!-- 맨뒤로 가기 -->
					<li>
            <router-link :to="{path: '/19?page='+realEnd+'&amount='+amount}" @click="goLastPage">
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
      모달창열렸니: false,
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

    yesbtn(com_id) {
      if (confirm("승인하시겠습니까?")) {
        Axios.post("/19/2", { com_id: com_id })
          .then((res) => {
            alert("승인되었습니다.");
            this.$router.go("/19");
          })
          .catch((err) => console.log(err));
      }
    },

    nobtn(com_id) {
      if (confirm("반려?")) {
        Axios.post("/19/3", { com_id: com_id })
          .then((res) => {
            alert("반려되었습니다.");
            this.$router.go("/19");
          })
          .catch((err) => console.log(err));
      }
    },

    async get() {
      let res = await Axios.get(
         "/19/1/?amount=" +
          this.amount +
          "&page=" +
          this.page +
          "&searchTitle=" +
          this.searchTitle +
          "&searchContent=" +
          this.searchContent
      );
      this.list = res.data.list;
      console.log(this.list);

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
* {
  margin: 0;
  padding: 0;
}

@import url("https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap");
* {
  padding: 0;
  margin: 0;
  font-family: "Noto Sans KR", sans-serif;
  text-decoration: none;
  box-sizing: border-box;
}

.main {
  margin: 100px 0 0 200px;
  padding: 30px;
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

.q {
  color: #f9f9f9;
}

.space {
  width: 10px;
  height: auto;
  display: inline-block;
}

.date {
  text-align: center;
}

div {
  box-sizing: border-box;
}

.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 20px;
}

.white-bg {
  width: 50%;
  height: 300px;
  background: white;
  border-radius: 8px;
  padding: 20px;
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
