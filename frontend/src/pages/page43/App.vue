<!-- 관리자페이지 ui -->
<template>
  <!-- <div class="admin_top_menu">
    <div class="admin_account">
      <button class="logout">로그아웃</button>
    </div>
  </div>

  <ul class="admin_nav">
    <hr/>
    <li class="sub_menu_toggle">
      <a class="sub menu select">기업</a>
      <hr/>
      <ul class="sub_menu" style="display: block;">
        <li><a href="#">기업 목록</a></li>
        <li><a href="#">기업 신청 관리</a></li>
      </ul>
    </li>
    <hr/>

    <li class="sub_menu_toggle">
      <a href="#">유저</a>
      <hr/>
      <ul class="sub_menu">
        <li><a href="#">유저 목록</a></li>
        <li><a href="#">유저 관리</a></li>
      </ul>
    </li>
    <hr/>

    <li class="sub_menu_toggle">
      <a href="#">통계</a>
      <hr/>
      <ul class="sub_menu">
        <li><a href="#">기업 통계</a></li>
        <li><a href="#">유저 통계</a></li>
      </ul>
    </li>
    <hr/>
    
    <li class="sub_menu_toggle">
      <a href="#">Q&A</a>
      <hr/>
      <ul class="sub_menu">
        <li><a href="#">Q&A 등록</a></li>
        <li><a href="#">Q$A 관리</a></li>
      </ul>
    </li>
    <hr/>

    </ul> -->

  <div class="admin_top">
    <div class="admin_logo">
      <a href="#">홈으로</a>
    </div>
    <div class="admin_account">
      <span>관리자님 환영합니다!</span>
      <button @click="doLogout">로그아웃</button>
    </div>
  </div>

  <div class="admin_nav">
    <ul>
      <li class="sub_menu_toggle">
        <a class="sub menu select">기업</a>
        <ul class="sub_menu" style="display: block;">
          <li><a href="#">기업 목록</a></li>
          <li><a href="#">기업 신청 관리</a></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">유저</a>
        <ul class="sub_menu">
          <li><a href="#">유저 목록</a></li>
          <li><a href="#">유저 관리</a></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">통계</a>
        <ul class="sub_menu">
          <li><a href="#">기업 통계</a></li>
          <li><a href="#">유저 통계</a></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">Q&A</a>
        <ul class="sub_menu">
          <li><a href="#">Q&A 등록</a></li>
          <li><a href="#">Q$A 관리</a></li>
        </ul>
      </li>
    </ul>
  </div>

  <div class="content">
    d안녕안녕
  </div>
</template>

<script>

export default {
  name: 'App',
  methods:{
    doLogout(){
      location.href ="page2";
    }
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black;}

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

.admin_nav {
  width: 200px;
  height: 100%;
  position: fixed;
  top: 100px;
  left: 0;
  background-color: #263238;
}

  .admin_nav li{
    margin-top: 20px;
    list-style: none;
  }

  .admin_nav li a {
      padding: 8px 20px;
      text-decoration: none;
      font-size: 15px;
      color: orange;
      display: block;
      width: 200px;
      font-weight: 600;
  }

  .admin_nav .sub_menu {margin-left: 25px;}
  .admin_nav .sub_menu li a {color: #fff; display: block; width: 155px; padding: 8px 10px 8px 10px; }
  .admin_nav .sub_menu li a:hover { background-color: orange;}
  .admin_nav .sub_menu li a.on {background-color: orange;}  
  
  .content {
  margin-left: 200px; /* admin_nav의 너비 + 20px 마진을 주어서 겹치지 않도록 함 */
  background-color: aqua;
  height: 100%;
  }

</style>

