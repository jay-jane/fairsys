<!-- 재윤 - 전체 공고 목록 -->
<template>
  <header>
    <ul class="head">
      <li>메인로고</li>
      <li><a href="page7">등록</a></li>
      <li>공고 관리</li>
      <li>마이페이지</li>
      <li>로그인/로그아웃</li>
    </ul>
  </header>

  <section>
    <h3>채용 공고 목록 페이지</h3>
    <div>
      <ul>
        <li>
          <table cellpadding="0" cellspacing="0" class="col_14" width="100%;">
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>보낸 사람</th>
              <th>받은 일자</th>
            </tr>

            <tr>
              <td>1</td>
              <td>1</td>
              <td>1</td>
              <td>1</td>
            </tr>
          </table>
        </li>
      </ul>
    </div>
    <div>
      <span>페이지네이션</span>
    </div>
    <div>
      <div>검색기능</div>
      <a href="page1">메인</a>
    </div>
  </section>

  <footer style="text-align: center;">
    푸푸푸푸<br>
    터터터터
  </footer>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
/* header */
header {
  background-color: #f7f7f7;
  padding: 10px;
}

.head {
  list-style: none;
  display: flex;
  justify-content: space-between;
}

.head li {
  font-size: 16px;
  margin-right: 20px;
}

.head li:first-child {
  font-size: 24px;
  font-weight: bold;
}

.head li:last-child {
  margin-right: 0;
}

.head a {
  color: #333;
  text-decoration: none;
}

.head a:hover {
  text-decoration: underline;
}

/* section */
section {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h3 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

ul {
  list-style: none;
  padding: 0;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

th {
  font-size: 16px;
  font-weight: bold;
  text-align: left;
  padding: 10px 0;
  border-bottom: 1px solid #ccc;
}

td {
  font-size: 14px;
  padding: 10px 0;
  border-bottom: 1px solid #ccc;
}

td:first-child {
  width: 10%;
}

td:last-child {
  width: 30%;
}

/* pagination */
.pagination {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.pagination li {
  margin: 0 5px;
}

.pagination li a {
  display: block;
  padding: 5px 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  text-decoration: none;
  color: #333;
}

.pagination li.active a {
  background-color: #333;
  color: #fff;
}

/* search */
.search {
  margin-bottom: 20px;
}

.search input[type="text"] {
  width: 200px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.search input[type="submit"] {
  padding: 5px 10px;
  border: none;
  border-radius: 5px;
  background-color: #333;
  color: #fff;
  cursor: pointer;
}

/* footer */
footer {
  background-color: #f7f7f7;
  padding: 20px;
  text-align: center;
  font-size: 14px;
}

</style>

