<!-- Q&A 페이지 -->

<template>
  <!--모달창-->
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
              <!--<a href="#pop1" class="btn" -->
              <a @click="모달창열렸니 = true">{{ item.com_name }}</a>
              <!--
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
                    <tr>
                      <td>{{ item.com_ceo }}</td>
                      <td>{{ item.com_manager }}</td>
                      <td>{{ item.com_manager_phone }}</td>
                      <td>{{ item.com_address }}</td>
                      <td>{{ item.com_postcode }}</td>
                    </tr>
                  </tbody>
                </table>
                <a href="#a">닫기</a>
              </div>
              <div class="dim"></div>
              -->
            </td>
            <td class="date">{{ item.com_Application_date }}</td>
            <td class="date">2023.03.09</td>
            <td>
              <button class="btn" @click="yesbtn(item.com_id)">승인</button>
              <div class="space"></div>
              <button @click="nobtn">거절</button>
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
      com_id: "",
    };
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

    nobtn() {
      console.log(vo.toString());
    },

    async get() {
      let res = await Axios.get("/19/1");
      this.list = res.data;
      console.log(this.list);
    },
  },
  mounted() {
    this.get();
  },

  created() {
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
