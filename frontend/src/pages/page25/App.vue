<!-- 재윤 - 지원자 현황 -->
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
    <h3>지원자 현황 페이지</h3>
    <button type="button" class="">받은 쪽지함</button>
    <button type="button" class="">보낸 쪽지함</button>

    <div id="posting_wrap">
      <a href="#">채용 공고 이름(데이터)</a>
    </div>

    <div id="content_wrap">
      <ul>
        <li>
          <table cellpadding="0" cellspacing="0" class="col_14" width="100%;">
            <tr>
              <th>번호</th>
              <th>지원 부서</th>
              <th>지원자 성명</th>
              <th>지원 일자</th>
              <th>쪽지 보내기</th>
            </tr>

            <tr>
              <td>1</td>
              <td>1</td>
              <td>1</td>
              <td>1</td>
              <td><button @click="sendMessage">send</button></td>
            </tr>
          </table>
        </li>
      </ul>
    </div>
    <span>페이지네이션</span>
    <div>
      <a href="page1">메인</a>
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

