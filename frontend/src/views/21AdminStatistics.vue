
<template>

  <div class="content">

    <h2>통합 통계</h2>
    <br>
    <br>
    <table class="integrated_statistics">

      <tr>
        <td>
          총 지원자
        </td>
        <td>
          
        </td>
        <td>
          악3
        </td>
      </tr>

      <tr>
        <td>
        6
        </td>
        <td>
          악2
        </td>
        <td>
          악3
        </td>
      </tr>
    </table>

    <br><br>

    <table class="graph_statistics">
      <tr>
        <td>
          <Bar class="barchart"
          :options="chartOptions"
          :data="chartData"
          />
        </td>
        <td>
          <Bar class="barchart"
          :options="chartOptions"
          :data="chartData2" />
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
  components:{
    Bar,    
  },
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
      chartData2: {
        /* x축 */
        labels: [ '여자', '남자'],
        /* Y축 */
        datasets: [ { data: [40, 20] } ]
      },
      chartOptions: {
        responsive: true
      }
    }
  }

}
</script>

<style>
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

