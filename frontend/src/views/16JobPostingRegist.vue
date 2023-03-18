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
          <div class="main-container">
            <div class="room-deal-information-container">
              <div class="room-deal-information-title">사진 등록</div>
              <div class="room-picture-notice">
                <ul class="room-write-wrapper">
                  <li>
                    사진은 가로로 찍은 사진을 권장합니다. (가로 사이즈 최소 800px)
                  </li>
                  <li>사진 용량은 사진 한 장당 10MB 까지 등록이 가능합니다.</li>

                </ul>
              </div>
              <div class="room-file-upload-wrapper">
                <div v-if="!files.length" class="room-file-upload-example-container">
                  <div class="room-file-upload-example">
                    <div class="room-file-image-example-wrapper">이미지</div>
                    <div class="room-file-notice-item">
                      실사진 최소 3장 이상 등록하셔야 하며, 가로사진을 권장합니다.
                    </div>
                    <div class="room-file-notice-item room-file-notice-item-red">
                      로고를 제외한 불필요한 정보(워터마크,상호,전화번호 등)가 있는 매물은 비공개처리됩니다
                    </div>
                    <div class="room-file-notice-item room-file-upload-button">
                      <div class="image-box">
                      <!-- <div class="image-profile">
            <img :src="profileImage" />
                        </div>-->
                        <label for="file">일반 사진 등록</label>
                        <input type="file" id="file" ref="files" @change="imageUpload" multiple />
                      </div>
                    </div>
                  </div>
                </div>
                <div v-else class="file-preview-content-container">
                  <div class="file-preview-container">
                    <div v-for="(file, index) in files" :key="index" class="file-preview-wrapper">
                      <div class="file-close-button" @click="fileDeleteButton" :name="file.number">
                        x
                      </div>
                      <img :src="file.preview" />
                    </div>
                    <div class="file-preview-wrapper-upload">
                      <div class="image-box">
                        <label for="file">추가 사진 등록</label>
                        <input type="file" id="file" ref="files" @change="imageAddUpload" multiple />
                      </div>
                      <!-- <div class="file-close-button" @click="fileDeleteButton" :name="file.number">x</div> -->
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="field_process">
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
import { ref, reactive } from 'vue';
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

      files: [], //업로드용 파일
      filesPreview: [],
      uploadImageIndex: 0 // 이미지 업로드를 위한 변수
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
        }
        const now = new Date();
        if (now > this.endDate) {
          alert('마감일은 오늘 날짜 이후로 설정 가능합니다');
          return;
        }
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
    },
    previewFile(file) {
      const fileData = (data) => {
        this.preview = data
      }
      const reader = new FileReader()
      reader.readAsDataURL(file)
      reader.addEventListener("load", function () {
        fileData(reader.result)
      }, false);
    },
    imageUpload() {
      console.log(this.$refs.files.files);

      // this.files = [...this.files, this.$refs.files.files];
      //하나의 배열로 넣기
      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {
        this.files = [
          ...this.files,
          //이미지 업로드
          {
            //실제 파일
            file: this.$refs.files.files[i],
            //이미지 프리뷰
            preview: URL.createObjectURL(this.$refs.files.files[i]),
            //삭제및 관리를 위한 number
            number: i
          }
        ];
        num = i;
        //이미지 업로드용 프리뷰
        // this.filesPreview = [
        //   ...this.filesPreview,
        //   { file: URL.createObjectURL(this.$refs.files.files[i]), number: i }
        // ];
      }
      this.uploadImageIndex = num + 1; //이미지 index의 마지막 값 + 1 저장
      console.log(this.files);
      // console.log(this.filesPreview);
    },
    imageAddUpload() {
      console.log(this.$refs.files.files);

      // this.files = [...this.files, this.$refs.files.files];
      //하나의 배열로 넣기c
      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {
        console.log(this.uploadImageIndex);
        this.files = [
          ...this.files,
          //이미지 업로드
          {
            //실제 파일
            file: this.$refs.files.files[i],
            //이미지 프리뷰
            preview: URL.createObjectURL(this.$refs.files.files[i]),
            //삭제및 관리를 위한 number
            number: i + this.uploadImageIndex
          }
        ];
        num = i;
      }
      this.uploadImageIndex = this.uploadImageIndex + num + 1;

      console.log(this.files);
      // console.log(this.filesPreview);
    },
    fileDeleteButton(e) {
      const name = e.target.getAttribute('name');
      this.files = this.files.filter(data => data.number !== Number(name));
      // console.log(this.files);
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
    getCompanyVO() {
      console.log(this.$route.params.com_id);
      this.axios.get("/registJobPosting", {})
    }
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

    return {
      endDate,
      locale,
      inputFormat
    }
  },
  mounted() {
    // this.getJobDetail();
    this.getCompanyVO();
  }
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


.main-container {
  width: 500px;
  height: 400px;
  margin: 0 auto;
}

.room-deal-information-container {
  margin-top: 50px;
  color: #222222;
  border: 1px solid #dddddd;
}

