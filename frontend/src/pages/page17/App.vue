


<template>
  <!-- 여기는 상단바 -->
  <header id="header">


    <!-- 메뉴바 -->
    <div id="menu">
      <ul>
        <!-- 로고 -->
        <li><img src="#"></li>
        <li><a href="page14">채용정보</a></li>
        <li><a href="page15">기업/연봉</a></li>
        <li><a href="page12">마이페이지</a></li>
        <li><a href="page2">로그인</a></li>
      </ul>
    </div>

    <!-- 로그인버튼 -->

  </header>


  <article id="article">
    <h3>리뷰보기</h3>
    <section id="section_top">
      <div class="section_top_left">
        <div class="co_logo">
          <img src="//imgs.jobkorea.co.kr/Images/Logo/160/b/c/2615f00fasrjlaz2_3020s8csrqqzpjlfs.gif?p=y&amp;hash=c"
            alt="비씨카드㈜">
        </div>
        <div class="co_info">
          <div class="co_hd">
            <span class="co_name">비씨카드㈜</span>
          </div>
          <div class="co_detail">
            신용카드 및 할부금융업
          </div>
          <a href="기업정보상세페이지">기업 정보 보기</a>
        </div>
      </div>
      <div class="section_top_right">
        <div class="co_review">리뷰쓰기</div>
        <div class="co_like">관심기업</div>
      </div>
    </section>
    <h3 id="review">리뷰종합</h3>
    <section id="section_bottom">
      <div class="chart_wrap">
        <div class="chart_wrap_top">
          <div class="chart">
            <div class="chart_content">
              <h4 class="review_title">리뷰총평</h4>
              <div>
                <Radar class="radarchart" :options="radarChartOptions" :data="radarChartData" />
              </div>
            </div>
          </div>
          <div class="chart">
            <div class="chart_content">
              <h4 class="review_title">이런 점이 좋았어요</h4>
              <div>
                <div class="like_box">
                  <div class="like_text">
                    <img src="https://i.jobkorea.kr/content/images/user/review/like-icon19.png" alt="icon">
                    <span>워라밸이 보장돼요</span>
                  </div>
                  <div class="like_bg" style="width:16%"></div>
                </div>
                <div class="like_box">
                  <div class="like_text">
                    <img src="https://i.jobkorea.kr/content/images/user/review/like-icon12.png" alt="icon">
                    <span>같이 일하는 사람들이 좋아요</span>
                  </div>
                  <div class="like_bg" style="width:16%"></div>
                </div>
                <div class="like_box">
                  <div class="like_text">
                    <img src="https://i.jobkorea.kr/content/images/user/review/like-icon02.png" alt="icon">
                    <span>신입사원 초봉이 높아요</span>
                  </div>
                  <div class="like_bg" style="width:16%"></div>
                </div>
                <div class="like_box">
                  <div class="like_text">
                    <img src="https://i.jobkorea.kr/content/images/user/review/like-icon03.png" alt="icon">
                    <span>퇴직금은 연봉과 별도예요</span>
                  </div>
                  <div class="like_bg" style="width:16%"></div>
                </div>
                <div class="like_box">
                  <div class="like_text">
                    <img src="https://i.jobkorea.kr/content/images/user/review/like-icon08.png" alt="icon">
                    <span>학습을 장려하고 지원 해줘요</span>
                  </div>
                  <div class="like_bg" style="width:16%"></div>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>

    </section>

  </article>




  <!-- 여기는 하단바 -->
  <footer id="footer">
    저작권 정보?

  </footer>
</template>

<script>

