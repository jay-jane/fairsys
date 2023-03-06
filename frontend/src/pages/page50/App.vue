
<!-- Q&A 페이지 -->

<template>
 <div id="menu">
    <img src="#" alt="">
</div>

  <section id="section">
    <h3 id="first_name">관리자 로그인</h3>


	<form>
        <div class="login_info">
            아이디<input type="email" placeholder="Email Address"><br>
            
            비밀번호<input type="email" placeholder="Email Address">
           
        </div>
        <button>로그인</button><br>

        <div class="ad">
        <img src="#">
        </div>
    </form>

  </section>

  <footer id="ft" style="border-top: 1px solid">
    <h3>여기 푸터야</h3>
  </footer>
</template>

<script>

export default {
  name: "App",


};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
a {
  text-decoration: none;
  color: white;
}
#menu {
  font: bold 16px "malgun gothic";
  width: 100%;
  height: 50px;
  background: black;
  color: black;
  line-height: 50px;
  margin: 0 auto;
  text-align: center;
  padding: auto;
  border-bottom: 1px solid;
}


#first_name {
  text-align: center;
}

#first{
  display: flex;
  justify-content: center;
}

#second{
  display: flex;
  justify-content: center;
}



.ad{
   text-align: center;
}

form{
         
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
