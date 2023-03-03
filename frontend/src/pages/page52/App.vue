
<template>

<!--공고상세 내용--> 

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

  <section>

     
          <h3>공고상세페이지</h3>
   
   <div id="first">
            <div>
              기업명1<input type="text"><br>
              제목<input type="text"><br>
              고용형태<input type="text"><br>
              급여<input type="text"><br>
              지역<input type="text"><br>
            </div>

            <div>
              기업로고<input type="text"><br>
              기업정보<input type="text"><br>
              산업<input type="text"><br>
              사원수<input type="text"><br>
              기업형태<input type="text"><br>
              홈페이지<input type="text"><br>
            </div>

      
    </div>
          
    <br><br>
        <div id="second">
          <div>
              상세요강<input type="text"><br>
              이미지<input type="text"><br>
              내용<input type="text"><br>
              모집분야 자격조건<input type="text"><br>
              담당업무<input type="text"><br>
              접수방법<input type="text"><br>
          </div>

          <div>
              <button><a href="page51">지원자 목록</a></button>
              <button>공고삭제</button>
            
          </div>

        </div>  





  </section> 






<footer style="border-top: 1px solid">

ㅇ
ㅇ
ㅇ
ㅇ
ㅇ
ㅇ
ㅇ
ㅇ

ㅇ
ㄴ
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


#first{
  display: flex;
  justify-content: center;
}

#second{
  display: flex;
  justify-content: center;
}





</style>

