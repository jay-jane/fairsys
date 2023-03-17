<!-- 재윤 - 채용 공고 등록 -->
<template>
  <section>
    <h3 style="text-align: center;">채용 공고 등록</h3>
    <form @submit="regist">
      <div id="field">
        <label class="field_name">제목</label>
        <div id="">
          <input type="hidden" v-model="com_id">
          <input type="text" id="j_title" v-model="j_title">
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
          <input type="email" v-model="j_email">
        </div>
      </div>
      <div id="field">
        <label class="field_name">모집 분야</label>
        <div id="job_type">
          <Hashtags></Hashtags>
        </div>
      <!-- <div v-for="item in $route.query.valList">
          {{ item }}
              </div> -->
        <div id="recruit_type" style="display: inline-block;">
          <input type="text" style="width: 40px; margin-left: 5px;" v-model="j_recruitNum">
          <span>명 모집</span>
        </div>
      </div>
      <div id="field">
        <label class="field_name">경력 여부</label>
        <div id="career" style="display: inline-block;">
          <input type="radio" name="career_type" v-model="j_career" value="신입">신입
          <input type="radio" name="career_type" v-model="j_career" value="경력">경력
          <input type="radio" name="career_type" v-model="j_career" value="경력무관">경력무관
        </div>
      </div>
      <div id="field">
        <label class="field_name">근무지역</label>
        <div class="kakaoAPI">(카카오맵api)</div>
      </div>
      <div id="field">
        <label class="field_name">급여(연봉)</label>
        <div id="sal_wrap">
          <select id="sal_y" v-model="j_salary">
            <option value="2200~2800">2,200만원 ~ 2,800만원</option>
            <option value="2800~3200">2,800만원 ~ 3,200만원</option>
            <option value="3200~3600">3,200만원 ~ 3,600만원</option>
            <option value="3600~4000">3,600만원 ~ 4,000만원</option>
          </select>
        </div>
      </div>
      <div id="field">
        <label class="field_name">근무 형태</label>
        <div style="display: inline-block;">
          <input type="radio" name="work_type" v-model="j_type" value="정규직">정규직
          <input type="radio" name="work_type" v-model="j_type" value="계약직">계약직
          <input type="radio" name="work_type" v-model="j_type" value="인턴">인턴
        </div>
      </div>
      <div id="field">
        <label class="field_name">학력</label>
        <div style="display: inline-block;">
          <input type="radio" name="graduation_type" v-model="j_graduation" value="대졸">대졸
          <input type="radio" name="graduation_type" v-model="j_graduation" value="고졸/초대졸">고졸/초대졸
          <input type="radio" name="graduation_type" v-model="j_graduation" value="학력무관">학력무관
        </div>
      </div>
      <div id="field">
        <label class="field_name">상세 내용</label>
        <div class="content">
          <textarea name="" id="" cols="30" rows="10">파일업로드ㅇ해야댐</textarea>
          <div class="upload">
            <span class="">상세 정보 업로드</span>
            <input id="uploadFile" type="file" @change="handleFileChange" accept="image/*" />
          </div>
          <div>
            <v-row justify="center">
              <v-col sm="7" md="7" lg="7" xl="7">
                <img :src="preview">
                <v-file-input v-model="file" @change="previewFile(file)" />
                <v-btn block color="blue" @click="validateCheck">
                  추가
                </v-btn>
              </v-col>
            </v-row>
          </div>
        </div>

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
            <input type="text" id="process" value="1차면접" readonly>
            <img class="deleteBtn" @click="deleteItem" name="interview1" src="https://picsum.photos/20/20" alt="삭제">
          </div>
          <div id="process_add">
            <button type="button" class="add_btn" name="interview2" style="display: none;" @click="addBtn" ref="btn2">
              2차면접
              <span style="font-size: 16px; color: orangered; font-weight: bold;">+</span>
            </button>
          </div>
          <div id="process_wrap" ref="interview2" style="display: none;">
            <input type="text" id="process" value="2차면접" readonly>
            <img class="deleteBtn" @click="deleteItem" name="interview2" src="https://picsum.photos/20/20" alt="삭제">
          </div>
          <div id="process_wrap">
            <input type="text" id="process" value="최종합격" readonly>
          </div>
        </div>
      </div>
      <div id="field endDate">
        <label class="field_name">마감일자</label><br>
        <!-- <input type="date" v-model="j_end_date"> -->
        <div class="date_Select">
          <table>
            <tbody>
              <td>
                <Datepicker v-model="endDate" :locale="locale" :weekStartsOn="0" :inputFormat="inputFormat"
                  :clearable="true" />
              </td>
            </tbody>
          </table>
        </div>
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
import { ref, reactive, watch } from 'vue';
import Datepicker from 'vue3-datepicker';
import { ko } from 'date-fns/locale';

