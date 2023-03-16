
<template>

  <div class="content">

    <div class="title">
      <h1>통합 통계</h1>
    </div>

    <div class="wrap">
      <div class="date_Select">
        <span>기간선택</span>
        <table>
          <tbody>

            <td>
              <tr>시작 날짜</tr>
            </td>

            <td>
              <tr>
                <!-- <font-awesome-icon
                  incon="fa-solid fa-calendar-days"
                  transform="down-2.5 right-20"
                  style="z-index: 1; cursor: pointer;"
                  @click="clickCalIcon()"
                /> -->
                <Datepicker
                  v-model="picked"
                  :locale="locale"
                  :weekStartsOn="0"
                  :inputFormat="inputFormat"
                  :clearable="true"
                  />
              </tr>
            </td>

            <td>
              <tr>마지막 날짜</tr>
            </td>
            
            <td>
              <tr>
                <Datepicker
                  v-model="picked"
                  :locale="locale"
                  :weekStartsOn="0"
                  :inputFormat="inputFormat"
                  :clearable="true"
                  />
              </tr>
            </td>

          </tbody>
        </table>




      </div>
    </div>

    <!-- <table class="graph_statistics">
      <tr>
        <td>
          <Bar class="barchart"
          :options="chartOptions"
          :data="chartData"
          />
        </td>
        <td>
          <Pie class="barchart"
          :options="chartOptions"
          :data="chartData2" />
        </td>
      </tr>
    </table> -->
  </div>


</template>

<script>
//데이트피커 관련 자료
import { ref, reactive, defineComponent} from 'vue';
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
    const picked = ref(new Date());
    const locale = reactive(ko); //한글달력 기본값 영어
    const inputFormat = ref('yyyy-MM-dd'); //날짜세팅

    return{
      picked,
      locale,
      inputFormat
    }
  }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
* {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none;}


  .content{
    margin-left: 200px; 
    margin-top: 100px;
    height: auto;
    background-color: #f5f5f5;
  }

  /* 타이틀설정 */

  .date_Select{

  }

  /* 통합 통계 */
  .integrated_statistics{
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .graph_statistics{
    display: flex;
    justify-content: center;
    align-items: center;
  }

  table{
    border-collapse: collapse;
  }

  td{
    border: 1px solid black;
    padding: 10px;
  }

  /* 차트디자인 */
  .barchart{
    width: 100%
  }

</style>

