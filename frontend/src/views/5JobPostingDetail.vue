<!-- 재윤 - 채용 공고 상세 -->
<template>
  <section id="section">
    <div id="detail_wrap" v-for="item in list">
      <div id="banner_wrap">
        <img src="https://picsum.photos/1000/100" alt="배너" width="100%" height="200px">
        <div class="bannerImg"></div>
        <div id="company_logo"><img src="https://picsum.photos/150/150" alt="로고" class="logoImg"></div>
        <div id="company_name">
          <h3>회사이름</h3>
        </div>
      </div>
      <article id="article_top">
        <div id="top">
          <div id="top_bottom">
            <div id="company_title">
              <div class="title">
                <h2>{{ item.j_title }}</h2>
                <h2>{{ $route.params.j_no }}</h2>
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
              <span id="q_left">근무지역</span> <span id="q_right"> 아직 안 만듦 </span>
            </div>
          </div>
        </div>
        <div id="mid">
          <div id="bottom_left">
            <h4>기업정보</h4>
            <div id="qualify">
              <span id="q_left">산업(업종)</span> <span id="q_right">company테이블 접근</span><br>
              <span id="q_left">설립년도</span> <span id="q_right">company테이블 접근</span><br>
              <span id="q_left">주소</span> <span id="q_right">company테이블 접근</span><br>
              <span id="q_left">홈페이지</span> <span id="q_right">company테이블 접근</span>
            </div>
          </div>
          <div id="bottom_left">
            <h4>채용정보</h4>
            <div id="qualify">
              <span id="q_left">채용 부서</span> <span id="q_right">{{ item.j_department }}</span><br>
              <span id="q_left">마감 일자</span> <span id="q_right">{{ item.j_end_date }}</span><br>
              <span id="q_left">전형 절차</span> <span id="q_right">{{ item.j_schedule }}</span><br>
            </div><br>
            <h4>채용 담당자</h4>
            <div id="qualify">
              <span id="q_left">담당자</span> <span id="q_right">company테이블 접근</span><br>
              <span id="q_left">핸드폰 번호</span> <span id="q_right">company테이블 접근</span><br>
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

      <div id="button_wrap" style="margin-top: 20px;">
        <a href="#">입사지원</a><br>
        <router-link :to="{name: 'jobPostingModify', params: {j_no: item.j_no}}">수정/삭제</router-link><br>
        <a href="99">목록</a>
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
      a: '',
    }

  },
  methods: {
    getJobDetail() {
      this.j_no = this.$route.params.j_no;
      this.axios.get('/jobPostingDetail/' + this.j_no, {params: {"j_no": this.j_no}})
        .then(res => {
          this.list = res.data;
        })
        .catch(err => {
          console.log(err);
        });
    },
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

#first_title {
  padding-top: 20px;
}

#article_top {
  padding-top: 120px;
}

#top_top {
  display: flex;
}

#company_name {
  position: absolute;
  top: 240px;
  left: 360px;
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
}

#company_logo {
  position: absolute;
  top: 66%;
  left: 10%;
  z-index: 999;
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
  color: blue;
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
