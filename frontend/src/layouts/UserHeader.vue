<template>
  <div id="user_menu">
    <nav id="top">
      <div id="logo"><router-link to="/">중앙정보 취업 박람회</router-link></div>
      <div id="menu"><router-link to="/4" @mouseover="doDropmenu">채용정보</router-link></div>
      <div id="menu"><router-link to="/6/mypage" @mouseover="doDropmenu">마이페이지</router-link></div>
      <div id="logInOut"><button class="btn_logInOut " @click="gologInOut">{{this.$store.state.logInOut }}</button></div>
    </nav>
    <nav id="drop_top" @mouseleave="doHidden">
      <div id="drop">
        <p><router-link to="/4" class="drop_menu">직무별</router-link></p>
        <p><router-link to="/4" class="drop_menu">산업별</router-link></p>
        <p><router-link to="/4" class="drop_menu">지역별</router-link></p>
      </div>
      <div id="drop">
        <p><router-link to="/applystatus" class="drop_menu">지원현황</router-link></p> <!--나중에 지원현황 css 체크필요 삐뚤어짐-->
        <p><router-link to="/11" class="drop_menu">문의하기</router-link></p>
      </div>
    </nav>
  </div>

</template>
<script>


export default {

  methods: {
    gologInOut() {
      if (sessionStorage.length<1) {
        location.href = "/2";
        
      } else {
        sessionStorage.clear();
        alert("로그아웃 되었습니다.")
        this.$router.push({ path: '/' })
        this.$store.commit("setLogInOut","로그인")
      }
      // location.href = "/2";
    },
    doDropmenu() {
      const dorp_top = document.querySelector("#drop_top");
      dorp_top.style.display = "block";
    },
    doHidden() {
      const dropMenu_hidden = document.querySelector("#drop_top");
      dropMenu_hidden.style.display = "none";
    },

    

  },
  
}
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
#top {
  font-size: 18px;
  font-weight: 500;
  text-align: center;
  border-bottom: 2px solid rgba(0, 0, 0, 0.2);
  margin-bottom: 25px;
}

#top div {
  display: inline-block;
  height: 100px;
}

#menu {
  width: 200px;
  line-height: 100px;
  display: inline-block;
}

#menu a {
  color: black;
}

#logo {
  float: left;
  margin-left: 50px;
  line-height: 100px;
}

/* 헤더 드롭다운 메뉴 */

#drop_top {
  display: none;
  position: absolute;
  top: 100px;
  left: 0;
  width: 100%;
  text-align: center;
  background-color: orange;
  z-index: 9999;
}

#drop {
  margin-bottom: 20px;
  width: 200px;
  line-height: 60px;
  display: inline-block;
  vertical-align: top;
}

#drop a {
  color: white;
  font-size: 18px;
}

#drop a:hover {
  color: black;
}

/* 로그인버튼 */
#logInOut {
  float: right;
  margin-right: 50px;
  line-height: 100px;
}

.btn_logInOut {
  font-size: 18px;
  font-weight: 500;
  color: white;
  background-color: orange;
  border: none;
  border-radius: 30px;
  height: 50px;
  width: 160px;
}

.btn_logInOut:hover {
  color: white;
  background-color: black;
}
</style>