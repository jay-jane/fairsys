
<template>
    <form action="">

        <section>


            <div class="cont_division">
                <div :style="{ display: ['flex'], flexDirection: ['row'], justifyContent: ['space-between'] }">
                    <h3 :style="{ borderBottom: ['4px solid #777'] }"><router-link to="/3-1">개인 회원가입</router-link></h3>
                    <h3><router-link to="/3-2">기업 회원가입</router-link></h3>
                </div>
                <br><br>
                <div>
                    <label for="user_id">아이디 </label>
                    <input v-model="user_id" @keydown.enter="sameIdCheck" required type="text" placeholder="아이디">
                    <button type="button" @click="checkId"
                        :style="{ width: ['60px'], fontSize: ['8px'], textAlign: ['center'], padding: ['1px'] }">중복확인</button>
                </div>

                <div>
                    <label for="user_pw">비밀번호 </label>
                    <input v-model="user_pw" required type="password" placeholder="비밀번호">
                    <span v-if="!passwordValidFlag && this.user_pw !== ''" :style="{ color: ['red'] }">유효하지 않은 비밀번호 입니다.</span>
                    <span v-if="passwordValidFlag && this.user_pw !== ''" :style="{ color: ['green'] }">유효한 비밀번호 입니다.</span>
                </div>

                <div>
                    <label for="user_pw_re">비밀번호 확인 </label>
                    <input v-model="user_pw_re" required type="password" placeholder="비밀번호 재확인">
                    <span v-if="!passwordCheckFlag && this.user_pw_re !== ''" :style="{ color: ['red'] }">비밀번호가 다릅니다.</span>
                    <span v-if="passwordCheckFlag && this.user_pw_re !== ''" :style="{ color: ['green'] }">비밀번호가 일치합니다.</span>
                </div>

                <div>
                    <label for="user_name">이름 <input v-model="user_name" required type="text" placeholder="성함"></label>
                </div>
                <label for="user_birth">생년월일 </label>
                <div>
                    <select id="yyyy" class="sel" v-model="signup.yyyy" :style="{width: ['100px'], textAlignLast: ['center']}">
                        <option value="">년</option>
                        <option v-for="(item, index) in yyyyList" :key="index" :value="item.value">
                            {{ item.text }}
                        </option>
                    </select>
                    <select id="mm" class="sel" v-model="signup.mm" :style="{width: ['100px'], textAlignLast: ['center']}">
                        <option value="">월</option>
                        <option v-for="(item, index) in mmlist" :key="index" :value="item.value">
                            {{ item.text }}
                        </option>
                    </select>
                    <select id="dd" class="sel" v-model="signup.dd" :style="{width: ['100px'], textAlignLast: ['center']}">
                        <option value="">일</option>
                        <option v-for="(item, index) in ddlist" :key="index" :value="item.value">
                            {{ item.text }}
                        </option>
                    </select>
                </div>
                <label for="user_gender">성별</label>
                <div>

                    <select class="sel" v-model="user_gender" :style="{width: ['100px'], textAlignLast: ['center']}">
                        <option value="">성별</option>
                        <option v-for="(item, index) in genderList" :key="index" :value="item.value">
                            {{ item.text }}
                        </option>
                    </select>
                </div>

                <div>
                    <label for="user_phone">전화번호 </label>
                    <input v-model="user_phone" required type="text" placeholder="전화번호를 입력하세요" maxlength="11">
                </div>

                <div>
                    <label for="user_email">이메일 </label>
                    <input v-model="user_email" required type="email" placeholder="이메일">
                </div>
                <div>
                    <!-- <label for="com_address">회사주소: </label> -->
                    <!-- <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요"> -->
                    <label for="address">주소 </label>
                    <input type="text" v-model="user_postcode" placeholder="우편번호">
                    <input type="button" @click="execDaumPostcode()" value="우편번호 찾기"><br>
                    <input type="text" v-model="user_address" placeholder="주소"><br>
                    <input type="text" v-model="user_detail_address" placeholder="상세주소">
                </div>




                <div class="cont_division">
                    <span class="terms_agree">
                        <strong>약관</strong>
                    </span>
                    <div class="agree_box">
                        <ul class="agree_article">
                            <li>
                                <span class="inpChk sizeL">
                                    <input type="checkbox" id="agreeAllPersonal" class="check_mail" v-model="allSelected">
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
                                        <!-- <span>개인회원 약관 상세보기</span> -->
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>


            </div>
            <div class="list">
                <button type="button" @click="submitForm">가입하기</button>
                <button class="view" @click="btn_view">목록</button>
            </div>
        </section>
    </form>
</template>
  
<script>

