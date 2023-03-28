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

          <li><router-link to="/ApplyStatus1">이력서 목록</router-link></li>

          <li><a href="#"></a></li>

        </ul>
      </li>



      <li class="hw_sub_menu_toggle">
   

        <ul class="sub_menu">
          <li><router-link to="/9-1">회원정보수정</router-link></li>

          <li><a href="#" @click="deleteUser">회원탈퇴</a></li>
        </ul>
      </li>
    </ul>
  </div>


<!-- 
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
               -->
                  <!-- <div v-for="(item, index) in index">
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
                </div> -->

<!-- 

                </div>
              </li>
            </ul>


          </div>
        </div>


      </table> -->


      <div class="hw_main">
    <div class="hw_container">

      <h2>작성 이력서</h2>

      <!-- 출력 카테고리 -->
      <select v-model="amount" class="hw_view" @change="loglist_view">
        <option value="10">10개 보기</option>
        <option value="20">20개 보기</option>
        <option value="30">30개 보기</option>
      </select>
      
      <table class="hw_list">
        <thead class="hw_head">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일자</th>
     
          </tr>
        </thead>

        <tbody class="hw_body">

          <tr v-for="(item, index) in list" v-bind:key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ item.resume_title }}</td>
            <td>{{ item.resume_date }}</td>
      
    
            <!-- <td @click.prevent="ResumeModify(item.user_no)">조회</td> -->
            <!-- <td><router-link :to="{name: 'ResumeUpdate', params: {user_no: item.com_id}}">수정</router-link></td> -->
             <!-- <td><button type="button" value="삭제" @click="deleteForm(item.user_no)" style="margin-right: 10px;">삭제</button> -->
            <!-- </td>  -->
          </tr>

        </tbody>
      </table>
      
      <div class="hw_serch_box">
  
  <select name="" id="">
    <option value="title">이름</option>
    <option value="status">진행상황</option>
  </select>

  <input type="text">
  <button @click="search($event.target)">검색</button>

</div>

      


    </div>

  </div>
</template>
  
<script>

