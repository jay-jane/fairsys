<!-- 재윤 - 쪽지 보내기 -->
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
    <div>
      <h3>쪽지 작성</h3>
      <form action="" method="post">
        <div class="my_name">
          <label for="name">이름 </label>
          <input type="text" id="name" name="myName" value="회원이름데이터" readonly>
        </div>
        <div class="manager_name">
          <label for="company">받는 사람</label>
          <input type="text" id="company" name="managerName" value="회사이름데이터" readonly>
        </div>
        <div class="title_wrap">
          <label for="title">제목</label>
          <input type="text" id="title" name="msgTitle" v-model="title" required>
        </div>
        <div class="content_wrap">
          <label for="message">내용</label>
          <textarea id="message" v-model="message" name="msgContent" required></textarea>
        </div>
        <button type="submit">보내기</button>
        <button type="button" @click="goMain">취소</button>
      </form>
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
  methods: {
    goMain: () => {
      location.href="page";
    },
  },
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
  background-color: orange;
  color: black;
  font-weight: bold;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 5px;
}
button[type="button"] {
  background-color: #ccc;
  color: black;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-left: 5px;
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

