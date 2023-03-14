
<template>
    <table>
            <caption>지원자 리스트</caption>
            <thead> 
                <tr>
                    <th>번호</th>
                    <th>공고제목</th>
                    <th>이름</th>
                    <th>성별</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="post in posts" :key="post.id"> 
                    <td> {{ post.r_no }}</td>
                    <td> {{ post.r_title }}</td>
                    <td> {{ post.r_name }}</td>
                    <td> {{ post.r_gender }}</td>
                </tr>
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
    import  Axios from 'axios';
    
    
    export default {
      name: 'App',
      data(){
        return {
          posts: [], 
        }
      },  
      methods: {
     
        get(){
          console.log(1);
          this.axios.get("resume/10").
          then((response)=>{
            console.log(response.data);
            console.log(title);
          })
          .catch((error)=>{
            console.log(error);
          })
        }
    
      },
      mounted(){
        this.get();
      }
    };
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
    