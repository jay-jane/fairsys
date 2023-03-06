
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
      </li>
    </ul>
    <button @click="logout"  style="float: right">로그아웃</button>
  </div>

  <section id="section">
    <h3 id="first_name">업체상세페이지</h3>

    <div id="bg">
      <div id="first">
        <div>
          기업정보<input type="text" /><br />
          산업(업종)<input type="text" /><br />
          사원수<input type="text" /><br />
          기업형태<input type="text" /><br />
          홈페이지<input type="text" /><br />
        </div>
      </div>

      <div id="second">
        <div>
          기업구분<input type="text" /><br />
          주소<input type="text" /><br />
          대표자<input type="text" /><br />
        </div>
      </div>

      <div id="thr">
        <div>
          기업형태<input type="text" /><br />
          사업자번호<input type="text" /><br />
          회사명<input type="text" /><br />
          대표자명<input type="text" /><br />
          회사주소<input type="text" /><br />
          대표자<input type="text" /><br />
        </div>
      </div>

      <div id="fou">
        <div>
          인사담당자<input type="text" /><br />
          아아디<input type="text" /><br />
          비번<input type="password" /><br />
          가입자명<input type="text" /><br />
          전화번호<input type="text" /><br />
          이메일<input type="text" /><br />
        </div>
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

#ft {
  text-align: center;
  border-bottom: 1px solid black;
  background: black;
}

#ft > h3 {
  color: azure;
}
</style>