export default {
    data() {
        return {
            user_id: '',
            user_pw: '',
            user_pw_re: '',
            user_name: '',
            user_birth: '',
            user_gender: '',
            user_postcode: '',
            user_address: '',
            user_detail_address: '',
            detailAddress: '',
            user_email: '',
            user_phone: '',
            checkList: ["(필수)개인회원 약관에 동의", "(필수)개인정보 수집 및 이용에 동의", "(선택)위치기반서비스 이용약관에 동의", "(선택)마케팅 정보 수신 동의 -이메일", "(선택)마케팅 정보 수신 동의"],
            selectList: [],
            idPassCheck: false, //id 중복확인 통과했는지 여부 체크 , 통과하면 true 로 바꿔줌.
            phCertifPassCheck: false, //핸드폰인증 확인했는지 여부 체크, 통과했으면 true
            //유효성 검사 정규식
            nameRule: /^[가-힣a-zA-Z]+$/, //한글,영문만 입력가능
            idRule: /^[a-z0-9]{4,12}$/, // 영문 대소문자, 숫자만 사용가능 길이는 4~12 글자
            passwordRule: /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,  //비밀번호 유효성 검사 정규표현식
            emailRule: /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/, //이메일 형식 유호성 검사 정규표현식
            phoneNumRule: /^[0-9]{8,13}$/, //휴대폰 번호 숫자만 가능


            passwordValidFlag: true,
            passwordCheckFlag: true,
            checkFlag: false,
            signup: {
                // id: this.propSignup.id,
                // password: this.propSignup.password,
                // pwhint: this.propSignup.pwhint,
                // pwhintans: this.propSignup.pwhintans,
                yyyy: "2023",
                mm: "03",
                dd: "14",

            },
            genderList: [
                {
                    value: "M",
                    text: "남성",
                },
                {
                    value: "F",
                    text: "여성",
                },
            ],
            yyyyList: [],
            mmlist: [],
            ddlist: [],
        };
    },
    methods: {

        // 아이디 중복확인 메서드
        checkId() {
            if (this.user_id !== '') {

                //아이디 중복확인 전 id 유효성 검사
                if (this.idRule.test(this.user_id.trim()) === false) {
                    alert('아이디는 4~12글자 이내로 영어 대소문자,숫자만 가능합니다')
                } else {
                    //id 중복확인 요청 보내기
                    this.axios.post('/3-1/checkId',
                        { user_id: this.user_id, })
                        .then(res => {
                            console.log(res)
                            if (res.data) {
                                this.msg = '사용이 가능한 id 입니다'
                            } else {
                                this.msg = '이미 사용하고 있는 id 입니다'
                            }
                            alert(this.msg)
                        })
                        .catch(err => {
                            console.log(err)
                        })

                }
            } else {
                this.msg = "Id를 입력해주세요"
            }
        },

        //비밀번호 유효성 검사
        checkPw() {
            if (/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/.test(this.user_pw)) {
                this.passwordValidFlag = true;
            } else {
                this.passwordValidFlag = false;
            }
        },

        // 비밀번호 재입력 검사
        checkPwRe(){
            if(this.user_pw===this.user_pw_re){
                this.passwordCheckFlag = true;
            }else{
                this.passwordCheckFlag = false;

            }
        },

        checkEmail(){

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

            this.axios.post('/3-1/registForm',
                {
                    user_id: this.user_id,
                    user_pw: this.user_pw,
                    user_name: this.user_name,
                    user_email: this.user_email,
                    user_birth: this.signup.yyyy + "" + this.signup.mm + "" + this.signup.dd,
                    user_gender: this.user_gender,
                    user_phone: this.user_phone,
                    user_postcode: this.user_postcode,
                    user_address: this.user_address,
                    user_detail_address: this.user_detail_address
                }
            ).then(res => {
                console.log(res)
                console.log(res.config.data)
                this.$router.push({ path: '/' })
            }).catch(err => {
                console.log(err)
            })
        },
        

        btn_view() {
            location.href = "page1";
        },


        execDaumPostcode() {
            new window.daum.Postcode({
                oncomplete: (data) => {
                    if (this.user_detail_address !== "") {
                        this.user_detail_address = "";
                    }
                    if (data.userSelectedType === "R") {
                        // 사용자가 도로명 주소를 선택했을 경우
                        this.user_address = data.roadAddress;
                    } else {
                        // 사용자가 지번 주소를 선택했을 경우(J)
                        this.user_address = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if (data.userSelectedType === "R") {
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                            this.user_detail_address += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if (data.buildingName !== "" && data.apartment === "Y") {
                            this.user_detail_address +=
                                this.user_detail_address !== ""
                                    ? `, ${data.buildingName}`
                                    : data.buildingName;
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if (this.user_detail_address !== "") {
                            this.user_detail_address = `(${this.user_detail_address})`;
                        }
                    } else {
                        this.user_detail_address = "";
                    }
                    // 우편번호를 입력한다.
                    this.user_postcode = data.zonecode;
                },
            }).open();
        },
    },

    computed: {

        allSelected: {
            get: function () {
                return this.checkList.length === this.selectList.length;
            },
            set: function (e) {
                this.selectList = e ? this.checkList : [];
            }
        }
    },

    watch: {
        'user_pw': function () {
            this.checkPw()
        },

        'user_pw_re': function(){
            this.checkPwRe()
        },

    },
    created() {
        // console.log(this.$store.state.todos.list[0]);
        const nowYear = new Date().getFullYear();
        for (let i = 0; i < 100; i++) {
            let date = nowYear - i;
            this.yyyyList.push({ value: date, text: date });
        }
        for (let i = 1; i < 13; i++) {
            if (i < 10) {
                this.mmlist.push({
                    value: "0" + i,
                    text: "0" + i,
                });
            } else {

                this.mmlist.push({
                    value: i,
                    text: i,
                });
            }
        }
        for (let i = 1; i <= 31; i++) {
            if (i < 10) {
                this.ddlist.push({
                    value: "0" + i,
                    text: "0" + i,
                });
            } else {

                this.ddlist.push({
                    value: i,
                    text: i,
                });
            }
        }
    },
};
</script>
  
<style>
div {
    display: block;
    margin: 0;
    padding: 0;
    font-size: 100%;
}

#join_wrapper {
    width: 300px;
    margin: 0 auto;
    position: relative;
}

div {
    display: block;
    margin: 0;
    padding: 0;
    font-size: 100%;
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

button[type="button"] {
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
    display: flex;
    justify-content: center;
    width: 300px;
}

.list :first-child{
    margin-right: 30px;
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

* {
    text-align: left;
}

.btn_logInOut {
    text-align: center;
}
</style>
  
  
  