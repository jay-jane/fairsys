<template>

<div class="admin_top">
      <div class="admin_logo">
        <a href="page45">홈으로</a>
      </div>
      <div class="admin_account">
        <span>관리자님 환영합니다!</span>
        <button @click="doLogout">로그아웃</button>
      </div>
  </div>

</template>
    
<script>


  export default {
    name: 'AdminHeader',
    methods:{
      doLogout(){
        location.href ='page1';
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

  .admin_top {
  background-color: #263238;
  height: 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.admin_top a {
  color: orange;
  text-decoration: none;
}

.admin_logo {
  margin-left: 20px;
}

.admin_account {
  margin-right: 20px;
}

.admin_account span{
  color: white;
  margin-right: 20px;
}

</style>