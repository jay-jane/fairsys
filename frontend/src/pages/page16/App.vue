

<template>
  <!-- 여기는 상단바 -->
  <header id="header">


    <!-- 메뉴바 -->
    <div id="menu">
      <ul>
        <!-- 로고 -->
        <li><img src="#"></li>
        <li><a href="page14">채용정보</a></li>
        <li><a href="page15">기업/연봉</a></li>
        <li><a href="page12">마이페이지</a></li>
        <li><a href="page2">로그인</a></li>
      </ul>
    </div>

    <!-- 로그인버튼 -->

  </header>

  <h3>23번 페이지로 변경 </h3>
  <h3 id="first_title">채용정보</h3>
  <section id="section">
    <article id="article_top">

      <div id="top">
        <div id="top_top">

          <p id="company_name">회사이름</p>
          <p id="company_logo">로고</p>
        </div>

        <div id="top_bottom">
          <p id="company_title">채용제목</p>
        </div>
      </div>

      <div id="bottom">
        <div id="bottom_left">
          <h4>지원자격</h4>
          <div id="qualify">
            <span id="q_left">경력</span> <span id="q_right">경력</span><br>
          </div>
          <div id="qualify">
            <span id="q_left">학력</span> <span id="q_right">대졸이상</span>
          </div>

        </div>
        <div id="bottom_left">
          <h4>근무조건</h4>
          <div id="qualify">
            <span id="q_left">고용형태</span> <span id="q_right">정규직</span><br>
          </div>
          <div id="qualify">
            <span id="q_left">급여</span> <span id="q_right">회사 내규에 따름</span><br>
          </div>
          <div id="qualify">
            <span id="q_left">지역</span> <span id="q_right">서울시 종로구</span>
          </div>

        </div>
        <div id="bottom_left">
          <h4>기업정보</h4>
          <div id="qualify">
            <span id="q_left">산업(업종)</span> <span id="q_right">건설,시공,토목,조경</span><br>
          </div>
          <div id="qualify">
            <span id="q_left">사원수</span> <span id="q_right">6,583명</span><br>
          </div>
          <div id="qualify">
            <span id="q_left">설립년도</span> <span id="q_right">1969년(55년차)</span><br>
          </div>
          <div id="qualify">
            <span id="q_left">기업형태</span> <span id="q_right">대기업(주권(유가증권)상장)</span><br>
          </div>
          <div id="qualify">
            <span id="q_left">홈페이지</span> <span id="q_right">qsenc.com</span>
          </div>

        </div>

      </div>
      <hr>
    </article>

    <article id="article_bottom">

      <div id="section_bottom">
        <h3>상세요강</h3>

      </div>
    </article>



  </section>

  <!-- 여기는 하단바 -->
  <footer id="footer">
    저작권 정보?

  </footer>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  list-style: none;
  text-align: center;
}



#menu li {
  display: inline;
  padding-left: 20px;
}

#first_title {
  padding-top: 20px;
}

#article_top {
  padding-top: 40px;
}


#top_top {
  display: flex;

}


#company_name {
  padding-left: 120px;
}

#company_logo {
  margin-left: auto;
  padding-right: 120px;
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

#qualify {
  text-align: left;
  display: flex;
}

#q_left {
  color: gray;
  padding-right: 40px;
  flex: auto;
  text-align: left;
  box-sizing: border-box;
}


#q_right {
  color: blue;
  flex: auto;
  text-align: right;
  box-sizing: border-box;


}

#article_bottom {
  padding-top: 40px;

}

#footer {
  height: 200px;
}
</style>
