<!-- 재윤 - 쪽지함
<template>
  <header>
    <ul class="head">
      <li>메인로고</li>
      <li><a href="page7">등록</a></li>
      <li>공고 관리</li>
      <li>마이페이지</li>
      <li>로그인/로그아웃</li>
    </ul>
  </header>

  <section>
    <h3>쪽지함</h3>
    <button type="button" class="">받은 쪽지함</button>
    <button type="button" class="">보낸 쪽지함</button>

    <ul>
      <li>
        <table cellpadding="0" cellspacing="0" class="col_14" width="100%;">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>보낸 사람</th>
            <th>받은 일자</th>
          </tr>

          <tr>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
          </tr>
        </table>
      </li>
    </ul>
    <span>페이지네이션</span>
    <div>
      <a href="page22">쪽지 쓰기</a>
      <a href="#">메인</a>
    </div>
  </section>

  <footer style="text-align: center;">
    푸푸푸푸<br>
    터터터터
  </footer>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
* {
  list-style: none;
  text-decoration: none;
}

/* 폼 요소들의 스타일링 */
/* 전체 페이지 스타일링 */
body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}

/* 헤더 스타일링 */
header {
  background-color: #333;
  color: #fff;
  align-items: center;
  padding: 10px;
}

.head {
  display: flex;
  justify-content: space-between;
  align-items: center;
  list-style: none;
  margin: 0;
  padding: 0;
}

.head li {
  margin-right: 10px;
  font-weight: bold;
  cursor: pointer;
}

.head li a {
  color: #fff;
}

.head li:first-child {
  font-size: 24px;
}

/* 폼 요소들 스타일링 */
form {
  margin: 20px;
}

input[type="text"],
textarea {
  padding: 8px;
  margin: 8px 0;
  border-radius: 4px;
  border: 1px solid #ccc;
  width: 100%;
  max-width: 500px;
}

label {
  font-weight: bold;
}

/* 라디오 버튼 스타일링 */
input[type="radio"] {
  margin-right: 5px;
}

/* 버튼 스타일링 */
button[type="submit"] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #45a049;
}

/* 푸터 스타일링 */
footer {
  background-color: #f2f2f2;
  padding: 10px;
  font-size: 14px;
}
</style>
 -->

