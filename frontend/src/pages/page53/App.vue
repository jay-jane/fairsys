
<!-- Q&A 페이지 -->

<template>
 



  <section id="section">
      <h3>회사이름</h3>
      <div class="bbg">       
        <div id="company_logo">
          <img src="https://picsum.photos/50/50" alt="로고" class="logoImg"></div>
        



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


* {margin: 0; padding: 0;}


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
