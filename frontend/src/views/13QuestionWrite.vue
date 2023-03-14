<template>

  <div class="content">

    <h1>문의사항 등록</h1>
    <div class="table_border">
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
          <td><input type="text" name="" id="" style="width: 870px; height: 50px;" ></td>
        </tr>
  
        <tr>
          <td>내용</td>
          <td><textarea name="" id="" class="input-style" ></textarea></td>
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
  methods:{
    doLogout(){
      location.href ="page2";
    },
    doCancel(){
      location.href = "#";
    }
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black;}
  
.content {
  margin-left: 200px;
  height: 100%;
}

.content h1 {
  margin: 20px auto;
  padding: 8px 20px;
}

.table_border {
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
  margin: 0 auto;
  width: 75%;
  padding: 20px;
}

.registration {
  margin: 0 auto;
  font-size: 16px;
}

.registration td {
  padding: 10px;
  text-align: center;
}

.input-style {
  width: 850px;
  height: 400px;
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
  resize: none;
  font-size: 16px;
}

.btn {
  padding: 10px 20px;
  border-radius: 3px;
  font-size: 16px;
  font-weight: 500;
  font-family: 'Noto Sans KR', sans-serif;
}

.btn-primary {
  background-color: orange;
  color: #fff;
  border: none;
  margin-right: 10px;
}

.btn-primary:hover {
  background-color: orangered;
}

.btn-secondary {
  background-color: #f8f9fa;
  color: #212529;
  border: 1px solid #ccc;
}

.btn-secondary:hover {
  background-color: #e9ecef;
  border-color: #adb5bd;
}

</style>

