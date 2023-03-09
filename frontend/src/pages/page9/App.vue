
<template>
  
  <Header></Header>

  <div class="btn-group">
    <button class="btn_qna" @click="showNotice">Q&A</button>
    <button class="btn_inquiry" @click="showQna">문의내역</button>
  </div>

  <div class="main">
    <div class="container">
      
      <table class="list">
        <thead class="head">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
          </tr>
        </thead>

        <tbody class="body">
          <tr>
            <td>1</td>
            <td><a href="">사이트 이용 안내 </a></td>
            <td>2023.03.02</td>
          </tr>
          <tr>
            <td>2</td>
            <td>사이트 이용 안내 </td>
            <td>2023.03.02</td>
          </tr>
          <tr>
            <td>3</td>
            <td>사이트 이용 안내 </td>
            <td>2023.03.02</td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>

  <Footer></Footer>

</template>

<script>
import Header from '../../components/layout/Header/Header.vue'
import Footer from '../../components/layout/Footer/Footer.vue'

export default {
  name: 'App',

  methods: {
    showNotice() {
      location.href = "page9";
    },
    showQna() {
      location.href = "page10";
    },
    gologin() {
      location.href = "page2";
    }, 
    doDropmenu(){
      const dorp_top = document.querySelector("#drop_top");
      dorp_top.style.display = "block";
    },
    doHidden(){
      const dropMenu_hidden = document.querySelector("#drop_top");
      dropMenu_hidden.style.display="none";
    }
  },
  components: {
    Header,
    Footer
  }
  
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none;}

/* 버튼 */
.btn-group {
  text-align: center;
  margin-top: 100px;
}

.btn_qna {
  width: 200px;
  height: 70px;
  background-color: orange;
  color: white;
  border: none;
  border-radius: 45px;
  margin-right: 20px;
  font-size: 24px;
  font-weight: 600;
  font-family: 'Noto Sans KR', sans-serif;
}

.btn_inquiry {
  width: 200px;
  height: 70px;
  background-color: lightslategray;
  border: none;
  border-radius: 45px;
  margin-left: 20px;
  color: white;
  font-size: 24px;
  font-weight: 400;
  font-family: 'Noto Sans KR', sans-serif;
}


/* Q&A 목록 화면 */
.main {
  display: flex;
  justify-content: center;
  height: 600px;
  margin-top: 50px;
  margin-bottom: 50px;
}

.container {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
}

.list {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
}

.head {
  background-color: #f5f5f5;
  text-align: center;
}

.head th {
  padding: 1em;
}

.head th:first-child {
  border-top-left-radius: 10px;
}

.head th:last-child {
  border-top-right-radius: 10px;
}

.body tr:nth-child(even) {
  background-color: #f9f9f9;
}

.body td {
  padding: 1em;
  text-align: center;
  border-bottom: 1px solid #ddd;
}

.body td:first-child {
  border-left: 1px solid #ddd;
  border-bottom-left-radius: 10px;
}

.body td:last-child {
  border-right: 1px solid #ddd;
  border-bottom-right-radius: 10px;
}

.body td a {
  color: #333;
  text-decoration: none;
}

.body td a:hover {
  text-decoration: underline;
}

/* footer 디자인 */
#bottom {
  height: 260px;
  background-color: black;
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}
</style>

