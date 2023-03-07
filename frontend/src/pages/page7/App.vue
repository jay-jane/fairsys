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
    <form @submit="regist">
      <div id="field">
        <label class="field_name">제목</label>
        <div id="">
          <input type="text">
        </div>
      </div>
      <div id="field">
        <label class="field_name">담당자 성함</label>
        <div id="">
          <input type="text">
        </div>
      </div>
      <div id="field">
        <label class="field_name">기업명</label>
        <div id="">
          <input type="text">
        </div>
      </div>
      <div class="field tel-number">
        <label class="field_name">휴대폰 번호</label>
        <div class="tel_number_input">
          <input type="text" id="tel_number_1"> - <input type="text" id="tel_number_2"> - <input type="text"
            id="tel_number_3">
        </div>
      </div>
      <div id="field">
        <label class="field_name">이메일 주소</label>
        <div id="">
          <input type="text">
        </div>
      </div>
      <div id="field">
        <label class="field_name">업종</label>
        <div id="">
          <input type="text">
        </div>
      </div>
      <div id="field">
        <label class="field_name">모집 분야</label>
        <div id="recruit_type">
          <input type="text" class="recruit_type_input">
          <input type="text" style="width: 40px; margin-left: 5px;">
          <span>명 모집</span>
        </div>
      </div>
      <div id="field">
        <label class="field_name">경력 여부</label>
        <div id="career" style="display: inline-block;">
          <input type="radio" name="career_type">신입
          <input type="radio" name="career_type">경력
          <input type="radio" name="career_type">경력무관
        </div>
      </div>
      <div id="field">
        <label class="field_name">대표 근무지역</label>
        <div class="kakaoAPI">(카카오맵api)</div>
      </div>
      <div id="field">
        <label class="field_name">연봉/급여</label>
        <div id="sal_wrap">
          <select id="sal_type">
            <option value="sal_y">연봉</option>
            <option value="sal_m">월급</option>
          </select>
          <select id="sal_y">
            <option value="sal_y">2,200 ~ 2,800</option>
            <option value="sal_y">2,800 ~ 3,200</option>
            <option value="sal_y">3,200 ~ 3,600</option>
            <option value="sal_y">3,600 ~ 4,000</option>
          </select>
          <input type="hidden" class="sal_m">
          <button type="button" class="sal_m" style="display: hidden">입력</button>
        </div>
      </div>
      <div id="field">
        <label class="field_name">근무 형태</label>
        <div style="display: inline-block;">
          <input type="radio" name="work_type" value="정규직">정규직
          <input type="radio" name="work_type" value="계약직">계약직
          <input type="radio" name="work_type" value="인턴">인턴
        </div>
      </div>
      <div id="field">
        <label class="field_name">상세 내용</label>
        <div id="tiptapAPI">
          <MenuBar />
          <tiptap />
        </div>
      </div>
      <div id="field">
        <label class="field_name">전형 절차</label>
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
      <div id="field endDate">
        <label class="field_name">마감일자</label>
        <div>(달력api)</div>
      </div>
      <div>
        <input type="submit" value="등록">
        <input type="button" value="취소" @click="goMain">
      </div>
    </form>
  </section>

  <footer style="text-align: center;">
    푸푸푸푸<br>
    터터터터
  </footer>
</template>

<script>

import Tiptap from '../../components/TipTap.vue'
import MenuBar from '../../components/MenuBar.vue'

export default {
  name: 'App',
  components: {
    Tiptap,
    MenuBar,
  },
  methods: {
    goMain: () => {
      location.href="page35";
    }
  }
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

form {
  max-width: 500px;
  margin: auto;
}

#field_name {
  font-weight: bold;
}

input[type="text"] {
  width: 100%;
  padding: 10px;
  margin: 10px 0;
  box-sizing: border-box;
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

.tel_number_input>input {
  width: 50px;
}

button[type="submit"]:hover {
  background-color: #45a049;
}

#field {
  margin-top: 10px;
}

#field #process_wrap {
  position: relative;
}

#field #process_wrap .deleteBtn {
  position: absolute;
  top: 20px;
  right: 20px;
}

#process_wrap .deleteBtn:hover {
  cursor: pointer;
}

#recruit_type {
  overflow: hidden;
}

#recruit_type input {
  float: left;
}

#recruit_type .recruit_type_input {
  width: 200px;
}

#recruit_type span {
  line-height: 59px;
}

#sal_wrap input[type=text] {
  width: 80%;
  margin-right: 10px;
}

#process_wrap #process {
  font-weight: bold;
  color: orangered;
}

#tiptapAPI {
  border: 1px solid #999;
}

/* 푸터 스타일링 */
footer {
  background-color: #f2f2f2;
  padding: 10px;
  font-size: 14px;
}</style>
