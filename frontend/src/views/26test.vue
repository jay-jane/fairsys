
<template>
  <section>
    <div class="resume">
      <div class="resume-wrapper">
        <ul class="step-progress">
          <li class="step-progress-item current">
            <router-link to="/23"> <strong>기본정보</strong></router-link>
          </li>
          <li class="step-progress-item">
            <router-link to="/24"> <strong>학력/경력</strong></router-link>
          </li>
          <li class="step-progress-item">
            <router-link to="/25"><strong>어학/자격증</strong></router-link>
          </li>
          <li class="step-progress-item">
            <router-link to="/26"><strong>???</strong></router-link>
          </li>
          <li class="step-progress-item">
            <router-link to="/27"><strong>???</strong></router-link>
          </li>
        </ul>
        <div class="resume-btn-box">
          <div>
            <div class="resume-save-btn" @click="submitForm">저장</div>
            <div class="resume-exit-btn" @click="exit">종료</div>
          </div>
        </div>
      </div>


      <div class="resume-main">
        <div class="resume-part-title">part1</div>
        <div class="resume-part-sub">기본정보를 입력해주세요.</div>
        <div class="resume-part-box">
          
          <table class="resume-part-table">
            <tr>
              <th><label for="w_name" >이름</label></th>
              <td><input v-model="w_name" required type="text" placeholder="이름을 입력하세요"></td>
            </tr>
            <tr>
              <th><label for="w_hp">연락처</label></th>
              <td>
                <input v-model="w_hp" required type="text" placeholder="전화번호를 입력하세요">
              </td>
            </tr>
            <tr>
              <th><label for="w_email">이메일</label></th>
              <td>
                <input v-model="w_email" required type="text" placeholder="이메일을 입력하세요">
              </td>
            </tr>
            <tr>
              <th><label for="w_address">주소</label></th>
              <td>
                <input v-model="w_address" required type="text" placeholder="주소를 입력하세요">
              </td>
            </tr>
            <tr>
              <th><label for="w_gender">성별</label></th>
              <td>
                <input v-model="w_gender" required type="radio" name="gender" value="남">남
                <input v-model="w_gender" required type="radio" name="gender" value="여">여
              </td>
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
            </div></td>
        </tr>
        <tr>
          <th><label for="w_major">전공</label></th>
          <td>
            <input v-model="w_major" required type="text">
          </td>
          <th style="padding-top:10px"><label for="w_fndate">졸업/졸업예정날짜</label></th>
          <td>
               
                <label for="w_fndate">
                <input v-model="w_fndate" required type="date" >
                </label>
              </td>
        </tr>
    
        <!-- <tr>
          <th style="padding-top:10px">입학</th>
          <td>
            <v-app class="date-pick">

            </v-app>
          </td>
          <th class="pl-15" style="padding-top:10px">졸업</th>
          <td>
            
          </td>
        </tr> -->
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
          <th style="padding-top:10px"><label for="w_join">입사일</label></th>
          <td>
                
                <label for="w_join">
                  <input v-model="w_join" required type="date" >
                </label>
              </td>
         <th style="padding-top:10px"><label for="w_leave">퇴사일</label></th>
          <td>
                
                <label for="w_leave">
                  <input v-model="w_leave" required type="date" >
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
            <input v-model="w_subject" required type="text">
          </td>
          <th class="pl-15"><label for="w_score">점수</label></th>
          <td>
            <input v-model="w_score" required type="text">
          </td>
        </tr>
        <tr>
          <th style="padding-top:10px"><label for="w_get">취득일</label></th>
          <td>
                
                <label for="w_get">
                  <input v-model="w_get" required type="date" >
                </label>
              </td>
         
        </tr>
    
        <!-- <tr>
          <th style="padding-top:10px">입학</th>
          <td>
            <v-app class="date-pick">

            </v-app>
          </td>
          <th class="pl-15" style="padding-top:10px">졸업</th>
          <td>
            
          </td>
        </tr> -->
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
                
            <input v-model="w_getlicense" required type="date" >
               
              </td>
        </tr>
      </table>
    </div>
    <button type="button" @click="submitForm" >가입하기</button>
      </div>

    </div>


  </section>
