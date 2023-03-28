<template>
  <section>
    <div class="main">
      <div class="container">
            <h1>{{list.com_name}}</h1>

            <table class="list">
	            <tbody class="body">
		            <tr>
			            <th>회사대표</th>
			            <td>{{list.com_ceo}}</td>
		            </tr>
		            <tr>
			            <th>사업자번호</th>
			            <td>{{list.com_num}}</td>
		            </tr>
		            <tr>
			            <th>업종</th>
			            <td>{{list.com_category}}</td>
		            </tr>
                    <tr>
			            <th>회사주소</th>
			            <td>{{list.com_address}}</td>
		            </tr>
                    <tr>
			            <th>담당자</th>
			            <td>{{list.com_manager}}</td>
		            </tr>
                    <tr>
			            <th>담당자 번호</th>
			            <td>{{list.com_manager_phone}}</td>
		            </tr>
                </tbody>
            </table>

            <button class="btnn" @click="bye">목록</button>
        </div>
    </div>
  </section>
</template>

<script>

export default {
  name: 'App',
  data(){
    return{
      com_id : '',
      list : '',
    }
  },
  methods:{

    getDetail(){
      this.com_id = this.$route.params.com_id;
      this.axios.get("/50", {params: {"com_id": this.com_id}})
                .then(res => {
                  this.list = res.data[0];
                })
                .catch(err => console.log(err));
    },
   bye() {
      //location.href = "/19/1";

    this.$router.push("/19").catch(()=>{});

    
    },
},
mounted() {
  
  this.getDetail();
},
}
</script>
  
<style>
@import url("https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap");
* {
  padding: 0;
  margin: 0;
  font-family: "Noto Sans KR", sans-serif;
  text-decoration: none;
  box-sizing: border-box;
}

.main {
  margin: 100px 0 0 200px;
  padding: 30px;
}

.container {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
}

.container select {
  float: left;
  margin: 10px 0;
}

.searchBox {
  float: right;
  margin: 10px 0;
}

.list {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;

}

.head {
  background-color: #263238;
  text-align: center;
}

.head th {
  padding: 1em;
  
}

.body tr:nth-child(even) {
  background-color: #f9f9f9;
}

.body td {
  padding: 1em;
  text-align: center;
  border-bottom: 1px solid #ddd;
}

.body td a {
  color: #333;
  text-decoration: none;
}

.body td a:hover {
  text-decoration: underline;
}

.q {
  color: #f9f9f9;
}

.btnn {
    width: 6%;
    background-color: orange;
    border: none;
    color: white;
    font-size: 9px;
}


</style>
  
  