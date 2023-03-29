<!-- 재윤 - 채용 공고 목록 -->
<template>
  <!-- <section id="jy_side_wrap">
    <div class="jy_admin_nav">
      <ul>
        <li class="jy_sub_menu_toggle">
          <a class="jy_sub menu select">채용공고</a>
          <ul class="jy_sub_menu" style="display: block;">
            <li><router-link to="/4">공고목록</router-link></li>
            <li><a href="#" @click.prevent="addPosting">채용공고 등록</a></li>
            <li><router-link to="/ApplyStatus">지원자 목록</router-link></li>
          </ul>
        </li>

        <li class="jy_sub_menu_toggle">
          <a>기업 정보</a>
          <ul class="jy_sub_menu">
            <li><router-link to="/9-1">내 정보 수정</router-link></li>
            <li><a href="#" @click="companyDelete" style="color: orangered;">회원탈퇴</a></li>
          </ul>
        </li>
      </ul>
    </div>
          </section> -->
  <section id="jy_salary_wrap">
    <h3 class="jy_title">채용 정보</h3>
    <hr>
    <div id="jy_content_wrap">
      <div id="jy_swiper_wrap" style="margin-top: 20px;">
      </div>
      <div id="jy_search_wrap">
        <div id="jy_search_name" class="jy_option_box">
          <strong class="jy_option_title">
            <label for="company_name" style="line-height: 40px;">제목</label>
          </strong>
          <input type="text" class="input_com" v-model="companyName" @change="getComName"
            placeholder="(주)와 같은 특수문자를 제외하고 입력해 주세요">
          <span @click="resetComName" style="font-size: 8px; font-weight: normal; cursor: pointer; font-weight: bold; color: grey;">
            <img src="@/img/return-icon.jpg" alt="r"> 초기화
          </span>
        </div>
        <div id="jy_search_salary" class="jy_option_box" style="overflow: hidden;">
          <strong class="jy_option_title" style="float: left;">지역<br><br>
            <span @click="resetCategory" style="font-size: 8px; font-weight: normal; cursor: pointer; font-weight: bold; color: grey;">
              <img src="@/img/return-icon.jpg" alt="r"> 초기화
            </span>
          </strong>
          <ul class="jy_category-list-left" style="float: left;">
            <li><a href="#" class="a_category1" @click.prevent="getCategory_List" name="1">서울</a></li>
            <li><a href="#" class="a_category2" @click.prevent="getCategory_List" name="2">경기</a></li>
            <li><a href="#" class="a_category3" @click.prevent="getCategory_List" name="3">인천</a></li>
          </ul>
          <ul class="jy_category-list-right" style="float: left;">
            <li v-for="r in seoul"><a href="#" class="서울" v-if="mid_category1" @click.prevent="getCategory">&gt; {{ r }}</a></li>
            <li v-for="r in gyeonggi"><a href="#" class="서울" v-if="mid_category2" @click.prevent="getCategory">&gt; {{ r }}</a></li>
            <li v-for="r in incheon"><a href="#" class="서울" v-if="mid_category3" @click.prevent="getCategory">&gt; {{ r }}</a></li>
          </ul>
        </div>
        <div id="jy_search_type" class="jy_option_box">
          <strong class="jy_option_title" style="">근무형태</strong>
          <div id="jy_job_type" style="display: inline-block;">
            <input @click="getCareer" type="radio" class="input_jobType" name="job_type" value="신입">신입
            <input @click="getCareer" type="radio" class="input_jobType" style="margin-left: 5px;" name="job_type"
            value="경력">경력
            <input @click="getCareer" type="radio" class="input_jobType" style="margin-left: 5px;" name="job_type"
            value="경력무관">경력무관
          </div>
          <span @click="resetCareer" style="font-size: 8px; font-weight: normal; cursor: pointer; margin-left: 40px; font-weight: bold; color: grey;">
            <img src="@/img/return-icon.jpg" alt="r"> 초기화
          </span>
        </div>
        <div id="jy_search_btn">
          검색 키워드 : 
          <span class="jy_search_category" v-if="com_name != ''">{{ com_name }}&nbsp;&nbsp;</span>
          <span class="jy_search_category" v-if="category != ''">/&nbsp;&nbsp;{{ category }}&nbsp;&nbsp;</span>
          <span class="jy_search_category" v-if="career != ''">/&nbsp;&nbsp;{{ career }}</span>
          <p class="jy_search_total">검색 결과 : <strong class="jy_num_total" style="color: orangered;">{{ total }}</strong> 건
          </p>
          <button type="button" class="jy_search_btn" @click="searchItem">검색하기</button>
        </div>
      </div>
      <div id="posting_btn" style="min-width: 800px;">
        <button type="button" v-if="ut_no == '2'" @click="addPosting"
          style="border: 0; background-color: orangered; float: right; width: 100px; height: 40px; color: white; margin: 50px 0 0 0; cursor: pointer;">
          공고 등록
        </button>
      </div>
      <div id="jy_salary_list_wrap">
        <div class="jy_total_sort">
          <p>총 <strong class="jy_num_total" style="color: orangered; font-size: 20px;">{{ total }}</strong>건</p>
          <!-- 출력 카테고리 -->
          <select v-model="amount" class="jy_view" @change="loglist_view">
            <option value="5">5개씩 보기</option>
            <option value="10">10개씩 보기</option>
            <option value="30">30개씩 보기</option>
          </select>

        </div>
        <div id="jy_salary_list_total">
          <div v-if="list.length == 0" style="text-align: center; margin-top: 30px;">
            <span style="text-align: center;">결과가 없습니다.</span>
          </div>
          <ul>
            <div v-for="item in list">
              <li>
                <a href="#" class="jy_logo" @click.prevent="getDetail(item.j_no)"><img src="@/img/jobposting_logo.png" alt="로고"></a>
                <div class="jy_company_info">
                  <strong class="jy_title">
                    <span style="cursor: pointer;" @click.prevent="getDetail(item.j_no)">{{ item.com_name }}</span>
                  </strong>
                  <a href="#" class="jy_mark" @click="(e) => { e.preventDefault(); }" style="cursor: default;">채용중</a>
                  <div class="jy_recruit_title">
                    <span style="cursor: pointer;" @click.prevent="getDetail(item.j_no)">{{ item.j_title }}</span>
                  </div>
                  <div id="jy_info_wrap" style="cursor: default;">
                    <dl class="jy_info_item">
                      <dt>{{ item.j_career }}</dt>
                    </dl>
                    <dl class="jy_info_item">
                      <dt>{{ item.j_graduation }}</dt>
                    </dl>
                    <dl class="jy_info_item">
                      <dt>{{ item.j_address.substr(0, 2) }}</dt>
                    </dl>
                  </div>
                </div>
              </li>
            </div>
          </ul>
        </div>
      </div>
    </div>

    <!-- 페이지네이션 -->
    <div class="page">
      <ul>
        <li>
          <!-- 맨앞으로 가기 -->
          <router-link :to="{ path: '/4/?page=1&amount=' + amount }" @click="goFirstPage" style="padding: 10px">
            <i class="fa fa-angle-double-left" aria-hidden="true"> &lt;&lt; </i>
          </router-link>
        </li>

        <!-- 앞으로 가기 -->
        <li style="margin-right:5px;">
          <router-link :to="{ path: '/4/?page=' + page + '&amount=' + amount }" @click="goBeforePage"
            style="padding: 10px">
            <i class="fa fa-angle-left" aria-hidden="true"> &lt; </i>
          </router-link>
        </li>

        <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
        <div v-for="(item, index) in pageList" :key="index" class="page_btn">
          <li v-bind:class="{ 'on': item === page }">
            <router-link :to="{ path: '/4/?page=' + page + '&amount=' + amount }" style="padding: 10px"
              @click="thisPage($event.target)">
              {{ item }}
            </router-link>
          </li>
        </div>

        <!-- 뒤로 가기 -->
        <li style="margin-left:5px;">
          <router-link :to="{ path: '/4/?page=' + page + '&amount=' + amount }" @click="goNextPage" style="padding: 10px">
            <i class="fa fa-angle-right" aria-hidden="true"> &gt; </i>
          </router-link>
        </li>

        <!-- 맨뒤로 가기 -->
        <li>
          <router-link :to="{ path: '/4/?page=' + realEnd + '&amount=' + amount }" @click="goLastPage"
            style="padding: 10px">
            <i class="fa fa-angle-double-right" aria-hidden="true"> &gt;&gt; </i>
          </router-link>
        </li>
      </ul>
    </div>

  </section>
