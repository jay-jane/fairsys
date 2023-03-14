
<template>
  <div class="admin_nav">
    <ul>
      <li class="sub_menu_toggle">
        <a class="sub menu select">채용공고</a>
        <ul class="sub_menu" style="display: block;">
          <li><router-link to="/16">공고등록</router-link></li>
          <li><a href="">공고 수정</a></li>
          <!-- <router-link :to="{name:'page8'}">공고수정</router-link> -->
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">이력서</a>
        <ul class="sub_menu">
          <li><router-link to="/10">이력서리스트</router-link></li>
          <li><a href="#"></a></li>
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
          <li><a href="page34">회원탈퇴</a></li>
        </ul>
      </li>
    </ul>
  </div>



  <div class="content_main">
    <div class="content">
      <table>
        <div id="salary_list_wrap">
          <div id="salary_list_total">
            <ul>
              <li class="com_info">
                <a href="#" class="logo"><img src="" alt="로고"></a>
                <div class="company_info">
                  <strong class="title">회사명</strong>
                  <a href="#" class="mark">채용중</a>
                  <dl class="info_item">
                    <dt></dt>
                    <dd>내용1</dd>
                  </dl>
                  <dl class="info_item">
                    <dt>정보2</dt>
                    <dd>내용2</dd>
                  </dl>
                  <dl class="info_item">
                    <dt>정보3</dt>
                    <dd>내용3</dd>
                  </dl>
                </div>
              </li>
            </ul>
          </div>
        </div>

      </table>
      <table>
        <caption>채용공고 현황</caption>

        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>채용 마감일</th>
            <th>
              <select name="" id="salary">
                <option value="">전체</option>
                <option value="">채용 전</option>
                <option value="">진행중</option>
                <option value="">채용마감</option>
              </select>
            </th>
            <th>조회</th>
          </tr>
        </thead>
        <tbody id="table-body">
          <tr>
            <td>1</td>
            <td>2</td>
            <td>2023-03-06</td>
            <td>진행상황</td>
            <td><input type="submit" value="조회" class="view"></td>
          </tr>

        </tbody>
      </table>


      <table>
        <caption>지원자 관리 </caption>

        <thead>
          <tr>
            <th>번호</th>
          <th>채용 공고명</th>
          <th>지원자</th>
          <th>조회</th>
          <!-- <th>
              <select name="" id="salary">
                <option value="">전체</option>
                  <option value="">합격</option>
                  <option value="">불합격</option>
                </select>
              </th> -->
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>2</td>
            <!-- <td>진행상황</td> -->
            <td><a href="page6" style="text-decoration: underline; font-weight: 700;">1</a></td>
            <td><button class="view" @click="btn_view">조회</button></td>
          </tr>
        </tbody>
      </table>
    </div>

  </div>
</template>

<script>
// import axios from "axios";


export default {
  name: 'App',
  data() {
    return {
      str: {
        id: "1",
        name: "test"
      },
    };
  },
  methods: {
    btn_view() {
      location.href = "page6";
    },
    getData() {
      // axios.post("update", this.str).then(response => {console.log(response.data);});
    },
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {
  margin: 0;
  padding: 0;
  font-family: 'Noto Sans KR', sans-serif;
  text-decoration: none;
  color: black;
  box-sizing: border-box;
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

.content{
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

.content_main {
  margin-left: 50px;
}


#salary_list_wrap {
  padding: 57px 0 65px;
}


#salary_list_wrap #salary_list_total {
  overflow: hidden;
}

#salary_list_wrap #salary_list_total ul li {
  overflow: hidden;
  padding: 8px 19px 6px 30px;
  width: 960px;
  /* border-bottom: 1px solid #e0e0e0; */
  box-sizing: border-box;
}

#salary_list_wrap #salary_list_total .logo {
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

#salary_list_wrap #salary_list_total .company_info {
  float: left;
  padding: 26px 60px 0 20px;
  width: 570px;
  box-sizing: border-box;
}

#salary_list_wrap #salary_list_total .company_info .title {
  font-size: 18px;
  font-weight: bold;
  line-height: 19px;
}

#salary_list_wrap #salary_list_total .mark {
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

#salary_list_wrap #salary_list_total .info_item {
  overflow: hidden;
  padding-top: 6px;
}

#salary_list_wrap #salary_list_total .info_item dt {
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

#salary_list_wrap #salary_list_total .info_item dd {
  overflow: hidden;
  padding: 0 7px 2px;
  color: #555;
  font-size: 13px;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.com_info {
  margin-left: 140px;
}
</style>
