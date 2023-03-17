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
          <tr>
            <td>1</td>
            <td>오하영</td>
            <td>ohy1234</td>
            <td>2023.03.02</td>
            <td><a href="#">선택</a></td>
          </tr>
          <tr>
            <td>2</td>
            <td>오하영</td>
            <td>ohy1234</td>
            <td>2023.03.02</td>
            <td><a href="#">선택</a></td>
          </tr>
          <tr>
            <td>3</td>
            <td>오하영</td>
            <td>ohy1234</td>
            <td>2023.03.02</td>
            <td><a href="#">선택</a></td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>

</template>

<script>
import Axios from 'axios';

export default {
  name: 'App',
  
  data(){
    return {

      //공용 데이터

      //페이지 이동에 필요한 데이터
      amount: 10,

    }
  },

  methods:{

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

</style>

