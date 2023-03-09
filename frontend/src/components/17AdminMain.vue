
<template>


  <AdminHeader></AdminHeader> 
  <Side></Side>
  <div class="container">
    
    <div class="wrap_top">
      
      <div class="admin_profile">
        <h3>관리자 프로필</h3>
        <div class="admin_account">
          <table>
            <tr>
              <td>ID</td>
              <!-- db에서  id 검색해서 넣기 -->
              <td>admin</td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <!-- db에서 비밀번호는 * 표시로 넣기-->
              <td>*********</td>
            </tr>
          </table>
        </div>
      </div>
      
      <div class="all_user">
        <h3>전체 유저</h3>
        <span>명</span>
        <!-- db에서 전체유저 검색해서 값 넣어야함 -->
        <b>9,999</b>
      </div>
      
      <div class="approved_company">
        <h3>승인완료 기업</h3>
        <span>기업</span>
        <!-- db에서 승인완료된 기업 검색해서 값 넣어야함-->
        <b>217</b>
      </div>
      
      <div class="waiting_company">
        <h3>승인대기 기업</h3>
        <span>기업</span>
        <!-- db에서 승인대기 기업 몇개인지 검색해서 값 넣어야함-->
        <b>8</b>
      </div>
    </div>

    <h1>한눈에 보는 통계</h1>
    <div class="wrap_middle">

      <div class="date_apply_user">
        <h3>일자별 지원자 수</h3>
        <Bar class="barchart"
          :options="chartOptions"
          :data="chartData"
        />
      </div>

      <div class="date_pass_user">
        <h3>일자별 합격자 수</h3>
        <Bar class="barchart"
          :options="chartOptions"
          :data="chartData2"
        />
      </div>

    </div>


  </div>

  
</template>

<script>
import AdminHeader from '../../components/layout/Header/AdminHeader.vue';
import Side from '../../components/layout/Side/Side.vue';
import {Bar} from 'vue-chartjs';
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js'
ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default {
  name: 'App',
  components: {
    AdminHeader,
    Side,
    Bar
  },
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
  @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black;}
  h3{color: white;}
  
  .container{
    margin-left: 200px;
    padding: 20px;
  }
  
  .wrap_top{
    display: flex;
    justify-content: center;
    gap: 50px;
    margin: 30px 0;
  }

  .admin_profile{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
  }

  .admin_account{
    padding-top: 15px;
  } 

  .all_user{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
  }

  .all_user b{font-size: 48px; float: right; }
  .all_user span{float: right; font-size: 24px;  font-weight: 500;}

  .approved_company{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
  }

  .approved_company b{font-size: 48px; float: right;}
  .approved_company span{float: right;}

  .waiting_company{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
  }

  .waiting_company b{ font-size: 48px; float: right; }
  .waiting_company span{ float: right; }

  .wrap_middle{
    display: flex;
    justify-content: center;
    gap: 50px;
    margin: 30px 0;
  }

  .date_apply_user{
    border: 1px solid grey;
    width: 700px;
    padding: 25px;
  }

  .date_pass_user{
    border: 1px solid grey;
    width: 700px;
    padding: 25px;
  }

</style>

