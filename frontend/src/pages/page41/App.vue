
<template>

  <nav id="top">
      <ul>
        <li><a href="#"><img src="#"></a></li>
        <li><a href="#">채용정보</a></li>
        <li><a href="#">기업/연봉</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">로그인</a></li>
      </ul>
  </nav>

  <div class="content">
    
    <div class="container">

      <table class="list">

        <tbody class="body">
          <tr>
            <td>문의회사</td>
            <td>내가 문의한 회사이름이 출력된다.</td>
          </tr>
          <tr>
            <td>글제목</td>
            <td>내가 쓴 글제목을 출력한다.</td>
          </tr>
          <tr>
            <td>내용</td>
            <td>내가 입력한 내용이 출력된다.</td>
          </tr>
        </tbody>
      </table>

      <hr/>
      <!-- 유저 답변이 있을 경우 -->
      <table class="list">
        <tbody class="answer">
          <tr>
            <td>답변</td>
            <td>내가 받은 답변이 출력된다</td>
          </tr>
        </tbody>
      </table>

      <button @click="golist">목록으로</button>

      <hr/>
      <!-- 회사계정으로 접속한 경우1. 미답변상태일경우 -->
      답변상태
      <select name="" id="">
        <option value="">답변대기</option>
        <option value="">답변완료</option>
      </select>
      <br/>
      내용
      <textarea name="" id="" cols="30" rows="10">

      </textarea>
      <br/>
      <input type="submit" value="답변하기">
    </div>

  </div>

</template>

<script>

export default {
  name: 'App',
  methods:{
    golist(){
      location.href = "page10";
    }
  }
}
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
</style>

