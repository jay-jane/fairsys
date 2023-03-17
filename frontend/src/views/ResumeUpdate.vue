<template>
  <section>
    <div class="resume" v-for="item in list">

      <div class="resume-main">
        <div class="resume-part-title">이력서 수정</div>
        <h3 style="text-align: left;">학력</h3>
        <div class="resume-part2-box">
          <table class="resume-part2-input">

            <tr>
              <th><label for="w_name">이름</label></th>
              <td>
                <input type="text" v-bind:value="item.w_name" @change="getName">
              </td>
              <th><label for="w_hp">연락처</label></th>
              <td>
                <input v-model="w_hp" required type="text">
              </td>
            </tr>
            <tr>
              <th><label for="w_email">이메일</label></th>
              <td>
                <input v-model="w_email" required type="text">
              </td>
              <th><label for="w_address">주소</label></th>
              <td>
                <input v-model="w_address" required type="text">
              </td>
            </tr>
            <tr>
              <th><label for="w_gender">성별</label></th>
              <select class="select-graduation" v-model="w_finish">
                <option value="남">남</option>
                <option value="여">여</option>
              </select>
            </tr>
          </table>
        </div>

        <h3 style="text-align: left;">학력</h3>
        <div class="resume-part2-box">
          <table class="resume-part2-input">

            <tr>
              <th><label for="w_level">최종학력</label></th>
              <td>
                <input v-model="w_level" required type="text">
              </td>
              <th class="pl-15"><label for="w_finish">졸업여부</label></th>
              <td>
                <div class="graduation">
                  <select class="select-graduation" v-model="w_finish">
                    <option value="졸업">졸업</option>
                    <option value="졸업예정">졸업예정</option>
                  </select>
                </div>
              </td>
            </tr>
            <tr>
              <th><label for="w_major">전공</label></th>
              <td>
                <input v-model="w_major" required type="text">
              </td>
              <th style="padding-top:10px"><label for="w_getlicense">졸업예정날짜</label></th>
              <td>

                <input v-model="w_getlicense" required type="date">

              </td>
            </tr>

          </table>
        </div>


        <!-- /// -->
        <h3 style="text-align: left;">경력</h3>
        <div class="resume-part2-box">
          <table class="resume-part2-input">
            <tr>
              <th><label for="w_com">회사명</label></th>
              <td>
                <input v-model="w_com" required type="text">
              </td>
              <th><label for="w_position">직급</label></th>
              <td>
                <input v-model="w_position" required type="text">
              </td>
            </tr>
            <tr>
              <th style="padding-top:10px"><label for="w_getlicense">입사일</label></th>
              <td>

                <input v-model="w_getlicense" required type="date">

              </td>

              <th style="padding-top:10px"><label for="w_getlicense">퇴사일</label></th>
              <td>

                <input v-model="w_getlicense" required type="date">

              </td>
            </tr>

          </table>
        </div>

        <h3 style="text-align: left;">어학</h3>
        <div class="resume-part2-box">
          <table class="resume-part2-input">

            <tr>
              <th><label for="w_subject">과목</label></th>
              <td>
                <input v-model="w_subject" required type="text">
              </td>
              <th class="pl-15"><label for="w_score">점수</label></th>
              <td>
                <input v-model="w_score" required type="text">
              </td>
            </tr>
            <tr>
              <th style="padding-top:10px"><label for="w_getlicense">취득일</label></th>
              <td>

                <input v-model="w_getlicense" required type="date">

              </td>

            </tr>


          </table>
        </div>


        <!-- /// -->
        <h3 style="text-align: left;">자격증</h3>
        <div class="resume-part2-box">
          <table class="resume-part2-input">
            <tr>
              <th class="pl-15"><label for="w_license">자격증명</label></th>
              <td>
                <input v-model="w_license" required type="text">
              </td>
              <th style="padding-top:10px"><label for="w_getlicense">취득일</label></th>
              <td>

                <input v-model="w_getlicense" required type="date">

              </td>
            </tr>
          </table>
        </div>

        <button type="button" value="수정완료" @click="updateForm">수정 완료</button>
        <button type="button" value="취소" @click="cancle">취소</button>

      </div>

    </div>


  </section>
</template>
    
<script>
export default {
  name: 'App',
  data() {
    return {
      w_no: 0,
      w_hp: "",
      w_email: "",
      w_address: "",
      w_gender: "",
      w_level: "",
      w_finish: "",
      w_major: "",
      w_fndate: "",
      w_com: "",
      w_position: "",
      w_join: "",
      w_leave: "",
      w_subject: "",
      w_score: "",
      w_get: "",
      w_license: "",
      w_getlicense: "",
      user_id: "",
      list: []
    };
  },
  methods: {
    cancle() {
      location.href = "/UserMyPage";
    },
    // updateForm() {
    //   this.axios.post('/ResumeUpdate',
    //     {
    //       w_no: this.$route.params.w_no,
    //       w_hp: this.w_hp,
    //       w_email: this.w_email,
    //       w_address: this.w_address,
    //       w_gender: this.w_gender,
    //       w_level: this.w_level,
    //       w_finish: this.w_finish,
    //       w_major: this.w_major,
    //       w_fndate: this.w_fndate,
    //       w_com: this.w_com,
    //       w_position: this.w_position,
    //       w_join: this.w_join,
    //       w_leave: this.w_leave,
    //       w_subject: this.w_subject,
    //       w_score: this.w_score,
    //       w_get: this.w_get,
    //       w_license: this.w_license,
    //       w_getlicense: this.w_getlicense,
    //       user_id: this.user_id
    //     }
    //   ).then(res => {
    //     console.log(res)
    //     this.w_no = this.$route.params.w_no;
    //     alert('수정이 완료되었습니다.!')
    //     this.$router.push('/ResumeModify/' + this.w_no);
    //     // this.$router.push('/ResumeModify?user_id=' + this.w_no);
    //   }).catch(err => {
    //     console.log(err);
    //   })
    // }, getName(e) {
    //   this.w_Name = e.target.value;
    // },
  }
};

</script>
<style>
.resume {
  width: 30vw;
  margin: 0 auto;
  display: grid;
  padding-top: 8vh;
  height: 100%;
}

.resume-wrapper {
  margin: 0 auto;
  width: 200px;
  font-size: 14px;
  top: 20vh;
  left: 20vw;
  position: fixed;
}


/* 본문 */
.resume-part-title {
  font-size: 40px;
  color: black;
  font-weight: bold;
}

.resume-part-box {
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

.resume-part2-box {
  display: flex;
  text-align: left;
  justify-content: center;
  padding: 4% 0px;
  margin: 20px 0px;
  border-radius: 30px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
  width: 42vw;
}

.resume-part2-input {
  border-spacing: 2px 5px;
  width: 90%;
}

.resume-part2-input>tr>td>input {
  width: 10vw;
  margin: 10px;
  border-radius: 5px;
  border: 2px solid #ccc;
  padding: 2px 3px;
}

.graduation {
  display: inline-block;
  margin: 8px;
}
</style>
  
  