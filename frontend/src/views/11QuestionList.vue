
<template>

  <div class="main">
    <div class="container">

      <h2>문의하기</h2>
      <button @click="inquiry" class="btn btn-primary">문의작성하기</button>

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
          <tr>
            <td>1</td>
            <td><router-link to="/test1">문의 1개 드립니다. 왜 서류 합격이 안뜨죠?</router-link></td>
            <td>오하영</td>
            <td>2023.03.02</td>
            <td>미답변</td>
          </tr>
          <tr>
            <td>2</td>
            <td>문의 1개 드립니다. 왜 서류 합격이 안뜨죠?</td>
            <td>오하영</td>
            <td>2023.03.02</td>
            <td>미답변</td>
          </tr>
          <tr>
            <td>3</td>
            <td>문의 1개 드립니다. 왜 서류 합격이 안뜨죠?</td>
            <td>오하영</td>
            <td>2023.03.02</td>
            <td>미답변</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

</template>

<script>

export default {
  name: 'App',

  methods: {
    inquiry(){
      location.href ="page43";
    }
  },
};
</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

  * {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none;}

/* 문의사항 목록  */

.main {
  display: flex;
  justify-content: center;
  height: 600px;
}

  .container {
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
  }

  .container h2{
  margin: 20px 0;
  }

  .container button{
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


</style>

