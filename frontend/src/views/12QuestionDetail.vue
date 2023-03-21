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
      <table class="answer_list">
        <tbody class="body">
          <tr>
            <td>답변</td>
            <td>{{list.qa_answer}}</td>
          </tr>
        </tbody>
      </table>

      <button @click="golist" class="goList">목록으로</button>

      <!-- 회사계정으로 접속한 경우1. 미답변상태일경우 -->

      <table class="com_list" style="display: none;">
        <tbody class="body">
          <tr>
            <td>답변상태</td>
            <td>
              <select v-model="qa_answertype">
                <option value="N">답변대기</option>
                <option value="Y">답변완료</option>
              </select>
            </td>
          </tr>

          <tr>
            <td>내용</td>
            <td>
              <textarea v-model="qa_answer"></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <button class="btn_answer" style="display: none;" @click="doAnswer">답변하기</button>
    </div>

  </div>


</template>

<script>
import  Axios from 'axios';

export default {
  name: 'App',
  data(){
    return{

      //공용
      user_id:'', //유저아이디
      com_id:'', //기업아이디
      ut_no:sessionStorage.getItem("ut_no"),     //유저타입

      qa_no : '',
      list : '',

      //전달데이터
      qa_answertype:'',
      qa_answer:''
    }
  },
  methods:{

    async getDetail(){
      // console.log("유저아이디>" + this.user_id);
      // console.log("유저타입>" + this.ut_no);
      // console.log(this.ut_no == 1);

      //ut_no가 1 유저라면
      if(this.ut_no == 1){

        this.qa_no = this.$route.params.qa_no;
        this.user_id = sessionStorage.getItem("user_id");

        let response = await Axios.get("/12/"+ this.qa_no +"/?user_id=" +this.user_id + "&com_id=" + this.com_id);
        this.list = response.data;
        this.list = this.list[0];

      }else{ //ut_no가 2 회사라면

        const answer_list = document.querySelector(".answer_list");
        answer_list.style = "display:none";

        const com_list = document.querySelector(".com_list");
        com_list.style = "display:block";

        const btn_answer = document.querySelector(".btn_answer");
        btn_answer.style = "display:block";

        //데이터받아오기
        this.qa_no = this.$route.params.qa_no;
        this.com_id = sessionStorage.getItem("com_id");


        let response = await Axios.get("/12/"+ this.qa_no +"/?user_id=" +this.user_id + "&com_id=" + this.com_id);
        this.list = response.data;
        this.list = this.list[0];


      }
    },

    golist(){
      location.href = "/11";
    },

    doAnswer(){

      // console.log(this.qa_answer);
      // console.log(this.qa_answertype);
      // console.log(this.qa_no);

      this.axios.post("/12_doRegistAnswer", {

        qa_no: this.qa_no,
        qa_answer: this.qa_answer,
        qa_answertype: this.qa_answertype

      })
      .then(res => {
        console.log(res.data);
      })
      .catch(err => {
        console.log(err);
      });

      location.href = '/11';
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

.answer_list{
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

.btn_answer{
  background-color: #007bff;
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 0.25rem;
  border: none;
  font-size: 1rem;
  cursor: pointer;
  margin: 1rem 0;  
}

</style>

