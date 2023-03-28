<!-- 재윤 - 채용 공고 상세 -->
<template>
  <section id="jy_section">
    <div id="jy_detail_wrap" v-for="item in list">
      <div id="jy_banner_wrap">
        <!-- <img src="@/img/c8d7cf7b-e0c7-459f-91a0-3862082908f7_duck2.jpg" alt="배너" style="width: 100%; height: 200px; margin-top: -25px;"> -->
        <div class="jy_bannerImg"></div>
        <div id="jy_company_logo"><img src="@/img/company_logo.png" alt="로고" class="jy_logoImg"></div>
        <div id="jy_company_name">
          <h3>{{ item.companyVO.com_name }}</h3>
        </div>
      </div>
      <article id="jy_article_top">
        <div id="jy_top">
          <div id="jy_top_bottom">
            <div id="jy_company_title">
              <div class="jy_title">
                <h2>{{ item.j_title }}</h2>
              </div>
            </div>
          </div>
        </div>

        <div id="jy_mid">
          <div id="jy_bottom_left">
            <h4>지원자격</h4>
            <div id="jy_qualify">
              <span id="jy_q_left">경력</span> <span id="jy_q_right">{{ item.j_career }}</span><br>
              <span id="jy_q_left">학력</span> <span id="jy_q_right">{{ item.j_graduation }}</span>
            </div><br><br>
            <h4>근무조건</h4>
            <div id="jy_qualify">
              <span id="jy_q_left">고용형태</span> <span id="jy_q_right">{{ item.j_type }}</span><br>
              <span id="jy_q_left">급여</span> <span id="jy_q_right">{{ item.j_salary }}</span><br>
              <span id="jy_q_left">근무지역</span> <span id="jy_q_right"> {{ item.com_address }} </span>
            </div>
          </div>
          <div id="jy_bottom_left">
            <h4>기업정보</h4>
            <div id="jy_qualify">
              <span id="jy_q_left">대표자</span> <span id="jy_q_right">{{ item.companyVO.com_ceo }}</span><br>
              <span id="jy_q_left">산업(업종)</span> <span id="jy_q_right">{{ item.companyVO.com_category }}</span><br>
              <span id="jy_q_left">주소</span> <span id="jy_q_right" style="text-align: right;">{{ item.j_address }}<br> {{ item.j_detail_address }}</span><br>
            </div><br><br>
            <h4>채용정보</h4>
            <div id="jy_qualify">
              <span id="jy_q_left">채용 분야</span> <span id="jy_q_right" v-for="item in j_department">{{ item
              }}&nbsp;&nbsp;</span><br>
              <span id="jy_q_left">마감 일자</span> <span id="jy_q_right">{{ j_end_date }}</span><br>
              <span id="jy_q_left">전형 절차</span> <span id="jy_q_right">서류 심사 > {{ item.j_schedule }} 최종 합격</span><br>
            </div><br><br>
            <h4>채용 담당자</h4>
            <div id="qualify">
              <span id="jy_q_left">담당자</span> <span id="jy_q_right">{{ item.companyVO.com_manager }}</span><br>
              <span id="jy_q_left">핸드폰 번호</span> <span id="jy_q_right">{{ item.companyVO.com_manager_phone }}</span><br>
              <span id="jy_q_left">이메일</span> <span id="jy_q_right">{{ item.j_email }}</span><br>
            </div>
          </div>
        </div>
        <hr>
      </article>

      <article id="jy_article_bottom">
        <div id="jy_section_bottom">
          <h3>상세 내용</h3>
          <pre>{{ item.j_content }}</pre>
          <div id="jy_posting_container">
            <img v-if="!this.imgUrl.includes('null')" :src="require(`@/img/${this.imgUrl}`)" :alt="item.j_img_fileName"
              id="jy_detailImg" />
          </div>
        </div>
      </article>
      <div id="jy_location_wrap">
        <span>기업 위치</span><br>
        <span>{{ item.j_address }} {{ item.j_detail_address }}</span>
        <div id="jy_kakao">
          (카카오맵api)
        </div>
      </div>

      <div id="jy_detail_button_wrap" style="margin-top: 20px; display: flex; justify-content: center; gap: 10px; margin-bottom: 20px;">
        <button v-if="ut_no == '1'" class="jy_btnApply" @click="apply"
          style="border: 0; width: 120px; height: 40px; line-height: 40px; background-color: orangered; border-radius: 2px; font-size: 20px; font-weight: 500; color: #efefef; letter-spacing: 1px;">입사지원</button>
        <button v-if="ut_no == '2'" class="jy_btnModify" @click="checkComId"
          style="display: inline-block; border: 0; width: 120px; height: 40px;line-height: 40px; background-color: orangered; border-radius: 2px; font-size: 20px;font-weight: 500; color: #efefef; letter-spacing: 1px;">수정/삭제</button>
        <router-link to="/4"
          style="display: inline-block; border: 0; width: 120px; height: 40px;line-height: 40px; background-color: orangered; border-radius: 2px; font-size: 20px;font-weight: 500; color: #efefef; letter-spacing: 1px;">목록</router-link>
      </div>
    </div>
  </section>
</template>

<script>

