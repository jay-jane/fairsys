<template>
    <h3 :style="{display:['inline']}"><button type="button" @click="userJoin" value="individual">개인회원가입</button></h3>
    <h3 :style="{display:['inline']}"><button type="button" @click="companyJoin" value="company">기업회원가입</button></h3>
    <section>
        <h3>개인회원가입</h3>
        <div>
            <label for="user_id">id:</label>
            <input v-model="user_id" required type="text" placeholder="아이디를 입력하세요">
        </div>
        <div>
            <label for="user_pw">password: </label>
            <input v-model="user_pw" required type="password" placeholder="비밀번호를 입력하세요">
        </div>
        <div>
            <label for="user_name">이름: </label>
            <input v-model="user_name" required type="text" placeholder="이름 입력하세요">
        </div>
        <div>
            <label for="user_birth">생일: <input v-model="user_birth" required type="text" placeholder="생일 입력하세요"></label>
        </div>

        <div>
            <label for="user_email">이메일: </label>
            <input v-model="user_email" required type="text" placeholder="이메일 입력하세요">
        </div>

        <div>
            <label for="user_hp">전화번호: </label>
            <input v-model="user_hp" required type="text" placeholder="전화번호를 입력하세요">
        </div>

        <div>
            <label for="user_gender">성별: </label>
            <input v-model="user_gender" required type="text">
        </div>
        <div>
            <!-- <label for="com_address">회사주소: </label> -->
            <!-- <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요"> -->
            <input type="text" v-model="user_address" placeholder="주소"><br>
        </div>


        <button type="button" @click="submitForm" >가입하기</button>
    </section>


    <section class="hide">
        <h3>회사회원가입</h3>
        <div>
            <label for="user_id">아이디:</label>
            <input v-model="user_id" required type="text" placeholder="아이디를 입력하세요">
        </div>
        <div>
            <label for="user_pw">비밀번호: </label>
            <input v-model="user_pw" required type="password" placeholder="비밀번호를 입력하세요">
        </div>
        <div>
            <label for="user_name">이름: </label>
            <input v-model="user_name" required type="text" placeholder="이름 입력하세요">
        </div>
        <div>
            <label for="user_birth">생일: <input v-model="user_birth" required type="text" placeholder="생일 입력하세요"></label>
        </div>

        <div>
            <label for="user_email">이메일: </label>
            <input v-model="user_email" required type="text" placeholder="이메일 입력하세요">
        </div>

        <div>
            <label for="user_hp">전화번호: </label>
            <input v-model="user_hp" required type="text" placeholder="전화번호를 입력하세요">
        </div>

        <div>
            <label for="user_gender">성별: </label>
            <input v-model="user_gender" required type="text">
        </div>
        <div>
            <!-- <label for="com_address">회사주소: </label> -->
            <!-- <input v-model="com_address" required type="text" placeholder="회사주소를 입력하세요"> -->
            <input type="text" v-model="user_address" placeholder="주소"><br>
        </div>


        <button type="button" @click="submitForm" >가입하기</button>
    </section>
    <h4>푸터</h4>
</template>
  
  
<script>
export default {
    data() {
        return {
            com_name: '',
            com_ceo: '',
            business_number: '',
            postcode: "",
            address: "",
            extraAddress: "",
            com_userid: '',
            com_password: '',
            com_number: '',
            com_manager: '',
            com_email: '',
        };
    }, methods: {
        userJoin:(e) => {
            console.log(e.target.value)

            if(e.target.value==='individual'){
                e.currentTarget.parentElement.nextSibling.nextSibling.classList.remove('hide')
                e.currentTarget.parentElement.nextSibling.nextSibling.nextSibling.classList.add('hide')
            }
        },
        companyJoin:(e) => {
            console.log(e.target.value)

            if(e.target.value==='company'){
                e.currentTarget.parentElement.nextSibling.nextSibling.classList.remove('hide')
                e.currentTarget.parentElement.nextSibling.classList.add('hide')
            }
        },


        btn_view() {
            location.href = "page1";
        },
        execDaumPostcode() {
            new window.daum.Postcode({
                oncomplete: (data) => {
                    if (this.extraAddress !== "") {
                        this.extraAddress = "";
                    }
                    if (data.userSelectedType === "R") {
                        // 사용자가 도로명 주소를 선택했을 경우
                        this.address = data.roadAddress;
                    } else {
                        // 사용자가 지번 주소를 선택했을 경우(J)
                        this.address = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if (data.userSelectedType === "R") {
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                            this.extraAddress += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if (data.buildingName !== "" && data.apartment === "Y") {
                            this.extraAddress +=
                                this.extraAddress !== ""
                                    ? `, ${data.buildingName}`
                                    : data.buildingName;
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if (this.extraAddress !== "") {
                            this.extraAddress = `(${this.extraAddress})`;
                        }
                    } else {
                        this.extraAddress = "";
                    }
                    // 우편번호를 입력한다.
                    this.postcode = data.zonecode;
                },
            }).open();


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

            this.axios.post('/test/registForm',
                {
                    user_id: this.user_id,
                    user_pw: this.user_pw,
                    user_name: this.user_name,
                    user_birth: this.user_birth,
                    user_email: this.user_email,
                    user_hp: this.user_hp,
                    user_status: this.user_status,
                    user_gender: this.user_gender,
                    user_address: this.user_address
                }
            ).then(res => {
                console.log(res)
                this.$router.push({path:'/'})
            }).catch(err => {
                console.log(err)
            })
        }
    },
};



</script>
  
<style>
form {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 10px;
    margin: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
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

.hide{
    display: none;
}
</style>
  
  