<template>
  <section>
    <div class="hw_resume">

      <div class="hw_resume-main">
        <div class="hw_resume-part-title">이력서 수정</div>
        <h3 style="text-align: left;">학력</h3>
        <div class="hw_resume-part2-box">
          <table class="hw_resume-part2-input">

            <tr>
              <th><label for="user_name">이름</label></th>
              <td>
                <input v-model="user_name" required type="text" disabled >
              </td>
              <th><label for="user_phone">연락처</label></th>
              <td>
                <input v-model="user_phone" required type="text" disabled>
              </td>
            </tr>
            <tr>
              <th><label for="user_email">이메일</label></th>
              <td>
                <input v-model="user_email" required type="text" disabled>
              </td>
              <th><label for="user_gender">성별</label></th>
              <td> <input v-model="user_gender" required type="text" disabled></td>
              
            </tr>
             <tr>
              <th><label for="user_address">주소</label></th>
              <td>
                <input v-model="user_address" required type="text" disabled >
              </td>
            </tr>

          </table>
        </div>

        <h3 style="text-align: left;">학력</h3>
        <div class="hw_resume-part2-box">
          <table class="hw_resume-part2-input">

            <tr>
              <th><label for="user_level">최종학력</label></th>
              <td>
                <select class="hw_select-graduation" v-model="user_level">
                    <option value="대졸">대졸</option>
                    <option value="고졸">고졸</option>
                  </select>
              </td>
              <th class="pl-15"><label for="user_finish">졸업여부</label></th>
              <td>
                <div class="hw_graduation">
                  <select class="hw_select-graduation" v-model="user_finish">
                    <option value="졸업">졸업</option>
                    <option value="졸업예정">졸업예정</option>
                  </select>
                </div>
              </td>
            </tr>
            <tr>
              <th><label for="user_major">전공</label></th>
              <td>
                <input v-model="user_major" required type="text">
              </td>
              <th style="padding-top:10px"><label for="user_fndate">졸업예정날짜</label></th>
              <td>

                <input v-model="user_fndate" required type="date">

              </td>
            </tr>

          </table>
        </div>
        
        <!-- /// -->
        <h3 style="text-align: left;">경력</h3>
        <div class="hw_resume-part2-box">
          <table class="hw_resume-part2-input">
            <tr>
              <th><label for="user_com">회사명</label></th>
              <td>
                <input v-model="user_com" required type="text">
              </td>
              <th><label for="user_position">직급</label></th>
              <td>
                <input v-model="user_position" required type="text">
              </td>
            </tr>
            <tr>
              <th style="padding-top:10px"><label for="user_join">입사일</label></th>
              <td>

                <input v-model="user_join" required type="date">

              </td>

              <th style="padding-top:10px"><label for="user_leave">퇴사일</label></th>
              <td>

                <input v-model="user_leave" required type="date">

              </td>
            </tr>

          </table>
        </div>

        <h3 style="text-align: left;">어학</h3>
        <div class="hw_resume-part2-box">
          <table class="hw_resume-part2-input">

            <tr>
              <th><label for="user_subject">과목</label></th>
              <td>
                <input v-model="user_subject" required type="text">
              </td>
              <th class="pl-15"><label for="user_score">점수</label></th>
              <td>
                <input v-model="user_score" required type="text">
              </td>
            </tr>
            <tr>
              <th style="padding-top:10px"><label for="user_get">취득일</label></th>
              <td>

                <input v-model="user_get" required type="date">

              </td>

            </tr>


          </table>
        </div>


        <!-- /// -->
        <h3 style="text-align: left;">자격증</h3>
        <div class="hw_resume-part2-box">
          <table class="hw_resume-part2-input">
            <tr>
              <th class="pl-15"><label for="user_license">자격증명</label></th>
              <td>
                <input v-model="user_license" required type="text">
              </td>
              <th style="padding-top:10px"><label for="user_getlicense">취득일</label></th>
              <td>

                <input v-model="user_getlicense" required type="date">

              </td>
            </tr>
          </table>
        </div>

        <button type="button" value="등록" @click="updateForm" style="margin-right: 10px;">수정 완료</button>

        <button type="button" value="취소" @click="cancel">취소</button>
      </div>

    </div>


  </section>
