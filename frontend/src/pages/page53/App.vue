
<!-- Q&A 페이지 -->

<template>
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




  <section id="section">

  <div class="bbg">  
        <div class="bannerImg"></div>
        <div id="company_logo">
          <img src="https://picsum.photos/50/50" alt="로고" class="logoImg"></div>
        <div id="company_name">
        <h3>회사이름</h3>
        </div>
      <article id="article_top">
      <div id="top">
        <div id="top_bottom">
          <div id="company_title">
            <h2>공고제목</h2>
          </div>
        </div>
      </div>

      <div id="bottom">
        <div id="bottom_left">
          <h4>지원자격</h4>
          <div id="qualify">
            <span id="q_left">경력</span> <span id="q_right">경력</span><br>
            <span id="q_left">학력</span> <span id="q_right">대졸이상</span>
          </div>
        </div>
        <div id="bottom_left">
          <h4>근무조건</h4>
          <div id="qualify">
            <span id="q_left">고용형태</span> <span id="q_right">정규직</span><br>
            <span id="q_left">급여</span> <span id="q_right">회사 내규에 따름</span><br>
            <span id="q_left">근무지역</span> <span id="q_right">서울시 종로구</span>
          </div>
        </div>
      </div>
      <div id="bottom">
        <div id="bottom_left">
          <h4>기업정보</h4>
          <div id="qualify">
            <span id="q_left">산업(업종)</span> <span id="q_right">건설,시공,토목,조경</span><br>
            <span id="q_left">설립년도</span> <span id="q_right">1969년(55년차)</span><br>
            <span id="q_left">기업형태</span> <span id="q_right">대기업(주권(유가증권)상장)</span><br>
            <span id="q_left">홈페이지</span> <span id="q_right">qsenc.com</span>
          </div>
        </div>
        <div id="bottom_left">
          <h4>채용정보</h4>
          <div id="qualify">
            <span id="q_left">마감 일자</span> <span id="q_right">2022/03/03 14:00</span><br>
            <span id="q_left">전형 절차</span> <span id="q_right">서류 > 1차 면접 > 최종합격</span><br>
          </div><br>
          <h4>채용 담당자</h4>
          <div id="qualify">
            <span id="q_left">담당자</span> <span id="q_right">이이이</span><br>
            <span id="q_left">핸드폰 번호</span> <span id="q_right">010-1111-xxxx</span><br>
            <span id="q_left">이메일</span> <span id="q_right">dldldl@dldldl.dldl</span><br>

               
          </div>
        </div>
      </div>
      <hr>
    </article>
    <div class="btn" >
              
                <button class="btn1">승인</button>
                <button class="btn2">반려</button>
    </div>
  </div>
    
    

    
    

   
  
</section>

  <footer id="ft" style="border-top: 1px solid">
    <h3>여기 푸터야</h3>
  </footer>
</template>

<script>
export default {
  name: 'App',


methods: {
  
doLogout(){
  location.href="page50";
  }
}
};

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

#info_wrap ul {
  display: flex;
}

#info_wrap ul li {
  display: inline-block;
  margin-right: 15px;
}

#menu li {
  display: inline;
  padding-left: 20px;
}

#first_title {
  padding-top: 20px;
}

#article_top {
  padding-top: 120px;
}

#top_top {
  display: flex;
}

#company_name {
  position: absolute;
  top: 240px;
  left: 360px;
}

#banner_wrap {
  position: relative;
}

#banner_wrap .bannerImg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 200px;
  background-color: black;
  opacity: 0.5;
  z-index: 9;
}

#company_logo {
 
  float: right;
  border: 2px solid #fff;
}

#top_bottom {
  display: flex;
}

#company_title {
  margin-top: auto;
  padding-left: 120px;

}

#bottom {
  display: flex;
  justify-content: space-around;
  padding-top: 30px;
}

#q_left {
  color: gray;
  padding-right: 20px;
}

#q_right {
  color: blue;
}

#article_bottom {
  padding-top: 40px;
}


.bbg{
  padding: 100px 200px 300px 400px;
  margin: 10px;
}

.btn {
  text-align: center;
  margin: 30px;
}

.btn1{
  margin: 26px;
  width: 100px;
  height: 50px;
}

.btn2{
  margin: 25px;
  width: 100px;
  height: 50px;
}



#first_name {
  text-align: center;
}

#ft {
  text-align: center;
  border-bottom: 1px solid black;
  background: black;
}

#ft > h3 {
  color: azure;
}
</style>
