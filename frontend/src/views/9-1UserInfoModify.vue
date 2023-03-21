<template>
  <form action="">

    <section>
      <div class="cont_division">
        <h3>개인정보수정</h3>
        <div>
          <label for="user_id">아이디 </label>
          <input v-model="user_id" required type="text" disabled>
        </div>

        <div>
          <label for="user_pw">비밀번호 </label>
          <input v-model="user_pw" required type="password" placeholder="비밀번호">
          <span v-if="!passwordValidFlag && this.user_pw !== ''" :style="{ color: ['red'] }">유효하지 않은 비밀번호 입니다.</span>
          <span v-if="passwordValidFlag && this.user_pw !== ''" :style="{ color: ['green'] }">유효한 비밀번호 입니다.</span>
        </div>

        <div>
          <label for="user_pw_re">비밀번호 확인 </label>
          <input v-model="user_pw_re" required type="password" placeholder="비밀번호 재확인">
          <span v-if="!passwordCheckFlag && this.user_pw_re !== ''" :style="{ color: ['red'] }">비밀번호가 다릅니다.</span>
          <span v-if="passwordCheckFlag && this.user_pw_re !== ''" :style="{ color: ['green'] }">비밀번호가 일치합니다.</span>
        </div>

        <div>
          <label for="user_name">이름 </label>
          <input v-model="user_name" required type="text" disabled>
        </div>
        <div>
          <label for="user_birth">생년월일 </label>
          <input v-model="user_birth" required type="text" disabled>

        </div>

        <label for="user_gender">성별</label>
        <div>
          {{ user_gender }}
        </div>

        <div>
          <label for="user_phone">전화번호 </label>
          <input v-model="user_phone" required type="text" placeholder="전화번호를 입력하세요" maxlength="11">
        </div>

        <div>
          <label for="user_email">이메일 </label>
          <input v-model="user_email" required type="email" placeholder="이메일">
        </div>
        <div>
          <!-- <label for="com_address">회사주소: </label> -->
          <!-- <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요"> -->
          <label for="address">주소 </label>
          <input type="text" v-model="user_postcode" placeholder="우편번호">
          <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
          <input type="text" v-model="user_address" placeholder="주소"><br>
          <input type="text" v-model="user_detail_address" placeholder="상세주소">
        </div>


        <button type="button" @click="modifyForm">수정하기</button>
        <button class="view" @click="btn_list"><router-link to="/1">목록</router-link></button>
        <button class="view" @click="btn_view">회원탈퇴</button>
      </div>
    </section>

  </form>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      userInfo: '',
      user_id: '',
      user_pw: '',
      user_pw_re: '',
      user_name: '',
      user_birth: '',
      birth: {
        yyyy: '',
        mm: '',
        dd: '',
      },
      user_gender: '',
      user_postcode: '',
      user_address: '',
      user_detail_address: '',
      detailAddress: '',
      user_email: '',
      user_phone: '',
      passwordValidFlag: true,
      passwordCheckFlag: true,
    }
  },
  methods: {

    //비밀번호 유효성 검사
    checkPw() {
      if (/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/.test(this.user_pw)) {
        this.passwordValidFlag = true;
      } else {
        this.passwordValidFlag = false;
      }
    },

    // 비밀번호 재입력 검사
    checkPwRe() {
      if (this.user_pw === this.user_pw_re) {
        this.passwordCheckFlag = true;
      } else {
        this.passwordCheckFlag = false;

      }
    },
    // btn_view() {
    //   location.href = "page34";
    // },
    // btn_list() {
    //   location.href = "page1";
    // },
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.user_detail_address !== "") {
            this.user_detail_address = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.user_address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.user_address = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.user_detail_address += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.user_detail_address +=
                this.user_detail_address !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.user_detail_address !== "") {
              this.user_detail_address = `(${this.user_detail_address})`;
            }
          } else {
            this.user_detail_address = "";
          }
          // 우편번호를 입력한다.
          this.user_postcode = data.zonecode;
        },
      }).open();
    },
    get() {

      axios.get('/6/mypage',
        {
          params: { user_id: sessionStorage.getItem("user_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
          }
        }).then(res => {
          console.log(res)
          console.log(res.data)

          this.birth.yyyy = res.data.user_birth.substr(0, 4)
          this.birth.mm = res.data.user_birth.substr(4, 2)
          this.birth.dd = res.data.user_birth.substr(6, 2)
          this.user_birth = this.birth.yyyy + "년 " + this.birth.mm + "월 " + this.birth.dd + "일"
          this.user_id = res.data.user_id
          this.user_phone = res.data.user_phone
          this.user_email = res.data.user_email
          this.user_name = res.data.user_name
          this.user_gender = res.data.user_gender == 'M' ? "남자" : "여자"
          this.user_postcode = res.data.user_postcode
          this.user_address = res.data.user_address
          this.user_detail_address = res.data.user_detail_address

        }).catch(err => {
          console.log(err)
          alert("로그인이 필요한 서비스입니다.")
          this.$router.push({ path: '/2' })

        })


    },

    async modifyForm() {
      console.log(1);

      // let data = await fetch("/test/registForm", {
      //     method: "post", 
      //     body: JSON.stringify({ user_id: "Xxxx" }),
      //     headers: { "Content-Type": "application/json", }
      //     })
      // let result = await data.text();
      // console.log(result)

      this.axios.post('/9/modifyForm',
        {
          user_pw: this.user_pw,
          user_phone: this.user_phone,
          user_email: this.user_email,
          user_postcode: this.user_postcode,
          user_address: this.user_address,
          user_detail_address: this.user_detail_address
        },
        {
          params: { user_id: sessionStorage.getItem("user_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
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
  },

  watch: {
    'user_pw': function () {
      this.checkPw()
    },

    'user_pw_re': function () {
      this.checkPwRe()
    },

  },
  mounted() {
    this.get()
  },


};


</script>

<style>
form {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  margin: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;

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

.cont_division {
  position: relative;
  width: 360px;
  box-sizing: border-box;
  margin-top: 24px;
}
</style>

