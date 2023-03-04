
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
        <a href="page9">Q&A</a>       
      </li>
    </ul>
    <button @click="logout"  style="float: right">로그아웃</button>
  </div>

  <section id="section">
    <h3 id="first_name">지원자상세페이지</h3>

    <div id="full"> 
          
   
   
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










#ft {
  text-align: center;
  border-bottom: 1px solid black;
  background: black;
}

#ft > h3 {
  color: azure;
}
</style>
