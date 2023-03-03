
<template>

  <nav id="top">
      <ul>
        <li><a href="#"><img src="#"></a></li>
        <li><a href="#">채용정보</a></li>
        <li><a href="#">기업/연봉</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">로그인</a></li>
      </ul>
  </nav>

  <div class="content">
    <h1>통계 화면</h1>
    <button>기간별</button>
    <button>나이대별</button>
    <button>성별</button>
    <table>
      <tr>
        <td>
          <Bar class="barchart"
          :options="chartOptions"
          :data="chartData"
          />
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import {Bar} from 'vue-chartjs';
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default {
  components:{Bar},
  name: 'App',
  data(){
    return{

      /* 차트데이터 입력 */
      chartData: {
        /* x축 */
        labels: [ '1일', '2일', '3일', '4일', '5일','6일','7일' ],
        /* Y축 */
        datasets: [ { data: [40, 20, 12, 22, 80, 60, 100] } ]
      },
      chartOptions: {
        responsive: true
      }
    }
  }

}
</script>

<style>
   #top{
    background-color: blue;
  }

  #top ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: space-around;
  }

  #top li {
    display: inline-block;
    padding: 10px;
  }

  #top a {
    color: white;
    text-decoration: none;
  }

  /* 차트디자인 */
  .barchart{
    width: 800px;
  }

</style>

