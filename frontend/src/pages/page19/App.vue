
<!-- 이력서 수정페이지 -->
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
  
  <h3>인적사항</h3>
  <input type="text" name="name"  placeholder="이름" >
  <input type="text" name="birth"  placeholder="생년월일" >
  <select>
    <option value="">성별</option>
    <option value="남">남</option>
    <option value="여">여</option>
  </select>
  <input type="email" name="email"  placeholder="email" ><br>
  
  <input type="text" name="hp_number"  placeholder="hp_number">
  <input type="text" name="adress"  placeholder="adress" ><br>
  
  <br><hr>
  
  <h3>희망직무</h3>
  <input type="text" name="task"  placeholder="직무" ><br>
  
  <br><hr>
  
  <h3>자격증/어학</h3>
  <input type="text" name="license"  placeholder="자격증" ><br>
  
  <input type="text" name="language"  placeholder="어학" ><br>
  <br><hr>
  
  
  
  <h3>학력</h3>
  <input type="text" name="education"  placeholder="학력" ><br>
  
  <br><hr>
  
  <h3>희망 근무조건</h3>
  <input type="text" name="salary"  placeholder="희망연봉" ><br>
  
  <input type="text" name="language"  placeholder="어학" ><br>
  <br><hr>
  

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




#footer{
  height: 200px;
}
</style>
