<template>
  <div id="user_menu">
    <nav id="top">
      <div id="logo"><router-link to="/" class="logo_alink"><img src="../img/jobhublogo.png" class="logo_img"
            :style="{ width: ['100px'] }"></router-link></div>
      <div id="menu"><router-link to="/4" @mouseover="doDropmenu">채용공고</router-link></div>
      <div id="menu"><router-link to="" @mouseover="doDropmenu">기업정보</router-link></div>
      <div id="logInOut"><button class="btn_logInOut " @click="gologInOut">{{ this.$store.state.logInOut }}</button></div>
    </nav>
    <nav id="drop_top" @mouseleave="doHidden">
      <div id="drop1">
        <p><router-link to="/4" class="drop_menu">전체 공고 목록</router-link></p>
        <p><a href="#" @click.prevent="getJno" class="drop_menu">내 공고 조회</a></p>
        <p><router-link to="/ApplyStatus" class="drop_menu">지원자 목록</router-link></p>
      </div>
      <div id="drop1">
        <p><router-link to="/9-2" class="drop_menu">기업정보 수정</router-link></p> <!--나중에 지원현황 css 체크필요 삐뚤어짐-->
        <p><router-link to="/#" class="drop_menu" @click="companyDelete">회원 탈퇴</router-link></p>
        <p><router-link to="/11" class="drop_menu">문의하기</router-link></p>
      </div>
    </nav>
  </div>
</template>
<script>


export default {

  data() {
    return {
      j_no: '',
    }
  },
  methods: {

    companyDelete() {
      if (confirm('아이디를 삭제하시겠습니까?')) {
        this.axios.get('/Company/deleteForm',
          {
            params: { com_id: sessionStorage.getItem("com_id") },
            headers: {
              'content-type': 'application/json',
              'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
            }
          }
        ).then(res => {
          alert('아이디가 삭제되었습니다.')
          // sessionStorage.clear();
          // this.$store.commit("setLogInOut","로그인")
          // this.$router.push({ path: '/' })
        })
      }
    },

    gologInOut() {
      if (sessionStorage.length < 1) {
        location.href = "/2";

      } else {
        sessionStorage.clear();
        alert("로그아웃 되었습니다.")
        this.$router.push({ path: '/' })
        this.$store.commit("setLogInOut", "로그인")
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
    getJno() {
      this.axios.get("/getJno", { params: { "com_id": sessionStorage.getItem("com_id") } })
        .then(res => {
          if (res.data == '') {
            alert('등록된 공고가 없습니다.');
          } else {
            this.$router.push({ name: 'jobPostingDetail', params: { 'j_no': res.data } })
          }
        })
        .catch(err => console.log(err));
    }

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
  margin-left: 100px;
}

#menu a {
  color: black;
}

#logo {
  position: absolute;
}

#logo .logo_alink {
  display: inline-block;
  position: fixed;
  top: 10px;
  left: 10px;
  height: 100px;
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

#drop1 {
  margin-bottom: 20px;
  width: 200px;
  line-height: 60px;
  display: inline-block;
  vertical-align: top;
  margin-right: 105px;
}

#drop1 a {
  color: white;
  font-size: 18px;
}

#drop1 a:hover {
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