
<!-- Q&A 페이지 -->

<template>



  <div class="out">
      <div class="out-out">
        <form action="#">
              <img src="#">
              <h3>관리자 페이지 로그인</h3>
            <input type="text" placeholder="아이디" class="in">
            <input type="password" placeholder="비밀번호" class="in">
            <input type="submit" id="btn" value="로그인"><br>
        </form>
        <a href="#none">비밀번호를 잊어버리셨나요?</a>
      </div>
  </div>

    <div class="ad">
      <img src="#">
    </div>

  
 
  <footer id="ft" style="border-top: 1px solid">
    
  </footer>

</template>

<script>
export default {
  name: 'App'


}
</script>

<style>
   @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            background-color:   sandybrown;
        }
        .out{
          margin: 100px;
        }

        .out-out {
            margin: auto;
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;

        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }

        .in {
            margin-bottom: 10px;
        }

        #btn {
            background-color: #bc1b1e;
            margin-bottom: 30px;
            color: white;
        }

        a {
            text-decoration: none;
            color: #9B9B9B;
            font-size: 12px;
        }

        .ad{
          text-align: center;
        }
</style>
