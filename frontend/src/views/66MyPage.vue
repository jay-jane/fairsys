<template>
  <div class="hw_admin_nav">
    <ul>
      <li class="hw_sub_menu_toggle">
        <a class="hw_sub menu select">채용공고</a>
        <ul class="hw_sub_menu" style="display: block;">
          <li><router-link to="/4">공고목록</router-link></li>
          <!-- <router-link :to="{name:'page8'}">공고수정</router-link> -->
        </ul>
      </li>

      <li class="hw_sub_menu_toggle">
        <a href="#">이력서</a>
        <ul class="hw_sub_menu">
          <li><router-link to="/ResumeRegist">이력서 작성</router-link></li>

          <li><router-link to="/UserMypage">이력서 목록</router-link></li>

          <li><a href="#"></a></li>

        </ul>
      </li>

      <li class="hw_sub_menu_toggle">
        <a href="#">쪽지</a>
        <ul class="sub_menu">
          <li><a href="#">쪽지 작성</a></li>
          <li><a href="#">쪽지 보관함</a></li>
        </ul>
      </li>

      <li class="hw_sub_menu_toggle">
        <a href="#">회사정보수정</a>
        <ul class="hw_sub_menu">
          <li><router-link to="/9">회원정보수정</router-link></li>

          <li><a href="#" @click="deleteUser">회원탈퇴</a></li>
        </ul>
      </li>
    </ul>
  </div>



  <div class="hw_my_content_main">
    <div class="hw_my_content">
      <table>
        <div id="hw_my_salary_list_wrap">
          <div id="hw_my_salary_list_total">
            <ul>
              <li class="hw_my_com_info">
                <div class="hw_my_company_info">
                  <strong class="hw_my_title">{{user_id}}님 안녕하세요</strong>
                  <br>
              
                  <div v-for="(item, index) in index">
                  <dl class="hw_my_info_item" >
                    <dt>이름</dt>
                    <dd>{{item.user_name}}</dd>
                  </dl>
                  <dl class="hw_my_info_item">
                    <dt>이메일</dt>
                    <dd>{{ item.user_email}}</dd>
                  </dl>
                  <dl class="hw_my_info_item">
                    <dt>전화번호</dt>
                    <dd>{{ item.user_phone}}</dd>
                  </dl>
                </div>
                </div>
              </li>
            </ul>


          </div>
        </div>


      </table>

      
      <table class="table">


        <thead class="hw_my_list">
          <tr>
            <th>번호</th>
            <th>진행상황</th>
            <th>조회</th>
            <th>수정</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody id="hw_table-body">

          <tr v-for="(item, index) in list" v-bind:key="index">
            <td>{{ item.com_id }}</td>
            <td>{{ item.status}}</td>
            <!-- <td @click.prevent="ResumeModify(item.w_no)">조회</td>
            <td><router-link :to="{ name: 'ResumeUpdate', params: { w_no: item.user_no } }">수정</router-link></td>
            -->  
            <td @click.prevent="ResumeModify(item.user_no)">조회</td>
            <td><router-link :to="{name: 'ResumeUpdate', params: {user_no: item.com_id}}">수정</router-link></td>
             <td><button type="button" value="삭제" @click="deleteForm(item.user_no)" style="margin-right: 10px;">삭제</button>
            </td> 
          </tr>

        </tbody>
      </table>



    </div>

  </div>
</template>
  
<script>

