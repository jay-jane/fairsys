<!-- 재윤 - 채용 공고 목록 -->
<template>
  <section id="salary_wrap">
    <h3>채용 정보</h3>
    <hr>
    <div id="content_wrap">
      <div id="swiper_wrap">
        <p>메인 공고</p>
        <div id="swiper">
          swiperAPI
        </div>
      </div>
      <div id="search_wrap">
        <div id="search_name" class="option_box">
          <strong class="option_title">
            <label for="company_name">기업명</label>
          </strong>
          <input type="text" v-model="companyName" @keydown.enter="getComName" @focusout="getComName"
            placeholder="(주)와 같은 특수문자를 제외하고 입력해 주세요">
        </div>
        <div id="search_salary" class="option_box" style="overflow: hidden;">
          <strong class="option_title" style="float: left;">지역<br><br>
            <span @click="" style="font-size: 8px; font-weight: normal; cursor: pointer;">
              <img src="https://picsum.photos/10/10" alt="r"> 초기화
            </span>
          </strong>
          <ul class="categoryList" style="float: left;">
            <li><a href="#" @click.prevent="getCategory_List" name="1">서울</a></li>
            <li><a href="#" @click.prevent="getCategory_List" name="2">경기</a></li>
            <li><a href="#" @click.prevent="getCategory_List" name="3">인천</a></li>
          </ul>
          <ul class="categoryList">
            <li><a href="#" class="서울시" v-if="mid_category1" @click.prevent="getCategory">&gt; 강남구</a></li>
            <li><a href="#" class="서울시" v-if="mid_category1" @click.prevent="getCategory">&gt; 서초구</a></li>
            <li><a href="#" class="서울시" v-if="mid_category1" @click.prevent="getCategory">&gt; 강서구</a></li>
            <li><a href="#" class="경기도" v-if="mid_category2" @click.prevent="getCategory">&gt; 수원</a></li>
            <li><a href="#" class="경기도" v-if="mid_category2" @click.prevent="getCategory">&gt; 성남</a></li>
            <li><a href="#" class="경기도" v-if="mid_category2" @click.prevent="getCategory">&gt; 안산</a></li>
            <li><a href="#" class="인천" v-if="mid_category3" @click.prevent="getCategory">&gt; 연수구</a></li>
            <li><a href="#" class="인천" v-if="mid_category3" @click.prevent="getCategory">&gt; 서구</a></li>
          </ul>
        <!-- <select @change="getRegion" id="salary">
            <option value="" selected></option>
            <option value="서울">서울</option>
            <option value="경기">경기</option>
            <option value="인천">인천</option>
            </select> -->
        </div>
        <div id="search_type" class="option_box">
          <strong class="option_title">근무형태</strong>
          <div id="job_type">
            <input @click="getCareer" type="radio" name="job_type" value="신입">신입
            <input @click="getCareer" type="radio" style="margin-left: 5px;" name="job_type" value="경력">경력
            <input @click="getCareer" type="radio" style="margin-left: 5px;" name="job_type" value="무관">경력무관
          </div>
        </div>
        <div id="search_btn">
          <span>{{ com_name }}&nbsp;/&nbsp;{{ category }}&nbsp;/&nbsp;{{ career }}</span>
          <p class="search_total">검색 결과 : <strong class="num_total" style="color: orangered;">{{ total }}</strong> 건</p>
          <button type="button" class="search_btn" @click="searchItem">검색하기</button>
        </div>
      </div>
      <div id="salary_list_wrap">
        <div class="total_sort">
          <p>총 <strong class="num_total" style="color: orangered; font-size: 20px;">{{ total }}</strong>건</p>
          <!-- 출력 카테고리 -->
          <select v-model="amount" class="view" @change="loglist_view">
            <option value="5">5개씩 보기</option>
            <option value="10">10개씩 보기</option>
            <option value="30">30개씩 보기</option>
          </select>
          <button type="button" @click="addPosting" style="border: 0; background-color: orangered; float: right; width: 100px; height: 40px; color: white;">
            공고 등록
          </button>
        </div>
        <div id="salary_list_total">
          <ul>
            <div v-for="item in list">
              <li>
                <a href="#" class="logo" @click.prevent="getDetail(item.j_no)"><img src="" alt="로고"></a>
                <div class="company_info">
                  <strong class="title">
                    <span style="cursor: pointer;" @click.prevent="getDetail(item.j_no)">{{ item.com_name}} {{ item.j_no }}</span>
                  </strong>
                  <a href="#" class="mark" @click="(e) => { e.preventDefault(); }" style="cursor: default;">채용중</a>
                  <div class="recruit_title">
                    <span style="cursor: pointer;" @click.prevent="getDetail(item.j_no)">{{ item.j_title }}</span>
                  </div>
                  <div id="info_wrap" style="cursor: default;">
                    <dl class="info_item">
                      <dt>{{ item.j_career }}</dt>
                    </dl>
                    <dl class="info_item">
                      <dt>{{ item.j_graduation }}</dt>
                    </dl>
                    <dl class="info_item">
                      <dt>지역</dt>
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
          <router-link :to="{ path: '/4/?page=1&amount=' + amount }" @click="goFirstPage">
            <i class="fa fa-angle-double-left" aria-hidden="true"> &lt;&lt; </i>
          </router-link>
        </li>

        <!-- 앞으로 가기 -->
        <li style="margin-right:5px;">
          <router-link :to="{ path: '/4/?page=' + page + '&amount=' + amount }" @click="goBeforePage">
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
          <router-link :to="{ path: '/4/?page=' + page + '&amount=' + amount }" @click="goNextPage">
            <i class="fa fa-angle-right" aria-hidden="true"> &gt; </i>
          </router-link>
        </li>

        <!-- 맨뒤로 가기 -->
        <li>
          <router-link :to="{ path: '/4/?page=' + realEnd + '&amount=' + amount }" @click="goLastPage">
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
    getComName: function (e) {
      this.com_name = e.target.value;
    },
    getCategory_List: function (e) {
      e.preventDefault();
      if (e.target.tagName != 'A') return;
      if (e.target.name == 1) {
        this.mid_category1 = true;
        this.mid_category2 = false;
        this.mid_category3 = false;
      } else if (e.target.name == 2) {
        this.mid_category1 = false;
        this.mid_category2 = true;
        this.mid_category3 = false;
      } else if (e.target.name == 3) {
        this.mid_category1 = false;
        this.mid_category2 = false;
        this.mid_category3 = true;
      }
    },
    getCategory: function (e) {
      console.log(e.target.className);
      this.category = e.target.className + " " + e.target.innerHTML.substr(4);
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
      this.searchContent = this.pages.cri.searchContent;
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
      console.log(this.searchCareer);
      this.get();
    },
    addPosting() {
      this.$router.push({
        path: '/registJobPosting',
        name: 'jobPostingRegist',
        params: { 'com_id': sessionStorage.getItem("com_id") },
        headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
          },
      })
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

