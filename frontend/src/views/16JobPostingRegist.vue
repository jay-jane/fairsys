<!-- 재윤 - 채용 공고 등록 -->
<template>
  <section id="jy_form_sec">
    <h3 style="text-align: center;">채용 공고 등록</h3>
    <form @submit="regist">
      <div id="jy_field">
        <label class="jy_field_name">제목</label>
        <div id="">
          <input type="hidden" v-model="com_id">
          <input type="text" class="jy_text" id="j_title" v-model="j_title">
        </div>
      </div>
      <div v-for="item in com_list">
        <div id="jy_field">
          <label class="jy_field_name">담당자 성함</label>
          <div id="">
            <input type="text" class="jy_text jy_f" :value="item.com_manager" style="border: 0;" readonly>
          </div>
        </div>
        <div id="jy_field">
          <label class="jy_field_name">기업명</label>
          <div id="">
            <input type="text" class="jy_text jy_f" :value="item.com_name" style="border: 0;" readonly>
          </div>
        </div>
        <div class="jy_field tel-number">
          <label class="jy_field_name">휴대폰 번호</label>
          <div class="jy_tel_number_input">
            <input type="text" class="jy_text jy_f" id="jy_tel_number" :value="item.com_manager_phone" style="border: 0;"
              readonly>
          </div>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">이메일 주소</label>
        <div id="">
          <input type="email" class="jy_text" v-model="j_email" id="j_email">
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">모집 분야</label>
        <div id="jy_job_type" style="margin-top: 5px;">
          <Hashtags></Hashtags>
        </div>
        <div id="jy_recruit_type" style="display: inline-block;">
          <input type="text" class="jy_text" style="width: 40px; margin-left: 5px;" v-model="j_recruitNum">
          <span>명 모집</span>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">경력 여부</label><br>
        <div id="jy_career" style="display: inline-block;">
          <input type="radio" name="career_type" v-model="j_career" value="신입">신입
          <input type="radio" name="career_type" v-model="j_career" value="경력">경력
          <input type="radio" name="career_type" v-model="j_career" value="경력무관">경력무관
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">근무지역</label>
        <div class="jy_postAPI">
          <label for="address" style="font-size: 14px;"> - 주소</label>
          <input type="text" class="jy_text" v-model="j_postcode" placeholder="우편번호">
          <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"
            style="cursor: pointer; border: 0; width: 120px; height: 30px; color: orangered; font-weight: bold; background-color: #efefef;"><br>
          <input type="text" class="jy_text" v-model="j_address" placeholder="주소"><br>
          <input type="text" class="jy_text" v-model="j_detail_address" placeholder="상세주소">
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">급여(연봉)</label>
        <div id="jy_sal_wrap" style="margin-top: 5px;">
          <select id="jy_sal_y" v-model="j_salary">
            <option value="2,200만원 ~ 2,800만원">2,200만원 ~ 2,800만원</option>
            <option value="2,800만원 ~ 3,200만원">2,800만원 ~ 3,200만원</option>
            <option value="3,200만원 ~ 3,600만원">3,200만원 ~ 3,600만원</option>
            <option value="3,600만원 ~ 4,000만원">3,600만원 ~ 4,000만원</option>
          </select>
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">근무 형태</label><br>
        <div style="display: inline-block;">
          <input type="radio" name="work_type" v-model="j_type" value="정규직">정규직
          <input type="radio" name="work_type" v-model="j_type" value="계약직">계약직
          <input type="radio" name="work_type" v-model="j_type" value="인턴">인턴
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">학력</label><br>
        <div style="display: inline-block;">
          <input type="radio" name="graduation_type" v-model="j_graduation" value="대졸">대졸
          <input type="radio" name="graduation_type" v-model="j_graduation" value="고졸/초대졸">고졸/초대졸
          <input type="radio" name="graduation_type" v-model="j_graduation" value="학력무관">학력무관
        </div>
      </div>
      <div id="jy_field">
        <label class="jy_field_name">상세 내용</label>
        <div class="jy_content" style="margin-top: 10px;">
          <textarea class="jy_textarea" cols="70" rows="10" v-model="j_content"></textarea>
          <div class="jy_main-container">
            <div class="room-deal-information-container">
              <div class="room-deal-information-title">사진 등록</div>
              <div class="room-picture-notice">
                <ul class="room-write-wrapper">
                  <li>사진 한 장당 10MB 까지 등록이 가능합니다.</li>
                </ul>
              </div>
              <div class="room-file-upload-wrapper">
                <div v-if="!files.length" class="room-file-upload-example-container">
                  <div class="room-file-upload-example">
                    <div class="room-file-image-example-wrapper">이미지</div>
                  <!-- <div class="room-file-notice-item">
                      설명
                                              </div> -->
                    <div class="room-file-notice-item room-file-notice-item-red">
                      <!-- 이미지는 최대 3개 까지 첨부하실 수 있습니다. -->
                    </div>
                    <div class="room-file-notice-item room-file-upload-button">
                      <div class="image-box">
                      <!-- <div class="image-profile">
                        <img :src="profileImage" />
                                                </div> -->
                        <label for="file">사진 등록</label>
                        <input type="file" id="file" ref="files" @change="imageUpload" accept="image/*" multiple />
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
                    <div v-if="files.length < 1" class="file-preview-wrapper-upload">
                      <div class="image-box">
                        <label for="file">추가 사진 등록</label>
                        <input type="file" id="file" ref="files" @change="imageAddUpload" multiple />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="jy_field_process">
        <label class="jy_field_name">전형 절차</label>
        <div id="">
          <div id="jy_process_wrap">
            <input type="text" class="jy_text" id="jy_process" value="서류전형" readonly>
          </div>
          <div id="jy_process_add">
            <button type="button" class="jy_add_btn" name="interview1" @click="addBtn" ref="btn1"
              style="margin-bottom: 15px;">
              1차면접
              <span style="font-size: 16px; color: orangered; font-weight: bold;">+</span>
            </button>
          </div>
          <div id="jy_process_wrap" ref="interview1" style="display: none;">
            <input type="text" class="jy_text" id="jy_process" value="1차면접" readonly>
            <img class="jy_deleteBtn" @click="deleteItem" name="interview1" src="@/img/delete-icon.png" alt="삭제">
          </div>
          <div id="jy_process_add">
            <button type="button" class="jy_add_btn" name="interview2" style="display: none;" @click="addBtn" ref="btn2">
              2차면접
              <span style="font-size: 16px; color: orangered; font-weight: bold;">+</span>
            </button>
          </div>
          <div id="jy_process_wrap" ref="interview2" style="display: none;">
            <input type="text" class="jy_text" id="jy_process" value="2차면접" readonly>
            <img class="jy_deleteBtn" @click="deleteItem" name="interview2" src="@/img/delete-icon.png" alt="삭제">
          </div>
          <div id="jy_process_wrap">
            <input type="text" class="jy_text" id="jy_process" value="최종합격" readonly>
          </div>
        </div>
      </div>
      <div id="jy_field endDate">
        <label class="jy_field_name">마감일자</label><br>
        <div class="jy_date_Select" style="margin-top: 5px;">
          <table>
            <tbody>
              <td>
                <Datepicker v-model="endDate" :locale="locale" :weekStartsOn="0" :inputFormat="inputFormat"
                  :clearable="true"  style="{z-index: 20;}"/>
              </td>
            </tbody>
          </table>
        </div>
      </div>
      <div id="jy_reg-btn-wrap">
        <button type="button" class="reg_btn" value="등록" @click="submitForm" style="margin-right: 10px;">등록</button>
        <button type="button" class="reset_btn" value="취소" @click="goMain">취소</button>
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
      j_content: '',
      j_salary: '',
      j_department: '',
      j_schedule: '',
      j_graduation: '',
      j_end_date: '',
      j_career: '',
      j_type: '',
      j_end_date: '',
      com_id: '',
      endDate: '',
      com_list: '',

      file: '',
      files: [], //업로드용 파일
      filesPreview: [],
      uploadImageIndex: 0, // 이미지 업로드를 위한 변수
      j_img_name: '',
      j_img_size: '',
      j_img_path: '',

      j_postcode: '',
      j_address: '',
      j_detail_address: '',
      detailAddress: '',

      upResult: false,
    }
  },
  methods: {
    goMain() {
      this.$router.push("/4");
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
    validation() {
      const now = new Date();
      if (this.j_title == '') {
        alert('글 제목은 필수 입력 항목입니다');
        document.getElementById("j_title").focus();
        return;
      }
      else if (this.j_email == '') {
        ``
        alert('이메일은 필수 입력 항목입니다');
        document.getElementById("j_email").focus();
        return;
      }
      else if (now > this.endDate) {
        alert('마감일은 오늘 날짜 이후로 설정 가능합니다');
        return;
      }
      else {
        this.upResult = true;
        return;
      }
    },
    submitForm() {
      if (confirm('등록하시겠습니까?')) {
        this.validation();
        console.log(this.upResult);
        if (this.upResult) {
          if (this.files.length >= 1) {
            this.uploadImg(sessionStorage.getItem("com_id"));
            if (this.$refs.interview1.style.display == "none") {
              this.j_schedule = "";
            } else if (this.$refs.interview1.style.display == "block" && this.$refs.interview2.style.display == "none") {
              this.j_schedule = "1차 면접 >";
            }
            if (this.$refs.interview2.style.display == "block") {
              this.j_schedule = "1차 면접 > 2차 면접 >";
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
                com_id: sessionStorage.getItem("com_id"),
                j_postcode: this.j_postcode,
                j_address: this.j_address,
                j_detail_address: this.j_detail_address,
              }
            ).then(() => {
              alert('등록되었습니다!');
              this.$router.push({ path: '/4' });
            }).catch(err => {
              console.log(err);
            });
          } else {
            if (this.$refs.interview1.style.display == "none") {
              this.j_schedule = "";
            } else if (this.$refs.interview1.style.display == "block" && this.$refs.interview2.style.display == "none") {
              this.j_schedule = "1차 면접 >";
            }
            if (this.$refs.interview2.style.display == "block") {
              this.j_schedule = "1차 면접 > 2차 면접 >";
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
                com_id: sessionStorage.getItem("com_id"),
                j_postcode: this.j_postcode,
                j_address: this.j_address,
                j_detail_address: this.j_detail_address,
              }
            ).then(() => {
              alert('등록되었습니다!');
              this.$router.push({ path: '/4' });
            }).catch(err => {
              console.log(err);
            });
          }
        }
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
      // console.log(this.$refs.files.files);
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
      this.j_img_name = URL.createObjectURL(this.files[0].file);
      this.j_img_size = this.files[0].file.size;
    },
    imageAddUpload() {
      // console.log(this.$refs.files.files);
      // this.files = [...this.files, this.$refs.files.files];
      //하나의 배열로 넣기
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
      this.com_id = this.$route.params.com_id;
      this.axios.get("/getCompanyVO/" + this.com_id, { params: { "com_id": this.com_id } })
        .then(res => {
          this.com_list = res.data;
        })
        .catch(err => console.log(err));
    },
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.j_detail_address !== "") {
            this.j_detail_address = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.j_address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.j_address = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.j_detail_address += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.j_detail_address +=
                this.j_detail_address !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.j_detail_address !== "") {
              this.j_detail_address = `(${this.j_detail_address})`;
            }
          } else {
            this.j_detail_address = "";
          }
          // 우편번호를 입력한다.
          this.j_postcode = data.zonecode;
        },
      }).open();
    },
    uploadImg(com_id) {
      console.log(this.files[0].file);
      console.log(com_id);
      const form = new FormData();
      form.append('file', this.files[0].file);
      form.append('com_id', com_id);
      this.axios.post("/uploadImg", form)
        .then(() => console.log("imgUp"))
        .catch(err => {
          alert('이미지 업로드에 실패하였습니다.');
          console.log(err);
        });
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
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
  font-family: 'Noto Sans KR', sans-serif;
}

