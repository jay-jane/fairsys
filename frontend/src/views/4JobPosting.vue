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
      <div id="category_wrap">
        <table cellpadding="0" cellspacing="0" class="board_basic_view" width="100%">
          <tr>
            <th>카테고리</th>
            <td colspan="5"><span style="display: inline-block" class="category_name">{{category}}</span>
              <div class="loading" style="display: none;">
                <div class="loader"></div>
                <div class="loading-overlay"></div>
              </div>

              <div class="categoryListWrap" ref="category">
                <ul class="categoryList" style="position: relative;">
                  <li><a href="#" @click="getCategory_List" name="1">머임</a></li>
                  <li><a href="#" @click="getCategory_List" name="2">지역</a></li>
                  <li><a href="#" @click="getCategory_List" name="3">근무형태</a></li>
                </ul>
                <ul class="categoryList" style="position: relative;">
                  <li><a href="#" v-if="mid_category1" @click="getCategory">머임1</a></li>
                  <li><a href="#" v-if="mid_category1" @click="getCategory">머임2</a></li>
                  <li><a href="#" v-if="mid_category1" @click="getCategory">머임3</a></li>
                  <li><a href="#" v-if="mid_category2" @click="getCategory">서울</a></li>
                  <li><a href="#" v-if="mid_category2" @click="getCategory">경기</a></li>
                  <li><a href="#" v-if="mid_category2" @click="getCategory">인천</a></li>
                  <li><a href="#" v-if="mid_category3" @click="getCategory">신입</a></li>
                  <li><a href="#" v-if="mid_category3" @click="getCategory">경력</a></li>
                  <li><a href="#" v-if="mid_category3" @click="getCategory">경력무관</a></li>
                </ul>
              </div>
            </td>
          </tr>
        </table>
      </div>
      <div id="search_wrap">
        <div id="search_name" class="option_box">
          <strong class="option_title">
            <label for="company_name">기업명</label>
          </strong>
          <input type="text" @focusout="getComName" placeholder="(주)와 같은 특수문자를 제외하고 입력해 주세요">
        </div>
        <div id="search_salary" class="option_box">
          <strong class="option_title">지역</strong>
          <select @change="getRegion" id="salary">
            <option value="서울, 경기">서울, 경기</option>
            <option value="인천">인천</option>
            <option value="나머지">나머지</option>
            <option value="@@@@">@@@@</option>
          </select>
        </div>
        <div id="search_type" class="option_box">
          <strong class="option_title">근무형태</strong>
          <div id="job_type">
            <input @click="getCareer" type="radio" name="job_type" value="신입">신입
            <input @click="getCareer" type="radio" style="margin-left: 5px;" name="job_type" value="경력">경력
            <input @click="getCareer" type="radio" style="margin-left: 5px;" name="job_type" value="경력무관">경력무관
          </div>
        </div>
        <div id="search_btn">
          <span>{{ com_name }}, {{ region }}, {{ career }}</span>
          <p class="search_total">검색 결과 : <strong class="num_total" style="color: orangered;">999</strong> 건</p>
          <button type="button" class="search_btn" @click="searchItem">검색하기</button>
        </div>
      </div>
      <div id="salary_list_wrap">
        <div class="total_sort">
          <p>총 <strong class="num_total" style="color: orangered; font-size: 20px;">999</strong>건</p>
        </div>

        <div id="salary_list_total">
          <ul>
            <li>
              <a href="#" class="logo"><img src="" alt="로고"></a>
              <div class="company_info">
                <strong class="title"><a href="#" style="color: #333;">회사명</a></strong>
                <a href="#" class="mark">채용중</a>
                <div class="recruit_title">
                  <a href="#" style="color: #333;">IT개발 부문 채용</a>
                </div>
                <div id="info_wrap">
                  <dl class="info_item">
                    <dt>경력</dt>
                  </dl>
                  <dl class="info_item">
                    <dt>학력</dt>
                  </dl>
                  <dl class="info_item">
                    <dt>지역</dt>
                  </dl>
                </div>
              </div>
            </li>
            <li>
              <a href="#" class="logo"><img src="" alt="로고"></a>
              <div class="company_info">
                <strong class="title"><a href="#" style="color: #333;">회사명</a></strong>
                <a href="#" class="mark">채용중</a>
                <div class="recruit_title">
                  <a href="#" style="color: #333;">IT개발 부문 채용</a>
                </div>
                <div id="info_wrap">
                  <dl class="info_item">
                    <dt>경력</dt>
                  </dl>
                  <dl class="info_item">
                    <dt>학력</dt>
                  </dl>
                  <dl class="info_item">
                    <dt>지역</dt>
                  </dl>
                </div>
              </div>
            </li>
            <li>
              <a href="#" class="logo"><img src="" alt="로고"></a>
              <div class="company_info">
                <strong class="title"><a href="#" style="color: #333;">회사명</a></strong>
                <a href="#" class="mark">채용중</a>
                <div class="recruit_title">
                  <a href="#" style="color: #333;">IT개발 부문 채용</a>
                </div>
                <div id="info_wrap">
                  <dl class="info_item">
                    <dt>경력</dt>
                  </dl>
                  <dl class="info_item">
                    <dt>학력</dt>
                  </dl>
                  <dl class="info_item">
                    <dt>지역</dt>
                  </dl>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <div id="pagination">
      페이지네이션
    </div>

  </section>
</template>

<script>
import axios from 'axios';

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
    }
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
      this.category = e.target.innerHTML;
    }
  },
  mounted() {

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
section {
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

/* footer */
footer {
  background-color: #f7f7f7;
  padding: 20px;
  text-align: center;
  font-size: 14px;
}
</style>
