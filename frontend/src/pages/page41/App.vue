
<template>

<Header></Header>
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

  <Footer></Footer>

</template>

<script>
import Header from '../../components/layout/Header/Header.vue'
import Footer from '../../components/layout/Footer/Footer.vue'


export default {
  name: 'App',
  methods:{
    golist(){
      location.href = "page10";
    }
  },
  components: {
    Header,
    Footer
  }
}
</script>

<style>

</style>