export default {

  name: 'App',
  data() {
    return {
      j_no: '',
      list: [],
      j_end_date: '',
      j_department: [],
      ut_no: sessionStorage.getItem("ut_no"),
      uuid: '',
      fileName: '',
      imgUrl: '',
    }

  },
  methods: {
    getJobDetail() {
      this.j_no = this.$route.params.j_no;
      this.axios.get('/jobPostingDetail/' + this.j_no, { params: { "j_no": this.j_no } })
        .then(res => {
          this.list = res.data;
          this.j_end_date = new Date(new Date(res.data[0].j_end_date) - (new Date(res.data[0].j_end_date).getTimezoneOffset() * 60000));
          this.j_end_date = new Date(this.j_end_date).toISOString().substring(0, 10);
          this.j_department = JSON.parse(res.data[0].j_department);
          this.uuid = res.data[0].j_img_uuid;
          this.fileName = res.data[0].j_img_fileName;
          this.imgUrl = this.uuid + "_" + this.fileName;
        })
        .catch(err => {
          console.log(err);
        });
    },
    apply() {
      this.axios.get("/checkApply", { params: { "user_id": sessionStorage.getItem("user_id"), "com_id": this.list[0].companyVO.com_id } })
        .then(res => {
          console.log(sessionStorage.getItem("user_id"));
          console.log(res.data);
          if (res.data == 1) {
            console.log("jno" + this.j_no),

            alert('해당 공고에 이미 지원하셨습니다.');
            return;
          } else {
            if (confirm('지원하시겠습니까?')) {
              this.axios.get("/apply", { params: { "user_id": sessionStorage.getItem("user_id") } })
                .then(res => {
                  console.log(res);
                  this.applyInsert(res.data, this.list[0].com_id);
                })
                .catch(() => {
                  console.log(err);
                  alert('등록된 이력서가 없습니다.');
                });
            }
          }
        })
        .catch(err => console.log(err));
    },
    applyInsert(vo, com_id) {
      this.axios.post("/applyInsert", {
        com_id: com_id,
        user_id: vo.user_id,
        user_address: vo.user_address,
        user_com: vo.user_com,
        user_email: vo.user_email,
        user_finish: vo.user_finish,
        user_fndate: vo.user_fndate,
        user_gender: vo.user_gender,
        user_get: vo.user_get,
        user_getlicense: vo.user_getlicense,
        user_phone: vo.user_phone,
        user_join: vo.user_join,
        user_leave: vo.user_leave,
        user_level: vo.user_level,
        user_license: vo.user_license,
        user_major: vo.user_major,
        user_name: vo.user_name,
        user_no: vo.user_no,
        user_position: vo.user_position,
        user_score: vo.user_score,
        user_subject: vo.user_subject,
        j_no: this.j_no
      })
        .then(res => {
          console.log(res);
          console.log("jno" + this.j_no),

          alert('성공적으로 지원되었습니다 !');
        })
        .catch(err => console.log(err));
    },
    checkComId() {
      if (sessionStorage.getItem("com_id") != this.list[0].companyVO.com_id) {
        alert('권한이 없습니다.');
        return;
      } else {
        this.$router.push({ name: 'jobPostingModify', params: { j_no: this.list[0].j_no } });
      }
    }
  },
  mounted() {
    this.getJobDetail();
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {
  margin: 0;
  padding: 0;
  list-style: none;
  font-family: 'Noto Sans KR', sans-serif;
}

#jy_info_wrap ul {
  display: flex;
}

#jy_info_wrap ul li {
  display: inline-block;
  margin-right: 15px;
}

#jy_menu li {
  display: inline;
  padding-left: 20px;
}

#jy_top {
  margin-bottom: 200px;
}

#jy_top .jy_title {
  padding-top: 100px;
  text-align: left;
  position: absolute;
  left: 250px;
}

#jy_company_name {
  position: absolute;
  top: 200px;
  left: 330px;
}

#jy_banner_wrap {
  position: relative;
  width: 100%;
  height: 200px;
}

#jy_banner_wrap .jy_bannerImg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 200px;
  background-color: orangered;
  opacity: 0.5;
  z-index: 9;
  margin-top: -25px;
}

#jy_company_logo {
  position: absolute;
  top: 100px;
  left: 150px;
  z-index: 998;
  border: 2px solid #fff;
  background-color: rgb(252, 187, 66);
}

#jy_top_bottom {
  display: flex;
}

#jy_bottom_left h4 {
  border-bottom: 1px solid orangered;
}

#jy_company_title .jy_title {
  color: #333;
}

#jy_mid {
  display: flex;
  justify-content: space-evenly;
  padding-top: 30px;
  padding-bottom: 20px;
}

#jy_bottom_left {
  float: right;
}

#jy_qualify {
  overflow: hidden;
}

#jy_q_left {
  float: left;
  color: gray;
  padding-right: 20px;
}

#jy_q_right {
  float: right;
  color: #333;
  font-weight: bold;
}

#jy_article_bottom {
  padding-top: 40px;
  text-align: center;
}

#jy_location_wrap {
  text-align: center;
}

#jy_detail_button_wrap {
  text-align: center;
}

.jy_logoImg {
  width: 150px;
  height: 150px;
}
</style>
