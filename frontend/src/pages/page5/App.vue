<template>
  <form action="">
  
    <h3>기업회원가입</h3>
    <div>
      <label for="com_name">회사명: </label>
      <input v-model="com_name" required type="text">
    </div>
    <div>
      <label for="com_ceo">대표자명: </label>
      <input v-model="com_ceo" required type="text" placeholder="대표자명을 입력하세요">
    </div>
    <div>
      <label for="business_number">사업자등록번호: </label>
      <input v-model="business_number" required type="text">
    </div>
    <div>
      <label for="com_address">회사주소: </label>
      <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요">
    </div>
    
  <hr/>

    <div>
      <label for="com_userid">id: </label>
      <input v-model="com_userid" required type="text" placeholder="아이디를 입력하세요">
    </div>
    <div>
      <label for="com_password">password: </label>
      <input v-model="com_password" required type="password" placeholder="비밀번호를 입력하세요">
    </div>
    <div>
      <label for="com_number">전화번호: </label>
      <input v-model="com_number" required type="number" placeholder="전화번호를 입력하세요">
    </div>
    <div>
      <label for="com_manager">가입자명: </label>
      <input v-model="com_manager" required type="text" placeholder="성함을 입력하세요">
    </div>
    <div>
      <label for="com_email">이메일: </label>
      <input v-model="com_email" required type="text">
    </div>


    <button type="submit">가입하기</button>
    <button type="submit">로그인</button>
  </form>
</template>


<script>
export default {
  data() {
    return {
      com_name: '',
      com_ceo: '',
      business_number:'',
      com_address: '',
      com_userid:'',
      com_password:'',
      com_number:'',
      com_manager:'',
      com_email:''
    }
  }
}


</script>

<style>
form {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  margin: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

label {
  font-weight: bold;
}

input {
  padding: 5px;
  border-radius: 3px;
  border: 1px solid #ccc;
  width: 100%;
}

button {
  padding: 10px;
  border-radius: 5px;
  border: none;
  background-color: #0077cc;
  color: #fff;
  font-weight: bold;
  cursor: pointer;
  margin-top: 10px;
  width: 100%;
}

button:hover {
  background-color: #005fa3;
}
</style>