#jy_form_sec {
  max-width: 500px;
  margin: auto;
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

.jy_text,
.jy_textarea:focus-within {
  outline-color: orange;
}

.jy_f {
  border: 0;
  cursor: default;
}

.jy_f:focus-within {
  outline: 0;
}

/* 라디오 버튼 스타일링 */
input[type="radio"] {
  margin-right: 5px;
}

.jy_tel_number_input>input {
  width: 150px;
}

#jy_process_wrap {
  position: relative;
}

#jy_process_wrap .jy_deleteBtn {
  position: absolute;
  top: 20px;
  right: 20px;
}

#jy_process_wrap .jy_deleteBtn:hover {
  cursor: pointer;
}

#jy_recruit_type {
  overflow: hidden;
}

#jy_recruit_type input {
  float: left;
}

#jy_recruit_type .jy_recruit_type_input {
  width: 200px;
}

#jy_recruit_type span {
  line-height: 59px;
}

#jy_sal_wrap input[type=text] {
  width: 80%;
  margin-right: 10px;
}

#jy_process_wrap #jy_process {
  font-weight: bold;
  color: orangered;
  cursor: default;
  text-align: center;
  position: relative;
}

#jy_process_add {
  text-align: center;
}

#jy_process_add .jy_add_btn {
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


.jy_main-container {
  width: 500px;
  height: 400px;
  margin: 0 auto;
}

.room-deal-information-container {
  margin-top: 20px;
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
  background-color: orangered;
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

#jy_field_process {
  margin-top: 180px;
}

#jy_reg-btn-wrap {
  text-align: center;
  margin: 30px 0 30px 0;
}

#jy_reg-btn-wrap .reg_btn,
.reset_btn {
  display: inline-block;
  border: 0;
  width: 120px;
  height: 40px;
  line-height: 40px;
  line-height: 40px;
  background-color: orangered;
  border-radius: 2px;
  font-size: 20px;
  font-weight: 500;
  color: #efefef;
  letter-spacing: 1px;
  cursor: pointer;
}
</style>
