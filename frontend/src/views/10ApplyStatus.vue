
<template>
  <div class="hw_main">
    <div class="hw_container">

      <h2>지원 현황</h2>

      <!-- 출력 카테고리 -->
      <select v-model="amount" class="hw_view" @change="loglist_view">
        <option value="10">10개 보기</option>
        <option value="20">20개 보기</option>
        <option value="30">30개 보기</option>
      </select>


      <table class="hw_list">
        <thead class="hw_head">
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>성별</th>
            <th>조회</th>
            <th>합격여부</th>
          </tr>
        </thead>

        <tbody class="hw_body">

          <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
          <tr v-for="(item, index) in list" v-bind:key="index">
            <td>{{ index+1}}</td>
            <td>{{ item.user_name }}</td>
            <td>{{ item.user_gender }}</td>
            <td @click.prevent="ResumeModify(item.user_no)">이력서열람</td>
            <td>{{ item.status }}</td>
          </tr>
        </tbody>
      </table>

      <div class="hw_search_box">

        <select name="" id="">
          <option value="title">이름</option>
          <option value="status">상태</option>
        </select>

        <input type="text">
        <button @click="search($event.target)">검색</button>

      </div>

      <!-- 페이지 이동 -->
      <div class="hw_page">
        <ul>
          <li>
            <!-- 맨앞으로 가기 -->
            <router-link :to="{ path: '/ApplyStatus/?page=1&amount=' + amount }" @click="goFirstPage">
              <i class="fa fa-angle-double-left" aria-hidden="true">&lt;&lt;</i>
            </router-link>
          </li>

          <!-- 앞으로 가기 -->
          <li style="margin-right:5px;">
            <router-link :to="{ path: '/ApplyStatus/?page=' + page + '&amount=' + amount }" @click="goBeforePage">
              <i class="fa fa-angle-left" aria-hidden="true">&lt;</i>
            </router-link>
          </li>

          <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
          <div v-for="(item, index) in pageList" :key="index" class="page_btn">
            <li v-bind:class="{ 'on': item === page }">
              <router-link :to="{ path: '/ApplyStatus/?page=' + page + '&amount=' + amount }"
                @click="thisPage($event.target)">
                {{ item }}
              </router-link>
            </li>
          </div>

          <!-- 뒤로 가기 -->
          <li style="margin-left:5px;">
            <router-link :to="{ path: '/ApplyStatus/?page=' + page + '&amount=' + amount }" @click="goNextPage">
              <i class="fa fa-angle-right" aria-hidden="true">></i>
            </router-link>
          </li>

          <!-- 맨뒤로 가기 -->
          <li>
            <router-link :to="{ path: '/ApplyStatus/?page=' + realEnd + '&amount=' + amount }" @click="goLastPage">
              <i class="fa fa-angle-double-right" aria-hidden="true">>></i>
            </router-link>
          </li>

        </ul>
      </div>

    </div>
  </div>
</template>

<script>
import Axios from 'axios';

