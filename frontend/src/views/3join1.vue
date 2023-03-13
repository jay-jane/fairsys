<template>
    <section>

        <div class="none">
        <button @click="showSignup = !showSignup">{{ showSignup ? '기업회원' : '개인회원' }}</button>
        </div>
        <form v-if="showSignup" @submit.prevent="signup">
            <div class="cont_division">



                    <div>
                        <label for="com_name">회사명: <input v-model="com_name" required type="text"
                                placeholder="회사이름을 입력하세요"></label>
                    </div>
                    <div>
                        <label for="com_ceo">대표자명: </label>
                        <input v-model="com_ceo" required type="text" placeholder="대표자명을 입력하세요">
                    </div>
                    <div>
                        <label for="com_business_number">사업자등록번호: </label>
                        <input v-model="com_business_number" required type="number" placeholder="사업자 번호를 입력하세요">
                    </div>
                    <div>
                        <label for="com_address">회사주소: </label> -
                         <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요">

                        <!-- <input type="text" v-model="postcode" placeholder="우편번호">
                        <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" v-model="address" placeholder="주소"><br>
                        <input type="text" v-model="detailAddress" placeholder="상세주소"> -->
                    </div>

                    <div>
                        <label for="com_id">id: </label>
                        <input v-model="com_id" required type="text" placeholder="아이디를 입력하세요">
                    </div>
                    <div>
                        <label for="com_pw">password: </label>
                        <input v-model="com_pw" required type="password" placeholder="비밀번호를 입력하세요">
                    </div>
                    <div>
                        <label for="com_hp">전화번호: </label>
                        <input v-model="com_hp" required type="number" placeholder="전화번호를 입력하세요">
                    </div>
                    <div>
                        <label for="com_user">가입자명: </label>
                        <input v-model="com_user" required type="text" placeholder="성함을 입력하세요">
                    </div>
                    <div>
                        <label for="com_email">이메일: </label>
                        <input v-model="com_email" required type="email">
                    </div>



                    <div class="cont_division">
                        <span class="terms_agree">
                            <strong>약관</strong>
                        </span>
                        <div class="agree_box">
                            <ul class="agree_article">
                                <li>
                                    <span class="inpChk sizeL">
                                        <input type="checkbox" id="agreeAllPersonal" class="check_mail"
                                            v-model="allSelected">
                                        <label class="check_all check_off lbl" for="agreeAllPersonal">
                                            <strong>전체동의</strong>
                                        </label>
                                    </span>
                                </li>
                            </ul>

                            <div v-for="(item, index) in checkList" :key="index">
                                <ul class="agree_article depth2">
                                    <li>
                                        <div class="agree_desc">
                                            <span class="chk">
                                                <input type="checkbox" :id="item" :value="item" v-model="selectList">
                                                <label :for="item">
                                                    <span><strong>{{ item }}</strong></span>
                                                </label>
                                            </span>
                                        </div>
                                        <a href=""><br />
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="list">
                        <button type="button" @click="submitForm" >가입하기</button>
                        <button class="view" @click="btn_view">목록</button>
                    </div>

                </div>

        </form>





        <form v-else @submit.prevent="login">
            <!-- 개인회원 -->
            <div class="cont_division">


                <div>
                        <label for="com_name">회사명: <input v-model="com_name" required type="text"
                                placeholder="회사이름을 입력하세요"></label>
                    </div>
                    <div>
                        <label for="com_ceo">대표자명: </label>
                        <input v-model="com_ceo" required type="text" placeholder="대표자명을 입력하세요">
                    </div>
                    <div>
                        <label for="com_business_number">사업자등록번호: </label>
                        <input v-model="com_business_number" required type="number" placeholder="사업자 번호를 입력하세요">
                    </div>
                    <div>
                        <label for="com_address">회사주소: </label> -
                         <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요">

                        <!-- <input type="text" v-model="postcode" placeholder="우편번호">
                        <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" v-model="address" placeholder="주소"><br>
                        <input type="text" v-model="detailAddress" placeholder="상세주소"> -->
                    </div>

                    <div>
                        <label for="com_id">id: </label>
                        <input v-model="com_id" required type="text" placeholder="아이디를 입력하세요">
                    </div>
                    <div>
                        <label for="com_pw">password: </label>
                        <input v-model="com_pw" required type="password" placeholder="비밀번호를 입력하세요">
                    </div>
                    <div>
                        <label for="com_hp">전화번호: </label>
                        <input v-model="com_hp" required type="number" placeholder="전화번호를 입력하세요">
                    </div>
                    <div>
                        <label for="com_user">가입자명: </label>
                        <input v-model="com_user" required type="text" placeholder="성함을 입력하세요">
                    </div>
                    <div>
                        <label for="com_email">이메일: </label>
                        <input v-model="com_email" required type="email">
                    </div>


