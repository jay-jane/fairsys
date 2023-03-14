
<template>

  <div class="main">
    <div class="container">

      <h2>문의하기</h2>

      <!-- 출력 카테고리 -->
      <select v-model="list_view" class="view" @change="loglist_view">
        <option value="10">10개 보기</option>
        <option value="20">20개 보기</option>
        <option value="30">30개 보기</option>
      </select>

      <button @click="inquiry" class="btn btn-primary btn_write">문의작성하기</button>

      <table class="list">
        <thead class="head">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>답변상태</th>
          </tr>
        </thead>

        <tbody class="body">

          <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
          <tr v-for="(item,index) in list">
            <td>{{ item.qa_no }}</td>
            <td><router-link to="#">{{ item.qa_title }}</router-link></td>
            <td>{{ item.user_id }}</td>
            <td>{{ item.qa_date }}</td>
            <td>{{ item.qa_answer }}</td>
          </tr>

        </tbody>
      </table>

      <div class="serch_box">
        <select name="" id="">
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
        <input type="text">
        <button>검색</button>
      </div>

      <!-- 페이지 이동 -->
      <div class="page">
				<ul>
          <!-- 맨앞으로 가기 -->
					<li>
            <a href="#">
              <i class="fa fa-angle-double-left" aria-hidden="true"></i>
            </a>
          </li>
          <!-- 앞으로 가기 -->
					<li style="margin-right:5px;">
            <a href="#">
              <i class="fa fa-angle-left" aria-hidden="true"></i>
            </a>
          </li>

					<li class="on"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>

          <!-- 뒤로 가기 -->
					<li style="margin-left:5px;">
            <a href="#">
              <i class="fa fa-angle-right" aria-hidden="true"></i>
            </a>
          </li>
          <!-- 맨뒤로 가기 -->
					<li>
            <a href="#">
              <i class="fa fa-angle-double-right" aria-hidden="true"></i>
            </a>
          </li>

				</ul>
			</div>

    </div>
  </div>

</template>

<script>
import  Axios from 'axios';

export default {
  el: '#App',
  data(){
    return {
      qa_no : 1,
      qa_title : "작성된 글이 없습니다.",
      list : '',
      list_view : 10
    }
  },  

  watch: {
    'list_view': function(){
      this.get();

    }
  },

  methods: {
    inquiry(){
      location.href ="/13";
    },

    async get(){
      console.log(this.list_view);
      let response = await Axios.get("/11/amount?page="+ 1 +"&amount=" + this.list_view  );
      this.list = response.data;
      
      // then((response)=>{
      //   //데이터전달
      //   this.list = response.data;
      //   //this.list_view = this.list_view;
      //   //console.log(response.data.length);
      //   //console.log(this.list);
      // })
      // .catch((err)=>{
      //   console.log(err);
      // })
    },

    loglist_view(){
      this.list_view = this.list_view;
      //this.$forceUpdate();
    }

  },
  mounted(){
    this.get();
    this.loglist_view();
  }
};
</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

  * {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none;}

/* 문의사항 목록  */

.main {
  display: flex;
  justify-content: center;
  height: auto;
}

  .container {
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
  }

  .container h2{
  margin: 20px 0;
  }

  .btn_write{
    float: right;
    margin: 10px 0;
    border-radius: 3px;
    font-size: 16px;
    font-weight: 500;
    background-color: orange;
    color: #fff;
    border: none;
    padding: 10px 20px;
  }

  .view{
    float: left;
    margin: 10px 0;
    padding: 10px 20px;
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

  .head th:first-child {
    border-top-left-radius: 10px;
  }

  .head th:last-child {
    border-top-right-radius: 10px;
  }

  .body tr:nth-child(even) {
    background-color: #f9f9f9;
  }

  .body td {
    padding: 1em;
    text-align: center;
    border-bottom: 1px solid #ddd;
  }

  .body td:first-child {
    border-left: 1px solid #ddd;
    border-bottom-left-radius: 10px;
  }

  .body td:last-child {
    border-right: 1px solid #ddd;
    border-bottom-right-radius: 10px;
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
  }

  .page{padding:30px 0 20px 0;position:relative;}
  .page ul{text-align:center;}
  .page ul li{display:inline;  padding:0px!important;}
  .page ul li a{display:inline-block; zoom:1;*display:inline; width: 35px; height: 35px; line-height: 35px; color:#777777; border:1px solid #dddddd;transition:all 0.25s ease-in-out;-webkit-transition:all 0.25s ease-in-out;font-size:15px;}
  .page ul li a:hover, .page ul li.on a{display:inline-block;zoom:1;*display:inline; border:1px solid #7866c9;background:#fff;color:#7866c9;}
  .page ul li a i{color:#777777;}
  .page ul li a:hover i{color:#7866c9;}

</style>

