
<template>

    <aside class="admin_nav">
      <ul>
        <li class="sub_menu_toggle">
          <a class="sub menu select">기업</a>
          <ul class="sub_menu" style="display: block;">
            <li><a href="page51">기업 목록</a></li>
            <li><a href="page52">기업 신청 관리</a></li>
          </ul>
        </li>
  
        <li class="sub_menu_toggle">
          <a href="#">유저</a>
          <ul class="sub_menu">
            <li><a href="page44">유저 관리</a></li>
          </ul>
        </li>
  
        <li class="sub_menu_toggle">
          <a href="#">통계</a>
          <ul class="sub_menu">
            <li><a href="page42">통합 통계</a></li>
          </ul>
        </li>

      </ul>
    </aside>
  
  </template>
  
  <script>


  export default {
    name: 'Side',
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
  
  .admin_nav {
    height: 100%;
    width: 200px;
    background-color: #263238;
    position: fixed;
    top: 100px;
    left: 0;
    overflow: auto;
    padding-top: 0;
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
   
  </style>
  