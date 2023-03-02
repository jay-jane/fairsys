
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
    <h3 style="text-align: center;">채용 공고 수정 페이지</h3>
    <form action="" method="post">
      <div id="">
        제목 <input type="text"><br>
      </div>
      <div id="">
        기업명 <input type="text" id="com_name" value="데이터" readonly><br>
      </div>
      <div id="">
        담당자 성함 <input type="text"><br>
      </div>
      <div id="">
        휴대폰 번호 <input type="text"><br>
      </div>
      <div id="">
        이메일 주소 <input type="text"><br>
      </div>
      <div id="">
        업종 <input type="text"><br>
      </div>
      <div id="">
        대표 근무지역 <div class="kakaoAPI">카카오맵api</div> <br>
      </div>
      <div id="">
        연봉/급여 <input type="text"><br>
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
        상세 내용 <textarea id="" cols="30" rows="3"></textarea>
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
      <div class="buttons">
        <input type="submit" value="수정">
        <a href="#" class="list">목록</a>
        <a href="#" class="delete">삭제</a>
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
header {
  background-color: #333;
  color: #fff;
  padding: 10px;
}

.head {
  list-style: none;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.head li {
  padding: 5px;
}

form {
  max-width: 500px;
  margin: auto;
}

input[type="text"],
textarea {
  width: 100%;
  padding: 10px;
  margin: 10px 0;
  box-sizing: border-box;
}

#com_name {
  border: 0;
}

input[type="radio"] {
  margin-right: 10px;
}

.buttons {margin-top: 10px; text-align: center;}

input[type="submit"],
input[type="reset"] {
  background-color: #333;
  color: #fff;
  padding: 10px;
  border: none;
  cursor: pointer;
  margin-right: 10px;
  font-size: 15px;
}

input[type="submit"]:hover,
input[type="reset"]:hover {
  background-color: #555;
}

.buttons a {
  text-decoration: none;
  background-color: #333;
  color: #fff;
  padding: 10px;
  border: none;
  cursor: pointer;
  margin-right: 10px;
}
.buttons a:hover {
  background-color: #555;
}

footer {
  background-color: #333;
  color: #fff;
  padding: 10px;
  margin-top: 50px;
}
</style>

