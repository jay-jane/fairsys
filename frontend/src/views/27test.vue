<!-- Q&A 페이지 -->

<template>
  <section>
    <div class="main">
      <h3 class="first_name">기업</h3>
      <table>
        <thead>
          <tr>
            <th class="jb-th-1">번호</th>
            <th class="jb-th-2">회사이름</th>
            <th class="jb-th-3">신청일자</th>
            <th class="jb-th-3">승인일자</th>
          </tr>
        </thead>
        <tbody>
          <!-- <tr v-for="(item, index) in list" v-bind:key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ item.com_name }}</td>
            <td>{{ item.com_Application_date }}</td>
            <td>{{ item.com_registration_date }}</td>
          </tr> -->

          <tr>
            <th>2</th>
            <td>(주)짜장면</td>

            <td class="date">2023.03.08</td>
            <td class="date">2023.03.09</td>
          </tr>

          <tr>
            <th>2</th>
            <td>(주)짜장면</td>
            <td class="date">2023.03.08</td>
            <td class="date">2023.03.09</td>
          </tr>
          <tr>
            <th>3</th>
            <td>(주)탕수육</td>
            <td class="date">2023.03.08</td>
            <td class="date">2023.03.09</td>
          </tr>
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
body {
  color: #666;
  font: 14px/24px "Open Sans", "HelveticaNeue-Light", "Helvetica Neue Light",
    "Helvetica Neue", Helvetica, Arial, "Lucida Grande", Sans-Serif;
}

.main {
  margin: 100px 0 0 200px;
  padding: 30px;
}

table {
  border-collapse: separate;
  border-spacing: 0;
  width: 70%;
}

th,
td {
  padding: 6px 15px;
}
th {
  background: #42444e;
  color: #fff;
  text-align: left;
}
tr:first-child th:first-child {
  border-top-left-radius: 6px;
}
tr:first-child th:last-child {
  border-top-right-radius: 6px;
}
td {
  border-right: 1px solid #c6c9cc;
  border-bottom: 1px solid #c6c9cc;
}
td:first-child {
  border-left: 1px solid #c6c9cc;
}
tr:nth-child(even) td {
  background: #eaeaed;
}
tr:last-child td:first-child {
  border-bottom-left-radius: 6px;
}
tr:last-child td:last-child {
  border-bottom-right-radius: 6px;
}

.date {
  text-align: center;
}
</style>