.room-deal-information-title {
  text-align: center;
  font-size: 18px;
  line-height: 60px;
  border-bottom: 1px solid #dddddd;
}

.room-deal-information-content-wrapper {
  min-height: 50px;
  display: flex;
}

.room-deal-informtaion-content-title {
  font-size: 15px;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 150px;
  background-color: #f9f9f9;
}

.room-deal-information-content {
  width: 100%;
  font-size: 14px;
}

.room-deal-option-selector {
  display: flex;
  align-items: center;
  padding: 15px;
}

.room-deal-option-item {
  width: 100px;
  height: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px solid #cccccc;
  border-radius: 5px;
  cursor: pointer;
}

.room-deal-option-item:last-child {
  margin-left: 10px;
}

.room-deal-option-notice {
  margin-left: auto;
  font-size: 14px;
  color: #888888;
}

.room-deal-option-item-deposit {
  margin-left: 10px;
}

.room-deal-information-wrapper {
  display: flex;
  flex-direction: column;
}

.room-deal-information-option {
  padding: 10px;
  display: flex;
  align-items: center;
}

.room-deal-information-option:last-child {
  border-bottom: 1px solid #dddddd;
}

.room-deal-information-item-type {
  font-size: 13px;
  color: #fff;
  background-color: #61b6e5;
  min-width: 50px;
  height: 26px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 3px;
}

.room-deal-information-item-wrapper {
  display: flex;
  align-items: center;
  margin-left: 10px;
  height: 46px;
  width: 100%;
}

.room-deal-information-item-wrapper>input {
  border: 1px solid #dddddd;
  width: 140px;
  height: 100%;
  padding: 0 15px;
  font-size: 15px;
}

.room-deal-inforamtion-won {
  margin: 0 10px;
}

.room-deal-information-example {
  color: #888888;
}

.room-deal-information-option:not(:first-child) {
  margin-top: 10px;
}

.room-deal-inforamtion-divide {
  font-size: 22px;
  margin: 0 8px;
  color: #222222;
  font-weight: 100;
}

.room-deal-close-button-wrapper {
  margin-left: auto;
  cursor: pointer;
}

.room-deal-close-button {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 22px;
  height: 22px;
  background-color: #666666;
  color: rgb(220, 220, 220);
}

.room-deal-cliked {
  background-color: rgb(235, 235, 235);
  color: rgb(170, 170, 170);
}

.room-file-upload-example {
  height: 100%;
}

.room-write-content-container {
  border-top: 1px solid #dddddd;
  min-height: 260px;
}

.room-picture-notice {
  margin: 20px;
  padding: 20px 40px;
  border: 1px solid #dddddd;
}

.file-preview-content-container {
  height: 100%;
}

.room-file-upload-wrapper {
  margin: 20px;
  border: 1px solid #dddddd;
  background-color: #f4f4f4;
  min-height: 350px;
  font-size: 15px;
  color: #888888;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}

.room-file-upload-example-container {
  display: flex;
  align-items: center;
  justify-content: center;
  /* height: 100%;
  width: 100%; */
}

.room-file-image-example-wrapper {
  text-align: center;
}

.room-file-notice-item {
  margin-top: 5px;
  text-align: center;
}

.room-file-notice-item-red {
  color: #ef4351;
}

.image-box {
  margin-top: 30px;
  padding-bottom: 20px;
  text-align: center;
}

.image-box input[type='file'] {
  position: absolute;
  width: 0;
  height: 0;
  padding: 0;
  overflow: hidden;
  border: 0;
}

.image-box label {
  display: inline-block;
  padding: 10px 20px;
  background-color: #232d4a;
  color: #fff;
  vertical-align: middle;
  font-size: 15px;
  cursor: pointer;
  border-radius: 5px;
}

.file-preview-wrapper {
  padding: 10px;
  position: relative;
}

.file-preview-wrapper>img {
  position: relative;
  width: 190px;
  height: 130px;
  z-index: 10;
}

.file-close-button {
  position: absolute;
  /* align-items: center; */
  line-height: 18px;
  z-index: 99;
  font-size: 18px;
  right: 5px;
  top: 10px;
  color: #fff;
  font-weight: bold;
  background-color: #666666;
  width: 20px;
  height: 20px;
  text-align: center;
  cursor: pointer;
}

.file-preview-container {
  height: 100%;
  display: flex;
  flex-wrap: wrap;
}

.file-preview-wrapper-upload {
  margin: 10px;
  padding-top: 20px;
  background-color: #888888;
  width: 190px;
  height: 130px;
}

.room-write-button-wrapper {
  margin-top: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #222222;
}

.room-write-button-wrapper>div {
  width: 160px;
  height: 50px;
  border: 1px solid #dddddd;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 15px;
  cursor: pointer;
}

.room-write-button {
  margin-left: 15px;
  color: #fff;
  background-color: #1564f9;
}

.room-write-button:hover {
  opacity: 0.8;
}

#field_process {
  margin-top: 200px;
}
</style>
