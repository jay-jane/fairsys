<template>
  <div class="login-form">
    <h2>로그인</h2>
    <form @submit.prevent="login">
      <div class="form-group">
            <label for="signup_user_id">User Id</label>
            <input type="email" id="signup_user_id" v-model="userId" class="form-control" placeholder="User ID를 입력해주세요." required autofocus>
          </div>
          <div class="form-group">
            <label for="signup_password">Password</label>
            <input type="password" id="signup_password" v-model="passWd" class="form-control" placeholder="비밀번호를 입력해주세요." required>
          </div>
      <button type="submit">로그인</button>
      <button type="submit">회원가입</button>
    </form>
  </div>
</template>

<script>
 export default {
    name: "App",
    data() {
      return {
        userId: '',
        passWd: ''
      }
    },
  methods: {
    login() {
      // 로그인 로직 구현
    }
  }
}
</script>

<style scoped>
.login-form {
  width: 300px;
  margin: 0 auto;
}
label {
  display: block;
  margin-bottom: 10px;
}
input {
  display: block;
  width: 100%;
  padding: 5px;
  border-radius: 5px;
  border: 1px solid #ccc;
  margin-bottom: 10px;
}
button {
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border-radius: 5px;
  border: none;
  cursor: pointer;
}
</style>