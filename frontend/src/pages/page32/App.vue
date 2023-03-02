
<template>
   <section id="section">
  
    <h2>지원자 상세페이지</h2>

  <h3>인적사항</h3>
  <input type="text" name="name"  placeholder="이름" >
  <input type="text" name="birth"  placeholder="생년월일" >
  <select>
    <option value="">성별</option>
    <option value="남">남</option>
    <option value="여">여</option>
  </select>
  <br>
  <input type="text" name="phone_num"  placeholder="phonenumber"><br>
  <input type="email" name="email"  placeholder="email" ><br>
  <input type="text" name="address"  placeholder="address" ><br>
  
  
  <br><hr>
  
  <h3>희망직무</h3>
  <input type="text" name="task"  placeholder="직무" ><br>
  
  <br><hr>
  
  <h3>자격증/어학</h3>
  <input type="text" name="license"  placeholder="자격증" ><br>
  
  <input type="text" name="language"  placeholder="어학" ><br>
  <br><hr>
  
  
  
  <h3>학력</h3>
  <input type="text" name="education"  placeholder="학력" ><br>
  
  <br><hr>
  
  <h3>희망 근무조건</h3>
  <input type="text" name="salary"  placeholder="희망연봉" ><br>
  
  <input type="text" name="place"  placeholder="희망지역" ><br>
  <br><hr>

  <h3>자기소개서</h3>
  <textarea id="" cols="150" rows="10"></textarea>


  </section>

</template>

<script>

export default {
  name: 'App',
  data() {
      return {
        userId: '',
        passWd: ''
      }
  }
}
</script>


<style scoped>
table {
 font-family: arial, sans-serif;
 border-collapse: collapse;
 width: 100%;
}
 
td, th {
 border-bottom: 1px solid #dddddd;
 text-align: left;
 padding: 8px;
}

</style>
