<!-- 재윤 - 채용 공고 수정 -->
<template>
  <section>
    <div id="jy_main_wrap" v-for="item in list">
      <h3 style="text-align: center;">채용 공고 수정</h3>
      <div id="jy_field">
        <label class="jy_field_name">제목</label>
        <div id="">
          <input type="hidden" v-model="com_id">
          <input type="text" class="jy_text" v-bind:value="item.j_title" @change="getTitle">
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">담당자 성함</label>
        <div id="">
          <input type="text" class="jy_text jy_f" :value="item.companyVO.com_manager" readonly>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">기업명</label>
        <div id="">
          <input type="text" class="jy_text jy_f" :value="item.companyVO.com_name" readonly>
        </div>
      </div>
      <div class="jy_field tel-number">
        <label class="jy_field_name">휴대폰 번호</label>
        <div class="jy_tel_number_input">
          <input type="text" class="jy_text jy_f" id="jy_tel_number" :value="item.companyVO.com_manager_phone" readonly>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">이메일 주소</label>
        <div id="">
          <input type="email" class="jy_text" :value="item.j_email" @change="getEmail">
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">모집 분야</label>
        <div id="jy_job_type">
         <input type="text" class="jy_text jy_f" :value="item.j_department" readonly>
        </div>
        <div id="jy_recruit_type" style="display: inline-block;">
          <input type="text" class="jy_text" style="width: 40px; margin-left: 5px;" v-bind:value="item.j_recruitNum"
            @change="getRecruitNum">
          <span>명 모집</span>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">경력 여부</label>
        <div id="jy_career">
          <input type="text" class="jy_text jy_f" :value="item.j_career" readonly>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">근무지역</label>
        <div class="jy_kakaoAPI">
          <input type="text" class="jy_text jy_f" :value="item.j_address + item.j_detail_address" readonly>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">급여(연봉)</label>
        <div id="jy_sal_wrap">
          <input type="text" class="jy_text jy_f" :value="item.j_salary" readonly>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">근무 형태</label>
        <div>
          <input type="text" class="jy_text jy_f" :value="item.j_type" readonly>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">학력</label><br>
        <input type="text" class="jy_text jy_f" :value="item.j_graduation" readonly>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">상세 내용</label>
          <textarea id="jy_field" class="jy_textarea" cols="70" rows="20" v-bind:value="item.j_content" @change="getContent"></textarea>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">전형 절차</label>
        <div id="">
          <input type="text" class="jy_text jy_f" :value="'서류심사 > ' + item.j_schedule + '합격'" readonly>
        </div>
      </div>
      <div id="jy_modi-btn-wrap">
        <button type="button" class="modi_btn" value="등록" @click="updateForm" style="margin-right: 10px;">수정 완료</button>
        <button type="button" class="modi_btn" value="삭제" @click="deleteForm" style="margin-right: 10px;">삭제</button>
        <button type="button" class="modi_btn" value="취소" @click="goMain">취소</button>
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
          this.getOriginal();
        })
        .catch(err => {
          console.log(err);
        });
    },
    getOriginal() {
      this.j_title = this.list[0].j_title;
      this.j_email = this.list[0].j_email;
      this.j_recruitNum = this.list[0].j_recruitNum;
      this.j_content = this.list[0].j_content;
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
    getContent(e) {
      this.j_content = e.target.value;
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
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
  font-family: 'Noto Sans KR', sans-serif;
}

#jy_main_wrap {
  margin: auto;
  max-width: 500px;
}

.jy_field_name {
  font-weight: bold;
  border-bottom: 1px solid orangered;
}

.jy_text {
  width: 100%;
  padding: 10px;
  margin: 10px 0;
  box-sizing: border-box;
}
.jy_text, .jy_textarea:focus-within {
  outline-color: orange;
}
.jy_f {
  border: 0;
  cursor: default;
}
.jy_f:focus-within {
  outline: 0;
}

#jy_sal_y {
  width: 50%;
  padding: 5px;
  margin: 10px 0;
  box-sizing: border-box;
}

label {
  font-weight: bold;
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

.jy_tel_number_input>input {
  width: 200px;
}

button[type="submit"]:hover {
  background-color: #45a049;
}

#jy_field {
  margin-top: 10px;
}

#jy_field #process_wrap {
  position: relative;
}

#jy_field #process_wrap .deleteBtn {
  position: absolute;
  top: 20px;
  right: 20px;
}

#jy_process_wrap .deleteBtn:hover {
  cursor: pointer;
}

#jy_recruit_type {
  overflow: hidden;
}

#jy_recruit_type input {
  float: left;
}

#jy_recruit_type .recruit_type_input {
  width: 200px;
}

#jy_recruit_type span {
  line-height: 59px;
}

#jy_sal_wrap input[type=text] {
  width: 80%;
  margin-right: 10px;
}

#jy_modi-btn-wrap {
  text-align: center;
  margin-bottom: 20px;
}

#jy_modi-btn-wrap .modi_btn {
  display: inline-block;
  border: 0;
  width: 120px;
  height: 40px;
  line-height: 40px;
  background-color: orangered;
  border-radius: 2px;
  font-size: 20px;
  font-weight: 500;
  color: #efefef;
  letter-spacing: 1px;
}

</style>
