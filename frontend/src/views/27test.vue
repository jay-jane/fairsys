<!-- Q&A 페이지 -->

<template>
  <section>
    <div class="main">
      <div class="container">
        <h1>기업목록</h1>

        <div class="searchBox">
          <input type="text" />
          <button>검색하기</button>
        </div>

        <select v-model="amount" class="list_view">
          <option value="10" selected>10개씩 보기</option>
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
              <td>{{ index + 1 }}</td>
              <td>{{ item.com_name }}</td>
              <td>{{ item.com_Application_date }}</td>
              <td>{{ item.com_registration_date }}</td>
            </tr>
          </tbody>
        </table>
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
      amount: 10,
    };
  },
  methods: {
    logout() {
      location.href = "/3";
    },
    async get() {
      let res = await Axios.get("/18");
      this.list = res.data;
      console.log(this.list);
    },
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
</style>