export default {
  
  name: 'App',
  data() {
    return {
      // user_no: '',
      list: [],
      a: '',
      user_id:sessionStorage.getItem("user_id"),
      com_id:'',
      user_phone:'',
      user_name:'',
    }
  },
  
  methods: {
    ApplyStatus1() {
      this.axios.get('/ApplyStatus1',
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
          // this.$store.commit("setLogInOut","로그인")
          // this.$router.push({ path: '/2' })
        });
    },
    ResumeModify(user_no) {
      this.$router.push({
        path: '/ResumeModify/',
        name: 'ResumeModify',
        params: { "user_no": user_no }
      })
    },
    // deleteUser(){
    //   if(confirm('아이디를 삭제하시겠습니까?')){
    //     this.axios.get('/ApplyStatus1/deleteForm',
    //     {
    //       params: { user_id: sessionStorage.getItem("user_id") },
    //       headers: {
    //         'content-type': 'application/json',
    //         'Authorization': "Bearer " + sessionStorage.getItem("user_auth"),
    //       }
    //     }
    //     ).then(res => {
    //       alert('아이디가 삭제되었습니다.')
    //       sessionStorage.clear();
    //       this.$store.commit("setLogInOut","로그인")
    //       this.$router.push({ path: '/' })
    //     })
    //   }
     
    // },


    // ResumeModify(user_no) {
    //   this.$router.push({
    //     path: '/ResumeModify/',
    //     name: 'ResumeModify',
    //     params: { "user_no": user_no }
    //   })
    // },

    // deleteForm(user_no) {
    //   if (confirm('삭제하시겠습니까?')) {
    //     this.axios.post('/ResumeDelete', { "user_no": user_no })
    //       .then(() => {
    //         alert('삭제되었습니다');
    //         this.$router.go('/UserMyPage');
    //       })
    //       .catch(err => console.log(err));
    //   };
    // },
  },
 
  async get() {
        //console.log(this.list_view);
  
        //화면에 리스트 출력을 위해 필요한 내용 전달
        let response = await Axios.get("/ApplyStatus1/?amount=" + this.amount + "&page=" + this.page + "&searchTitle=" + this.searchTitle + "&searchStatus=" + this.searchStatus + "&searchContent=" + this.searchContent,
         
        );
  
        //필요한 공용 데이터를 담기
        this.list = response.data.list;
        this.pages = response.data.pageVO;
        this.pageList = this.pages.pageList;
  
        //페이지이동에 필요한 데이터 담기
        this.page = this.pages.page;
        this.searchTitle = this.pages.cri.searchTitle;
        this.searchStatus = this.pages.cri.searchStatus;
        this.searchContent = this.pages.cri.searchContent;
        this.prev = this.pages.prev;
        this.pageStart = this.pages.pageStart;
        this.pageEnd = this.pages.pageEnd;
        this.realEnd = this.pages.realEnd;
  
      },
  
      loglist_view() {
        this.amount = this.amount;
      },
  
      goFirstPage() {
        this.page = 1;
        this.get();
      },
  
      goBeforePage() {
        if (this.page > 1) {
          this.page = this.page - 1;
        } else {
          alert("첫번째 페이지입니다.");
        }
      },
  
      thisPage(target) {
  
        this.page = target.innerHTML;
        this.get();
  
      },
  
      goNextPage() {
  
        if (this.page < this.realEnd) {
          this.page = this.page + 1;
          this.get();
        } else {
          alert("마지막 페이지입니다.");
        }
      },
  
      goLastPage() {
        this.page = this.realEnd;
        this.get();
      },
  
      search(target) { //검색버튼 선택
  
        const userselect = target.previousElementSibling.previousElementSibling.value;
        const usertext = target.previousElementSibling.value;
        console.log(userselect);
        console.log(usertext);
  
        if (userselect === "title") {
          this.searchTitle = usertext;
          this.get();
        } else if (userselect === "content") {
          this.searchContent = usertext;
          this.get();
        } else if (userselect === "status") {
          console.log("여기로")
          this.searchStatus = usertext;
          this.get();
        }
  
  
      
    
    },

  mounted() {
    this.ApplyStatus1();
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

  /* 문의사항 목록  */
  
  .hw_main {
    display: flex;
    justify-content: center;
    height: auto;
  }
  
  .hw_container {
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
  }
  
  .hw_container h2 {
    margin: 20px 0;
  }
  
  .hw_btn_write {
    float: right;
    margin: 10px 0;
    border-radius: 3px;
    font-size: 16px;
    font-weight: 500;
    background-color: orange;
    color: #fff;
    border: none;
    padding: 10px 20px;
  }
  
  .hw_view {
    float: right;
    margin: 10px 0;
    padding: 10px 20px;
  }
  
  
  .hw_list {
    width: 100%;
    border-collapse: collapse;
    border-spacing: 0;
  }
  
  
  .hw_head {
    background-color: #f5f5f5;
    text-align: center;
  }
  
  .hw_head th {
    padding: 1em;
  }
  
  .hw_head th:first-child {
    border-top-left-radius: 10px;
  }
  
  .hw_head th:last-child {
    border-top-right-radius: 10px;
  }
  
  .hw_body tr:nth-child(even) {
    background-color: #f9f9f9;
  }
  
  .hw_body td {
    padding: 1em;
    text-align: center;
    border-bottom: 1px solid #ddd;
  }
  
  .hw_body td:first-child {
    border-left: 1px solid #ddd;
    border-bottom-left-radius: 10px;
  }
  
  .hw_body td:last-child {
    border-right: 1px solid #ddd;
    border-bottom-right-radius: 10px;
  }
  
  .hw_body td a {
    color: #333;
    text-decoration: none;
  }
  
  .hw_body td a:hover {
    text-decoration: underline;
  }
  
  
  .hw_serch_box {
    margin-top: 20px;
  }
  
  .hw_serch_box select,
  input,
  button {
    padding: 5px;
    margin: 5px;
  }
  
  .hw_serch_box input {
    width: 50%;
    border-radius: 35px;
    border: 1px solid #ddd;
  }
  
  .hw_serch_box button {
    width: 10%;
    background-color: orange;
    border: none;
    color: white;
    font-size: 16px;
  }
  
  .hw_page {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px 0;
  }
  
  .hw_page ul {
    display: flex;
    align-items: center;
    list-style: none;
  }
  
  .hw_page li {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    font-size: 14px;
    margin: 0 5px;
    cursor: pointer;
    background-color: #fff;
    border: 1px solid #ccc;
  }
  
  .hw_page li.on {
    font-weight: bold;
    color: #fff;
    background-color: orange;
    border-color: orange;
  }
  
  .hw_page i {
    font-size: 14px;
    margin: 0;
    padding: 0;
    line-height: 1;
  }
  
  .hw_page_btn {
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>