<template>
  <div class="black-bg" v-if="모달창열렸니 == true">
    <div class="white-bg">
      <h4>
        <td>{{ com_ceo }}</td>
      </h4>
      <p>상페이지내용임</p>
      <button @click="모달창열렸니 = false">닫기</button>
    </div>
  </div>

  <section>
    <div class="bg">
      <h3 class="first_name">기업관리</h3>
      <table>
        <thead>
          <tr>
            <th class="jb-th-1">번호</th>
            <th class="jb-th-2">회사이름</th>
            <th class="jb-th-3">신청일자</th>
            <th class="jb-th-3">마감일자</th>
            <th class="jb-th-4">인가</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in list" v-bind:key="index">
            <th>{{ index + 1 }}</th>
            <td>
              <h4 @click="모달창열렸니 = true">{{ item.com_name }}</h4>
            </td>
            <td class="date">2023.03.08</td>
            <td class="date">2023.03.09</td>
            <td>
              <button class="btn">승인</button>
              <div class="space"></div>
              <button>거절</button>
            </td>
          </tr>

          <!-- <tr>
              <th>2</th>
              <td>(주)짜장면</td>
              <td class="date">2023.03.08</td>
              <td class="date">2023.03.09</td>
             <td><button class="btn">승인</button><div class="space"></div><button>거절</button></td>            
            </tr>

             <tr>
              <th>3</th>
              <td>(주)탕수육</td>
              <td class="date">2023.03.08</td>
              <td class="date">2023.03.09</td>
              <td><button class="btn">승인</button><div class="space"></div><button>거절</button></td>  
            </tr> -->
        </tbody>
      </table>
    </div>
  </section>

  <footer id="ft" style="border-top: 1px solid">
    <h3>여기 푸터야</h3>
  </footer>
</template>

<script>
import Axios from "axios";

export default {
  name: "App",

  data() {
    return {
      모달창열렸니: false,
      list: "",
    };
  },
  methods: {
    logout() {
      location.href = "/3";
    },
    async get() {
      let res = await Axios.get("/27");
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
* {
  margin: 0;
  padding: 0;
}

.space {
  width: 10px;
  height: auto;
  display: inline-block;
}

table {
  padding: auto;
  margin: auto;
  border: 1px solid black;
  border-collapse: collapse;
  border-radius: 5px;
}

th {
  border: 1px solid black;
}

td {
  border: 1px solid black;
  text-align: center;
}

.jb-th-1 {
  width: 200px;
  background-color: bisque;
}

.jb-th-2 {
  width: 600px;
  background-color: bisque;
  text-align: center;
}

.jb-th-3 {
  width: 200px;
  background-color: bisque;
  text-align: center;
}

.jb-th-4 {
  width: 100px;
  background-color: bisque;
  text-align: center;
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
</style>
