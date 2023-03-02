
<!-- 마이페이지 -->
<template>
  <!-- 여기는 상단바 -->
  <header id="header">

    
    <!-- 메뉴바 -->
    <div id="menu">
      
      <ul>
        <!-- 로고 -->
        <li><img src="#"></li>
        <li><a href="http://localhost:8081/page14">채용정보</a></li>
        <li><a href="http://localhost:8081/page15">기업/연봉</a></li>
        <li><a href="http://localhost:8081/page12">마이페이지</a></li>
        <li><a href="http://localhost:8081/page2">로그인</a></li>
      </ul> 
    </div>
      
    <!-- 로그인버튼 -->

  </header>


  <section id="section">
    
    <ul id="section_menu">
      <li><a href="회원정보 수정페이지">회원 정보 수정</a></li>
      <li>탈퇴</li>
      <!-- 회원정보 수정 및 탈퇴를 위해서는 비밀번호 입력을 하게 해야할듯? -->
      
      <li><a href="http://localhost:8081/page13">이력서 작성</a></li>
      <li><a href="지원 현황 확인 페이지">지원 현황 확인</a></li>

      <li><a href="http://localhost:8081/page16">Q&A</a></li>
      <li><a href="쪽지함 페이지 ">쪽지함</a></li>
    
      
    </ul>
    
    여기에는 광고 배너 및 공고 들어가고<br/>

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
*{
  margin: 0;
  padding: 0;
  list-style: none;
  text-align: center;
}

#header{
  
}
#menu li{
  display: inline;
  padding-left: 20px;
}

#section_menu{
  display: flex;
  justify-content: space-between;

}

#menu li{
  width: 100px;
  height: 50px;
  }


#section{
  line-height: 100px;
}

#footer{
  height: 200px;
}
</style>
