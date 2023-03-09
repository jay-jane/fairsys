<!-- 재윤 - 채용 공고 수정 -->
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
      <div id="field_name">
        제목 <input type="text">
      </div>
      <div id="field_name">
        기업명 <input type="text" id="com_name" value="데이터" readonly>
      </div>
      <div id="field_name">
        담당자 성함 <input type="text">
      </div>
      <div id="field_name">
        휴대폰 번호
        <div class="tel_number_input">
          <input type="text" id="tel_number_1"> - <input type="text" id="tel_number_2"> - <input type="text"
            id="tel_number_3">
        </div>
      </div>
      <div id="field_name">
        이메일 주소 <input type="text">
      </div>
      <div id="field_name">
        업종 <input type="text">
      </div>
      <div id="field_name">
        모집부서 <input type="text">
      </div>
      <div id="field_name">
        대표 근무지역 <div class="kakaoAPI">(카카오맵api)</div> 
      </div>
      <div id="field_name">
        경력 여부
        <div style="display: inline-block;">
          <input style="margin-left: 20px;" type="radio" name="career_type">신입
          <input style="margin-left: 20px;" type="radio" name="career_type">경력
          <input style="margin-left: 20px;" type="radio" name="career_type">경력무관
        </div>
      </div>
      <div id="field_name">
        연봉/급여 <input type="text">
      </div>
      <div id="field_name">
        근무 형태
        <div style="display: inline-block;">
          <input type="radio" style="margin-left: 20px;" name="work_type" value="정규직">정규직
          <input type="radio" style="margin-left: 20px;" name="work_type" value="계약직">계약직
          <input type="radio" style="margin-left: 20px;" name="work_type" value="인턴">인턴
        </div>
      </div>
      <div id="field_name">
        상세 내용
        <div>
          (에디터api)
        </div>
      </div>
      <div id="field_name">
        전형 절차
        <div id="">
          <div id="process_wrap">
            <input type="text" id="process" value="서류전형" readonly>
          </div>
          <div id="process_wrap">
            <input type="text" id="process" value="1차면접" readonly>
            <img class="deleteBtn" @click="deleteItem" src="https://picsum.photos/20/20" alt="삭제">
          </div>
          <div id="process_wrap">
            <input type="text" id="process" value="2차면접" readonly>
            <img class="deleteBtn" @click="deleteItem" src="https://picsum.photos/20/20" alt="삭제">
          </div>
          <div id="process_wrap">
            <input type="text" id="process" value="최종합격" readonly>
          </div>
        </div>
      </div>
      <div id="endDate_wrap">
        마감일자
        <div>
          (달력api)
        </div>
      </div>
      <div class="buttons">
        <input type="submit" value="수정하기">
        <a href="page23" class="list">취소</a>
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
  // methods: {
  //   deleteItem: () => {
  //     alert('삭제 이벤트');
  //   }
  // },
 
  
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
  font-family: 'Noto Sans KR', sans-serif;
}

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

input[type="text"] {
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

.buttons {
  margin-top: 10px;
  text-align: center;
}

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

.tel_number_input>input {
  width: 50px;
}

#process_wrap {
  position: relative;
}
#process_wrap .deleteBtn {
  position: absolute;
  top: 20px;
  right: 20px;
}
#process_wrap .deleteBtn:hover {
  cursor: pointer;
}
#process_wrap #process {
  font-weight: bold;
  color: orangered;
}

#field_name {
  font-weight: bold;
  margin-top: 10px;
}
#field_name div {
  font-weight: normal;
}

footer {
  background-color: #333;
  color: #fff;
  padding: 10px;
  margin-top: 50px;
}
</style>
