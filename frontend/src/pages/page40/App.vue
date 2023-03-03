
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
    <h2>문의사항 등록하기</h2>
    <ul>
      <li>회사
          <select name="" id="">
            <option>지원한 회사1</option>
            <option>지원한 회사2</option>
            <option>지원한 회사3</option>
          </select>
      </li>
      <li>제목 <input type="text"></li>
      <li>내용 <textarea name="aaa" id="" cols="30" rows="10"></textarea></li>
      <input type="submit" value="등록하기">
      <input type="button" value="취소하기" @click="goback">
    </ul>
  </div>

</template>

<script>

export default {
  name: 'App',
  methods:{
    goback: function(){
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

