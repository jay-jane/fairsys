
<template>
  <div class="content">
    <div class="title">
      <h1>통합 통계</h1>
    </div>

    <div class="wrap">
      <div class="date_Select">
        <table class="wrap_tb">
          <tbody>
            <tr>
              <td>시작 날짜</td>
              <td>
                <Datepicker v-model="startDate" :locale="locale" :weekStartsOn="0" :inputFormat="inputFormat"
                  :clearable="true" />
              </td>
              <td>마지막 날짜</td>
              <td>
                <Datepicker v-model="endDate" :locale="locale" :weekStartsOn="0" :inputFormat="inputFormat"
                  :clearable="true" />
              </td>
              <td><button @click="doSelectPeriod">검색하기</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="btn_group">
      <button @click="totalChartView">전체보기</button>
      <button @click="joinChartView">가입자 추이</button>
      <button @click="applyChartview">지원자 추이</button>
      <button @click="passChartview">합격자 추이</button>
    </div>



    <table class="graph_statistics">
      <tbody>
        <tr>
          <td class="tchart">
            <Bar class="totalChart" :data="totalChart" :options="totalChart.options" />
          </td>
        </tr>
        <tr>
          <td class= "achart" style="display: none;">
            <Bar class="applyChart" :data="applyUserChart" />
          </td>
        </tr>
        <tr>
          <td class="jchart" style="display: none;">
            <Line class="joinChart" :data="joinUserChart" />          
          </td>
        </tr>
        <tr>
          <td class="pchart" style="display: none;">
            <Bar class="passChart" :data="passUserChart" />
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import Axios from 'axios';

//데이트피커 관련 자료
import { ref, reactive, watch } from 'vue';
import Datepicker from 'vue3-datepicker';
import { ko } from 'date-fns/locale';

import { Bar, Line, Pie } from 'vue-chartjs';
import { Chart, registerables } from 'chart.js'
Chart.register(...registerables)