export default {
  name: 'App',
  data() {
    return {
      j_recruitNum: '',
      j_email: '',
      j_title: '',
      j_content: '업로드 기능 넣어야댐',
      j_salary: '',
      j_department: '',
      j_schedule: '',
      j_graduation: '',
      j_end_date: '',
      j_career: '',
      j_type: '',
      j_end_date: '',
      com_id: '1818',
      endDate: '',

      // hash: [],
      // valList: '',

      file: '',
      preview: '',
      saveFile: null,
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
        this.$refs.interview2.style.display = "none";
        this.$refs.btn2.style.display = "none";
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
        this.$refs.btn2.style.display = "inline-block";
      } else {
        this.$refs.interview2.style.display = "block";
        this.$refs.btn2.style.display = "none";
      }
    },
    submitForm() {
      if (confirm('등록하시겠습니까?')) {
        if (this.$refs.interview1.style.display == "none") {
          this.j_schedule = "";
        } else if (this.$refs.interview1.style.display == "block" && this.$refs.interview2.style.display == "none") {
          this.j_schedule = "1차 면접 >";
        }
        if (this.$refs.interview2.style.display == "block") {
          this.j_schedule = "1차 면접 > 2차 면접 >";
        }
        if (this.j_title == '') {
          alert('글 제목은 필수 입력 항목입니다');
          document.getElementById("j_title").focus();
          return;
        } else {
          this.axios.post('/jobPostingRegist',
            {
              j_recruitNum: this.j_recruitNum,
              j_email: this.j_email,
              j_title: this.j_title,
              j_content: this.j_content,
              j_salary: this.j_salary,
              j_department: JSON.stringify(this.$route.query.valList),
              j_schedule: this.j_schedule,
              j_graduation: this.j_graduation,
              j_end_date: this.endDate,
              j_career: this.j_career,
              j_type: this.j_type,
              com_id: this.com_id,
            }
          ).then(() => {
            alert('등록되었습니다!');
            this.$router.push({ path: '/4' });
          }).catch(err => {
            console.log(err);

          });
        }
      }
    },
    handleFileChange(e) {
      const file = e.target.files;
      let validation = true;
      let message = '';

      if (file.length > 1) {
        validation = false;
        message = `파일은 한개만 등록 가능합니다.`
      }
      if (file[0].size > 1024 * 1024 * 2) {
        message = `${message}, 파일은 용량은 2MB 이하만 가능합니다.`;
        validation = false;
      }
      if (file[0].type.indexOf('image') < 0) {
        message = `${message}, 이미지 파일만 업로드 가능합니다.`;
        validation = false;
      }

      if (validation) {
        this.file = file;
      } else {
        this.file = '';
        alert(message);
      }
    },
    previewFile(file){
      const fileData = (data) => {
        this.preview = data
      }
      const reader = new FileReader()
      reader.readAsDataURL(file)
      reader.addEventListener("load", function () {
        fileData(reader.result)
      }, false);
    },
  },
  components: {
    Hashtags,
    Datepicker,
  },
  setup() {
    //공통설정
    const locale = reactive(ko); //한글달력 기본값 영어
    const inputFormat = ref('yyyy-MM-dd'); //날짜세팅

    const now = new Date();
    let endDate = ref(new Date(now.setDate(now.getDate())));

    console.log("now : " + now);
    console.log(endDate);

    watch(endDate, (newEndDate) => {
      console.log("new end : " + newEndDate);
      if (now > newEndDate) {
        alert('마감일은 오늘 날짜 이후로 설정 가능합니다.');
      }
    });

    return {
      endDate,
      locale,
      inputFormat
    }
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

input[type="text"],
[type="email"] {
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