</template>
  
<script>
export default {
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
                  w_getlicense: ""
        };
    },methods: {
        btn_view() {
            location.href = "page1";
        },
async submitForm() {
              alert('작성이 완료되었습니다.!');

            // let data = await fetch("/test/registForm", {
            //     method: "post", 
            //     body: JSON.stringify({ user_id: "Xxxx" }),
            //     headers: { "Content-Type": "application/json", }
            //     })
            // let result = await data.text();
            // console.log(result)

            this.axios.post('/resume/26',
                {
                  w_no: this.w_no,
                  w_name: this.w_name,
                  w_hp: this.w_hp,
                  w_email: this.w_email,
                  w_address: this.w_address,
                  w_gender: this.w_gender,
                  w_level: this.w_level,
                  w_finish: this.w_finish,
                  w_major: this.w_major,
                  w_fndate: this.w_fndate,
                  w_com: this.w_com,
                  w_position: this.w_position,
                  w_join: this.w_join,
                  w_leave: this.w_leave,
                  w_subject: this.w_subject,
                  w_score: this.w_score,
                  w_get: this.w_get,
                  w_license: this.w_license,
                  w_getlicense: this.w_getlicense
                }
            ).then(res => {
                console.log(res)
                this.$router.push({path:'/'})
            }).catch(err => {
                console.log(err)
            })
        }
      }
    };
</script>
  
<style>

.resume {
  width: 30vw;
  margin: 0 auto;
  display: grid;
  padding-top: 8vh;
  height: 92vh;
}

  .resume-wrapper {
    margin: 0 auto;
    width: 200px;
    font-size: 14px;
    top: 20vh;
    left: 20vw;
    position: fixed;
  }


  .step-progress{
    padding-left: 50px;
  }


.step-progress {
  position: relative;
  list-style: none;
  padding-left: 45px;
}
.step-progress::before {
  display: inline-block;
  content: '';
  position: absolute;
  top: 0;
  left: 24px;
  width: 10px;
  height: 92%;
  border-left: 2px solid #ccc;
}
.step-progress-item {
  position: relative;
  counter-increment: list;
  padding-top: 10px;
  padding-left: 15px;
  cursor: pointer;
   padding-bottom: 30px;
}
.step-progress::before {
  display: inline-block;
  content: '';
  position: absolute;
  top: 0;
  left: 24px;
  width: 10px;
  height: 92%;
  border-left: 2px solid #ccc;
}
.step-progress-item::after {
  display: inline-block;
  position: absolute;
  top: 0;
  left: -38px;
  width: 32px;
  height: 32px;
  border: 2px solid #ccc;
  border-radius: 50%;
  background-color: #fff;
  text-align: center;
  line-height: 30px;
  content: attr(data-step);
}

.step-progress-item.current::after {
  background-size: 24px 24px;
  background-repeat: no-repeat;
  background-position: center;
  width: 32px;
  height: 32px;
  top: 0;
  left: -38px;
  font-size: 14px;
  text-align: center;
  background-color: black;
  color: white;

}

.step-progress strong {
  display: block;
}


.resume-save-btn {
  margin-top: 50px;
  width: 120px;
  text-align: center;
  line-height: 50px;
  height: 50px;
  background-color: black;
  border-radius: 30px;
  color: white;
  font-weight: 700;
  font-size: 16px;
  cursor: pointer;
  border: none;
  background-size: 300% 100%;
  border-radius: 50px;
}

.resume-exit-btn {
  margin-top: 20px;
  width: 120px;
  text-align: center;
  line-height: 50px;
  height: 50px;
  background-color: black;
  border-radius: 30px;
  color: white;
  font-weight: 700;
  font-size: 16px;
  cursor: pointer;
  border: none;
  border-radius: 50px;
}
.resume-btn-box {
  display: flex;
  justify-content: center;
}