</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      com_name: '',
      region: '',
      career: '',
      category: '',
      category_region: '',
      category_type: '',
      mid_category1: false,
      mid_category2: false,
      mid_category3: false,
      ut_no: sessionStorage.getItem("ut_no"),

      //공용
      pages: '',   //pageVO
      pageList: '',  //pageVO.pageList 배열값
      detailNum: '',

      //페이지이동에 필요한 초기값들
      page: 1,
      amount: 10,
      prev: '',
      pageStart: '',
      pageEnd: '',
      realEnd: '',

      //검색
      searchTitle: '',
      searchRegion: '',
      searchCareer: '',
      companyName: '',
      regionName: '',
      careerName: '',

      total: '',

      //게시글 리스트
      list: [],

      seoul: ["서울 전체", "강남구", "서초구", "반포구", "마포구"],
      gyeonggi: ["경기 전체", "수원시", "성남시", "안산시", "화성시"],
      incheon: ["인천 전체", "연수구", "서구"],
    }
  },
  watch: {
    'amount': function () {
      this.get();
    },
  },
  methods: {
    getRegion: function (e) {
      this.region = e.target.value;
    },
    getCareer: function (e) {
      this.career = e.target.value;
    },
    getComName: function () {
      this.com_name = document.getElementsByClassName("input_com")[0].value;
    },
    getCategory_List: function (e) {
      e.preventDefault();
      if (e.target.tagName != 'A') return;
      if (e.target.name == 1) {
        this.mid_category1 = true;
        this.mid_category2 = false;
        this.mid_category3 = false;
        document.getElementsByClassName("a_category1")[0].classList.add("font_orange");
        document.getElementsByClassName("a_category2")[0].classList.remove("font_orange");
        document.getElementsByClassName("a_category3")[0].classList.remove("font_orange");
      } else if (e.target.name == 2) {
        this.mid_category1 = false;
        this.mid_category2 = true;
        this.mid_category3 = false;
        document.getElementsByClassName("a_category1")[0].classList.remove("font_orange");
        document.getElementsByClassName("a_category2")[0].classList.add("font_orange");
        document.getElementsByClassName("a_category3")[0].classList.remove("font_orange");
      } else if (e.target.name == 3) {
        this.mid_category1 = false;
        this.mid_category2 = false;
        this.mid_category3 = true;
        document.getElementsByClassName("a_category1")[0].classList.remove("font_orange");
        document.getElementsByClassName("a_category2")[0].classList.remove("font_orange");
        document.getElementsByClassName("a_category3")[0].classList.add("font_orange");
      }
    },
    getCategory: function (e) {
      console.log("클래스(도/시) : " + e.target.className);
      console.log("클릭값(시/구) : " + e.target.innerHTML.substr(5));
      this.category = e.target.className + " " + e.target.innerHTML.substr(5);
      

    },
    getDetail(j_no) {
      this.$router.push({
        path: '/jobPostingDetail',
        name: 'jobPostingDetail',
        params: { 'j_no': j_no }
      })
    },
    async get() {
      //화면에 리스트 출력을 위해 필요한 내용 전달하기
      let response = await this.axios.get("/4/?amount=" + this.amount + "&page=" + this.page + "&searchTitle=" + this.searchTitle + "&searchRegion=" + this.searchRegion + "&searchCareer=" + this.searchCareer);
      //필요한 공용 데이터를 담기
      this.list = response.data.jobList;
      this.pages = response.data.pageVO;
      this.pageList = this.pages.pageList;
      this.total = response.data.pageVO.total;
      //페이지이동에 필요한 데이터 담기
      this.page = this.pages.page;
      this.searchTitle = this.pages.cri.searchTitle;
      this.searchCareer = this.pages.cri.searchCareer;
      this.searchRegion = this.pages.cri.searchRegion;
      this.prev = this.pages.prev;
      this.pageStart = this.pages.pageStart;
      this.pageEnd = this.pages.pageEnd;
      this.realEnd = this.pages.realEnd;
    },
    loglist_view() {
      this.amount = this.amount;
    },
    goFirstPage() {
      this.page = 1;
      this.get();
    },
    goBeforePage() {
      if (this.page > 1) {
        this.page = this.page - 1;
        this.get();
      } else {
        alert("첫번째 페이지입니다.");
      }
    },
    thisPage(target) {
      this.page = target.innerHTML;
      this.get();
    },
    goNextPage() {
      if (this.page < this.realEnd) {
        this.page = this.page + 1;
        this.get();
      } else {
        alert("마지막 페이지입니다.");
      }
    },
    goLastPage() {
      this.page = this.realEnd;
      this.get();
    },
    searchItem() {
      this.searchTitle = this.companyName;
      this.searchCareer = this.career;
      this.searchRegion = this.category;
      this.get();
    },
    addPosting() {
      this.axios.get("/checkPosting", { params: { "com_id": sessionStorage.getItem("com_id") } })
        .then(res => {
          if (res.data == 1) {
            alert('공고는 최대 1개 까지만 등록하실 수 있습니다.');
            return;
          } else {
            this.$router.push({
              path: '/registJobPosting',
              name: 'jobPostingRegist',
              params: { 'com_id': sessionStorage.getItem("com_id") },
              headers: {
                'content-type': 'application/json',
                'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
              },
            })
          }
        })
        .catch(err => console.log(err));
    },
    companyDelete() {
      if (confirm('정말로 탈퇴하시겠습니까?')) {
        this.axios.get('/Company/deleteForm',
          {
            params: { com_id: sessionStorage.getItem("com_id") },
            headers: {
              'content-type': 'application/json',
              'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
            }
          }
        ).then(res => {
          alert('탈퇴 완료 되었습니다.');
          sessionStorage.clear();
          this.$store.commit("setLogInOut", "로그인");
          this.$router.push({ path: '/' });
        })
      }
    },
    resetComName() {
      this.com_name = '';
      this.companyName = '';
      document.getElementsByClassName("input_com")[0].value = '';
    },
    resetCategory() {
      this.category = '';
      this.mid_category1 = false;
      this.mid_category2 = false;
      this.mid_category3 = false;
      document.getElementsByClassName("a_category1")[0].classList.remove("font_orange");
      document.getElementsByClassName("a_category2")[0].classList.remove("font_orange");
      document.getElementsByClassName("a_category3")[0].classList.remove("font_orange");
    },
    resetCareer() {
      this.career = '';
      let list = document.getElementsByClassName("input_jobType");
      list[0].checked = false;
      list[1].checked = false;
      list[2].checked = false;
    },
  },
  mounted() {
    this.get();
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
  font-family: 'Noto Sans KR', sans-serif;
}

