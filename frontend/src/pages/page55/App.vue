
<!-- Q&A 페이지 -->

<template>
 <div id="menu">
    <img src="#" style="float: left" />
    <ul>
      <li>
        <a href="page4">공고</a>
        <ul>
          <li><a href="page52">공고상세페이지</a></li>
        </ul>
      </li>
      <li>
        <a href="page3">업체</a>
        <ul>
          <li><a href="page53">업체상세페이지</a></li>
        </ul>
      </li>
      <li>
        <a href="page42">통계</a>
        <ul>
          <li><a href="#">기간별 지원자</a></li>
          <li><a href="#">업체별 모집</a></li>
        </ul>
      </li>
      <li>
        <a href="#">Q&A</a>
        <ul>
          <li><a href="#">등록</a></li>
          <li><a href="#">내역확인</a></li>
        </ul>
      </li>
    </ul>
    <button @click="logout" style="float: right">로그아웃</button>
  </div>

     <section>

     
            <h3 id="first_name">공고상세페이지</h3>
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


  <footer id="ft" style="border-top: 1px solid">
    <h3>여기 푸터야</h3>
  </footer>
</template>

<script>
export default {
  name: 'App',


methods: {
  
logout(){
  location.href="page50";
  }
}
};


</script>

<style>
* {
  margin: 0;
  padding: 0;
}
#menu a {
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
#menu > ul {
  list-style: none;
  display: inline-block;
  text-align: center;
}

#menu > ul > li {
  float: left;
  width: 140px;
  position: relative;
}
#menu > ul > li > ul {
  width: 130px;
  display: none;
  position: absolute;
  font-size: 14px;
  background: skyblue;
  list-style: none;
}
#menu > ul > li:hover > ul {
  display: block;
}
#menu > ul > li > ul > li:hover {
  background: orange;
  transition: ease 1s;
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

a {
  text-decoration: none;
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
