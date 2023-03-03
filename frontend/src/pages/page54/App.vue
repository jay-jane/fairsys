
<template>

<!--공고페이지--> 

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

    <div id="full"> 
          <h3>지원자 상세페이지</h3>
   
   
            <div id="left">
              이름<input type="text"><br>
              아이디입력창<input type="text"><br>
              비밀번호<input type="text"><br>
              비밀번호재입력<input type="text"><br>
              이메일입력<input type="text"><br>
              헨드폰번호<input type="text"><br>
              자택주소입력<input type="text"><br>
              성별<input type="text"><br>
            </div>



            <div id="right">
              희망직무<input type="text"><br>
              핵심역량<input type="text"><br>
              희망연봉<input type="text"><br>
          
              자격증<input type="text"><br>
              해외경험<input type="text"><br>
              수상<input type="text"><br>
             어학<input type="text"><br>
              자기소개서<input type="text"><br>
              학력<input type="text"><br>
              경력<input type="text"><br>
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

#full{
	width: 600px;
	height: 600px;
	
	margin: auto; /* 중앙 맞춤 */
}

#left{
	width: 200px;
	float: left;	
}


#right{
	width: 200px;
	float: left;
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









</style>

