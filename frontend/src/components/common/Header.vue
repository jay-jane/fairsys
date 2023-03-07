<template>
    <nav id="top">
    <div id="logo"><a href="#">중앙정보 취업 박람회</a></div>
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
      <p><a href="#" class="drop_menu" >Q&A</a></p>
    </div>
  </nav>
</template>

<script>
    export default {
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
</style>