<!-- 재윤 - 채용 공고 등록 -->
<template>
  <section>
    <h3 style="text-align: center;">채용 공고 등록</h3>
    <form @submit="regist">
      <div id="field">
        <label class="field_name">제목</label>
        <div id="">
          <input type="hidden" v-model="com_id">
          <input type="text" v-model="j_title">
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
          <input type="text" id="tel_number_1"> - <input type="text" id="tel_number_2"> - <input type="text" id="tel_number_3">
        </div>
      </div>
      <div id="field">
        <label class="field_name">이메일 주소</label>
        <div id="">
          <input type="email" v-model="j_email">
        </div>
      </div>
      <div id="field">
        <label class="field_name">업종</label>
        <div id="job_type">
          <select name="" id="">
            <option value="">서비스업</option>
            <option value="">제조</option>
            <option value="">IT/웹</option>
          </select>
        </div>
      </div>
      <div id="field">
        <label class="field_name">모집 분야</label>
        <div id="job_type">
          <Hashtags></Hashtags>
        </div>
        <div id="recruit_type" style="display: inline-block;">
          <input type="text" style="width: 40px; margin-left: 5px;" v-model="j_recruitNum">
          <span>명 모집</span>
        </div>
      </div>
      <div id="field">
        <label class="field_name">경력 여부</label>
        <div id="career" style="display: inline-block;">
          <input type="radio" name="career_type" v-model="j_career" value="N">신입
          <input type="radio" name="career_type" v-model="j_career" value="Y">경력
          <input type="radio" name="career_type" v-model="j_career" value="B">경력무관
        </div>
      </div>
      <div id="field">
        <label class="field_name">근무지역</label>
        <div class="kakaoAPI">(카카오맵api)</div>
      </div>
      <div id="field">
        <label class="field_name">연봉/급여</label>
        <div id="sal_wrap">
          <select id="sal_type">
            <option value="sal_y">연봉</option>
            <option value="sal_m">월급</option>
          </select>
          <select id="sal_y" v-model="j_salary">
            <option value="2200~2800">2,200 ~ 2,800</option>
            <option value="2800~3200">2,800 ~ 3,200</option>
            <option value="3200~3600">3,200 ~ 3,600</option>
            <option value="3600~4000">3,600 ~ 4,000</option>
          </select>
          <input type="hidden" class="sal_m">
          <button type="button" class="sal_m" style="display: hidden">입력</button>
        </div>
      </div>
      <div id="field">
        <label class="field_name">근무 형태</label>
        <div style="display: inline-block;">
          <input type="radio" name="work_type" v-model="j_type" value="Y">정규직
          <input type="radio" name="work_type" v-model="j_type" value="N">계약직
          <input type="radio" name="work_type" v-model="j_type" value="F">인턴
        </div>
      </div>
      <div id="field">
        <label class="field_name">학력</label>
        <div style="display: inline-block;">
          <input type="radio" name="graduation_type" v-model="j_graduation" value="Y">대졸
          <input type="radio" name="graduation_type" v-model="j_graduation" value="N">고졸/초대졸
          <input type="radio" name="graduation_type" v-model="j_graduation" value="F">학력무관
        </div>
      </div>
      <div id="field">
        <label class="field_name">상세 내용</label>

        <div class="content">나중에@@@@</div>

      </div>
      <div id="field">
        <label class="field_name">전형 절차</label>
        <div id="">
          <div id="process_wrap">
            <input type="text" id="process" value="서류전형" readonly>
          </div>
          <div id="process_add">
            <button type="button" class="add_btn" name="interview1" @click="addBtn" ref="btn1"
              style="margin-bottom: 15px;">
              1차면접
              <span style="font-size: 16px; color: orangered; font-weight: bold;">+</span>
            </button>
          </div>
          <div id="process_wrap" ref="interview1" style="display: none;">
            <input type="text" id="process" value="A" readonly>
            <img class="deleteBtn" @click="deleteItem" name="interview1" src="https://picsum.photos/20/20" alt="삭제">
          </div>
          <div id="process_add">
            <button type="button" class="add_btn" name="interview2" @click="addBtn" ref="btn2">
              2차면접
              <span style="font-size: 16px; color: orangered; font-weight: bold;">+</span>
            </button>
          </div>
          <div id="process_wrap" ref="interview2" style="display: none;">
            <input type="text" id="process" value="B" readonly>
            <img class="deleteBtn" @click="deleteItem" name="interview2" src="https://picsum.photos/20/20" alt="삭제">
          </div>
          <div id="process_wrap">
            <input type="text" id="process" value="최종합격" readonly>
          </div>
        </div>
      </div>
      <div id="field endDate">
        <label class="field_name">마감일자</label><br>
        <input type="date" v-model="j_end_date">
      </div>
      <div>
        <button type="button" value="등록" @click="submitForm">등록</button>
        <button type="button" value="취소" @click="goMain">취소</button>
      </div>
    </form>
  </section>