<!-- 재윤 - 받은 쪽지함 -->
<template>
 
  <nav id="top">
     <div id="logo"><a href="#">중앙정보 취업 박람회</a></div>
     <div id="menu"><a href="#" @mouseover="doDropmenu">채용정보</a></div>
     <div id="menu"><a href="#" @mouseover="doDropmenu">기업/연봉</a></div>
     <div id="menu"><a href="#" @mouseover="doDropmenu">마이페이지</a></div>
     <div id="login"><button class="btn_login" @click="gologin">로그인</button></div>
   </nav>
   <nav id="drop_top" @mouseleave="doHidden">
     <div id="drop">
       <p><a href="#" class="drop_menu" >직무별</a></p>
       <p><a href="#" class="drop_menu" >산업별</a></p>
       <p><a href="#" class="drop_menu" >지역별</a></p>
       <p><a href="#" class="drop_menu" >기업별</a></p>
     </div>
     <div id="drop">
       <p><a href="#" class="drop_menu" >기업정보</a></p>
       <p><a href="#" class="drop_menu" >연봉정보</a></p>
     </div>
     <div id="drop">
       <p><a href="#" class="drop_menu" >이력서관리</a></p>
       <p><a href="#" class="drop_menu" >Q&A</a></p>
     </div>
   </nav>
 
 
   <div class="btn-group">
     <button class="btn_qna" @click="getMessageBox">받은 쪽지함</button>
     <button class="btn_inquiry" @click="sendMessageBox">보낸 쪽지함</button>
   </div>
 
   <div class="main">
     <div class="container">
       <table class="list">
         <thead class="head">
           <tr>
             <th>번호</th>
             <th>제목</th>
             <th>보낸 사람</th>
             <th>받은 일자</th>
           </tr>
         </thead>
 
         <tbody class="body">
           <tr>
             <td>1</td>
             <td><a href="page29">받은 쪽지 제목1 </a></td>
             <td>이이이</td>
             <td>2023.03.06</td>
           </tr>
           <tr>
             <td>2</td>
             <td>사이트 이용 안내 </td>
             <td>사이트 이용 안내 </td>
             <td>2023.03.02</td>
           </tr>
           <tr>
             <td>3</td>
             <td>사이트 이용 안내 </td>
             <td>사이트 이용 안내 </td>
             <td>2023.03.02</td>
           </tr>
         </tbody>
       </table>
 
     </div>
   </div>
 
   <div id="bottom">
     중앙정보처리 채용 박람회<br />
     서울 강남구 테헤란로 7길 7(역삼동 에스코빌딩 6층) / 대표자:정현경<br />
     TEL:02-561-1911 / FAX:02-538-2613
   </div>
 </template>
 
 <script>
 
 export default {
   name: 'App',
 
   methods: {
     getMessageBox() {
       location.href = "page21";
     },
     sendMessageBox() {
       location.href = "page25";
     },
     gologin() {
       location.href = "page2";
     }, 
     doDropmenu(){
       const dorp_top = document.querySelector("#drop_top");
       dorp_top.style.display = "block";
     },
     doHidden(){
       const dropMenu_hidden = document.querySelector("#drop_top");
       dropMenu_hidden.style.display="none";
     }
   }
 };
 </script>
 
 <style>
 @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
 
 * {
   padding: 0;
   margin: 0;
   font-family: 'Noto Sans KR', sans-serif;
   text-decoration: none;
 }
 
 /* header 디자인 */
  /* 헤더 기본메뉴 */
  #top{
     font-size: 18px;
     font-weight: 500;
     text-align: center;
     border-bottom: 2px solid rgba(0,0, 0, 0.2);
   }
 
   #top div{
     display: inline-block;
     height: 100px;
   }
 
   #menu{
     width: 200px;
     line-height: 100px;
     display: inline-block;
   }
 
   #logo{
     float: left;
     margin-left: 50px;
     line-height: 100px;
   }
 
   /* 헤더 드롭다운 메뉴 */
   #drop_top {
     display: none;
     text-align: center;
     background-color: orange;
   }
 
   #drop {
     margin-bottom: 20px;
     width: 200px;
     line-height: 60px;
     display: inline-block;
     vertical-align: top;
   }
 
   #drop a{
     color: white;
     font-size: 18px;
   }
 
   #drop a:hover{
     color: black;
   }
 
   /* 로그인버튼 */
   #login{
     float: right;
     margin-right: 50px;
     line-height: 100px;
   }
 
   .btn_login{
     font-size: 18px;
     font-weight: 500;
     color:  white;
     background-color: orange;
     border: none;
     border-radius: 30px;
     height: 50px;
     width: 160px;
   }
 
   .btn_login:hover{
     color: white;
     background-color: black;
   }
 
 
 
 /* 콘텐츠화면 */
 .main {
   display: flex;
   justify-content: center;
   height: 600px;
   margin-top: 50px;
   margin-bottom: 50px;
 }
 
 .container {
   border: 1px solid black;
   margin-top: 20px;
   margin-bottom: 20px;
 }
 
 table {
   border: 0;
   padding: 0;
   margin: 0;
 }
 
 table caption {
   display: none;
 }
 
 .list {
   display: table;
   clear: both;
   width: 1200px;
   border-collapse: collapse;
 }
 
 .list th {
   border-color: #333333;
   background: #fcfcfc;
   padding: 10px 0 10px 0;
   text-align: center;
   border-top-width: 2px;
   border-bottom-width: 1px;
   border-top-style: solid;
   border-bottom-style: solid;
   font-weight: 400;
 }
 
 .list .body td {
   text-align: center;
   padding: 5px 9px 5px 9px;
   border-bottom-color: #eeeeee;
   border-bottom-width: 1px;
   border-bottom-style: solid;
 }
 
 .btn-group {
   text-align: center;
   margin-top: 100px;
 }

 .btn-group button:hover {
  cursor: pointer;
  background-color: orange;
 }
 
 .btn_qna {
   width: 200px;
   height: 70px;
   background-color: orange;
   color: white;
   border: none;
   border-radius: 45px;
   margin-right: 20px;
   font-size: 24px;
   font-weight: 600;
   font-family: 'Noto Sans KR', sans-serif;
 }
 
 .btn_inquiry {
   width: 200px;
   height: 70px;
   background-color: lightslategray;
   border: none;
   border-radius: 45px;
   margin-left: 20px;
   color: white;
   font-size: 24px;
   font-weight: 400;
   font-family: 'Noto Sans KR', sans-serif;
 }
 
 /* footer 디자인 */
 #bottom {
   height: 260px;
   background-color: black;
   color: white;
   display: flex;
   align-items: center;
   justify-content: center;
   text-align: center;
 }
 </style>
 
 