export default {
  
  name: 'App',
  data() {
    return {
      user_no: '',
      list: [],
      a: '',
      user_id:sessionStorage.getItem("user_id"),
      com_id:'',
      user_phone:'',
      user_name:'',
    }
  },
  
  methods: {
    UserMyPage() {
      this.axios.get('/UserMyPage',
        {
          params: { user_id: sessionStorage.getItem("user_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
          }
        })
        .then(res => {
          // this.w_no = this.$route.query.w_no;
          this.user_name = this.$route.query.user_name;
          this.user_phone = this.$route.query.user_phone;
          this.user_id = sessionStorage.getItem("user_id")

          console.log(this.user_id)
          console.log(this.user_name)
          console.log(res)
          this.list = res.data;
          console.log(res.data)
        })
        .catch(err => {
          console.log(err);
          alert("로그인이 필요한 서비스입니다.")
          sessionStorage.clear();
          this.$store.commit("setLogInOut","로그인")
          this.$router.push({ path: '/2' })
        });
    },

    deleteUser(){
      if(confirm('아이디를 삭제하시겠습니까?')){
        this.axios.get('/UserMyPage/deleteForm',
        {
          params: { user_id: sessionStorage.getItem("user_id") },
          headers: {
            'content-type': 'application/json',
            'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
          }
        }
        ).then(res => {
          alert('아이디가 삭제되었습니다.')
          sessionStorage.clear();
          this.$store.commit("setLogInOut","로그인")
          this.$router.push({ path: '/' })
        })
      }
     
    },


    ResumeModify(user_no) {
      this.$router.push({
        path: '/ResumeModify/',
        name: 'ResumeModify',
        params: { "user_no": user_no }
      })
    },

    deleteForm(user_no) {
      if (confirm('삭제하시겠습니까?')) {
        this.axios.post('/ResumeDelete', { "user_no": user_no })
          .then(() => {
            alert('삭제되었습니다');
            this.$router.go('/UserMyPage');
          })
          .catch(err => console.log(err));
      };
    },
  },

  mounted() {
    this.UserMyPage();
  },
}

</script>
  
  
<style>
* {
  list-style: none;
  margin: 0;
  padding: 0;
  font-family: 'Noto Sans KR', sans-serif;
  text-decoration: none;
  color: black;
  box-sizing: border-box;
}

.hw_my_title {
  float: left;
}

.hw_admin_account {
  margin-right: 20px;
}

.hw_admin_account span {
  color: white;
  margin-right: 20px;
}

.hw_admin_nav {
  width: 200px;
  height: 100%;
  position: fixed;
  top: 100px;
  left: 0;
  background-color: white;
}

.hw_admin_nav li {
  margin-top: 20px;
  list-style: none;
}

.hw_admin_nav li a {
  padding: 8px 20px;
  text-decoration: none;
  font-size: 15px;
  color: orange;
  display: block;
  width: 200px;
  font-weight: 600;
}

.hw_admin_nav .hw_sub_menu {
  margin-left: 25px;
}

.hw_admin_nav .hw_sub_menu li a {
  color: black;
  display: block;
  width: 155px;
  padding: 8px 10px 8px 10px;
}

.hw_admin_nav .hw_sub_menu li a:hover {
  background-color: orange;
}

.hw_admin_nav .hw_sub_menu li a.on {
  background-color: orange;
}

.hw_my_content {
  width: auto;
}

.table {
  width: 80%;
  text-align: center;
  border: 1px solid #fff;
  font-family: 'Cairo', sans-serif;
  margin: auto;
  border-collapse: collapse;
  border-radius: 5px;
}

caption {
  font-weight: bold;
}

.table td {
  padding: 10px;
  background-color: #eee;
}

.table th {
  background-color: #d1cece;
  color: #000;
  padding: 10px;
}

.view,
.delete {
  border: none;
  padding: 5px 10px;
  color: #fff;
  font-weight: bold;
}

.view {
  background-color: #000;
}

.hw_my_content_main {
  margin-left: 50px;
}

#hw_my_salary_list_wrap {
  padding: 57px 0 65px;
}

#hw_my_salary_list_wrap #hw_salary_list_total {
  overflow: hidden;
}

#hw_my_salary_list_wrap #hw_salary_list_total ul li {
  overflow: hidden;
  padding: 8px 19px 6px 30px;
  width: 960px;
  /* border-bottom: 1px solid #e0e0e0; */
  box-sizing: border-box;
}

#hw_my_salary_list_wrap #hw_salary_list_total .logo {
  display: table;
  overflow: hidden;
  float: left;
  margin-top: 29px;
  padding: 0 10px;
  width: 100px;
  height: 104px;
  border: 1px solid #efefef;
  text-align: center;
}

#hw_my_salary_list_wrap #hw_my_salary_list_total .hw_my_company_info {
  float: left;
  padding: 26px 60px 40px 20px;
  width: 570px;
  box-sizing: border-box;
}

#hw_my_salary_list_wrap #hw_my_salary_list_total .hw_my_company_info .hw_title {
  font-size: 18px;
  font-weight: bold;
  line-height: 19px;
}

#hw_my_salary_list_wrap #hw_my_salary_list_total .hw_mark {
  display: inline-block;
  overflow: hidden;
  margin: 2px 0 0 9px;
  padding: 0 9px 2px 8px;
  height: 16px;
  border: 1px solid #ff6e51;
  color: #ff6e51;
  font-size: 11px;
  font-weight: normal;
  line-height: 16px;
  vertical-align: top;
}

#hw_my_salary_list_wrap #hw_my_salary_list_total .my_info_item {
  overflow: hidden;
  padding-top: 6px;
}

#hw_my_salary_list_wrap #hw_my_salary_list_total .hw_my_info_item dt {
  float: left;
  padding: 1px 0 2px;
  width: 80px;
  height: 18px;
  border: 1px solid #e4e4e4;
  box-sizing: border-box;
  color: #888;
  font-size: 11px;
  line-height: 14px;
  text-align: center;
}

#hw_my_salary_list_wrap #hw_my_salary_list_total .hw_my_info_item dd {
  overflow: hidden;
  padding: 0 7px 2px;
  color: #555;
  font-size: 13px;
  text-overflow: ellipsis;
  white-space: nowrap;
  float: left;
}
</style>