
<!-- 메인 페이지 -->
<template>
  <!-- 여기는 상단바 -->
 
  
  <Header></Header>

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
