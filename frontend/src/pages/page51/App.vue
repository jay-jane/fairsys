
<template>

<!--지원자목록-->
  <header>
      
    <div class="menu1" style="border-bottom: 1px solid">
          <img src="#" style="float:left">
            <ul>
              <li><a href="#">공고</a></li>
              <li><a href="#">업체</a></li>              
              <li><a href="#">통계</a></li>
              <li><a href="#">Q&A</a></li>  
              <button style="float:right">로그아웃</button>       
            </ul>
        
      </div>
  </header> 
    <section>

      
        <table border="1" width="500">
        <tr>
            <td>번호</td>
            <td>이름</td>
            <td>공고제목</td>
            <td>등록일</td>
 
        </tr>
        <tr>
            <td>ㅌㅌㅌㅌ</td>
            <td>ㅌㅌㅌ</td>
            <td>ㅌㅌㅌ</td>
            <td>ㅌㅌㅌ</td>
  
        </tr>
        <tr>
            <td>ㅌㅌㅌㅌ</td>
            <td>ㅌㅌㅌㅌ</td>
            <td>ㅌㅌㅌ</td>
            <td>ㅌㅌㅌ</td>  
        </tr>
    </table>
 
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

html{
width: "100%"; 
border: 1px solid #444444;
  
}


  ul{
list-style:none;
text-align: center;
padding: 10px 0px
}

ul li{
  display: inline;
  padding: 0px 10px 0px 10px;
}




table {

  
  margin-left:auto; 
  margin-right:auto;
  
  border: 1px #444444 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 50%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}



</style>
