
<template>
  
  <h1>Q&A 관리</h1>
  <div class="btn-group">
    <button>전체삭제</button>
    <button>선택삭제</button>
  </div>
  <div class="main">    
    <div class="container">  
      <table class="list">
        <thead class="head">
          <tr>
            <th>선택</th>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
            <th>수정하기</th>
          </tr>
        </thead>

        <tbody class="body">
          <tr>
            <td><input type="checkbox"></td>
            <td>1</td>
            <td><a href="">사이트 이용 안내 </a></td>
            <td>2023.03.02</td>
            <td><a href="#">수정하기</a></td>
          </tr>
          <tr>
            <td><input type="checkbox"></td>
            <td>2</td>
            <td>사이트 이용 안내 </td>
            <td>2023.03.02</td>
            <td><a href="#">수정하기</a></td>
          </tr>
          <tr>
            <td><input type="checkbox"></td>
            <td>3</td>
            <td>사이트 이용 안내 </td>
            <td>2023.03.02</td>
            <td><a href="#">수정하기</a></td>
          </tr>
        </tbody>
      </table>

    </div>
  </div>

</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none;}

.main {
  display: flex;
  justify-content: center;
  height: 600px;
  margin-bottom: 50px;
}

  .container {
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
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

  .btn-group{
    display: flex;
    justify-content: left;
    margin: 0 auto;
    width: 800px;
    text-align: center;
  }

</style>

