<!-- Q&A 페이지 -->

<template>
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
              <a href="#pop1" class="btn">{{ item.com_name }}</a>
              <div class="POPUP" id="pop1">
                <h3>{{ item.com_name }}</h3>
                <table class="poptab">
                  <thead>
                    <tr>
                      <th>회사대표자</th>
                      <th>담당자</th>
                      <th>담당자번호</th>
                      <th>주소</th>
                      <th>사업자번호</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(item, index) in list" v-bind:key="index">
                      <td>{{ com_ceo }}</td>
                      <td>{{ com_manager }}</td>
                      <td>{{ com_manager_phone }}</td>
                      <td>{{ com_address }}</td>
                      <td>{{ com_postcode }}</td>
                    </tr>
                  </tbody>
                </table>
                <a href="#a">닫기</a>
              </div>
              <div class="dim"></div>
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
      list: "",
    };
  },
  methods: {
    logout() {
      location.href = "/3";
    },
    async get() {
      let res = await Axios.get("/19");
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

.POPUP {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  padding: 20px;
  box-sizing: border-box;
  background: #fff;
  z-index: 5;
  width: 500px;
  height: 300px;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 5);
  border-radius: 5px;
  text-align: right;
  opacity: 0;
  transition: all 0.5s;
}
.POPUP:target {
  opacity: 1;
}
.POPUP:target + .dim {
  opacity: 1;
  z-index: 2;
}

.POPUP a {
  color: grey;
  text-decoration: none;
}

.dim {
  position: absolute;
  left: 0;
  top: 0;
  z-index: -1;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.6);
  opacity: 0;
  transition: all 0.5s;
}

.poptab {
  float: left;
  width: 50%;
  height: 50%;
}
</style>
