<!-- 재윤 - 연봉 정보 -->
<template>
  <header>
    <ul class="head">
      <li>메인로고</li>
      <li><a href="page7">등록</a></li>
      <li>공고 관리</li>
      <li>마이페이지</li>
      <li>로그인/로그아웃</li>
    </ul>
  </header>

  <section id="salary_wrap">
    <h3>연봉 정보 페이지</h3>
    <hr>
    <div id="content_wrap">
      <div id="swiper_wrap">
        <p>기업별 평균 연봉</p>
        <div id="swiper">
          swiperAPI
        </div>
      </div>
      <div id="search_wrap">
        <div id="search_name" class="option_box">
          <strong class="option_title">
            <label for="company_name">기업명</label>
          </strong>
          <input type="text" placeholder="(주)와 같은 특수문자를 제외하고 입력해 주세요">
        </div>
        <div id="search_salary" class="option_box">
          <strong class="option_title">연봉</strong>
          <select name="" id="salary">
            <option value="">2,400 만원 ~</option>
            <option value="">2,600 만원 ~</option>
            <option value="">2,800 만원 ~</option>
            <option value="">3,000 만원 ~</option>
          </select>
        </div>
        <div id="search_btn">
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
              <a href="#" class="logo"><img src="#" alt="로고"></a>
              <div class="company_info">
                <strong class="title">회사명</strong>
                <a href="#" class="mark">채용중</a>
                <dl class="info_item">
                  <dt>정보1</dt>
                  <dd>내용1</dd>
                </dl>
                <dl class="info_item">
                  <dt>정보2</dt>
                  <dd>내용2</dd>
                </dl>
                <dl class="info_item">
                  <dt>정보3</dt>
                  <dd>내용3</dd>
                </dl>
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

  <footer style="text-align: center;">
    푸푸푸푸<br>
    터터터터
  </footer>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
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

/* footer */
footer {
  background-color: #f7f7f7;
  padding: 20px;
  text-align: center;
  font-size: 14px;
}</style>

