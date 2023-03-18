
<template>
  <div class="admin_nav">
    <ul>
      <li class="sub_menu_toggle">
        <a class="sub menu select">채용공고</a>
        <ul class="sub_menu" style="display: block;">
          <li><router-link to="/16">공고목록</router-link></li>
          <li><a href="">공고 수정</a></li>
          <!-- <router-link :to="{name:'page8'}">공고수정</router-link> -->
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">이력서</a>
        <ul class="sub_menu">
          <li><router-link to="/ResumeRegist">이력서 작성</router-link></li>
          <li><router-link to="/UserMypage">이력서 목록</router-link></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">쪽지</a>
        <ul class="sub_menu">
          <li><a href="#">쪽지 작성</a></li>
          <li><a href="#">쪽지 보관함</a></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">회사정보수정</a>
        <ul class="sub_menu">
          <li><router-link to="/9">회원정보수정</router-link></li>
          <li><a href="#">회원탈퇴</a></li>
        </ul>
      </li>
    </ul>
  </div>

</template>

<script>
export default {

  name: 'App',
  data() {
    return {

    }

  },
  methods: {

  }
}

</script>


<style>
* {
  margin: 0;
  padding: 0;
  font-family: 'Noto Sans KR', sans-serif;
  text-decoration: none;
  color: black;
  box-sizing: border-box;
}

.my_title {
  float: left;
}

.admin_account {
  margin-right: 20px;
}

.admin_account span {
  color: white;
  margin-right: 20px;
}

.admin_nav {
  width: 200px;
  height: 100%;
  position: fixed;
  top: 100px;
  left: 0;
  background-color: white;
}

.admin_nav li {
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

.admin_nav .sub_menu {
  margin-left: 25px;
}

.admin_nav .sub_menu li a {
  color: black;
  display: block;
  width: 155px;
  padding: 8px 10px 8px 10px;
}

.admin_nav .sub_menu li a:hover {
  background-color: orange;
}

.admin_nav .sub_menu li a.on {
  background-color: orange;
}

.my_content {
  width: auto;
}

table {
  width: 80%;
  text-align: center;
  border: 1px solid #fff;
  font-family: 'Cairo', sans-serif;
  margin: auto;
  border-collapse: collapse;
  border-radius: 5px;
}

caption {
  font-weight: bold;
}

table td {
  padding: 10px;
  background-color: #eee;
}

table th {
  background-color: #d1cece;
  color: #000;
  padding: 10px;

}


.view,
.delete {
  border: none;
  padding: 5px 10px;
  color: #fff;
  font-weight: bold;
}

.view {
  background-color: #000;
}

.my_content_main {
  margin-left: 50px;
}


#my_salary_list_wrap {
  padding: 57px 0 65px;
}


#my_salary_list_wrap #salary_list_total {
  overflow: hidden;
}

#my_salary_list_wrap #salary_list_total ul li {
  overflow: hidden;
  padding: 8px 19px 6px 30px;
  width: 960px;
  /* border-bottom: 1px solid #e0e0e0; */
  box-sizing: border-box;
}

#my_salary_list_wrap #salary_list_total .logo {
  display: table;
  overflow: hidden;
  float: left;
  margin-top: 29px;
  padding: 0 10px;
  width: 100px;
  height: 104px;
  border: 1px solid #efefef;
  text-align: center;
}

#my_salary_list_wrap #my_salary_list_total .my_company_info {
  float: left;
  padding: 26px 60px 0 20px;
  width: 570px;
  box-sizing: border-box;
}

#my_salary_list_wrap #my_salary_list_total .my_company_info .title {
  font-size: 18px;
  font-weight: bold;
  line-height: 19px;
}

#my_salary_list_wrap #my_salary_list_total .mark {
  display: inline-block;
  overflow: hidden;
  margin: 2px 0 0 9px;
  padding: 0 9px 2px 8px;
  height: 16px;
  border: 1px solid #ff6e51;
  color: #ff6e51;
  font-size: 11px;
  font-weight: normal;
  line-height: 16px;
  vertical-align: top;
}

#my_salary_list_wrap #my_salary_list_total .my_info_item {
  overflow: hidden;
  padding-top: 6px;
}

#my_salary_list_wrap #my_salary_list_total .my_info_item dt {
  float: left;
  padding: 1px 0 2px;
  width: 80px;
  height: 18px;
  border: 1px solid #e4e4e4;
  box-sizing: border-box;
  color: #888;
  font-size: 11px;
  line-height: 14px;
  text-align: center;
}

#my_salary_list_wrap #my_salary_list_total .my_info_item dd {
  overflow: hidden;
  padding: 0 7px 2px;
  color: #555;
  font-size: 13px;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.my_com_info {
  margin-left: 140px;
}
</style>