/* section */
#jy_salary_wrap {
  max-width: 1080px;
  margin: 0 auto;
  padding: 20px;
}

.jy_title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

#jy_search_wrap {
  border: 1px solid #ebebeb;
  border-top: 2px solid #5c667b;
  min-width: 800px;
}

#jy_search_wrap .jy_option_box {
  padding: 0 18px 0 112px;
  font-size: 13px;
}

#jy_search_wrap .jy_option_title {
  padding-top: 2px;
  width: 85px;
  float: left;
}

#jy_search_wrap #jy_search_name {
  background-color: #f9f9f9;
  border-bottom: 1px solid #ebebeb;
  padding-top: 22px;
  padding-bottom: 22px;
  position: relative;
}

#jy_search_wrap #jy_search_salary {
  background-color: #f9f9f9;
  padding-top: 54px;
  padding-bottom: 22px;
  position: relative;
}

#jy_search_wrap #jy_search_type {
  background-color: #f9f9f9;
  border-top: 1px solid #ebebeb;
  padding-top: 22px;
  padding-bottom: 22px;
  position: relative;
}

#jy_search_wrap #jy_search_btn {
  border: 1px solid #ccc;
  padding: 15px 163px 16px 18px;
  position: relative;
  letter-spacing: -1px;
  font-size: 14px;
}

