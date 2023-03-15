
<template>
  <section id="section" >
    <table>
            <caption>지원자 리스트</caption>
            <thead> 
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>성별</th>
                </tr>
            </thead>
            <tbody>
              <tr v-for="(item,index) in list">
                    <td><router-link :to="`/ResumeModify?w_no=${item.w_no}`">{{ item.w_no}}</router-link></td>
                    <td> {{ item.w_name }}</td>
                    <td> {{ item.w_email}}</td>
                    <td> {{ item.w_gender }}</td>

                </tr>
    
            </tbody>
    
        </table>

      </section>
    </template>
    

    
    <script>
    export default {

name: 'App',
data() {
  return {
    w_no: '',
    list: [],
    a: '',
  }

},
methods: {
  ApplyStatus() {
    this.axios.get('/ApplyStatus')
              .then(res => {
                this.a = this.$route.query.w_no;
                this.w_no = this.$route.query.w_no;
                this.list = res.data;})
              .catch(err => {
                console.log(err);});
  },
},
mounted() {
  this.ApplyStatus();
  },
}
    // import  Axios from 'axios';
    
    
    // export default {
    //   name: 'App',
    //   data(){
    //     return {
    //       posts: [], 
    //     }
    //   },  
    //   methods: {
     
    //     get(){
    //       console.log(1);
    //       this.axios.get("resume/ResumeModify").
    //       then((response)=>{
    //         console.log(response.data);
    //         console.log(title);
    //       })
    //       .catch((error)=>{
    //         console.log(error);
    //       })
    //     }
    
    //   },
    //   mounted(){
    //     this.get();
    //   }
    // };
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
    
   
    </style>
    