export default {
  components: {
    Bar,
    Line,
    Pie,
    Datepicker
  },
  name: 'App',
  data() {

    return {

      ed: new Date().toISOString().slice(0, 10),
      sd: new Date().toISOString().slice(0, 10) - 7,
      day: 7,
      companyName: '',

      //차트 단일데이터
      female: null,
      male: null,

      //차트 배열데이터
      date1: [],
      date2: [],
      date3: [],
      applycount: [],
      joincount: [],
      passcount: [],

      /* 차트데이터 입력 */
      totalChart: {

        labels: [],
        datasets: [
          { label: '', data: [] },
          { label: '', data: [] },
          { label: '', data: [] },
        ],

      },

      applyUserChart: {
        /* x축 */
        labels: [],
        /* Y축 */
        datasets: [{ label: '', data1: [] }],
      },

      joinUserChart: {
        /* x축 */
        labels: [],
        /* Y축 */
        datasets: [{ label: '', data2: [] }],
      },

      passUserChart: {
        /* x축 */
        labels: [],
        /* Y축 */
        datasets: [{ label: '', data3: [] }],
      }
    }
  },
  // 데이터피커 설정
  setup() {

    //공통설정
    const locale = reactive(ko); //한글달력 기본값 영어
    const inputFormat = ref('yyyy-MM-dd'); //날짜세팅

    const now = new Date();

    //시작날짜는 당일 날짜 8일전
    const startDate = ref(new Date(now.setDate(now.getDate() - 8)));
    //마지막날짜는 당일 날짜 1일전
    const endDate = ref(new Date(now.setDate(now.getDate() + 7)));

    watch([startDate, endDate], ([newStartDate, newEndDate]) => {

      if (newStartDate && newEndDate && newStartDate > newEndDate) {
        alert('기간은 7일으로만 설정이 가능합니다.');
        this.startDate = this.startDate;
      }

    });

    return {
      startDate,
      endDate,
      locale,
      inputFormat
    }
  },
  methods: {

    doSelectPeriod() {

      //전달할 날짜 분리하기
      this.sd = new Date(this.startDate - (this.startDate.getTimezoneOffset() * 60000));
      this.ed = new Date(this.endDate - (this.endDate.getTimezoneOffset() * 60000));


      this.sd = this.sd.toISOString().substring(0, 10);
      this.ed = this.ed.toISOString().substring(0, 10);

      //날짜 계산하기
      const sday = new Date(this.sd);
      const eday = new Date(this.ed);

      const diffTime = Math.abs(sday.getTime() - eday.getTime());
      this.day = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
      
      //재사용을 위한 초기화
      this.date1 = [];
      this.date2 = [];
      this.date3 = [];
      this.applycount= [];
      this.joincount=[];
      this.passcount= [];
    
      this.getData();
    },

    async getData() {

      
      let res = await Axios.get("/21?sd=" + this.sd + "&ed=" + this.ed + "&day=" + this.day);
      res = res.data;

      //console.log(res);

      //재사용을 위한 초기화
      this.date1 = [];
      this.date2 = [];
      this.date3 = [];
      this.applycount= [];
      this.joincount=[];
      this.passcount= [];
    

      //기간별 가입유저 데이터 저장
      let ju = res.joinUser;
      for (var i = 0; i < ju.length; i++) {
        this.date1.push(ju[i].date);
        this.joincount.push(ju[i].count);
      }

      this.joinUserChart = {
        labels: this.date1,
        datasets: [{
          label: '기간별 가입자',
          data: this.joincount
        }],
        options: {
          responsive: false
        }
      }



      //기간별 가입자 데이터 저장
      let au = res.applyUser;
      for (var i = 0; i < au.length; i++) {
        this.date2.push(au[i].date);
        this.applycount.push(au[i].count);
      }

      this.applyUserChart = {
        labels: this.date2,
        datasets: [{
          label: '기간별 지원자',
          data: this.applycount
        }]
      }

    

      //기간별 합격자 데이터 저장
      let pu = res.passUser;
      for (var i = 0; i < pu.length; i++) {
        this.date3.push(pu[i].date);
        this.passcount.push(pu[i].count);
      }

      this.passUserChart = {
        labels: this.date3,
        datasets: [{
          label: '기간별 합격자',
          data: this.passcount
        }]
      }

      this.totalChart = {
        labels: this.date3,
        datasets: [
          { type: 'line', label: '기간별 가입자', data: this.joincount },
          { type: 'bar', label: '기간별 지원자', data: this.applycount },
          { type: 'bar', label: '기간별 합격자', data: this.passcount },
        ]
      }

    },

    totalChartView() {
      //block 처리할애
      let tchart = document.querySelector(".tchart");
      tchart.style = "display: block";
      
      //none처리하는 애들
      let jchart = document.querySelector(".jchart");
      let achart = document.querySelector(".achart");
      let pchart = document.querySelector(".pchart");
      
      jchart.style ="display: none";
      achart.style = "display: none";
      pchart.style = "display: none";
    },

    joinChartView(){
      
      //block 처리할애
      let jchart = document.querySelector(".jchart");
      jchart.style ="display: block";
      
      //none처리하는 애들
      let tchart = document.querySelector(".tchart");
      let achart = document.querySelector(".achart");
      let pchart = document.querySelector(".pchart");

      tchart.style = "display: none";
      achart.style = "display: none";
      pchart.style = "display: none";

    },

    applyChartview(){

      //block 처리할애
      let achart = document.querySelector(".achart");
      achart.style = "display: block";
      
      //none처리하는 애들
      let jchart = document.querySelector(".jchart");
      let tchart = document.querySelector(".tchart");
      let pchart = document.querySelector(".pchart");
      
      tchart.style = "display: none";
      jchart.style ="display: none";
      pchart.style = "display: none";

    },

    passChartview(){

      //block 처리할애
      let pchart = document.querySelector(".pchart");
      pchart.style = "display: block";
      
      //none처리하는 애들
      let achart = document.querySelector(".achart");
      let jchart = document.querySelector(".jchart");
      let tchart = document.querySelector(".tchart");
      
      tchart.style = "display: none";
      jchart.style ="display: none";
      achart.style = "display: none";

    }

  },

 
  mounted() {
    //재사용을 위한 초기화
    this.date = [];
    this.count = [];
    this.getData();
  }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {
  padding: 0;
  margin: 0;
  font-family: 'Noto Sans KR', sans-serif;
  text-decoration: none;
  box-sizing: border-box;
}


.content {
  margin: 100px 0 0 200px;
  padding: 30px;
}


.title h1 {
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
}

.wrap {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  align-items: center;
  padding: 20px;
}

.wrap_tb {
  border-collapse: collapse;
  width: 100%;
}

.wrap_tb td {
  padding: 10px;
  text-align: center;
  vertical-align: middle;
}

.date_Select button {
  font-size: 16px;
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
  border-radius: 5px;
  padding: 10px 20px;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out, border-color 0.3s ease-in-out;
}

.date_Select button:hover {
  background-color: #0069d9;
  border-color: #0062cc;
}

.date_Select table {
  border: 1px solid #ccc;
}

.date_Select td:first-child {
  font-weight: bold;
}

.date_Select td:nth-child(1),
.date_Select td:nth-child(3),
.date_Select td:nth-child(5) {
  font-weight: bold;
  color: #007bff;
}

.btn_group {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: 10px 20px;
}

.btn_group button {
  font-size: 16px;
  color: #333;
  background-color: #f2f2f2;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  margin-right: 10px;
  margin-bottom: 10px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out, border-color 0.3s ease-in-out;
}

.btn_group button:hover {
  background-color: #e2e2e2;
}

.graph_statistics {
  width: 100%;
  margin: 30px 0;
  display: flex;
  justify-content: space-around;
  box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
}

.achart, .pchart, .jchart, .tchart {
  width: 1000px;
  padding: 25px;
}

</style>

