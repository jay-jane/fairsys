
<!-- 로그인페이지 -->
<template>
<!-- 홈으로 넘어갈 수 있는 img 로고 헤더 -->
<header>
  <img src="#">
</header>

<!-- 아이디, 비밀번호 입력 하는 로그인 창 -->
<section>
  <input type="text" name="id"  placeholder="id" ><br>
  <input type="password" name="pw"  placeholder="pw" ><br><br><br>
  <input type="submit" value="로그인">
<a href="http://localhost:8081/page11">회원가입하기</a><br>
  <a href="아이디 찾기링크">아이디 찾기</a> /
  <a href="비밀번호 찾기 찾기링크">비밀번호 찾기</a>

  <!-- 광고 영역 -->
  <div class="ad">
    광고 영역
  </div>
</section>

<!-- 여기는 하단바 -->
<footer>

  
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
.ad{
  padding-top: 100px;
  height: 100px;
}
</style>

