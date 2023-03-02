<!-- 재윤 - 기업 정보 -->
<template>
  <header>
    <ul class="head">
      <li>메인로고</li>
      <li>등록</li>
      <li>공고 관리</li>
      <li>마이페이지</li>
      <li>로그인/로그아웃</li>
    </ul>
  </header>

  <section>
    <h3 style="text-align: center;">기업 정보 페이지</h3>
    <div id="banner_wrap">
      <div>기업관련 이미지 배너 <img src="" alt=""></div>
    </div>
    <div id="logo_wrap">
      기업 로고 이미지 데이터<img src="" alt="">
    </div>
    <div id="title_wrap">
      <div id="">
        기업명 데이터
      </div>
      <div id="menu_wrap">
        <ul>
          <li><a href="">정보</a></li>
          <li><a href="">채용</a></li>
          <li><a href="">Q&A</a></li>
        </ul>
      </div>
    </div>
    <div id="content_wrap">
      <div id="img_wrap">
        <img src="" alt="">
      </div>
      <div id="">
        <p>상세내용(데이터 히든태그로 넣기)</p>
      </div>
      <div id="">
        기업 위치
        <div class="kakaoAPI">(카카오맵api)</div>
      </div>
      <div id="">
        기업정보
      </div>
    </div>
    <div id="button_wrap">
      <input type="button" value="지원하기"><br>
      <input type="button" value="수정"><br>
      <input type="button" value="목록">
    </div>
  </section>

  <footer style="text-align: center;">
    푸푸푸푸<br>
    터터터터
  </footer>
</template>

<script>
export default {
  name: 'App',
}
</script>

<style>
* {
  list-style: none;
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

#info_wrap ul {
  display: flex;
}

#info_wrap ul li {
  display: inline-block;
  margin-right: 15px;
}

/* 푸터 스타일링 */
footer {
  background-color: #f2f2f2;
  padding: 10px;
  font-size: 14px;
}
</style>
