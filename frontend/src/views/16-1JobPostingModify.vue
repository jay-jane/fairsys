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
          <input type="text" :value="item.com_manager_name" readonly style="border: 0;">
        </div>
      </div>
      <div id="field">
        <label class="field_name">기업명</label>
        <div id="">
          <input type="text" :value="item.com_name" readonly style="border: 0;">
        </div>
      </div>
      <div class="field tel-number">
        <label class="field_name">휴대폰 번호</label>
        <div class="tel_number_input">
          <input type="text" id="tel_number" :value="item.com_manager_phone" readonly style="border: 0;">
        </div>
      </div>
      <div id="field">
        <label class="field_name">이메일 주소</label>
        <div id="">
          <input type="email" :value="item.j_email" @change="getEmail">
        </div>
      </div>
      <div id="field">
        <label class="field_name">모집 분야</label>
        <div id="job_type">
          {{ item.j_department }}
        </div>
        <div id="recruit_type" style="display: inline-block;">
          <input type="text" style="width: 40px; margin-left: 5px;" v-bind:value="item.j_recruitNum"
            @change="getRecruitNum">
          <span>명 모집</span>
        </div>
      </div>
      <div id="field">
        <label class="field_name">경력 여부</label>
        <div id="career">
          {{ item.j_career }}
        </div>
      </div>
      <div id="field">
        <label class="field_name">근무지역</label>
        <div class="kakaoAPI">
          {{ item.com_detail_address }}
          (카카오맵api)
        </div>
      </div>
      <div id="field">
        <label class="field_name">급여(연봉)</label>
        <div id="sal_wrap">
          {{ item.j_salary }}
        </div>
      </div>
      <div id="field">
        <label class="field_name">근무 형태</label>
        <div>
          {{ item.j_type }}
        </div>
      </div>
      <div id="field">
        <label class="field_name">학력</label><br>
        {{ item.j_graduation }}
        <!-- <div>
          <input type="radio" id="대졸" name="graduation_type" v-bind:value="j_graduation" value="대졸">대졸
          <input type="radio" id="고졸" name="graduation_type" v-bind:value="j_graduation" value="고졸/초대졸">고졸/초대졸
          <input type="radio" id="무관" name="graduation_type" v-bind:value="j_graduation" value="학력무관">학력무관
        </div> -->
      </div>
      <div id="field">
        <label class="field_name">상세 내용</label>

        <div class="content">나중에@@@@</div>

      </div>
      <div id="field">
        <label class="field_name">전형 절차</label>
        <div id="">
          서류 심사 > {{ item.j_schedule }} 합격
        </div>
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
      j_content: '',
      j_salary: '',
      j_department: '',
      j_schedule: '',
      j_graduation: '',
      j_career: '',
      j_type: '',
      com_id: '1818',
      list: [],
      j_end_date: '',
    }
  },
  methods: {
    goMain() {
      this.$router.push('/4');
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
        console.log(err);
      })
    },
    deleteForm() {
      if (confirm('삭제하시겠습니까?')) {
        this.axios.post('/jobPostingDelete', { "j_no": this.$route.params.j_no })
          .then(() => {
            alert('삭제되었습니다');
            this.$router.push('/4');
          })
          .catch(err => console.log(err));
      }
    },
    getJobDetail() {
      this.j_no = this.$route.params.j_no;
      this.axios.get('/jobPostingDetail/' + this.j_no, { params: { "j_no": this.j_no } })
        .then(res => {
          this.list = res.data;
          this.j_schedule = this.list[0].j_schedule;
          this.list[0].j_department = this.list[0].j_department.replaceAll("[", "").replaceAll("]", "").replaceAll("\"", "").replaceAll(",", " / ");
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

input[type="text"],
[type="email"] {
  width: 100%;
  padding: 10px;
  margin: 10px 0;
  box-sizing: border-box;
}

#sal_y {
  width: 50%;
  padding: 5px;
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
  width: 200px;
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