import {
  Chart as ChartJS,
  RadialLinearScale,
  PointElement,
  LineElement,
  Filler,
  Tooltip,
  Legend
} from 'chart.js'
import { Radar } from 'vue-chartjs'
ChartJS.register(
  RadialLinearScale,
  PointElement,
  LineElement,
  Filler,
  Tooltip,
  Legend
)
export default {
  name: 'App',
  components: {
    Radar
  },

  data() {
    return {

      /* 차트데이터 입력 */
      radarChartData: {
        labels: [
          '워라밸',
          '고용안정성',
          '조직문화',
          '커리어성장',
          '복리후생',
          '급여'

        ],
        datasets: [
          {
            label: '점수',
            backgroundColor: 'rgba(179,181,198,0.2)',
            borderColor: '#39f',
            pointBackgroundColor: '#39f',
            pointBorderColor: '#39f',
            pointHoverBackgroundColor: '#39f',
            pointHoverBorderColor: 'rgba(179,181,198,1)',
            data: [65, 75, 70, 70, 75, 75]

          }
        ]
      },
      radarChartOptions: {
        responsive: true
      }
    }
  }

}



</script>




<style>
* {
  margin: 0;
  padding: 0;
  list-style: none;
}

#header {
  text-align: center;
}

#menu li {
  display: inline;
  padding-left: 20px;
}


#article {
  position: relative;
  width: 100%;
  margin: 25px auto 0 auto;
  text-align: left;
  margin-top: 31px;
  width: 960px;

}

#section_top {
  display: flex;
  justify-content: space-between;
  align-items: center;

  background-color: #fff;
  padding: 30px;
  border: 1px solid #dce1eb;
  box-sizing: border-box;

  position: relative;
  width: 100%;
  margin: 25px auto 0 auto;
  text-align: left;
}

.section_top_left {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.section_top_left .co_logo {
  width: 87px;
  margin-right: 30px;
}

.section_top_left .co_logo img {
  width: 100%;
  height: 100%;
}

.co_info {
  display: flex;
  flex-direction: column;
}

.co_info .co_name {
  font-size: 22px;
  letter-spacing: -1.1px;
  margin-right: 11.6px;
}

.co_info .co_detail {
  font-size: 15px;
  letter-spacing: -.75px;
  color: #666;
  margin: 10px 0;
}

.co_info a {
  font-size: 13px;
  letter-spacing: -.65px;
  color: #999;
}


.section_top_right {
  display: flex;
}

.section_top_right .co_review {
  display: block;
  padding: 11px 20px 9px;
  font-size: 15px;
  letter-spacing: -.75px;
  color: #999;
  background: #fff 0 0 no-repeat padding-box;
  border: 1px solid #d5d5d7;

  border-radius: 20px;
  margin-right: 10px;
}

.section_top_right .co_like {
  display: block;
  padding: 11px 20px 9px;
  font-size: 15px;
  letter-spacing: -.75px;
  color: #999;
  background: #fff 0 0 no-repeat padding-box;
  border: 1px solid #d5d5d7;

  border-radius: 20px;
  margin-right: 10px;
}

.section_bottom {
  background: #fff 0 0 no-repeat padding-box;
  border: 1px solid #dce1eb;
  padding: 30px;
  margin-bottom: 10px;

  box-sizing: border-box;
}

#review {
  padding: 10px 0;
}

.chart_wrap {
  position: relative;
}

.chart_wrap_top {
  display: flex;
  align-items: center;
}

.chart_wrap_top .chart {
  height: 420px;
  width: 420px;
  padding: 30px;
}

.review_title {
  padding: 10px 0;
}

.like_box {
  width: 100%;
  height: 44px;
  border: 1px solid #eee;
  border-radius: 5px;
  margin-bottom: 10px;
  padding: 10px 11px;
  position: relative;
}

.like_text {
  display: flex;
  align-items: center;
  position: relative;
}

.like_text img {
  width: 20px;
  height: 20px;
  margin-right: 11px;
  border: 0 none;
  vertical-align: top;
}

.like_text span {
  display: block;
  margin-bottom: -2px;
  font-size: 15px;
  letter-spacing: -.75px;
  color: #333;
}

#footer {
  height: 200px;
  text-align: center;
}
</style>
