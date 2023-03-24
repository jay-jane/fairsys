<template>
  <form>
    <div class="login-wrap">
      <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">개인회원</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">기업회원</label>
        <div class="login-form">
          <div class="sign-in-htm">
            <div class="group">
              <label for="user_id" class="label">아이디 </label>
              <input v-model="user_id" id="user_id" type="text" class="input">
            </div>
            <div class="group">
              <label for="user_pw" class="label">비밀번호 </label>
              <input v-model="user_pw" id="user_pw" type="password" class="input" data-type="password">
            </div>
            <div class="group">
              <input id="check" type="checkbox" class="check" checked>
              <label for="check"><span class="icon"></span>로그인 정보 저장</label>
            </div>
            <div class="group">
              <button type="button" class="button" @click="loginForm1">login</button>
            </div>
            <a href="#">아이디찾기 </a><br>
            <a href="#">비밀번호찾기</a>
            <br><router-link to="/3-1">회원가입</router-link>

            <div class="hr"></div>
            <div class="sns">소셜 계정으로 간편 로그인</div>

            <a @click="kakaoLogin()"><img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
                width="222" alt="카카오 로그인 버튼" /></a>
          </div>



          <div class="sign-up-htm">
            <div class="group">
              <label for="com_id" class="label">아이디 </label>
              <input v-model="com_id" required type="text" class="input">
            </div>
            <div class="group">
              <label for="com_pw" class="label">비밀번호 </label>
              <input v-model="com_pw" id="com_pw" type="password" class="input" data-type="password">
            </div>
            <div class="group">
              <input id="check1" type="checkbox" class="check" checked>
              <label for="check1"><span class="icon"></span>로그인 정보 저장 </label>
            </div>
            <div class="group">
              <button value=2 type="button" class="button" @click="loginForm2">로그인</button>
            </div>
            <a href="#">아이디찾기 </a><br>
            <a href="#">비밀번호찾기</a><br>
            <router-link to="/3-2">회원가입</router-link>
            <div class="hr"></div>
          </div>
        </div>
      </div>
    </div>
  </form>
</template>

<script>

export default {
  name: "App",
  data() {
    return {
      user_id: '',
      user_pw: '',
      com_id: '',
      com_pw: '',
    }
  },
  methods: {
    async loginForm1() {
      this.axios.post('/3-1/loginForm',
        {
          user_id: this.user_id,
          user_pw: this.user_pw,
        }
      ).then(res => {
        console.log(res)
        //sessionStorage에 id / auth 추가
        // sessionStorage.setItem('user_id',JSON.stringify(res.data.user_id))
        // sessionStorage.setItem('user_auth',JSON.stringify(res.data.mg_auth))

        console.log(res.headers.authorization)

        sessionStorage.setItem('user_auth', res.headers.authorization.substr(7))
        sessionStorage.setItem('user_id', res.data.user_id)
        sessionStorage.setItem('ut_no', res.data.ut_no)
        console.log(sessionStorage)
        this.$store.commit("setUtNo", 1)
        location.href = "/";
        console.log(this.$store.state.logInOut)
        this.$store.commit("setLogInOut", "로그아웃")




        //서버에서 로그인 성공시 data에는 회원아이디 정도만 저장해서 반환
        //헤더에 담긴 오소라이제이션 토큰의 bearer를 제외헌 부분을 세션스토리지(브라우저끄면 사라짐) or 스토어에 저장
        //아이디도 세션스토리지(브라우저끄면 사라짐) or 스토어에 저장

        //회원정보를 가져올때는 header에 토큰을 담아서 항상 보내야됨
        //서버에서는 filter or 인터셉터로 header에 담긴 토큰의 유효성을 검사하고, 
        //토큰이 유효하면 컨트롤러, 만료되거나 위조되었으면 거부

      }).catch(err => {
        if (err.response.status == 401) {
          alert("아뒤 비번좀 봐라")
        }
      })
    },
    async loginForm2() {
      this.axios.post('/3-2/loginForm',
        {
          com_id: this.com_id,
          com_pw: this.com_pw,
        }
      ).then(res => {
        console.log(res)
        //sessionStorage에 id / auth 추가
        // sessionStorage.setItem('user_id',JSON.stringify(res.data.user_id))
        // sessionStorage.setItem('user_auth',JSON.stringify(res.data.mg_auth))

        console.log(res.headers.authorization)

        sessionStorage.setItem('com_auth', res.headers.authorization.substr(7))
        sessionStorage.setItem('com_id', res.data.com_id)
        sessionStorage.setItem('ut_no', res.data.ut_no)
        console.log(sessionStorage)
        this.$store.commit("setUtNo", 2)
        location.href = "/";
        console.log(this.$store.state.logInOut)
        this.$store.commit("setLogInOut", "로그아웃")



        //서버에서 로그인 성공시 data에는 회원아이디 정도만 저장해서 반환
        //헤더에 담긴 오소라이제이션 토큰의 bearer를 제외헌 부분을 세션스토리지(브라우저끄면 사라짐) or 스토어에 저장
        //아이디도 세션스토리지(브라우저끄면 사라짐) or 스토어에 저장

        //회원정보를 가져올때는 header에 토큰을 담아서 항상 보내야됨
        //서버에서는 filter or 인터셉터로 header에 담긴 토큰의 유효성을 검사하고, 
        //토큰이 유효하면 컨트롤러, 만료되거나 위조되었으면 거부

      }).catch(err => {
        if (err.response.status == 401) {
          alert("아뒤 비번좀 봐라")
        }else if(err.response.status == 403){
          alert("관리자의 승인이 필요합니다")
        }
      })
    },

    // kakaoLogin() {
    //   this.axios.get('/api/login')
    //     .then((response) => {
    //       console.log(response.data)
    //       console.warn("warn : " + response);
    //       window.location.href = response.data;
    //     })
    //     .catch(err=>{
    //       console.log(err)
    //     })
    // },


    // getKakaoAccount() {
    //   window.Kakao.API.request({
    //     url: '/v2/user/me',
    //     success: res => {
    //       const kakao_account = res.kakao_account;
    //       console.log(res)
    //       const profile_nickname = kakao_account.profile.nickname;//카카오 닉네임
    //       const account_email = kakao_account.email;//카카오 닉네임
    //       console.log('profile_nickname', profile_nickname)
    //       console.log('account_email', account_email)
    //       //로그인 처리 구현
    //       alert("로그인 성공!")
    //     },
    //     fail: error => {
    //       console.log(error);
    //     }
    //   })
    // }

  },
  mounted() {

  }
}