export default {
  el: '#App',
  data() {
    return {

      //공용

      pages: '',   //pageVO
      pageList: '',  //pageVO.pageList 배열값
      detailNum: '',

      //페이지이동에 필요한 초기값들
      page: 1,
      amount: 10,
      searchTitle: '',
      searchStatus: '',
      searchContent: '',
      prev: '',
      pageStart: '',
      pageEnd: '',
      realEnd: '',

      list: [],    //게시글리스트
    }
  },

  watch: {
    'amount': function () {
      this.get();
    }
  },

  methods: {

    async get() {
      //console.log(this.list_view);

      //화면에 리스트 출력을 위해 필요한 내용 전달
      let response = await Axios.get("/ApplyStatus/?amount=" + this.amount + "&page=" + this.page + "&searchTitle=" + this.searchTitle + "&searchStatus=" + this.searchStatus + "&searchContent=" + this.searchContent,
        {
          params: { com_id: sessionStorage.getItem("com_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("com_auth"),
          },
        }
      );

      //필요한 공용 데이터를 담기
      this.list = response.data.list;
      this.pages = response.data.pageVO;
      this.pageList = this.pages.pageList;

      //페이지이동에 필요한 데이터 담기
      this.page = this.pages.page;
      this.searchTitle = this.pages.cri.searchTitle;
      this.searchStatus = this.pages.cri.searchStatus;
      this.searchContent = this.pages.cri.searchContent;
      this.prev = this.pages.prev;
      this.pageStart = this.pages.pageStart;
      this.pageEnd = this.pages.pageEnd;
      this.realEnd = this.pages.realEnd;

    },

    ResumeModify(user_no) {

      this.$router.push({
        path: '/ResumeComModify/',
        name: 'ResumeComModify',
        // params: { "w_no": w_no }
        params: { "user_no": user_no }
      })

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

    search(target) { //검색버튼 선택

      const userselect = target.previousElementSibling.previousElementSibling.value;
      const usertext = target.previousElementSibling.value;
      console.log(userselect);
      console.log(usertext);

      if (userselect === "title") {
        this.searchTitle = usertext;
        this.get();
      } else if (userselect === "content") {
        this.searchContent = usertext;
        this.get();
      } else if (userselect === "status") {
        console.log("여기로")
        this.searchStatus = usertext;
        this.get();
      }


    }

  },
  mounted() {
    //데이터 출력시키기
    this.get();
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {
  padding: 0;
  margin: 0;
  font-family: 'Noto Sans KR', sans-serif;
  text-decoration: none;
}

/* 문의사항 목록  */

.hw_main {
  display: flex;
  justify-content: center;
  height: 805px;

}

.hw_container {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
}

.hw_container h2 {
  margin: 20px 0;
}

.hw_btn_write {
  float: right;
  margin: 10px 0;
  border-radius: 3px;
  font-size: 16px;
  font-weight: 500;
  background-color: orange;
  color: #fff;
  border: none;
  padding: 10px 20px;
}

.hw_view {
  float: right;
  margin: 10px 0;
  padding: 10px 20px;
}


.hw_list {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
}


.hw_head {
  background-color: #f5f5f5;
  text-align: center;
}

.hw_head th {
  padding: 1em;
}

.hw_head th:first-child {
  border-top-left-radius: 10px;
}

.hw_head th:last-child {
  border-top-right-radius: 10px;
}

.hw_body tr:nth-child(even) {
  background-color: #f9f9f9;
}

.hw_body td {
  padding: 1em;
  text-align: center;
  border-bottom: 1px solid #ddd;
}

.hw_body td:first-child {
  border-left: 1px solid #ddd;
  border-bottom-left-radius: 10px;
}

.hw_body td:last-child {
  border-right: 1px solid #ddd;
  border-bottom-right-radius: 10px;
}

.hw_body td a {
  color: #333;
  text-decoration: none;
}

.hw_body td a:hover {
  text-decoration: underline;
}


.hw_serch_box {
  margin-top: 20px;
}

.hw_serch_box select, input {
  padding: 5px;
  margin: 5px;
}

.hw_serch_box>button {
  padding: 5px;
  margin: 5px;
}

.hw_serch_box input {
  width: 50%;
  border-radius: 35px;
  border: 1px solid #ddd;
}

.hw_serch_box>button {
  width: 10%;
  background-color: orange;
  border: none;
  color: white;
  font-size: 16px;
}

.hw_page {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}

.hw_page ul {
  display: flex;
  align-items: center;
  list-style: none;
}

.hw_page li {
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

.hw_page li.on {
  font-weight: bold;
  color: #fff;
  background-color: orange;
  border-color: orange;
}

.hw_page i {
  font-size: 14px;
  margin: 0;
  padding: 0;
  line-height: 1;
}

.hw_page_btn {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>

