<template>

  <h1>통계화면 나와라이</h1>
  <Line class="linechart" 
  :options="chartOptions"
  :data="chartData"/>

</template>

<script>
import { Line } from 'vue-chartjs';

export default {
  components:{Line},
  name: 'App',
  data() {
    return {
      chartData:{
        labels:['20대', '30대', '40대'],
        datasets: [{
          data:[7, 8, 11]
        }]
      },
      chartOptions:{
        responsive: true
      }
    }
  }
}

</script>

<style>

</style>
