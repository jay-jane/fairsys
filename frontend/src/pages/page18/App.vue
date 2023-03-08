
<!-- 회원정보 수정 페이지 -->
<template>
  <!-- 홈으로 넘어갈 수 있는 img 로고 헤더 -->
  <Header></Header>

  <!-- 아이디, 비밀번호 입력 하는 로그인 창 -->

  <h3>31번 페이지로 변경</h3>

  <section>
    <H3>회원정보 수정 페이지</H3>
    <input type="text" name="name" placeholder="이름"><br>
    <input type="text" name="id" placeholder="id"><br>
    <input type="password" name="pw" placeholder="pw"><br>
    <input type="password" name="pw_re" placeholder="pw_re"><br>
    <input type="email" name="email" placeholder="email"><br>
    <input type="number" name="hp_number" placeholder="hp_number"><br>
    <input type="text" name="adress" placeholder="adress"><br>
    <input type="radio" name="gender" value="man">남
    <input type="radio" name="gender" value="woman">여<br><br><br>
    <input type="submit" value="가입하기">

    <!-- 가입 후에는 바로 메인 페이지 이동 -->

    <!-- 광고 영역 -->
    <div class="ad">
      광고 영역
    </div>
  </section>

  <!-- 여기는 하단바 -->
  <Footer></Footer>
</template>
  
<script>
import Header from '../../components/layout/Header/Header.vue'
import Footer from '../../components/layout/Footer/Footer.vue'

export default {
  name: 'App',
  components: {
    Header,
    Footer
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

.ad {
  padding-top: 100px;
  height: 100px;
}
</style>
  
  