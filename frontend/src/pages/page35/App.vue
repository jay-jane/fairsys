
<!-- Q&A 페이지 -->



<template>




   <div class="admin_nav">
    <ul>
      <li class="sub_menu_toggle">
        <a class="sub menu select">채용공고</a>
        <ul class="sub_menu" style="display: block;">
          <li><a href="page7">공고 등록</a></li>
          <li><a href="page8">공고 수정</a></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">이력서</a>
        <ul class="sub_menu">
          <li><a href="page6">이력서 리스트</a></li>
          <li><a href="#"></a></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">쪽지</a>
        <ul class="sub_menu">
          <li><a href="#">쪽지 작성</a></li>
          <li><a href="#">쪽지 보관함</a></li>
        </ul>
      </li>

      <li class="sub_menu_toggle">
        <a href="#">Q&A</a>
        <ul class="sub_menu">
          <li><a href="#">Q&A 등록</a></li>
          <li><a href="#">Q$A 관리</a></li>
        </ul>
      </li>
    </ul>
  </div>

<div class="content_main">
  <div class="content">
    <table>
   <caption>채용공고 현황</caption>
      
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>마감일</th>
            <th>
            <select name="" id="salary">
            <option value="">전체</option>
            <option value="">채용 전</option>
            <option value="">진행중</option>
            <option value="">채용마감</option>
          </select>
        </th>
        <th>조회</th>
            </tr>
        </thead>
        <tbody id="table-body">
            <tr>
                <td>1</td>
                <td>2</td>
                <td>2023-03-06</td>
                <td>진행상황</td>
                <td><input type="submit" value="목록조회" class="view"></td>
            </tr>

        </tbody>
      </table>
  </div>

  
  <table>
   <caption>지원자 관리 </caption>
      
        <thead>
            <tr>
                <th>번호</th>
                <th>채용 공고명</th>
                <th>
            <select name="" id="salary">
            <option value="">전체</option>
            <option value="">합격</option>
            <option value="">불합격</option>
          </select>
                </th>
                <th>지원자 조회</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>진행상황</td>
                <td>4</td>
            </tr>
        </tbody>
      </table>

    </div>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');

* {margin: 0; padding: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none; color: black;}



.admin_account {
  margin-right: 20px;
}

.admin_account span{
  color: white;
  margin-right: 20px;
}

.admin_nav {
  width: 200px;
  height: 100%;
  position: fixed;
  top: 100px;
  left: 0;
  background-color: white;
}

  .admin_nav li{
    margin-top: 20px;
    list-style: none;
  }

  .admin_nav li a {
      padding: 8px 20px;
      text-decoration: none;
      font-size: 15px;
      color: orange;
      display: block;
      width: 200px;
      font-weight: 600;
  }

  .admin_nav .sub_menu {margin-left: 25px;}
  .admin_nav .sub_menu li a {color: black; display: block; width: 155px; padding: 8px 10px 8px 10px; }
  .admin_nav .sub_menu li a:hover { background-color: orange;}
  .admin_nav .sub_menu li a.on {background-color: orange;}  
  
  table {
    width: 1150px;
    text-align: center;
    border: 1px solid #fff;
    border-spacing: 1px;
    font-family: 'Cairo', sans-serif;
  margin: auto;
}

caption {
    font-weight: bold;
}

table td {
    padding: 10px;
    background-color: #eee;
}

table th {
    background-color: #d1cece;
    color: #000;
    padding: 10px;
  
}


.view, .delete {
    border: none;
    padding: 5px 10px;
    color: #fff;
    font-weight: bold;
}

.view {
    background-color: #000;
}

.content_main {
  margin-left: 50px;
}

</style>
