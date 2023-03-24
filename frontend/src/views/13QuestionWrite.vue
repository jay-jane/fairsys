<template>

  <div class="content">

    <div class="container">

      <h1>문의사항 등록</h1>

      <table class="list">

        <tbody class="body">

          <tr>
            <td>회사</td>
            <td>
              <select v-model="com_id" @change="selectCompany">
                <!-- 회사정보 가져와서 value와 태그사이 둘다입력 필요 -->
                <option value="0">문의할 회사를 선택해 주세요.</option>
                <option v-for="(item, index) in list"> {{ item.name }}</option>
              </select>
            </td>
          </tr>

          <tr>
            <td>제목</td>
            <td><input type="text" v-model="qa_title"></td>
          </tr>
    
          <tr>
            <td>내용</td>
            <td><textarea cols="30" rows="20" v-model="qa_content"></textarea></td>
          </tr>

        </tbody>
      </table>
      
      <button class="btn btn-primary" @click="doRegist">등록하기</button>
      <button class="btn btn-secondary" @click="doCancel">취소하기</button>

    </div>
  </div>

</template>

<script>
import Axios from 'axios';
import axios from 'axios';


export default {
  name: 'App',
  data(){
    return{

      //공용
      test:'',
      company:0,
      list:[{ id: '' , name: ''}],
      
      //전달데이터
      qa_title:'',           //제목 
      qa_content:'',         //내용
      user_id:'',            //유저아이디
      com_id:0               //회사아이디
    }
  },
  created(){

  },  
  methods:{

    async get(){

      this.user_id = sessionStorage.getItem("user_id");
      let res = await Axios.get("/13?user_id=" + this.user_id);
      res = res.data;
      console.log(res);
      for(var i = 0; i < this.list.length; i++){
        this.list= [{
          id: res[i].com_id,
          name: res[i].com_name
        }]
      }

      console.log(this.list);

    },  

    doLogout(){
      location.href ="/";
    },

    doCancel(){
      location.href = "/11";
    },

    selectCompany(event){
      this.company = this.list.find(item => item.name === this.com_id).id;
    },
    //글작성 처리
    doRegist(){

      this.axios.post("/13", 
        {
          qa_title: this.qa_title,
          qa_content: this.qa_content,
          user_id: sessionStorage.getItem("user_id"),
          com_id: this.company
        })
        .then(res => {
          console.log(res.data);
        })
        .catch(err => {
          console.log(err);
        });

      location.href= "/11";
    }
  },
  mounted(){

    this.get();

  }
}

</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black; overflow: auto;}
  
.content {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
}

.container {
  width: 60%;
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

.btn {
  display: inline-block;
  padding: 10px 20px;
  border-radius: 5px;
  font-size: 1rem;
  color: #fff;
  text-align: center;
  text-decoration: none;
  background-color: #007bff;
  border: none;
  cursor: pointer;
  transition: background-color 0.2s ease;
}

.btn-secondary {
  background-color: #6c757d;
  margin-left: 10px;
}

.btn:hover {
  background-color: #0069d9;
}

.btn-secondary:hover {
  background-color: #5a6268;
}

select {
  width: 100%;
  text-align: left;
}

input {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  resize: none;
  padding: 0 10px;
  text-align: left;
}

textarea {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  resize: none;
  padding: 10px;
  text-align: left;
}


</style>

