<template>
  <form action="" id="form_modi">

    <section>
      <div class="cont_division">
        <h3>기업정보수정</h3>
        <div class="field_modi">
          <label class="label_modi" for="com_id">아이디 </label>
          <input v-model="com_id" required type="text" disabled>

        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_pw">비밀번호 </label>
          <input v-model="com_pw" required type="password" placeholder="비밀번호">
          <span v-if="!passwordValidFlag && this.com_pw !== ''" :style="{ color: ['red'] }">유효하지 않은 비밀번호 입니다.</span>
          <span v-if="passwordValidFlag && this.com_pw !== ''" :style="{ color: ['green'] }">유효한 비밀번호 입니다.</span>
        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_pw_re">비밀번호 확인 </label>
          <input v-model="com_pw_re" required type="password" placeholder="비밀번호 재확인">
          <span v-if="!passwordCheckFlag && this.com_pw_re !== ''" :style="{ color: ['red'] }">비밀번호가 다릅니다.</span>
          <span v-if="passwordCheckFlag && this.com_pw_re !== ''" :style="{ color: ['green'] }">비밀번호가 일치합니다.</span>
        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_num">사업자등록번호 </label>
          <input v-model="com_num" required type="text" disabled>
        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_name">회사명 </label>
          <input v-model="com_name" required type="text">
        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_category">회사분류 </label>
          <input v-model="com_category" required type="text">
        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_ceo">대표자명 </label>
          <input v-model="com_ceo" required type="text">
        </div>

        <div class="field_modi">
          <label class="label_modi" for="address">주소 </label>
          <input type="text" v-model="com_postcode" placeholder="우편번호">
          <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
          <input type="text" v-model="com_address" placeholder="주소"><br>
          <input type="text" v-model="com_detail_address" placeholder="상세주소">
        </div>

        <div class="field_modi">
          <label class="label_modi" for="com_manager">담당자명 </label>
          <input v-model="com_manager" required type="text">
        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_manager_phone">전화번호 </label>
          <input v-model="com_manager_phone" required type="text">
        </div>
        <div class="field_modi">
          <label class="label_modi" for="com_email">이메일 </label>
          <input v-model="com_email" required type="email">
        </div>

        <div class="btn_modi" style="margin-top: 30px; text-align: center;">  
          <button @click="modifyForm" style="margin-right: 50px;">수정하기</button>
          <button class="view" @click="companyDelete" style="background-color: red;">회원탈퇴</button>
        </div>
      </div>
    </section>

  </form>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      com_id: '',
      com_pw: '',
      com_pw_re: '',
      com_num: '',
      com_name: '',
      com_category: '',
      com_ceo: '',
      com_postcode: "",
      com_address: "",
      com_detail_address: "",
      com_manager: '',
      com_manager_phone: '',
      com_email: '',
      msg: '',
      checkList: ["(필수)개인회원 약관에 동의", "(필수)개인정보 수집 및 이용에 동의", "(선택)위치기반서비스 이용약관에 동의", "(선택)마케팅 정보 수신 동의 -이메일", "(선택)마케팅 정보 수신 동의"],
      selectList: [],
      passwordValidFlag: true,
      passwordCheckFlag: true,
      idRule: /^[a-z0-9]{4,12}$/, // 영문 대소문자, 숫자만 사용가능 길이는 4~12 글자
      passwordRule: /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,  //비밀번호 유효성 검사 정규표현식
      emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
      phoneNumRule: /^[0-9]{8,13}$/, //휴대폰 번호 숫자만 가능
    };
  },
  methods: {

    //비밀번호 유효성 검사
    checkPw() {
      if (/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/.test(this.com_pw)) {
        this.passwordValidFlag = true;
      } else {
        this.passwordValidFlag = false;
      }
    },

    // 비밀번호 재입력 검사
    checkPwRe() {
      if (this.com_pw === this.com_pw_re) {
        this.passwordCheckFlag = true;
      } else {
        this.passwordCheckFlag = false;

      }
    },
    get() {
      axios.get('/9-2',
        {
          params: { com_id: sessionStorage.getItem("com_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
          }
        }).then(res => {
          console.log(res)
          console.log(res.data)

          this.com_category = res.data.com_category
          this.com_manager = res.data.com_manager
          this.com_manager_phone = res.data.com_manager_phone
          this.com_ceo = res.data.com_ceo
          this.com_num = res.data.com_num
          this.com_id = res.data.com_id
          this.com_email = res.data.com_email
          this.com_name = res.data.com_name
          this.com_postcode = res.data.com_postcode
          this.com_address = res.data.com_address
          this.com_detail_address = res.data.com_detail_address

        }).catch(err => {
          console.log(err)
          alert("로그인이 필요한 서비스입니다.")
          this.$router.push({ path: '/2' })

        })


    },
    async modifyForm() {
      this.axios.post('/9-2/modifyForm',
        {
          com_pw: this.com_pw,
          com_name: this.com_name,
          com_category: this.com_category,
          com_ceo: this.com_ceo,
          com_email: this.com_email,
          com_postcode: this.com_postcode,
          com_address: this.com_address,
          com_detail_address: this.com_detail_address,
          com_manager: this.com_manager,
          com_manager_phone: this.com_manager_phone,
        },
        {
          params: { com_id: sessionStorage.getItem("com_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("com_id"),
          },
        }
      ).then(res => {
        console.log(res)
        console.log(res.config.data)
        alert("정보가 수정되었습니다.")
        this.$router.push({ path: '/' })
      }).catch(err => {
        console.log(err)
      })
    },
    companyDelete() {
      if (confirm('아이디를 삭제하시겠습니까?')) {
        this.axios.get('/Company/deleteForm',
          {
            params: { com_id: sessionStorage.getItem("com_id") },
            headers: {
              'content-type': 'application/json',
              'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
            }
          }
        ).then(res => {
          alert('아이디가 삭제되었습니다.')
          sessionStorage.clear();
          this.$store.commit("setLogInOut", "로그인")
          this.$router.push({ path: '/' })
        })
      }
    },
    btn_view() {
      location.href = "page34";
    },
    btn_list() {
      location.href = "page1";
    },
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extraAddress !== "") {
            this.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.address = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.

            // if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
            //   this.extraAddress += data.bname;
            // }

            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extraAddress +=
                this.extraAddress !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extraAddress !== "") {
              this.extraAddress = `(${this.extraAddress})`;
            }
          } else {
            this.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
    },
  },

  watch: {
    'com_pw': function () {
      this.checkPw()
    },

    'com_pw_re': function () {
      this.checkPwRe()
    },

  },
  mounted() {
    this.get()
  },

};


</script>

<style>
#form_modi {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  margin: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  
}
.field_modi input {
  padding: 5px;
  border-radius: 3px;
  border: 1px solid #ccc;
  width: 100%;
}

.label_modi {
  display: inline-block;
  font-weight: bold;
  border-bottom: 1px solid orangered;
  margin-bottom: 5px;
}

.cont_division {
  position: relative;
  width: 360px;
  box-sizing: border-box;
  margin-top: 24px;
}

.field_modi {
  margin-top: 10px;
}

.btn_modi button {
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
}
</style>

