
<template>
<table>
        <caption>지원자 리스트</caption>
        <thead>
            <tr>
                <th>번호</th>
                <th>공고제목</th>
                <th>이름</th>
                <th>성별</th>
                <th>목록</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>3</td>
                <td>
                  <button class="view" @click="btn_view">view</button>
                  <input type="submit" value="delete" class="delete">
                </td>
            </tr>

            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>3</td>
                <td>
                  <button class="view" @click="btn_view">view</button>
                  <input type="submit" value="delete" class="delete">
                </td>
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
    background-color: #333;
    color: #fff;
    padding: 10px;
}


.view, .delete {
    border: none;
    padding: 5px 10px;
    color: #fff;
    font-weight: bold;
}

.view {
    background-color: #03A9F4;
}

.delete {
    background-color: #E91E63;
}

</style>
