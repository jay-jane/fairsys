
<template>

  <div class="hy_main">
    
    <div class="hy_wrap_top">
      
      <div class="hy_admin_profile">
        <h3>관리자 프로필</h3>
        <div class="hy_admin_account">
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
      
      <div class="hy_all_user">
        <h3>전체 유저</h3>
        <span>명</span>
        <!-- db에서 전체유저 검색해서 값 넣어야함 -->
        <b>{{ totalUser }}</b>
      </div>
      
      <div class="hy_approved_company">
        <h3>승인완료 기업</h3>
        <span>기업</span>
        <!-- db에서 승인완료된 기업 검색해서 값 넣어야함-->
        <b>{{ approveCompany }}</b>
      </div>
      
      <div class="hy_waiting_company">
        <h3>승인대기 기업</h3>
        <span>기업</span>
        <!-- db에서 승인대기 기업 몇개인지 검색해서 값 넣어야함-->
        <b>{{ waitCompany }}</b>
      </div>
    </div>

    <div class="hy_wrap_middle">

      <div class="date_apply_user">
        <Bar class="barchart"
          :data="chartData"
        />
      </div>

      <div class="date_pass_user">
        <Pie class="barchart"
          :data="chartData2"
          :options="options"
        />
      </div>

    </div>


  </div>

</template>

<script>
import Axios from 'axios';

import {Bar, Line, Pie} from 'vue-chartjs';
import { Chart, registerables} from 'chart.js'
Chart.register(...registerables)

export default {
  name: 'App',
  components: {
    Bar,
    Line,
    Pie
  },
  data(){
    return{

      //통계출력용 
      date:[],
      count:[],
      approveCompany: '',
      passerFemale: '',
      passerMale:'',
      totalUser:'',
      waitCompany:'',

      /* 차트데이터 입력 */
      chartData: {
        /* x축 */
        labels: [],
        /* Y축 */
        datasets: [ { 
          //그래프 명
          label: '',
          data: [] 
        } ],
      },
      chartData2: {
        /* x축 */
        labels: [],
        /* Y축 */
        datasets: [ { 
          //그래프 명
          label: '',
          data: [] 
        } ],
      },
      options:{
        responsive: true
      }
    }
  },

  mounted() {
    //데이터 출력시키기
    this.get();
  },

  methods:{
    async get() {
      let response = await Axios.get("/17");
      response = response.data;

      //단일데이터 저장
      this.totalUser = response.totalUser;
      this.approveCompany = response.approveCompany;
      this.waitCompany = response.waitCompany;
      this.passerFemale = response.passerFemale;
      this.passerMale = response.passerMale;

      //배열형 데이터 저장
      response = response.ApplicantsbyDate;
      
      for(var i = 0; i < response.length; i++){
        this.date.unshift(response[i].date);
        this.count.unshift(response[i].count);
      }

      // console.log(this.date);
      // console.log(this.count);

      this.chartData = {labels: this.date,
                        datasets: [{
                          label:'일자별 합격자',
                          data:this.count
                        }]}

      this.chartData2 = {labels: ['남자', '여자'],
                         datasets: [{
                          label: '합격자 성별비율',
                          data:[this.passerMale, this.passerFemale]
                         }]}
          

    }
  }

}
</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
  * {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black;}
  
  
  h3{color: white;}
  
  .hy_main{
    padding: 20px;
    background-color: #f5f5f5;
  }

  
  .hy_wrap_top{
    display: flex;
    justify-content: center;
    gap: 50px;
  }

  .hy_admin_profile{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
  }

  .hy_admin_account{
    padding-top: 15px;
  } 

  .hy_all_user{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
    box-shadow: black;
  }

  .hy_all_user b{font-size: 48px; float: right; }
  .hy_all_user span{float: right; font-size: 24px;  font-weight: 500;}

  .hy_approved_company{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
  }

  .hy_approved_company b{font-size: 48px; float: right;}
  .hy_approved_company span{float: right;}

  .hy_waiting_company{
    background-color: orange;
    width: 300px;
    border-radius: 25px;
    padding: 25px;
  }

  .hy_waiting_company b{ font-size: 48px; float: right; }
  .hy_waiting_company span{ float: right; }

  .hy_wrap_middle{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    gap: 30px;
    margin: 30px 0;
  }

  .date_apply_user, .date_pass_user{
    width: 700px;
    padding: 25px;
  }

</style>
