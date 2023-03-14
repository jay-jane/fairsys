
<!-- Q&A 페이지 -->

<template>
 
  <section>
   
      
     <div class="bg"> 
      <h3 class="first_name">기업</h3>    
        <table>
        <thead>
          <tr>
            <th class="jb-th-1">번호</th>
            <th class="jb-th-2">회사이름</th>
            <th class="jb-th-3">신청일자</th>
            <th class="jb-th-3">승인일자</th>
           
          </tr>
        </thead>
        <tbody>
          <tr>
            <th >1</th>
            <td>(주)짬뽕</td>
            <td class="date">2023.03.08</td>
            <td class="date">2023.03.09</td>
            
          </tr>
            <tr>
              <th>2</th>
              <td>(주)짜장면</td>
              <td class="date">2023.03.08</td>
              <td class="date">2023.03.09</td>
            </tr>

             <tr>
              <th>3</th>
              <td>(주)탕수육</td>
              <td class="date">2023.03.08</td>
              <td class="date">2023.03.09</td>
            </tr>
         </tbody>
      </table>
    </div>
     <input type="text" v-model="com_id">
</section> 
 

  <footer id="ft" style="border-top: 1px solid">
    <h3>여기 푸터야</h3>
  </footer>
</template>

<script>
import  Axios from 'axios';

export default {
  name: 'App',

data(){

return{
  com_id:1
}
},
methods: {
  
logout(){
  location.href="/3";
  },
get(){
      Axios.get("/18?" + com_id).
      then((response)=>{
        console.log(response.data);
        this.title = response.data.title;
        console.log(title);
      })
      .catch((err)=>{
        console.log(err);
      })
    }

  },
  mounted(){
    this.get();
  }
};
</script>
<style>

* {margin: 0; padding: 0; }

  table{
    padding: auto;
    margin: auto;
    border: 1px solid black;
    border-collapse : collapse;
    border-radius: 5px; 
    }
 
  th {
    border: 1px solid black;
  }

  td{
  border: 1px solid black;
  text-align:center;
  }

  .jb-th-1 {
    width: 200px;
    background-color: bisque;
  }



  .jb-th-2 {
    width: 600px;
     background-color: bisque;
     text-align: center;
  }

  .jb-th-3{
    width: 200px;
     background-color: bisque;
      text-align: center;
  }

 .date{
  text-align: center;
 }

   
</style>