/* 본문 */
.resume-part-title {
  font-size: 40px;
  color: skyblue;
  font-weight: bold;
}
.resume-part-sub {
  font-size: 18px;
  font-weight: 600;
  margin-top: 10px;
  margin-bottom: 50px;
}
.image-label {
  display: flex;
  width: 10vw;
  height: 20vh;
  cursor: pointer;
  border: 2px solid #ccc;
  overflow: hidden;
  justify-content: center;
  align-items: center;
  background-color: white;
}

.resume-part-box {
    display: flex;
    text-align: left;
    justify-content: center;
    align-items: center;
    /* background-color: rgba(230, 230, 230, 0.12); */
    padding: 30px 0px;
    margin: 20px 0px;
    border-radius: 30px;
    box-shadow: 0 2px 6px rgb(0 0 0 / 20%);
    width: 42vw;
}

.resume-part-table {
  padding-left: 40px;
  display: inline-block;
}
.resume-part-table > tr > td {
  padding-left: 20px;
}

.resume-part-table > tr > td > input {
  border-radius: 5px;
  border: 2px solid #ccc;
  padding: 2px 3px;
  margin: 1%;
  width: 13vw;
}
.resume-part-table > tr > td > textarea {
  border-radius: 5px;
  border: 2px solid #ccc;
  padding: 2px 3px;
  margin: 1%;
  width: 13vw;
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

.resume-part2-input > tr > td > input {
  width: 10vw;
  margin: 10px;
  border-radius: 5px;
  border: 2px solid #ccc;
  padding: 2px 3px;
}
.pl-15 {
  padding-left: 15px;
}
.hr-border-m-40 {
  width: 40vw;
  height: 1px;
  background-color: #c9c8c8f6;
  margin: 40px 0px;
}
.graduation {
  display: inline-block;
  margin: 8px;
}
.select-graduation {
  width: 10vw;
  border-radius: 5px;
  border: 2px solid #ccc;
  padding: 2px 3px;
}
.select-graduation:focus {
  outline: none;
  border: 2px solid rgb(85, 153, 255);
}
.select-graduation > option:hover {
  background-color: #ccc;
}

.resume-p2-career {
  margin: 10px;
  width: 93%;
  height: 50px;
  border-radius: 5px;
  border: 2px solid #ccc;
  resize: none;
  margin-top: 5%;
}
.resume-p2-exp {
  margin: 10px;
  width: 95%;
  height: 50px;
  border-radius: 5px;
  border: 2px solid #ccc;
  resize: none;
  margin-top: 5%;
}
.plus-btn-box {
  display: flex;
  align-items: center;
}
.plus-btn {
  display: inline-block;
  margin-left: 10px;
  font-size: 18px;
  width: 26px;
  height: 26px;
  border-radius: 26px;
  border: 2px solid #ccc;
  text-align: center;
  cursor: pointer;
  box-sizing: border-box;
  display: flex;
  align-items: center;
  justify-content: center;
}
.resume-p2-award {
  margin: 10px;
  width: 95%;
  height: 50px;
  border-radius: 5px;
  border: 2px solid #ccc;
  resize: none;
  margin-top: 10px;
}
.resume textarea:focus {
  outline: none;
  border: 2px solid rgb(85, 153, 255);
}
.resume-p5-project {
  margin: 10px;
  width: 95%;
  height: 50px;
  border-radius: 5px;
  border: 2px solid #ccc;
  resize: none;
}
.resume-p5-summary {
  margin: 10px;
  height: 30px;
  border-radius: 5px;
  border: 2px solid #ccc;
  resize: none;
  margin-top: 10px;
}

.tech-stack-box {
  display: inline-block;
  height: 10%;
  border-radius: 5px;
  padding: 2% 5%;
  margin-right: 5px;
  text-align: center;
  cursor: pointer;
  font-size: 14px;
}


</style>
  