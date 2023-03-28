
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
                    <th><label for="user_name">이름</label></th>
                    <td>
                      <input type="hidden" :value="item.user_no">
                      {{ item.user_name }}
                    </td>
                    <th class="pl-15"><label for="user_phone">연락처</label></th>
                    <td>
                      <div class="graduation">
  
                        {{ item.user_phone }}
  
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <th><label for="user_email">이메일</label></th>
                    <td>
                      {{ item.user_email }}
                    </td>
                    <th class="text_resume"><label for="user_address">주소</label></th>
                    <td>
                      <div class="graduation">
  
                        {{ item.user_address }}
  
                      </div>
                    </td>
                    <th><label for="user_gender">성별</label></th>
                    <td>
                      {{ item.user_gender }}
                    </td>
                  </tr>
  
                </table>
              </div>
  
  
              <h3 style="text-align: left;">학력</h3>
              <div class="resume-part2-box">
                <table class="resume-part2-input">
                  <tr>
                    <th><label for="user_level">최종학력</label></th>
                    <td>
                      {{ item.user_level }}
                    </td>
                    <th><label for="user_finish">졸업여부</label></th>
                    <td>
                      {{ item.user_finish }}
                    </td>
                  </tr>
                  <tr>
                    <th style="padding-top:10px"><label for="user_major">전공</label></th>
                    <td>
  
                      <label for="user_major">
                        {{ item.user_major }}
                      </label>
                    </td>
                    <th style="padding-top:10px"><label for="user_fndate">졸업/졸업예정날짜</label></th>
                    <td>
  
                      <label for="user_fndate">
                        {{ item.user_fndate }}
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
                    <th><label for="user_com">회사명</label></th>
                    <td>
                      {{ item.user_com }}
                    </td>
                    <th><label for="user_position">직급</label></th>
                    <td>
                      {{ item.user_position }}
                    </td>
                  </tr>
                  <tr>
                    <th style="padding-top:10px"><label for="user_join">입사일</label></th>
                    <td>
  
                      <label for="user_join">
                        {{ item.user_join }}
                      </label>
                    </td>
                    <th style="padding-top:10px"><label for="user_leave">퇴사일</label></th>
                    <td>
  
                      <label for="user_leave">
                        {{ item.user_leave }}
                      </label>
                    </td>
                  </tr>
  
                </table>
              </div>
  
              <h3 style="text-align: left;">어학</h3>
              <div class="resume-part2-box">
                <table class="resume-part2-input">
  
                  <tr>
                    <th><label for="user_subject">과목</label></th>
                    <td>
                      {{ item.user_subject }}
                    </td>
                    <th><label for="user_score">점수</label></th>
                    <td>
                      {{ item.user_score }}
                    </td>
                  </tr>
                  <tr>
                    <th style="padding-top:10px"><label for="user_get">취득일</label></th>
                    <td>
                      <label for="user_get">
                        {{ item.user_get }}
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
                    <th class="text_resume"><label for="user_license">자격증명</label></th>
                    <td>
                      <label for="user_license">
                      {{ item.user_license }}
                      </label>
                    </td>
                    <th style="padding-top:10px"><label for="user_getlicense">취득일</label></th>
                    <td>
                      <label for="user_getlicense">
                      {{ item.user_getlicense }}
                    </label>
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
        user_no: "",
        user_name: "",
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
        user_no:"",
        list: [],
        
        //진행 상황
        status: '',
      }
    },
    methods: {
        ResumeComModify() {
        this.user_no = this.$route.params.user_no;
        this.axios.get('/ResumeComModify/' + this.user_no, { params: { "user_no": this.user_no } })
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
        console.log(this.list[0].user_no);
        this.axios.post("/updateStatus", {user_no: this.list[0].user_no, status: this.status, com_id: this.list[0].com_id} )
                  .then(() => {
                    this.$router.push('/ApplyStatus');
                  })
                  .catch(err => console.log(err));
      }
    },
    mounted() {
      this.ResumeComModify();
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
    