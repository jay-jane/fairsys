
<!-- Q&A 페이지 -->

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


  <section id="section">

    <h3>6번 페이지로 변경</h3>

 
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

#header {}

#menu li {
  display: inline;
  padding-left: 20px;
}



#section_menu {
  display: flex;
  justify-content: center;
}

tr{
  display: flex;
  justify-content: center;
}

#footer {
  height: 200px;
}
</style>