#jy_search_wrap #jy_search_btn button {
  overflow: hidden;
  position: absolute;
  top: -1px;
  right: -1px;
  bottom: -1px;
  width: 145px;
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  background-color: orangered;
  border: 0;
  cursor: pointer;
  letter-spacing: -1px;
}

#jy_salary_list_wrap {
  padding: 57px 0 65px;
}

#jy_salary_list_wrap .jy_total_sort {
  width: 100%;
  height: 42px;
  border-bottom: 2px solid #444;
}

#jy_salary_list_wrap #jy_salary_list_total {
  overflow: hidden;
}

#jy_salary_list_wrap #jy_salary_list_total ul li {
  overflow: hidden;
  padding: 8px 19px 6px 30px;
  width: 960px;
  border-bottom: 1px solid #e0e0e0;
  box-sizing: border-box;
}

#jy_salary_list_wrap #jy_salary_list_total .jy_logo {
  display: table;
  overflow: hidden;
  float: left;
  margin-top: 29px;
  margin-bottom: 20px;
  padding: 0 10px;
  width: 100px;
  height: 104px;
  border: 1px solid #efefef;
  text-align: center;
}

#jy_salary_list_wrap #jy_salary_list_total .jy_company_info {
  float: left;
  padding: 26px 60px 0 20px;
  width: 570px;
  box-sizing: border-box;
}

