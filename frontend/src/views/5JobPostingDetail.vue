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
              <span id="q_left">주소</span> <span id="q_right">{{ item.com_detail_address }}</span><br>
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
              <span id="q_left">담당자</span> <span id="q_right">{{ item.com_manager_name }}</span><br>
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
        기업 위치
        <div id="kakao">
          (카카오맵api)
        </div>
      </div>

      <div id="button_wrap" style="margin-top: 20px; display: flex; justify-content: center; gap: 10px; margin-bottom: 20px;">
        <button type="button" id="btnApply" @click="apply" style="border: 0; width: 120px; height: 40px;line-height: 40px; background-color: orangered; border-radius: 2px; font-size: 20px;font-weight: 500; color: #efefef; letter-spacing: 1px;">입사지원</button>
        <router-link :to="{ name: 'jobPostingModify', params: { j_no: item.j_no } }" id="btnModify" style="display: inline-block; border: 0; width: 120px; height: 40px;line-height: 40px; background-color: orangered; border-radius: 2px; font-size: 20px;font-weight: 500; color: #efefef; letter-spacing: 1px;">수정/삭제</router-link>
        <router-link to="/4" style="display: inline-block; border: 0; width: 120px; height: 40px;line-height: 40px; background-color: orangered; border-radius: 2px; font-size: 20px;font-weight: 500; color: #efefef; letter-spacing: 1px;">목록</router-link>
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
    }

  },
  methods: {
    getJobDetail() {
      console.log(this.com_id)
      this.j_no = this.$route.params.j_no;
      this.axios.get('/jobPostingDetail/' + this.j_no, { params: { "j_no": this.j_no } })
        .then(res => {
          console.log(res.data);
          this.list = res.data;
          this.j_end_date = res.data[0].j_end_date.substring(0, 10);
          this.j_department = JSON.parse(res.data[0].j_department);
        })
        .catch(err => {
          console.log(err);
        });
    },
    apply() {
      console.log(this.list[0].com_id);
      console.log(sessionStorage.getItem("user_id"));
      if (confirm('지원하시겠습니까?')) {
        this.axios.get("/apply", { params: { "user_id": sessionStorage.getItem("user_id") } })
          .then(res => {
            console.log(res);
            console.log(1);
            console.log(res.data);
            this.applyInsert(res.data, this.list[0].com_id);
          })
          .catch(() => {
            console.log(err);
            alert('등록된 이력서가 없습니다.');
          });
      }
    },
    applyInsert(vo, com_id) {
      console.log(vo);
      console.log(this.list[0].com_id);
      this.axios.post("/applyInsert", {
        com_id: com_id,
        user_id: vo.user_id,
        w_address: vo.w_address,
        w_com: vo.w_com,
        w_email: vo.w_email,
        w_finish: vo.w_finish,
        w_fndate: vo.w_fndate,
        w_gender: vo.w_gender,
        w_get: vo.w_get,
        w_getlicense: vo.w_getlicense,
        w_hp: vo.w_hp,
        w_join: vo.w_join,
        w_leave: vo.w_leave,
        w_level: vo.w_level,
        w_license: vo.w_license,
        w_major: vo.w_major,
        w_name: vo.w_name,
        w_no: vo.w_no,
        w_position: vo.w_position,
        w_score: vo.w_score,
        w_subject: vo.w_subject,
      })
        .then(res => {
          console.log(2);
          console.log(res);
          alert('성공적으로 등록되었습니다 !');
        })
        .catch(err => console.log(err));
    },
    displayBtn() {
      if(sessionStorage.getItem("user_id") == '' || sessionStorage.getItem("user_id") == null) {
        console.log(document.getElementById("btnApply"));
      }
    },
  },
  mounted() {
    this.getJobDetail();
    this.displayBtn();
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
}
</style>
