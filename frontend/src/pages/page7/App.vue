<!-- 재윤 - 채용 공고 등록 -->
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
    <h3 style="text-align: center;">채용 공고 등록 페이지</h3>
    <form action="" method="post">
      <div id="">
        제목 <input type="text">
      </div>
      <div id="">
        기업명 <input type="text">
      </div>
      <div id="">
        담당자 성함 <input type="text">
      </div>
      <div id="">
        휴대폰 번호 <input type="text">
      </div>
      <div id="">
        이메일 주소 <input type="text">
      </div>
      <div id="">
        업종 <input type="text">
      </div>
      <div>
        모집 부서 <input type="text">
      </div>
      <div id="">
        경력 여부
        <div style="display: inline-block;">
          <input type="radio" name="career_type" >신입
          <input type="radio" name="career_type" >경력
          <input type="radio" name="career_type" >경력무관
        </div>
      </div>
      <div id="">
        대표 근무지역 <div class="kakaoAPI">(카카오맵api)</div>
      </div>
      <div id="">
        연봉/급여 <input type="text">
      </div>
      <div id="">
        근무 형태
        <div style="display: inline-block;">
          <input type="radio" name="work_type" value="정규직">정규직
          <input type="radio" name="work_type" value="계약직">계약직
          <input type="radio" name="work_type" value="인턴">인턴
        </div>
      </div>
      <div id="">
        상세 내용
        <div id="app">
          (에디터api)
        </div>
      </div>
      <div id="">
        전형 절차
        <div style="display: inline-block;">
          <input type="radio" id="process" value="서류전형" checked>서류전형
          <input type="radio" id="process" value="1차면접">1차면접
          <input type="radio" id="process" value="2차면접">2차면접
          <input type="radio" id="process" value="최종합격" checked>최종합격
        </div>
      </div>
      <div id="endDate">
        마감일자
        <div>(달력api)</div>
      </div>
      <div>
        <input type="submit" value="등록">
        <input type="reset" value="취소">
      </div>
    </form>
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

/* 푸터 스타일링 */
footer {
  background-color: #f2f2f2;
  padding: 10px;
  font-size: 14px;
}
</style>

