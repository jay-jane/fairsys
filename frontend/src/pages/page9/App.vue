
<template>

  <nav id="top">
    <ul>
      <li><a href="page1"><img src="page1"></a></li>
      <li><a href="#">채용정보</a></li>
      <li><a href="#">기업/연봉</a></li>
      <li><a href="#">마이페이지</a></li>
      <li><a href="page2">로그인</a></li>
    </ul>
  </nav>

  <div class="btn-group">
    <button class="btn" @click="showNotice">Q&A</button>
    <button class="btn" @click="showQna">문의내역</button>
  </div>
  
  <div>
    <div class="container">

      <table class="list">
        <thead class="head">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
          </tr>
        </thead>

        <tbody class="body">
          <tr>
            <td>1</td>
            <td><a href="">사이트 이용 안내 </a></td>
            <td>2023.03.02</td>
          </tr>
          <tr>
            <td>2</td>
            <td>사이트 이용 안내 </td>
            <td>2023.03.02</td>
          </tr>
          <tr>
            <td>3</td>
            <td>사이트 이용 안내 </td>
            <td>2023.03.02</td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>
  
  <div id="bottom">


  </div>
</template>

<script>

export default {
  name: 'App',
  
  methods: {
    showNotice() {
      location.href ="page9";
    },
    showQna() {
      location.href ="page10";
    }
  }
};
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

  /* 리스트 디자인 */

/* 콘텐츠화면 */
.container {
    width: 1200px;
    border: 1px solid black;
    text-align: center;
 }

  table {
    border:0;
    padding:0;
    margin:0;
  }

  table caption { 
    display:none; 
  }


  .list { 
    display: table;
    clear:both; 
    width:1200px; 
    border-collapse: collapse; 
  }
            
  .list th { 
    border-color:#333333; 
    background: #fcfcfc;
    padding:10px 0 10px 0; 
    text-align:center; 
    border-top-width: 2px;
    border-bottom-width: 1px;
    border-top-style: solid;
    border-bottom-style: solid;
    font-weight: 400;
  }

  .list .body td {
    text-align: center;
    padding:5px 9px 5px 9px; 
    border-bottom-color: #eeeeee;
    border-bottom-width: 1px;
    border-bottom-style: solid;
  }

  .btn-group{
    text-align: center;
  }
</style>