</template>
    
<script>
export default {
  name: 'App',
  data() {
    return {
      user_name:"",
      user_phone: "",
      user_email: "",
      user_address: "",
      user_gender: "",
      user_level: "",
      user_finish: "",
      user_major: "",
      user_fndate: "",
      user_com: "",
      user_position: "",
      user_join: "",
      user_leave: "",
      user_subject: "",
      user_score: "",
      user_get: "",
      user_license: "",
      user_getlicense: "",
      user_id: "",
      com_id:"",
      list: [],
      userInfo:'',
    };
  },
  methods: {
    cancel: () => {
      location.href = "/";
    },
    async updateForm() {
      this.axios.post('/ResumeUpdate/updateForm', {
        user_no: this.user_no,
          user_name: this.user_name,
          user_phone: this.user_phone,
          user_email: this.user_email,
          user_address: this.user_address,
          user_gender: this.user_gender,
          user_level: this.user_level,
          user_finish: this.user_finish,
          user_major: this.user_major,
          user_fndate: this.user_fndate,
          user_com: this.user_com,
          user_position: this.user_position,
          user_join: this.user_join,
          user_leave: this.user_leave,
          user_subject: this.user_subject,
          user_score: this.user_score,
          user_get: this.user_get,
          user_license: this.user_license,
          user_getlicense: this.user_getlicense,
          user_id: this.user_id,
          com_id: this.com_id
        },
        {
          params: { user_id: sessionStorage.getItem("user_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
          },
        }
      ).then(res => {
        console.log(this.user_id)
        alert('수정이 완료되었습니다.!');
        console.log(res)
        this.$router.push('/UserMyPage');
      }).catch(err => {
        console.log(err)
      })
    },
    async get() {

this.axios.get('/ResumeRegist',
  {
    params: { user_id: sessionStorage.getItem("user_id") },
    headers: {
      'content-type': 'application/json',
      'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
    },
  }
).then(res => {
  console.log(res)
  this.user_name=res.data.user_name
  this.user_phone=res.data.user_phone
  this.user_email=res.data.user_email
  this.user_address=res.data.user_address + res.data.user_detail_address
  this.user_gender = res.data.user_gender == 'M' ? "남자" : "여자"
}).catch(err => {
  console.log(err)
})
}
},

mounted(){
this.get()
}
};
</script>
<style>
.hw_resume {
  width: 30vw;
  margin: 0 auto;
  display: grid;
  padding-top: 8vh;
  height: 100%;
}

.hw_resume-wrapper {
  margin: 0 auto;
  width: 200px;
  font-size: 14px;
  top: 20vh;
  left: 20vw;
  position: fixed;
}
.hw_select-graduation {
  width: 10vw;
  margin: 10px;
  border-radius: 5px;
  border: 2px solid #ccc;
  padding: 2px 3px;
}

/* 본문 */
.hw_resume-part-title {
  font-size: 40px;
  color: black;
  font-weight: bold;
}

.hw_resume-part-box {
  display: flex;
  text-align: left;
  justify-content: center;
  align-items: center;
  padding: 30px 0px;
  margin: 20px 0px;
  border-radius: 30px;
  box-shadow: 0 2px 6px rgb(0 0 0 / 20%);
  width: 42vw;
}

.hw_resume-part2-box {
  display: flex;
  text-align: left;
  justify-content: center;
  padding: 4% 0px;
  margin: 20px 0px;
  border-radius: 30px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
  width: 42vw;
}

.hw_resume-part2-input {
  border-spacing: 2px 5px;
  width: 90%;
}

.hw_resume-part2-input>tr>td>input {
  width: 10vw;
  margin: 10px;
  border-radius: 5px;
  border: 2px solid #ccc;
  padding: 2px 3px;
}


.hw_graduation {
  display: inline-block;
  margin: 8px;
}


</style>
  
  