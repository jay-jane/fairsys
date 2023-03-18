
<template>
  <form action="">

    <section>


      <div class="cont_division">

        <div :style="{ display: ['flex'], flexDirection: ['row'], justifyContent: ['space-between'] }">
          <h3><router-link to="/3-1">개인 회원가입</router-link></h3>
          <h3 :style="{ borderBottom: ['4px solid #777'] }"><router-link to="/3-2">기업 회원가입</router-link></h3>
        </div>
        <br><br>
        <div>
          <label for="com_id">아이디 </label>
          <input v-model="com_id" required type="text" placeholder="아이디">
          <button type="button" @click="checkId"
            :style="{ width: ['60px'], fontSize: ['8px'], textAlign: ['center'], padding: ['1px'] }">중복확인</button>
        </div>
        <div>
          <label for="com_pw">비밀번호 </label>
          <input v-model="com_pw" required type="password" placeholder="비밀번호">
          <span v-if="!passwordValidFlag && this.com_pw !== ''" :style="{ color: ['red'] }">유효하지 않은 비밀번호 입니다.</span>
          <span v-if="passwordValidFlag && this.com_pw !== ''" :style="{ color: ['green'] }">유효한 비밀번호 입니다.</span>
        </div>
        <div>
          <label for="com_pw_re">비밀번호 확인 </label>
          <input v-model="com_pw_re" required type="password" placeholder="비밀번호 재확인">
          <span v-if="!passwordCheckFlag && this.com_pw_re !== ''" :style="{ color: ['red'] }">비밀번호가 다릅니다.</span>
          <span v-if="passwordCheckFlag && this.com_pw_re !== ''" :style="{ color: ['green'] }">비밀번호가 일치합니다.</span>
        </div>
        <div>
          <label for="com_num">사업자등록번호 </label>
          <input v-model="com_num" required type="text" placeholder="사업자 번호">
        </div>
        <div>
          <label for="com_name">회사명 </label>
          <input v-model="com_name" required type="text" placeholder="회사이름">
        </div>
        <div>
          <label for="com_category">회사분류 </label>
          <input v-model="com_category" required type="text" placeholder="회사분류">
        </div>
        <div>
          <label for="com_ceo">대표자명 </label>
          <input v-model="com_ceo" required type="text" placeholder="대표자명">
        </div>

        <div>
          <label for="address">주소 </label>
          <input type="text" v-model="com_postcode" placeholder="우편번호">
          <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
          <input type="text" v-model="com_address" placeholder="주소"><br>
          <input type="text" v-model="com_detail_address" placeholder="상세주소">
        </div>

        <div>
          <label for="com_manager">담당자명 </label>
          <input v-model="com_manager" required type="text" placeholder="담당자">
        </div>
        <div>
          <label for="com_manager_phone">전화번호 </label>
          <input v-model="com_manager_phone" required type="text" placeholder="전화번호">
        </div>
        <div>
          <label for="com_email">이메일 </label>
          <input v-model="com_email" required type="email" placeholder="이메일">
        </div>



        <div class="cont_division">
          <span class="terms_agree">
            <strong>약관</strong>
          </span>
          <div class="agree_box">
            <ul class="agree_article">
              <li>
                <span class="inpChk sizeL">
                  <input type="checkbox" id="agreeAllPersonal" class="check_mail" v-model="allSelected">
                  <label class="check_all check_off lbl" for="agreeAllPersonal">
                    <strong>전체동의</strong>
                  </label>
                </span>
              </li>
            </ul>
          <!-- <template v-for="(item, index) in checkList" :key="index">
                <input type="checkbox" :id="item" :value="item" v-model="selectList" />
                <label :for="item" > {{ item }}</label>
                              </template> -->
            <div v-for="(item, index) in checkList" :key="index">
              <ul class="agree_article depth2">
                <li>
                  <div class="agree_desc">
                    <span class="chk">
                      <input type="checkbox" :id="item" :value="item" v-model="selectList">
                      <label :for="item">
                        <span><strong>{{ item }}</strong></span>
                      </label>
                    </span>
                  </div>
                  <a href=""><br />
                    <!-- <span>개인회원 약관 상세보기</span> -->
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>

        <div class="list">
          <button type="button" @click="submitForm">가입하기</button>
          <button class="view" @click="btn_view">목록</button>
        </div>

      </div>


    </section>


  </form>
</template>

