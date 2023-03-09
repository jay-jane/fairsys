<!-- 재윤 - 기업 정보 화면 -->
<template>
  <Header></Header>

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
            <h2>기업 정보</h2>
          </div>
        </div>
      </div>

      <div id="mid" style="margin-bottom: 10px;">
        <div id="bottom_left">
          <div id="qualify">
            <span id="q_left">산업(업종)</span> <span id="q_right">건설,시공,토목,조경</span><br>
            <span id="q_left">설립년도</span> <span id="q_right">1969년(55년차)</span><br>
            <span id="q_left">주소</span> <span id="q_right">기업주소</span><br>
            <span id="q_left">홈페이지</span> <span id="q_right">qsenc.com</span>
          </div>
        </div>
        <div id="bottom_left">
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
        <h3>진행 중인 채용</h3>
        <p>내용(게시판)</p>
      </div>
    </article>
    <div id="location_wrap" style="margin-top: 20px;">
      기업 위치
      <div id="kakao">
        (카카오맵api)
      </div>
    </div>

    <div id="button_wrap" style="margin-top: 20px;">
      <a href="#">수정</a><br>
      <a href="#">목록</a>
    </div>
  </section>

  <Footer></Footer>
</template>

<script>
import Header from '../../components/layout/Header/Header.vue'
import Footer from '../../components/layout/Footer/Footer.vue'

export default {
  name: 'App',
  components: {
    Header,
    Footer,
  }
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
  font-family: Arial, sans-serif;
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

#mid {
  display: flex;
  justify-content: space-around;
  padding-top: 30px;
}

#qualify {
  overflow: hidden;
}
#q_left {
  float: left;
  color: gray;
  padding-right: 20px;
}
#q_right {
  float: right;
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
