<template>
  <section class="">
    <div role="region" aria-label="추천공고" id="section_contents" class="cont_top">
      <div class="inner">
        <child></child>
        <div class="wrap_service_aside">
          <a href="" class="area_matching banner01" style="display: none;">
          </a>
          <a href="" class="area_matching banner02" style="display:">
          </a>
          <a href="" class="area_matching banner03" style="display: none;">
          </a>
          <div class="area_banner">
            <a href="" target="_blank"><img src="" alt="배너넣기" width="292"></a>
          </div>
        </div>
      </div>
    </div>
    <div class="company">
      <div class="com_item" v-for="(item, index) in jobPostingList">
        <div class="com_line">
          <a class="menu">
            <ul>
              <li><img src="" alt="" width="300px"></li>
              <li @click.prevent="getDetail(item.j_no)">{{ item.com_name }}</li>
              <li>{{ item.com_id }}</li>
              <li>신입/경력채용</li>
              <li>{{ item.j_regdate.substr(0, 11) }}</li>
            </ul>
          </a>
        </div>
      </div>
    </div>

  </section>
</template>

<script>
import axios from 'axios';
import child from './maincopy.vue'

export default {
  name: 'App',
  components : { child },
  data() {
    return {
      jobPostingList: '',

      //공용
      pages: '',   //pageVO
      pageList: '',  //pageVO.pageList 배열값
      detailNum: '',

      //페이지이동에 필요한 초기값들
      page: 1,
      amount: 3,
      prev: '',
      pageStart: '',
      pageEnd: '',
      realEnd: '',

      total: '',

      //게시글 리스트
      list: [],
    }
  },
  methods: {
    getBottom() {
      axios.get("/main2"
      ).then(res => {
        console.log(res)
        console.log(res.data)
        this.jobPostingList = res.data;

      }).catch(err => {
        console.log(err)
      })


    },

    getDetail(j_no) {
      this.$router.push({
        path: '/jobPostingDetail',
        name: 'jobPostingDetail',
        params: { 'j_no': j_no }
      })
    },
  },



  mounted() {
    this.getBottom()
  },


};
</script>
 
<style>


html,
body {
  width: 100%;
  -webkit-text-size-adjust: none
}


/* ////////////////////////////// 하단부 */

.company {
  margin: 0 auto;
  width: 1300px;
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  padding-top: 30px;

}

.company .com_item {
  padding: 10px;
  width: 305px;
}

.company .com_item ul {
  list-style: none;
}

.btn_login {
  text-align: center;
}

.company a ul li:nth-child(2) {
  font-size: 25px;
  width: 305px;
  border-bottom: 1.5px solid #d6d6d6;
  padding: 20px 0;
}

.company a ul li:nth-child(3) {
  padding: 5px 0 20px 0;
}

.company a ul li:nth-child(3),
.company a ul li:nth-child(4) {
  color: #777777;
  padding: 10px;
}

.company ul {
  position: relative;
}


.company a ul li:nth-child(5) {
  position: absolute;
  top: 45px;
  right: 0;
  background-color: orange;
  padding: 5px 20px;
  color: white;
  border-radius: 17px;
}
</style>
 