<script>

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
    btn_view() {
      location.href = "page1";
    },

    // 아이디 중복확인 메서드
    checkId() {
      if (this.user_id !== '') {

        //아이디 중복확인 전 id 유효성 검사
        if (this.idRule.test(this.com_id.trim()) === false) {
          alert('아이디는 4~12글자 이내로 영어 대소문자,숫자만 가능합니다')
        } else {
          //id 중복확인 요청 보내기
          this.axios.post('/3-2/checkId',
            { user_id: this.com_id, })
            .then(res => {
              console.log(res)
              if (res.data) {
                this.msg = '사용이 가능한 id 입니다'
              } else {
                this.msg = '이미 사용하고 있는 id 입니다'
              }
              alert(this.msg)
            })
            .catch(err => {
              console.log(err)
            })

        }
      } else {
        this.msg = "Id를 입력해주세요"
      }
    },

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

    //회원가입폼
    async submitForm() {
      console.log(1);

      // let data = await fetch("/test/registForm", {
      //     method: "post", 
      //     body: JSON.stringify({ user_id: "Xxxx" }),
      //     headers: { "Content-Type": "application/json", }
      //     })
      // let result = await data.text();
      // console.log(result)

      this.axios.post('/3-2/registForm',
        {
          com_id: this.com_id,
          com_pw: this.com_pw,
          com_num: this.com_num,
          com_name: this.com_name,
          com_category: this.com_category,
          com_ceo: this.com_ceo,
          com_postcode: this.com_postcode,
          com_address: this.com_address,
          com_detail_address: this.com_detail_address,
          com_manager: this.com_manager,
          com_manager_phone: this.com_manager_phone,
          com_email: this.com_email,
        }
      ).then(res => {
        console.log(res)
        console.log(res.config.data)
        // this.$router.push({ path: '/' })
      }).catch(err => {
        console.log(err)
      })
    },

    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.com_detail_address !== "") {
            this.com_detail_address = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.com_address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.com_address = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.com_detail_address += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.user_detail_address +=
                this.user_detail_address !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.com_detail_address !== "") {
              this.com_detail_address = `(${this.com_detail_address})`;
            }
          } else {
            this.com_detail_address = "";
          }
          // 우편번호를 입력한다.
          this.com_postcode = data.zonecode;
        },
      }).open();
    },
  },
  computed: {
    allSelected: {
      get: function () {
        return this.checkList.length === this.selectList.length;
      },
      set: function (e) {
        this.selectList = e ? this.checkList : [];
      }
    }
  },
  watch: {
    'com_pw': function () {
      this.checkPw()
    },

    'com_pw_re': function () {
      this.checkPwRe()
    },

  },
};


</script>

<style>
div {
  display: block;
  margin: 0;
  padding: 0;
  font-size: 100%;
}

#join_wrapper {
  width: 300px;
  margin: 0 auto;
  position: relative;
}

div {
  display: block;
  margin: 0;
  padding: 0;
  font-size: 100%;
}

#join_wrapper {
  width: 300px;
  margin: 0 auto;
  position: relative;
}

li {
  list-style: none;

}

a:link,
a:visited,
a:active,
a:hover {
  text-decoration: none;
  color: black;
}


form {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  margin: 20px;
  padding: 20px;
}

label {
  font-weight: bold;
}

input {
  padding: 5px;
  border-radius: 3px;
  border: 1px solid #ccc;
  width: 100%;
}

button[type="button"] {
  padding: 10px;
  font-size: 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.view {
  padding: 10px;
  font-size: 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #005fa3;
}

.list {
  text-align: center;
  margin-top: 30px;
  display: flex;
  justify-content: center;
  width: 300px;
}

.list :first-child {
  margin-right: 30px;
}

/* 약관동의 부분 */
.cont_division {
  position: relative;
  width: 360px;
  box-sizing: border-box;
  margin-top: 24px;
}

.cont_division .terms_agree {
  font-size: 16px;
  color: #373f57;
  margin-bottom: 8px;
  display: inline-block;
}

.cont_division .agree_box {
  border: 1px solid #d7dce5;
  padding: 10px;
}

.cont_division .agree_box .agree_article {
  color: black;
  border-bottom: 1px solid #d7dce5;
  padding-bottom: 16px;

}

.inpChk {
  display: inline-block;
  position: relative;
  vertical-align: top;
}




.cont_division .agree_box .agree_article.depth2 {
  border: none;
  padding-bottom: 0;
}

.cont_division .agree_box .agree_article.depth2 li {
  position: relative;
  margin: -10px;
}

.cont_division .agree_box .agree_article.depth2 span {
  font-size: 15px;
}

input[type="checkbox"] {
  display: inline-block;
  width: 15px;
  height: 13px;

}

* {
  text-align: left;
}

.btn_logInOut {
    text-align: center;
}
</style>
  
  