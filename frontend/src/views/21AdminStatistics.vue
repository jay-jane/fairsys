
<template>

  <div class="content">
    <div class="title">
      <h1>통합 통계</h1>
    </div>

    <div class="wrap">
      <div class="date_Select">
        <table>
          <tbody>

            <tr>
              <td>기간선택</td>
              <td>시작 날짜</td>
              <td>                
                <Datepicker
                  v-model="startDate"
                  :locale="locale"
                  :weekStartsOn="0"
                  :inputFormat="inputFormat"
                  :clearable="true"
                />
              </td>
              <td>마지막 날짜</td>
              <td>
                <Datepicker
                  v-model="endDate"
                  :locale="locale"
                  :weekStartsOn="0"
                  :inputFormat="inputFormat"
                  :clearable="true"
                />
              </td>
              <td><button>검색하기</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="btn_group">
      <button>전체보기</button>
      <button>가입자 추이</button>
      <button>지원자 추이</button>
      <button>합격자 추이</button>
      <button>성별, 연령분포</button>
    </div>



    <table class="graph_statistics">
      <tr>
        <td>
          <Bar class="barchart"
          :data="chartData"
          />
        </td>
        <td>
          <Pie class="barchart"
          :data="chartData2" />
        </td>
      </tr>
    </table>
  </div>


</template>

<script>
//데이트피커 관련 자료
import { ref, reactive, watch} from 'vue';
import Datepicker from 'vue3-datepicker';
import {ko} from 'date-fns/locale';

import {Bar, Line, Pie} from 'vue-chartjs';
import { Chart, registerables} from 'chart.js'
Chart.register(...registerables)

export default {
  components:{
    Bar,
    Line,
    Pie,
    Datepicker
  },
  name: 'App',
  data(){

    return{
      /* 차트데이터 입력 */
      chartData: {
          /* x축 */
          labels: [ '1일', '2일', '3일', '4일', '5일','6일','7일' ],
          /* Y축 */
          datasets: [ { 

            label: 'Data One',
            backgroundColor: '#f87979',
            pointBackgroundColor: 'white',
            borderWidth: 1,
            pointBorderColor: '#249EBF',
            data: [40, 20, 12, 22, 80, 60, 100] 
          
          } ]
        },
        chartData2: {
          /* x축 */
          labels: [ '여자', '남자'],
          /* Y축 */
          datasets: [ { data: [40, 20] } ]
        }
    }
  },
  // 데이터피커 설정
  setup(){

    //공통설정
    const locale = reactive(ko); //한글달력 기본값 영어
    const inputFormat = ref('yyyy-MM-dd'); //날짜세팅
    
    const now = new Date();

    //시작날짜는 당일 날짜 8일전
    const startDate = ref(new Date(now.setDate(now.getDate()-8)));
    //마지막날짜는 당일 날짜 1일전
    const endDate = ref(new Date(now.setDate(now.getDate()+7)));

    watch([startDate, endDate], ([newStartDate, newEndDate]) =>{

      if (newStartDate && newEndDate && newStartDate > newEndDate) {
        alert('시작일은 종료일보다 작거나 같아야합니다.');
      }

    });

    return{
      startDate,
      endDate,
      locale,
      inputFormat
    }
  }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
* {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; box-sizing: border-box;}


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

table {
  border-collapse: collapse;
  width: 100%;
}

td {
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

.date_Select td:nth-child(2),
.date_Select td:nth-child(4) {
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
  margin: 20px 0;
  display: flex;
  justify-content: space-around;
  box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
}

.barchart {
  width: 45%;
  height: 300px;
}


</style>

