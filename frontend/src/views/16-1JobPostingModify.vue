<!-- 재윤 - 채용 공고 수정 -->
<template>
  <section>
    <div id="main_wrap" v-for="item in list">
      <h3 style="text-align: center;">채용 공고 수정</h3>
      <div id="field">
        <label class="field_name">제목</label>
        <div id="">
          <input type="hidden" v-model="com_id">
          <input type="text" v-bind:value="item.j_title" @change="getTitle">
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
          <input type="email" v-bind:value="item.j_email" @change="getEamil">
        </div>
      </div>
      <div id="field">
        <label class="field_name">업종</label>
        <div id="job_type">
          <select name="" id="">
            <option value="a">서비스업</option>
            <option value="b">제조</option>
            <option value="c">IT/웹</option>
          </select>
        </div>
      </div>
      <div id="field">
        <label class="field_name">모집 분야</label>
        <div id="job_type">
          <Hashtags></Hashtags>
        </div>
        <div id="recruit_type" style="display: inline-block;">
          <input type="text" style="width: 40px; margin-left: 5px;" v-bind:value="item.j_recruitNum"
            @change="getRecruitNum">
          <span>명 모집</span>
        </div>
      </div>
      <div id="field">
        <label class="field_name">경력 여부</label>
        <div id="career" style="display: inline-block;">
          <input type="radio" name="career_type" v-bind:value="j_career" value="N">신입
          <input type="radio" name="career_type" v-bind:value="j_career" value="Y">경력
          <input type="radio" name="career_type" v-bind:value="j_career" value="B">경력무관
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
          <select id="sal_y" v-bind:value="j_salary">
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
          <input type="radio" name="work_type" v-bind:value="j_type" value="Y">정규직
          <input type="radio" name="work_type" v-bind:value="j_type" value="N">계약직
          <input type="radio" name="work_type" v-bind:value="j_type" value="F">인턴
        </div>
      </div>
      <div id="field">
        <label class="field_name">학력</label>
        <div style="display: inline-block;">
          <input type="radio" name="graduation_type" v-bind:value="j_graduation" value="Y">대졸
          <input type="radio" name="graduation_type" v-bind:value="j_graduation" value="N">고졸/초대졸
          <input type="radio" name="graduation_type" v-bind:value="j_graduation" value="YN">학력무관
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
        <label class="field_name">마감일자</label>
        <div>(달력api)</div>
      </div>
      <div>
        <button type="button" value="등록" @click="updateForm" style="margin-right: 10px;">수정 완료</button>
        <button type="button" value="삭제" @click="deleteForm" style="margin-right: 10px;">삭제</button>
        <button type="button" value="취소" @click="goMain">취소</button>
      </div>
    </div>
  </section>
</template>

<script>
import Hashtags from '../components/Hashtags.vue';

export default {
  name: 'App',
  data() {
    return {
      j_no: 0,
      j_recruitNum: '',
      j_email: '',
      j_title: '',
      j_content: '상세 내용12345',
      j_salary: '',
      j_department: '임시',
      j_schedule: 'A',
      j_graduation: '',
      j_career: '',
      j_type: '',
      com_id: '1818',
      list: [],
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
    updateForm() {
      this.axios.post('/jobPostingUpdate',
        {
          j_no: this.$route.params.j_no,
          j_recruitNum: this.j_recruitNum,
          j_email: this.j_email,
          j_title: this.j_title,
          j_content: this.j_content,
          j_salary: this.j_salary,
          j_department: this.j_department,
          j_schedule: this.j_schedule,
          j_graduation: this.j_graduation,
          j_career: this.j_career,
          j_type: this.j_type,
        }
      ).then(() => {
        this.j_no = this.$route.params.j_no;
        alert('수정되었습니다.');
        this.$router.push('/jobPostingDetail/' + this.j_no);
      }).catch(err => {
        console.log("에러");
        console.log(err);
      })
    },
    deleteForm() {
      confirm('삭제하시겠습니까?');
      this.axios.post('/jobPostingDelete', {"j_no": this.$route.params.j_no})
                .then(() => {
                  alert('삭제되었습니다');
                  this.$router.push('/4');
                })
                .catch(err => console.log(err));
    },
    getJobDetail() {
      this.j_no = this.$route.params.j_no;
      this.axios.get('/jobPostingDetail/' + this.j_no, { params: { "j_no": this.j_no } })
        .then(res => {
          this.list = res.data;
        })
        .catch(err => {
          console.log(err);
        });
    },
    getTitle(e) {
      this.j_title = e.target.value;
    },
    getEmail(e) {
      this.j_email = e.target.value;
    },
    getRecruitNum(e) {
      this.j_recruitNum = e.target.value;
    },
  },
  mounted() {
    this.getJobDetail();
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
  font-family: Arial, sans-serif;
}

#main_wrap {
  margin: auto;
  max-width: 500px;
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