/* header */
header {
  background-color: #f7f7f7;
  padding: 10px;
}

.head {
  list-style: none;
  display: flex;
  justify-content: space-between;
}

.head li {
  font-size: 16px;
  margin-right: 20px;
}

.head li:first-child {
  font-size: 24px;
  font-weight: bold;
}

.head li:last-child {
  margin-right: 0;
}

.head a {
  color: #333;
  text-decoration: none;
}

.head a:hover {
  text-decoration: underline;
}

/* section */
#salary_wrap {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h3 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

#search_wrap {
  border: 1px solid #ebebeb;
  border-top: 2px solid #5c667b;
  min-width: 800px;
}

#search_wrap .option_box {
  padding: 0 18px 0 112px;
  font-size: 13px;
}

#search_wrap .option_title {
  padding-top: 2px;
  width: 85px;
  float: left;
}

#search_wrap #search_name {
  background-color: #f9f9f9;
  border-bottom: 1px solid #ebebeb;
  padding-top: 22px;
  padding-bottom: 22px;
  position: relative;
}

#search_wrap #search_salary {
  background-color: #f9f9f9;
  padding-top: 54px;
  padding-bottom: 22px;
  position: relative;
}

#search_wrap #search_type {
  background-color: #f9f9f9;
  border-top: 1px solid #ebebeb;
  padding-top: 22px;
  padding-bottom: 22px;
  position: relative;
}

#search_wrap #search_btn {
  border: 1px solid #ccc;
  padding: 15px 163px 16px 18px;
  position: relative;
  letter-spacing: -1px;
  font-size: 14px;
}

#search_wrap #search_btn button {
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

#salary_list_wrap {
  padding: 57px 0 65px;
}

#salary_list_wrap .total_sort {
  width: 100%;
  height: 42px;
  border-bottom: 2px solid #444;
}

#salary_list_wrap #salary_list_total {
  overflow: hidden;
}

#salary_list_wrap #salary_list_total ul li {
  overflow: hidden;
  padding: 8px 19px 6px 30px;
  width: 960px;
  border-bottom: 1px solid #e0e0e0;
  box-sizing: border-box;
}

#salary_list_wrap #salary_list_total .logo {
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

#salary_list_wrap #salary_list_total .company_info {
  float: left;
  padding: 26px 60px 0 20px;
  width: 570px;
  box-sizing: border-box;
}

#salary_list_wrap #salary_list_total .company_info .title {
  font-size: 18px;
  font-weight: bold;
  line-height: 19px;
}

#salary_list_wrap #salary_list_total .company_info .recruit_title {
  margin-top: 20px;
}

#salary_list_wrap #salary_list_total .mark {
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

#salary_list_wrap #salary_list_total .info_item {
  overflow: hidden;
  padding-top: 6px;
}

#salary_list_wrap #salary_list_total .info_item dt {
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

#salary_list_wrap #salary_list_total .info_item dd {
  overflow: hidden;
  padding: 0 7px 2px;
  color: #555;
  font-size: 13px;
  text-overflow: ellipsis;
  white-space: nowrap;
}

#info_wrap {
  overflow: hidden;
}

#info_wrap .info_item {
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
  background-color: #007bff;
  border-color: #007bff;
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
</style>
