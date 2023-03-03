<!-- 재윤 - 채용 공고 상세 -->
<template>
  <header>
    <ul class="head">
      <li><a href="">메인로고</a></li>
      <li><a href="">등록</a></li>
      <li><a href="">공고 관리</a></li>
      <li><a href="">마이페이지</a></li>
      <li><a href="page2">로그인/로그아웃</a></li>
    </ul>
  </header>

  <section id="section">
    <div id="banner_wrap">
      <img src="https://picsum.photos/1000/100" alt="배너" width="100%" height="200px">
      <div class="bannerImg"></div>
      <div id="company_logo"><img src="https://picsum.photos/150/150" alt="로고" class="logoImg"></div>
      <div id="company_name">
        <h3>회사이름</h3>
      </div>
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

    <article id="article_bottom">
      <div id="section_bottom">
        <h3>상세 내용</h3>
        <p>내용12345</p>
      </div>
    </article>
    <div id="location_wrap">
      기업 위치
      <div id="kakao">
        (카카오맵api)
      </div>
    </div>

    <div id="button_wrap" style="margin-top: 20px;">
      <a href="#">입사지원</a><br>
      <a href="#">수정/삭제</a><br>
      <a href="#">목록</a>
    </div>
  </section>

  <footer style="text-align: center;">
    푸푸푸푸<br>
    터터터터
  </footer>
</template>

<script>
export default {
  name: 'App',
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  list-style: none;
  text-align: center;
}

body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}

/* 헤더 스타일링 */
header {
  background-color: #333;
  color: #fff;
  align-items: center;
  padding: 10px;
}

.head {
  display: flex;
  justify-content: space-between;
  align-items: center;
  list-style: none;
  margin: 0;
  padding: 0;
}

.head li {
  margin-right: 10px;
  font-weight: bold;
  cursor: pointer;
}

.head li:first-child {
  font-size: 24px;
}

.head li a {
  color: #fff;
  text-decoration: none;
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
  position: absolute;
  top: 66%;
  left: 10%;
  z-index: 999;
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

/* 푸터 스타일링 */
footer {
  background-color: #f2f2f2;
  padding: 10px;
  font-size: 14px;
}
</style>
