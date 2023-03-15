<template>

  <div class="content">
    <div class="table_border">
      <h1>문의사항 등록</h1>
      <table class="registration">
        <tr>
          <td>회사</td>
          <td>
            <select name="" id="">
              <option value="">선택한 회사1</option>
              <option value="">선택한 회사2</option>
              <option value="">선택한 회사3</option>
              <option value="">선택한 회사4</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" ></td>
        </tr>
  
        <tr>
          <td>내용</td>
          <td><textarea class="input-style" ></textarea></td>
        </tr>
  
        <tr>
          <td></td>
          <td>
            <button class="btn btn-primary">등록하기</button>
            <button class="btn btn-secondary" @click="doCancel">취소하기</button>
          </td>
        </tr>
      </table>
    </div>
  </div>

</template>

<script>

export default {
  name: 'App',
  data(){
    return{
      test:''
    }
  },
  created(){

  },  
  methods:{
    doLogout(){
      location.href ="page2";
    },
    doCancel(){
      location.href = "/11";
    }
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black; overflow: auto;}
  
.content {
  width: 100%;
  max-width: 1200px;
  margin: 0 auto;
  padding: 40px 20px;
}

.table_border {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
}

h1 {
  margin: 0;
  font-size: 2rem;
  font-weight: bold;
  text-align: center;
}

.registration {
  margin: 30px auto;
  width: 100%;
  max-width: 700px;
  border-collapse: collapse;
}

.registration td {
  padding: 10px;
}

.registration td:first-child {
  font-weight: bold;
  width: 120px;
}

input[type="text"],
textarea {
  width: 100%;
  padding: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
  resize: none;
  font-size: 1rem;
}

.btn {
  display: inline-block;
  padding: 10px 20px;
  border-radius: 5px;
  font-size: 1rem;
  font-weight: bold;
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



</style>

