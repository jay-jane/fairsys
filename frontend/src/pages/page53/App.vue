
<!-- Q&A 페이지  -->

<template>
 <header class="head">
      
      <div class="menu1" style="border-bottom: 1px solid" >
          <img src="#" style="float:left">
            <ul>
              <li><a href="#">공고 </a></li>
              <li><a href="#">업체</a></li>
              <li><a href="#">통계</a></li>              
              <li><a href="#">Q&A</a></li>  
              <button style="float:right">로그아웃</button>     
            </ul>
          
        </div>
  </header> 



  <section id="section">

    <h3>업체상세페이지</h3>

 
    <div id="first">
            <div>
              기업정보<input type="text"><br>
              산업(업종)<input type="text"><br>
              사원수<input type="text"><br>
              기업형태<input type="text"><br>
              홈페이지<input type="text"><br>
            </div>
    </div>


    <div id="second">
            <div>
              기업구분<input type="text"><br>
              주소<input type="text"><br>
              대표자<input type="text"><br>
            </div>
  
    </div>

     <div id="thr">
        <div>
        기업형태<input type="text"><br>
        사업자번호<input type="text"><br>
        회사명<input type="text"><br>
        대표자명<input type="text"><br>
        회사주소<input type="text"><br>
        대표자<input type="text"><br>
        </div>
      </div>

      <div id="fou">
        <div>
        인사담당자<input type="text"><br>
        아아디<input type="text"><br>
         비번<input type="password"><br>
        가입자명<input type="text"><br>
        전화번호<input type="text"><br>
        이메일<input type="text"><br>
        </div>
      </div>





  </section>

  <footer style="border-top: 1px solid">


내용아직안넣음





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

html{
width: "100%"; 
border: 1px solid #444444;
  
}



.head ul{
list-style:none;
text-align: center;
padding: 10px 0px
}

.head ul li{
  display: inline;
  padding: 0px 10px 0px 10px;
}

#footer {
  height: 200px;
}
</style>
