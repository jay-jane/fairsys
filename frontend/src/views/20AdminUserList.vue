<template>

  <div class="main">    
    <div class="container">

      <h1>유저 전체 목록</h1>

      <div class="searchBox">
        <input type="text">
        <button>검색하기</button>
      </div>  

      <select v-model="amount" class="list_view">
        <option value="10"> 10개씩 보기</option>
        <option value="30"> 30개씩 보기</option>
        <option value="50"> 50개씩 보기</option>
        <option value="100"> 100개씩 보기</option>
      </select>

      <table class="list">

        <thead class="head">
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>아이디</th>
            <th>가입일</th>
            <th>상세보기</th>
          </tr>
        </thead>

        <tbody class="body">
 
          <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
          <tr v-for="(item,index) in list" v-bind:key="index" @click.prevent="goDetail(item.qa_no)" style="cursor: pointer;">
            <td>{{ item.u_no }}</td>
            <td>{{ item.user_name }}</td>
            <td>{{ item.user_id }}</td>
            <td> 가입일 출력되어야 함</td>
            <td> 선택</td>
          </tr>


        </tbody>
      </table>

       <!-- 페이지 이동 -->
       <div class="page">
        <ul>
          <li>
            <!-- 맨앞으로 가기 -->
            <router-link :to="{path: '/20?page=1&amount='+amount}" @click="goFirstPage">
              <i class="fa fa-angle-double-left" aria-hidden="true">&lt;&lt;</i>
            </router-link>
          </li>

          <!-- 앞으로 가기 -->
            <li style="margin-right:5px;">
              <router-link :to="{path: '/20?page='+page+'&amount='+amount}" @click="goBeforePage">
                <i class="fa fa-angle-left" aria-hidden="true">&lt;</i>
              </router-link>
            </li>

           <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
          <div v-for="(item, index) in pageList" :key="index" class="page_btn">
            <li v-bind:class="{ 'on' : item === page}">
              <router-link :to="{path: '/20?page='+page+'&amount='+amount}" @click="thisPage($event.target)">
                {{item}}
              </router-link>
            </li>
          </div>              

          <!-- 뒤로 가기 -->
					<li style="margin-left:5px;">
            <router-link :to="{path: '/20?page='+page+'&amount='+amount}" @click="goNextPage">
              <i class="fa fa-angle-right" aria-hidden="true">&gt;</i>
            </router-link>
          </li>

          <!-- 맨뒤로 가기 -->
					<li>
            <router-link :to="{path: '/20?page='+realEnd+'&amount='+amount}" @click="goLastPage">
              <i class="fa fa-angle-double-right" aria-hidden="true">&gt;&gt;</i>
            </router-link>
          </li>

				</ul>
			</div>


    </div>
  </div>

</template>

<script>
import Axios from 'axios';

export default {
  name: 'App',
  
  data(){
    return {

      //공용
      list : '',    //게시글리스트
      pages : '',   //pageVO
      pageList:'',  //pageVO.pageList 배열값
      detailNum:'',

      //페이지이동에 필요한 초기값들
      page: 1,
      amount: 10,
      searchTitle: '',
      searchContent: '',
      prev:'',
      pageStart:'',
      pageEnd:'',
      realEnd:''
      
    }
  },

  watch: {
    'amount': function(){
      this.get();
    }
  },

  methods:{

    async getList(){
      //console.log(this.list_view);

      //화면에 리스트 출력을 위해 필요한 내용 전달
      let response = await Axios.get("/20?amount="+this.amount+"&page="+this.page+"&searchTitle="+this.searchTitle+"&searchContent="+this.searchContent);
      console.log(response.data.list);
    
      //필요한 공용 데이터를 담기
      this.list = response.data.list;
      this.pages = response.data.pageVO;
      console.log(this.pages);
      this.pageList = this.pages.pageList;
      console.log(this.pageList);
      

      //페이지이동에 필요한 데이터 담기
      this.page = this.pages.page;
      this.searchTitle = this.pages.cri.searchTitle;
      this.searchContent = this.pages.cri.searchContent;
      this.prev = this.pages.prev;
      this.pageStart = this.pages.pageStart;
      this.pageEnd = this.pages.pageEnd;
      this.realEnd = this.pages.realEnd;

    },

    //페이지 이동에 필요한 메서드
    goFirstPage(){
      this.page = 1;
      this.get();
    },

    goBeforePage(){
      if(this.page > 1){
        this.page = this.page-1;
      }else{
        alert("첫번째 페이지입니다.");
      }
    },
    
    thisPage(target){

      this.page = target.innerHTML;
      this.get();

    },  

    goNextPage(){

      if(this.page < this.realEnd){
        this.page = this.page +1;
        this.get();
      }else{
        alert("마지막 페이지입니다.");
      }
    },

    goLastPage(){
      this.page=this.realEnd;
      this.get();
    },



  },
  mounted(){
    this.getList();
  }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
* {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; box-sizing: border-box;}


.main {
  margin: 100px 0 0 200px;
  padding: 30px;
}

  .container {
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
  }

  .container select{
    float: left;
    margin: 10px 0;
  }

  .searchBox{
    float: right;
    margin: 10px 0;
  }

  .list {
    width: 100%;
    border-collapse: collapse;
    border-spacing: 0;
  }

  .head {
    background-color: #f5f5f5;
    text-align: center;
  }

  .head th {
    padding: 1em;
  }

  .body tr:nth-child(even) {
    background-color: #f9f9f9;
  }

  .body td {
    padding: 1em;
    text-align: center;
    border-bottom: 1px solid #ddd;
  }

  .body td a {
    color: #333;
    text-decoration: none;
  }

  .body td a:hover {
    text-decoration: underline;
  }


  .serch_box{
    margin-top: 20px;
    display: flex;
    justify-content: space-around;
  }

  .serch_box select,input,button{
    padding: 5px;
    margin: 5px;
  }

  .serch_box input{
    width: 50%;
    border-radius: 35px;
    border: 1px solid #ddd;
  }

  .serch_box button {
    width: 10%;
    background-color: orange;
    border: none;
    color: white;
    font-size: 16px;
  }

  .page {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
  }

  .page ul {
    display: flex;
    align-items: center;
    list-style: none;
  }

  .page li {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    font-size: 14px;
    margin: 0 5px;
    cursor: pointer;
    background-color: #fff;
    border: 1px solid #ccc;
  }

  .page li.on {
    font-weight: bold;
    color: #fff;
    background-color: #007bff;
    border-color: #007bff;
  }

  .page i {
    font-size: 14px;
    margin: 0;
    padding: 0;
    line-height: 1;
  }

  .page_btn {
    display: flex;
    justify-content: center;
    align-items: center;
  }

</style>

