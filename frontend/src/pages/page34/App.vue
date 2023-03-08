<template>
  <div class="withdrawal-page">
    <h1>회원 탈퇴</h1>
    <form>

      <div class="form-group">
        <label for="id">아이디</label>
        <input id="id" type="id" value="{{ 아이디값 }}" readonly>
      </div>

      <div class="form-group">
        <label for="password">비밀번호</label>
        <input id="password" type="password" v-model="password">
      </div>
      <div class="form-group">
        <label for="confirmPassword">비밀번호 확인</label>
        <input id="confirmPassword" type="password" v-model="confirmPassword">
      </div>
      <div class="form-group">
        <button type="submit" @click="deleteAlert">회원탈퇴</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name:'App',
  data() {
    return {
      password: "",
      confirmPassword: ""
    };
  },
  methods: {
    // deleteAlert() {
    //   alert("탈퇴되었습니다. 감사합니다.");
    // }
    deleteAlert() {
      if (confirm("탈퇴하시겠습니까?")) {
        //탈퇴버튼 눌렀을때 맞으면 탈퇴
        alert("탈퇴되었습니다.")
      } else {
        // 취소 버튼을 누른 경우 취소

      }
    }
  },
};
</script>

<style>
.withdrawal-page {
  max-width: 500px;
  margin: 0 auto;
  padding: 50px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

h1 {
  font-size: 24px;
  margin-bottom: 30px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-size: 16px;
  margin-bottom: 10px;
}

input[type="password"] {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 5px;
}
input[type="id"] {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

button[type="submit"] {
  padding: 10px;
  font-size: 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>