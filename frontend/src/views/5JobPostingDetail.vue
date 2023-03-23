<!-- 재윤 - 채용 공고 상세 -->
<template>
  <section id="section">
    <div id="detail_wrap" v-for="item in list">
      <div id="banner_wrap">
        <img src="https://picsum.photos/1000/100" alt="배너" width="100%" height="200px">
        <div class="bannerImg"></div>
        <div id="company_logo"><img src="https://picsum.photos/150/150" alt="로고" class="logoImg"></div>
        <div id="company_name">
          <h3>{{ item.com_name }}</h3>
        </div>
      </div>
      <article id="article_top">
        <div id="top">
          <div id="top_bottom">
            <div id="company_title">
              <div class="title">
                <h2>{{ item.j_title }}</h2>
              </div>
            </div>
          </div>
        </div>

        <div id="mid">
          <div id="bottom_left">
            <h4>지원자격</h4>
            <div id="qualify">
              <span id="q_left">경력</span> <span id="q_right">{{ item.j_career }}</span><br>
              <span id="q_left">학력</span> <span id="q_right">{{ item.j_graduation }}</span>
            </div>
          </div>
          <div id="bottom_left">
            <h4>근무조건</h4>
            <div id="qualify">
              <span id="q_left">고용형태</span> <span id="q_right">{{ item.j_type }}</span><br>
              <span id="q_left">급여</span> <span id="q_right">{{ item.j_salary }}</span><br>
              <span id="q_left">근무지역</span> <span id="q_right"> {{ item.com_address }} </span>
            </div>
          </div>
        </div>
        <div id="mid">
          <div id="bottom_left">
            <h4>기업정보</h4>
            <div id="qualify">
              <span id="q_left">산업(업종)</span> <span id="q_right">company테이블 접근</span><br>
              <span id="q_left">설립년도</span> <span id="q_right">company테이블 접근</span><br>
              <span id="q_left">주소</span> <span id="q_right" style="text-align: right;">{{ item.j_address }}<br> {{ item.j_detail_address }}</span><br>
              <span id="q_left">홈페이지</span> <span id="q_right">company테이블 접근</span>
            </div>
          </div>
          <div id="bottom_left">
            <h4>채용정보</h4>
            <div id="qualify">
              <span id="q_left">채용 분야</span> <span id="q_right" v-for="item in j_department">{{ item
              }}&nbsp;&nbsp;</span><br>
              <span id="q_left">마감 일자</span> <span id="q_right">{{ j_end_date }}</span><br>
              <span id="q_left">전형 절차</span> <span id="q_right">서류 심사 > {{ item.j_schedule }} 최종 합격</span><br>
            </div><br>
            <h4>채용 담당자</h4>
            <div id="qualify">
              <span id="q_left">담당자</span> <span id="q_right">{{ item.com_manager}}</span><br>
              <span id="q_left">핸드폰 번호</span> <span id="q_right">{{ item.com_manager_phone }}</span><br>
              <span id="q_left">이메일</span> <span id="q_right">{{ item.j_email }}</span><br>
            </div>
          </div>
        </div>
        <hr>
      </article>

      <article id="article_bottom">
        <div id="section_bottom">
          <h3>상세 내용</h3>
          <p>{{ item.j_content }}</p>
        </div>
      </article>
      <div id="location_wrap">
        <span>기업 위치</span><br>
        <span>{{ item.j_address }} {{ item.j_detail_address }}</span>
        <div id="kakao">
          (카카오맵api)
        </div>
      </div>

      <div id="button_wrap"
        style="margin-top: 20px; display: flex; justify-content: center; gap: 10px; margin-bottom: 20px;">
        <button type="button" v-if="ut_no == '1'" class="btnApply" @click="apply"
          style="border: 0; width: 120px; height: 40px;line-height: 40px; background-color: orangered; border-radius: 2px; font-size: 20px;font-weight: 500; color: #efefef; letter-spacing: 1px;">입사지원</button>
        <button v-if="ut_no == '2'" class="btnModify" @click="checkComId"
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
        })
        .catch(err => {
          console.log(err);
        });
    },
    apply() {
      this.axios.get("/checkApply", { params: { "user_id": sessionStorage.getItem("user_id"), "com_id": this.list[0].com_id } })
        .then(res => {
          console.log(res.data);
          if (res.data == 1) {
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
      })
        .then(res => {
          console.log(res);
          alert('성공적으로 지원되었습니다 !');
        })
        .catch(err => console.log(err));
    },
    displayBtn() {
      if (sessionStorage.getItem("ut_no") != '1') {
        console.log(1234);
        console.log(this.$refs.btnApply);
      }
    },
    checkComId() {
      if(sessionStorage.getItem("com_id") != this.list[0].com_id) {
        alert('권한이 없습니다.');
        return;
      } else {
        this.$router.push({name: 'jobPostingModify', params: { j_no: this.list[0].j_no } });
        // :to="{ name: 'jobPostingModify', params: { j_no: item.j_no } }
      }
    }
  },
  mounted() {
    this.getJobDetail();
  },
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  list-style: none;
  text-align: center;
}

body {
  font-family: Arial, sans-serif;
}

#info_wrap ul {
  display: flex;
}

#info_wrap ul li {
  display: inline-block;
  margin-right: 15px;
}

#menu li {
  display: inline;
  padding-left: 20px;
}

#top .title {
  padding-top: 50px;
  text-align: left;
  position: absolute;
  left: 300px;

}

#article_top {
  padding-top: 120px;
}

#top_bottom {
  margin-top: 80px;
}

#company_name {
  position: absolute;
  top: 200px;
  left: 330px;
}

#banner_wrap {
  position: relative;
}

#banner_wrap .bannerImg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 200px;
  background-color: black;
  opacity: 0.5;
  z-index: 9;
  margin-top: -25px;
  margin-bottom: 200px;
}

#company_logo {
  position: absolute;
  top: 100px;
  left: 10%;
  z-index: 998;
  border: 2px solid #fff;
}

#top_bottom {
  display: flex;
}

#company_title .title {
  color: #333;
}

#mid {
  display: flex;
  justify-content: space-around;
  padding-top: 30px;
}

#qualify {
  overflow: hidden;
}

#q_left {
  float: left;
  color: gray;
  padding-right: 20px;
}

#q_right {
  float: right;
  color: orangered;
}

#article_bottom {
  padding-top: 40px;
}

/* 푸터 스타일링 */
footer {
  background-color: #f2f2f2;
  padding: 10px;
  font-size: 14px;
}</style>
