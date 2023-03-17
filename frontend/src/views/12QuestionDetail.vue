<template>

  <div class="content">
    
    <div class="container">

      <h1>문의 상세내용</h1>

      <table class="list">

        <tbody class="body">
          <tr>
            <td>문의회사</td>
            <td>{{list.com_id}}</td>
          </tr>
          <tr>
            <td>글제목</td>
            <td>{{list.qa_title}}</td>
          </tr>
          <tr>
            <td>내용</td>
            <td>{{ list.qa_content }}</td>
          </tr>
        </tbody>
      </table>

      <!-- 유저 답변이 있을 경우 -->
      <table class="list">
        <tbody class="body">
          <tr>
            <td>답변</td>
            <td>내가 받은 답변이 출력된다</td>
          </tr>
        </tbody>
      </table>

      <button @click="golist" class="goList">목록으로</button>

      <!-- 회사계정으로 접속한 경우1. 미답변상태일경우 -->

      <table class="list" style="display: none;">
        <tbody class="body">
          <tr>
            <td>답변상태</td>
            <td>
              <select name="" id="">
                <option value="">답변대기</option>
                <option value="">답변완료</option>
              </select>
            </td>
          </tr>

          <tr>
            <td>내용</td>
            <td>
              <textarea name="" id="" cols="30" rows="10"></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <button class="goList" style="display: none;">답변하기</button>
    </div>

  </div>


</template>

<script>
import  Axios from 'axios';

export default {
  name: 'App',
  data(){
    return{
      qa_no : '',
      list : ''
    }
  },
  methods:{

    async getDetail(){
      this.qa_no = this.$route.params.qa_no;
      let response = await Axios.get("/12/"+ this.qa_no);
      this.list = response.data;
      this.list = this.list[0];
    },

    golist(){
      location.href = "/11";
    }
  },mounted(){
    this.getDetail();
  }
}
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black;}
  
.content {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
}

.container {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  background-color: white;
  padding: 30px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 0.5rem;
}

h1 {
  font-size: 2.5rem;
  margin-bottom: 2rem;
  float: left;
}

table.list {
  width: 100%;
  margin-bottom: 2rem;
  border-collapse: collapse;
  border: 1px solid #ccc;
  background-color: white;
}

td {
  padding: 1rem;
  border: 1px solid #ccc;
}

tbody.body td:first-child {
  font-weight: bold;
  width: 20%;
}

tbody.body td:last-child{
  text-align: left;
}

.goList{
  background-color: #007bff;
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 0.25rem;
  border: none;
  font-size: 1rem;
  cursor: pointer;
  margin: 1rem 0;  
}

.goList:hover {
  background-color: #0069d9;
}

select {
  width: 100%;
}

input[type="submit"] {
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-size: 16px;
  padding: 10px 20px;
}

textarea {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  resize: none;
  padding: 20px;
  text-align: left;
}

</style>

