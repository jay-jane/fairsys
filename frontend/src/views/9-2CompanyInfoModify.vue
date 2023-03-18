<template>
  <form action="">
  
    <section>
    <h3>기업정보수정</h3>
    <div>
      <label for="com_name">회사명: <input v-model="com_name" required type="text" placeholder="회사이름을 입력하세요"></label>
    </div>
    <div>
      <label for="com_ceo">대표자명: </label>
      <input v-model="com_ceo" required type="text" placeholder="대표자명을 입력하세요">
    </div>
    <div>
      <label for="business_number">사업자등록번호: </label>
      <input v-model="business_number" required type="number" placeholder="사업자 번호를 입력하세요">
    </div>
    <div>
      <!-- <label for="com_address">회사주소: </label> -->
      <!-- <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요"> -->
      <input type="text" v-model="postcode" placeholder="우편번호">
      <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
      <input type="text" v-model="address" placeholder="주소"><br>
      <input type="text" v-model="detailAddress" placeholder="상세주소">
    </div>
    
    <div>
      <label for="com_userid">id: </label>
      <input v-model="com_userid" required type="text" placeholder="아이디를 입력하세요">
    </div>
    <div>
      <label for="com_password">password: </label>
      <input v-model="com_password" required type="password" placeholder="비밀번호를 입력하세요">
    </div>
    <div>
      <label for="com_number">전화번호: </label>
      <input v-model="com_number" required type="number" placeholder="전화번호를 입력하세요">
    </div>
    <div>
      <label for="com_manager">담당자명: </label>
      <input v-model="com_manager" required type="text" placeholder="성함을 입력하세요">
    </div>
    <div>
      <label for="com_email">이메일: </label>
      <input v-model="com_email" required type="email">
    </div>


    <button type="submit" @click="page30">수정하기</button>
    <button class="view" @click="btn_list"><router-link to="/1">목록</router-link></button>
    <button class="view" @click="btn_view">회원탈퇴</button>
  </section>
 
  </form>
</template>


<script>
export default {
  data() {
    return {
      com_name: '',
      com_ceo: '',
      business_number:'',
      postcode: "",
      address: "",
      extraAddress: "",
      com_userid:'',
      com_password:'',
      com_number:'',
      com_manager:'',
      com_email:'',
    };
  }, methods: {
    btn_view() {
      location.href = "page34";
    },
    btn_list() {
      location.href ="page1";
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

button[type="submit"] {
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


</style>