#jy_salary_list_wrap #jy_salary_list_total .jy_company_info .jy_title {
  font-size: 18px;
  font-weight: bold;
  line-height: 19px;
}

#jy_salary_list_wrap #jy_salary_list_total .jy_company_info .jy_recruit_title {
  margin-top: 20px;
}

#jy_salary_list_wrap #jy_salary_list_total .jy_mark {
  display: inline-block;
  overflow: hidden;
  margin: 2px 0 0 9px;
  padding: 0 9px 2px 8px;
  height: 16px;
  border: 1px solid #ff6e51;
  color: #ff6e51;
  font-size: 11px;
  font-weight: normal;
  line-height: 16px;
  vertical-align: top;
}

#jy_salary_list_wrap #jy_salary_list_total .jy_info_item {
  overflow: hidden;
  padding-top: 6px;
}

#jy_salary_list_wrap #jy_salary_list_total .jy_info_item dt {
  float: left;
  padding: 1px 0 2px;
  width: 80px;
  height: 18px;
  border: 1px solid #e4e4e4;
  box-sizing: border-box;
  color: #888;
  font-size: 11px;
  line-height: 14px;
  text-align: center;
}

#jy_salary_list_wrap #salary_list_total .jy_info_item dd {
  overflow: hidden;
  padding: 0 7px 2px;
  color: #555;
  font-size: 13px;
  text-overflow: ellipsis;
  white-space: nowrap;
}

#jy_info_wrap {
  overflow: hidden;
}

#jy_info_wrap .jy_info_item {
  float: left;
  margin-right: 5px;
}

.page {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}

.page ul {
  display: flex;
  align-items: center;
  list-style: none;
}

.page li {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  font-size: 14px;
  margin: 0 5px;
  cursor: pointer;
  background-color: #fff;
  border: 1px solid #ccc;
}

.page li.on {
  font-weight: bold;
  color: #fff;
  background-color: orangered;
  border-color: orangered;
}

.page i {
  font-size: 14px;
  margin: 0;
  padding: 0;
  line-height: 1;
}

.page_btn {
  display: flex;
  justify-content: center;
  align-items: center;
}

.jy_category-list-left {
  float: left;
  width: 100px;
}
.jy_category-list-left li {
  margin-bottom: 20px;
}

.jy_category-list-right {
  float: left;
  width: 100px;
}

.jy_category-list-right li {
  float: left;
  margin-left: 10px;
  margin-bottom: 2px;
}

.jy_admin_nav {
  width: 200px;
  height: 100%;
  position: fixed;
  top: 100px;
  left: 0;
  background-color: white;
}

.jy_admin_nav li {
  margin-top: 20px;
  list-style: none;
}

.jy_admin_nav li a {
  padding: 8px 20px;
  text-decoration: none;
  font-size: 15px;
  color: orange;
  display: block;
  width: 200px;
  font-weight: 600;
}

.jy_admin_nav .jy_sub_menu {
  margin-left: 25px;
}

.jy_admin_nav .jy_sub_menu li a {
  color: black;
  display: block;
  width: 155px;
  padding: 8px 10px 8px 10px;
}

.jy_admin_nav .jy_sub_menu li a:hover {
  background-color: orange;
}

.jy_admin_nav .jy_sub_menu li a.on {
  background-color: orange;
}

.font_orange {
  font-weight: bold;
  color: orangered;
}

.jy_search_category {
  font-weight: bold;
  color: orangered;
}

.input_com {
  width: 300px;
  height: 40px;
  margin-right: 20px;
  font-size: 14px;
}
.input_com:focus-within {
  outline-color: orangered;
}
</style>