</script>

<style>
body {
  margin: 0;
  color: #6a6f8c;
  background: #c8c8c8;
}

form{
  background: white;
  margin-top: -26px;
}
*,
:after,
:before {
  box-sizing: border-box
}

.clearfix:after,
.clearfix:before {
  content: '';
  display: table
}

.clearfix:after {
  clear: both;
  display: block
}

a {
  color: inherit;
  text-decoration: none
}

.login-wrap {
  width: 100%;
  margin: auto;
  max-width: 525px;
  min-height: 670px;
  position: relative;

}

.login-html {
  width: 100%;
  height: 100%;
  position: absolute;
  padding: 90px 70px 50px 70px;
  background: white;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.login-html .sign-in-htm,
.login-html .sign-up-htm {
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  position: absolute;
  transform: rotateY(180deg);
  backface-visibility: hidden;
  transition: all .4s linear;
}

.login-html .sign-in,
.login-html .sign-up,
.login-form .group .check {
  display: none;
}

.login-html .tab,
.login-form .group .label,
.login-form .group .button {
  text-transform: uppercase;
}

.login-html .tab {
  font-size: 22px;
  margin-right: 15px;
  padding-bottom: 5px;
  margin: 0 15px 10px 0;
  display: inline-block;
  border-bottom: 5px solid transparent;
}

.login-html .sign-in:checked+.tab,
.login-html .sign-up:checked+.tab {
  color: black;
  border-color: orange;
}

.login-form {
  min-height: 345px;
  position: relative;
  perspective: 1000px;
  transform-style: preserve-3d;
}

.login-form .group {
  margin-bottom: 15px;
}

.login-form .group .label,
.login-form .group .input,
.login-form .group .button {
  width: 100%;
  color: #fff;
  display: block;
}

.login-form .group .input,
.login-form .group .button {
  border: none;
  padding: 15px 20px;
  border-radius: 25px;
  background: rgba(35, 33, 33, 0.1);
}

.login-form .group input[data-type="password"] {
  text-security: circle;
  -webkit-text-security: circle;
}

.login-form .group .label {
  color: #aaa;
  font-size: 12px;
}

.login-form .group .button {
  background: orange
}

.login-form .group label .icon {
  width: 15px;
  height: 15px;
  border-radius: 2px;
  position: relative;
  display: inline-block;
  background: rgba(255, 255, 255, .1);
}

.login-form .group label .icon:before,
.login-form .group label .icon:after {
  content: '';
  width: 10px;
  height: 2px;
  background: #fff;
  position: absolute;
  transition: all .2s ease-in-out 0s;
}

.login-form .group label .icon:before {
  left: 3px;
  width: 5px;
  bottom: 6px;
  transform: scale(0) rotate(0);
}

.login-form .group label .icon:after {
  top: 6px;
  right: 0;
  transform: scale(0) rotate(0);
}

.login-form .group .check:checked+label {
  color: #fff;
}

.login-form .group .check:checked+label .icon {
  background: orange;
}

.login-form .group .check:checked+label .icon:before {
  transform: scale(1) rotate(45deg);
}

.login-form .group .check:checked+label .icon:after {
  transform: scale(1) rotate(-45deg);
}

.login-html .sign-up:checked+.tab+.login-form .sign-up-htm {
  transform: rotate(0);
}

.login-html .sign-in:checked+.tab+.sign-up+.tab+.login-form .sign-in-htm {
  transform: rotate(0);
}


.hr {
  height: 2px;
  margin: 60px 0 50px 0;
  background: rgba(255, 255, 255, .2);
}

.sns {
  height: 2px;
  margin: -30px 0 50px 0;
  color: white
}

.foot-lnk {
  text-align: center;
}

.simple_login_box {
  margin-top: 30px;
}

.simple_login_btn>h3 {
  color: #1F2124;
  font-weight: bold;
  margin-bottom: 30px;
}

/* .simple_login_btn .login_icon {
  display: inline;
  margin: 0 auto;

}

.login_icon>a>img {
  width: 50px;
  height: 50px;
  align-items: center;
  border-radius: 50%;
}

.login_icon>a>img:hover {
  opacity: 0.7;
  transition: 0.2s ease-in-out;
}

.login_icon .kakao_login {
  margin-right: 30px;
}

.login_icon .naver_login {
  margin-right: 30px;
} */

.btn_login {
  text-align: center;
}
</style>