<div class="cont_division">
    <span class="terms_agree">
        <strong>약관</strong>
    </span>
    <div class="agree_box">
        <ul class="agree_article">
            <li>
                <span class="inpChk sizeL">
                    <input type="checkbox" id="agreeAllPersonal" class="check_mail"
                        v-model="allSelected">
                    <label class="check_all check_off lbl" for="agreeAllPersonal">
                        <strong>전체동의</strong>
                    </label>
                </span>
            </li>
        </ul>

        <div v-for="(item, index) in checkList" :key="index">
            <ul class="agree_article depth2">
                <li>
                    <div class="agree_desc">
                        <span class="chk">
                            <input type="checkbox" :id="item" :value="item" v-model="selectList">
                            <label :for="item">
                                <span><strong>{{ item }}</strong></span>
                            </label>
                        </span>
                    </div>
                    <a href=""><br />
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div> 
<div class="list">
    <button type="submit" >가입하기</button>
    <button class="view" @click="btn_view">목록</button>
</div>

</div>
        </form>
 
</section>
</template>
  
<script>
export default {
    data() {
        return {
            showSignup: true,
            name: '',
            email: '',
            password: '',
            checkList: ["(필수)개인회원 약관에 동의", "(필수)개인정보 수집 및 이용에 동의", "(선택)위치기반서비스 이용약관에 동의", "(선택)마케팅 정보 수신 동의 -이메일", "(선택)마케팅 정보 수신 동의"],
            selectList: [],
        }
    },
    methods: {
        signup() {
            // 회원가입 로직
        },
        login() {
            // 로그인 로직
        }
    },

    async submitForm() {
            console.log(1);

            // let data = await fetch("/test/registForm", {
            //     method: "post", 
            //     body: JSON.stringify({ user_id: "Xxxx" }),
            //     headers: { "Content-Type": "application/json", }
            //     })
            // let result = await data.text();
            // console.log(result)

            this.axios.post('/regist/registForm',
                {
                    com_name: this.com_name,
                    com_ceo: this.com_ceo,
                    com_Business_number: this.com_Business_number,
                    com_address: this.com_address,
                    com_id: this.com_id,
                    com_pw: this.com_pw,
                    com_hp: this.com_hp,
                    com_user: this.com_user,
                    com_email: this.com_email
                }
            ).then(res => {
                console.log(res)
                this.$router.push({path:'/'})
            }).catch(err => {
                console.log(err)
            })
        }
};

</script>
  
<style>
div {
  display: block;
  margin: 0;
  padding: 0;
  font-size: 100%;
}
.none{
    text-align: center;
}

#join_wrapper {
  width: 300px;
  margin: 0 auto;
  position: relative;
}

li {
  list-style: none;

}

a:link,
a:visited,
a:active,
a:hover {
  text-decoration: none;
  color: black;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 10px;
  margin: 20px;
  padding: 20px;
}

label {
  font-weight: bold;
}

input {
  padding: 5px;
  border-radius: 3px;
  border: 1px solid #ccc;
  width: 100%;
}

button[type="submit"] {
  padding: 10px;
  font-size: 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.view {
  padding: 10px;
  font-size: 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #005fa3;
}

.list {
  text-align: center;
  margin-top: 30px;
}


/* 약관동의 부분 */
.cont_division {
  position: relative;
  width: 360px;
  box-sizing: border-box;
  margin-top: 24px;
}

.cont_division .terms_agree {
  font-size: 16px;
  color: #373f57;
  margin-bottom: 8px;
  display: inline-block;
}

.cont_division .agree_box {
  border: 1px solid #d7dce5;
  padding: 10px;
}

.cont_division .agree_box .agree_article {
  color: black;
  border-bottom: 1px solid #d7dce5;
  padding-bottom: 16px;

}

.inpChk {
  display: inline-block;
  position: relative;
  vertical-align: top;
}




.cont_division .agree_box .agree_article.depth2 {
  border: none;
  padding-bottom: 0;
}

.cont_division .agree_box .agree_article.depth2 li {
  position: relative;
  margin: -10px;
}

.cont_division .agree_box .agree_article.depth2 span {
  font-size: 15px;
}

input[type="checkbox"] {
  display: inline-block;
  width: 15px;
  height: 13px;

}
*{
  text-align: left;
}

</style>