
<!-- 메인 페이지 -->
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
        <!-- 로그인이 되면 로그아웃으로 변경이 되야함 -->
      </ul> 
    </div>
      
    <!-- 로그인버튼 -->

  </header>


  <section id="section">
  여기에는 광고 배너 및 공고 들어가고<br/>

  <ul>
    <li>대충 이미지랑 링크 걸어줄거 시간되면 하기</li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>

  </ul>

  <!-- 더보기 버튼 -->
  <button type="button" >더보기</button>

  </section>


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


#section{
  height: 200px;
  line-height: 100px;
}

#footer{
  height: 200px;
}
</style>