</template>

<script>
import Hashtags from '../components/Hashtags.vue';

export default {
  name: 'App',
  data() {
    return {
      j_recruitNum: '',
      j_email: '',
      j_title: '',
      j_content: '상세 내용12345',
      j_salary: '',
      j_department: '임시',
      j_schedule: 'A',
      j_graduation: '',
      j_end_date: '',
      j_career: '',
      j_type: '',
      hash: '',
      com_id: '1818',
    }
  },
  methods: {
    goMain: () => {
      location.href = "/";
    },
    deleteItem: function (e) {
      if (e.target.tagName != "IMG") return;
      if (e.target.name == "interview1") {
        this.$refs.interview1.style.display = "none";
        this.$refs.btn1.style.display = "inline-block";
      } else {
        this.$refs.interview2.style.display = "none";
        this.$refs.btn2.style.display = "inline-block";
      }

    },
    addBtn: function (e) {
      if (e.target.tagName != "BUTTON") return;
      if (e.target.name == 'interview1') {
        this.$refs.interview1.style.display = "block";
        this.$refs.btn1.style.display = "none";
      } else {
        this.$refs.interview2.style.display = "block";
        this.$refs.btn2.style.display = "none";
      }
    },
    submitForm() {
      console.log(1);

      // let data = await fetch("/test/registForm", {
      //     method: "post", 
      //     body: JSON.stringify({ user_id: "Xxxx" }),
      //     headers: { "Content-Type": "application/json", }
      //     })
      // let result = await data.text();
      // console.log(result)

      this.axios.post('/jobPostingRegist',
        {
          j_recruitNum: this.j_recruitNum,
          j_email: this.j_email,
          j_title: this.j_title,
          j_content: this.j_content,
          j_salary: this.j_salary,
          j_department: this.j_department,
          j_schedule: this.j_schedule,
          j_graduation: this.j_graduation,
          j_end_date: this.j_end_date,
          j_career: this.j_career,
          j_type: this.j_type,
          com_id: this.com_id,
          hash: this.hash,
        }
        ).then(res => {
          console.log(res);
          this.$router.push({ path: '/' });
          console.log(this.com_id);
          console.log(this.j_schedule);
        }).catch(err => {
          console.log(err);
      })
    }
  },
  components: {
    Hashtags,
  },
}

</script>

<style>
/* @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap'); */

* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
  /* font-family: 'Noto Sans KR', sans-serif; */
}

body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
}

form {
  max-width: 500px;
  margin: auto;
}

#field_name {
  font-weight: bold;
}

input[type="text"], [type="email"] {
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
  cursor: default;
}

#process_add .add_btn {
  width: 80%;
  text-align: center;
  height: 30px;
  background-color: #eee;
  border: 0;
  border-radius: 2px;
  color: grey;
  font-weight: bold;
  cursor: pointer;
}
</style>
