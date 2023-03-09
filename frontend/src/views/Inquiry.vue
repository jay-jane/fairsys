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
            <td><router-link to="/databinding">문의 1개 드립니다. 왜 서류 합격이 안뜨죠?</router-link></td>
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
    name:'inquiry',
    methods: {
        inquiry(){
        location.href ="#";
        }
  }
}

</script>