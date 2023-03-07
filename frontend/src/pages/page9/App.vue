
<template>
 
 <nav id="top">
    <div id="logo"><a href="page1">중앙정보 취업 박람회</a></div>
    <div id="menu"><a href="#" @mouseover="doDropmenu">채용정보</a></div>
    <div id="menu"><a href="#" @mouseover="doDropmenu">기업/연봉</a></div>
    <div id="menu"><a href="#" @mouseover="doDropmenu">마이페이지</a></div>
    <div id="login"><button class="btn_login" @click="gologin">로그인</button></div>
  </nav>
  <nav id="drop_top" @mouseleave="doHidden">
    <div id="drop">
      <p><a href="#" class="drop_menu" >직무별</a></p>
      <p><a href="#" class="drop_menu" >산업별</a></p>
      <p><a href="#" class="drop_menu" >지역별</a></p>
      <p><a href="#" class="drop_menu" >기업별</a></p>
    </div>
    <div id="drop">
      <p><a href="#" class="drop_menu" >기업정보</a></p>
      <p><a href="#" class="drop_menu" >연봉정보</a></p>
    </div>
    <div id="drop">
      <p><a href="#" class="drop_menu" >이력서관리</a></p>
      <p><a href="page9" class="drop_menu" >Q&A</a></p>
      <p><a href="page21" class="drop_menu" >쪽지함</a></p>
    </div>
  </nav>


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

  <div id="bottom">

    중앙정보 채용 박람회<br />
    중앙정보 7층 704호 / 대표자:coding404<br />
    TEL:02-1253-8253 / FAX:02-1253-8253

  </div>
</template>

<script>

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

/* header 디자인 */
 /* 헤더 기본메뉴 */
 #top{
    font-size: 18px;
    font-weight: 500;
    text-align: center;
    border-bottom: 2px solid rgba(0,0, 0, 0.2);
  }

  #top div{
    display: inline-block;
    height: 100px;
  }

  #menu{
    width: 200px;
    line-height: 100px;
    display: inline-block;
  }

  #logo{
    float: left;
    margin-left: 50px;
    line-height: 100px;
  }

  /* 헤더 드롭다운 메뉴 */

  #drop_top {
    display: none;
    text-align: center;
    background-color: orange;
  }

  #drop {
    margin-bottom: 20px;
    width: 200px;
    line-height: 60px;
    display: inline-block;
    vertical-align: top;
  }

  #drop a{
    color: white;
    font-size: 18px;
  }

  #drop a:hover{
    color: black;
  }

  /* 로그인버튼 */
  #login{
    float: right;
    margin-right: 50px;
    line-height: 100px;
  }

  .btn_login{
    font-size: 18px;
    font-weight: 500;
    color:  white;
    background-color: orange;
    border: none;
    border-radius: 30px;
    height: 50px;
    width: 160px;
  }

  .btn_login:hover{
    color: white;
    background-color: black;
  }

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

