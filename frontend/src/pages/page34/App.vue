
<!-- Q&A 페이지 -->

<template>
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
      <hr/>

      <table>
   <caption>지원자 관리 </caption>
      
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>마감일</th>
                <th>진행상태</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
            </tr>
        </tbody>
      </table>

      
</template>

<script>
export default {
  name: 'App',
  methods: {
    btn_view() {
      location.href = "page32";
    }
  },
 
  data() {
      return {
        userId: '',
        passWd: ''
      }
  }
}

</script>


<style>
table {
    width: 1500px;
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


</style>