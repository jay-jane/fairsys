
<!-- Q&A 페이지 -->

<template>
  <!-- 여기는 상단바 -->
  <header id="header">


    <!-- 메뉴바 -->
    <div id="menu">
      <ul>
        <!-- 로고 -->
        <li><img src="#"></li>
        <li><a href="http://localhost:8081/page14">채용정보</a></li>
        <li><a href="http://localhost:8081/page15">기업/연봉</a></li>
        <li><a href="http://localhost:8081/page12">마이페이지</a></li>
        <li><a href="http://localhost:8081/page2">로그인</a></li>
      </ul>
    </div>

    <!-- 로그인버튼 -->

  </header>


  <section id="section">

    <ul id="section_menu">
      <li>번호</li>
      <li>회사 이름</li>
      <li>제목</li>
      <li>시작일</li>
      <li>마감일</li>
    </ul>

    <tbody>
      <tr>
        <th>1</th>
        <td>1</td>
        <td>1</td>
        <td>1</td>
      </tr>
      <br>
      <tr>
        <th>2</th>
        <td>2</td>
        <td>2</td>
        <td>2</td>
      </tr>
      <br>
      <tr>
        <th>3</th>
        <td>3</td>
        <td>3</td>
        <td>3</td>
      </tr>
      <br>
      <tr>
        <th>4</th>
        <td>4</td>
        <td>4</td>
        <td>4</td>
      </tr>
      <br>
      <tr>
        <th>5</th>
        <td>5</td>
        <td>5</td>
        <td>5</td>
      </tr>

    </tbody>

 
  </section>

  <!-- 여기는 하단바 -->
  <footer id="footer">
    저작권 정보?

  </footer>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  list-style: none;
  text-align: center;
}

#header {}

#menu li {
  display: inline;
  padding-left: 20px;
}



#section_menu {
  display: flex;
  justify-content: center;
}

tr{
  display: flex;
  justify-content: center;
}

#footer {
  height: 200px;
}
</style>
