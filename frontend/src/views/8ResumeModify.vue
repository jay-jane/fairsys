
<template>
  <section id="section">
    <div class="resume">



      <div class="resume-main">
        <div class="resume-part-title">개인이력서</div>
        <div class="resume-status-update" style="float: right;">
          <select id="" @change="getStatusValue">
            <option value="대기">대기</option>
            <option value="진행중">진행중</option>
            <option value="합격">합격</option>
            <option value="불합격">불합격</option>
          </select>
          <button type="button" @click="updateStatus">적용</button>
        </div>
        <div v-for="(item, index) in list">
          <div >
            <h3 style="text-align: left;">개인정보</h3>
            <div class="resume-part2-box">
              <table class="resume-part2-input">
                
                <tr>
                  <th><label for="w_level">이름</label></th>
                  <td>
                    <input type="hidden" :value="item.user_no">
                    {{ item.w_name }}
                  </td>
                  <th class="pl-15"><label for="w_finish">연락처</label></th>
                  <td>
                    <div class="graduation">

                      {{ item.w_hp }}

                    </div>
                  </td>
                </tr>
                <tr>
                  <th><label for="w_level">이메일</label></th>
                  <td>
                    {{ item.w_email }}
                  </td>
                  <th class="text_resume"><label for="w_finish">주소</label></th>
                  <td>
                    <div class="graduation">

                      {{ item.w_address }}

                    </div>
                  </td>
                  <th><label for="w_level">성별</label></th>
                  <td>
                    {{ item.w_gender }}
                  </td>
                </tr>

              </table>
            </div>


            <h3 style="text-align: left;">학력</h3>
            <div class="resume-part2-box">
              <table class="resume-part2-input">
                <tr>
                  <th><label for="w_com">최종학력</label></th>
                  <td>
                    {{ item.w_level }}
                  </td>
                  <th><label for="w_position">졸업여부</label></th>
                  <td>
                    {{ item.w_finish }}
                  </td>
                </tr>
                <tr>
                  <th style="padding-top:10px"><label for="w_join">전공</label></th>
                  <td>

                    <label for="w_join">
                      {{ item.w_major }}
                    </label>
                  </td>
                  <th style="padding-top:10px"><label for="w_leave">졸업/졸업예정날짜</label></th>
                  <td>

                    <label for="w_leave">
                      {{ item.w_fndate }}
                    </label>
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
                    {{ item.w_com }}
                  </td>
                  <th><label for="w_position">직급</label></th>
                  <td>
                    {{ item.w_position }}
                  </td>
                </tr>
                <tr>
                  <th style="padding-top:10px"><label for="w_join">입사일</label></th>
                  <td>

                    <label for="w_join">
                      {{ item.w_join }}
                    </label>
                  </td>
                  <th style="padding-top:10px"><label for="w_leave">퇴사일</label></th>
                  <td>

                    <label for="w_leave">
                      {{ item.w_leave }}
                    </label>
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
                    {{ item.w_subject }}
                  </td>
                  <th class="text_resume"><label for="w_score">점수</label></th>
                  <td>
                    {{ item.w_score }}
                  </td>
                </tr>
                <tr>
                  <th style="padding-top:10px"><label for="w_get">취득일</label></th>
                  <td>
                    <label for="w_get">
                      {{ item.w_get }}
                    </label>
                  </td>
                </tr>

              </table>
            </div>

            <!-- /// -->
            <h3 style="text-align: left;">자격증</h3>
            <div class="resume-part2-box">
              <table class="resume-part2-input">
                <tr>
                  <th class="text_resume"><label for="w_license">자격증명</label></th>
                  <td>
                    {{ item.w_license }}
                  </td>
                  <th style="padding-top:10px"><label for="w_getlicense">취득일</label></th>
                  <td>
                    {{ item.w_getlicense }}
                  </td>
                </tr>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>

    


  </section>
</template>
  
<script>
export default {
  name: 'App',
  data() {
    return {
      w_no: "",
      w_name: "",
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
      com_id:"",
      list: [],
      
      //진행 상황
      status: '',
    }
  },
  methods: {
    ResumeModify() {
      this.w_no = this.$route.params.w_no;
      this.axios.get('/ResumeModify/' + this.w_no, { params: { "w_no": this.w_no } })
        .then(res => {
          this.list = res.data;
          console.log(this.list)
        })
        .catch(err => {
          console.log(err);
        });
    },
    getStatusValue(e) {
      this.status = e.target.value; 
    },
    updateStatus() {
      console.log(this.status);
      console.log(this.list[0].com_id);
      console.log(this.list[0].user_no);
      console.log(this.list[0].w_no);
      this.axios.post("/updateStatus", {user_no: this.list[0].user_no, status: this.status, com_id: this.list[0].com_id} )
                .then(() => {
                  this.$router.push('/ApplyStatus');
                })
                .catch(err => console.log(err));
    }
  },
  mounted() {
    this.ResumeModify();
  },
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
  