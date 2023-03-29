<template>
    <div class="main_page">
        <ul>
            <!-- for문사용 방법 : item >> 각 배열의 값 index >> 배열 현재 index list >> 배열명  -->
            <div v-for="(item, index) in pageList" :key="index" class="main_page_btn">
                <li v-bind:class="{ 'on': item === page }">
                    <router-link :to="{ path: '/?page=' + page + '&amount=' + amount }" style="padding: 10px"
                        @click="thisPage($event.target)">
                        {{ item }}
                    </router-link>
                </li>
            </div>
        </ul>
    </div>
    <div class="main_page_middle" v-for="(item, index) in jobList">
        <div class="card_detail">
            <div class="logo empty"><img src="@/img/jobposting_logo.png"></div>
            <div class="box_bubble"><span class="txt">{{ item.j_regdate.substr(0, 11) }}</span>
            </div>
            <div class="box_text"><strong class="tit_type2">{{ item.com_name }}</strong></div>
            <div class="box_source">
                <p class="corp">{{ item.com_name }}</p>
            </div>
        </div>
    </div>
    <div class="hidden" v-for="(item,index) in number">
        <div class="card_detail">
            <div class="logo empty"><img src=""></div>
            <div class="box_bubble"><span class="txt"></span>
            </div>
            <div class="box_text"><strong class="tit_type2"></strong></div>
            <div class="box_source">
                <p class="corp"></p>
            </div>
        </div>
    </div>
   

    <div class="go_front">
        <!-- 앞으로 가기 -->
        <router-link :to="{ path: '/?page=' + page + '&amount=' + amount }" @click="goBeforePage" class="btn_prev">
            <span class="l_arrow"></span>
        </router-link>
    </div>

    <!-- 중앙 컨텐츠 -->

    <div class="go_back">
        <!-- 뒤로 가기 -->
        <router-link :to="{ path: '/?page=' + page + '&amount=' + amount }" @click="goNextPage" class="btn_next">
            <span class="r_arrow"></span>
        </router-link>
    </div>
</template>
  
<script>
import axios from 'axios';

export default {
    name: 'App',

    data() {
        return {
            jobPostingList: '',


            //공용
            pages: '',   //pageVO
            pageList: '',  //pageVO.pageList 배열값
            detailNum: '',

            //페이지이동에 필요한 초기값들
            page: 1,
            amount: 3,
            prev: '',
            pageStart: '',
            pageEnd: '',
            realEnd: '',

            total: '',
            jobList: '',
            //게시글 리스트
        }
    },
    methods: {
        getTop() {
            axios.get("/main2/?amount=" + this.amount + "&page=" + this.page
            ).then(res => {
                console.log(res)
                console.log(res.data)
                this.jobList = res.data.jobList;

                console.log(res.data.pageVO)
                this.pages = res.data.pageVO;
                this.pageList = this.pages.pageList;
                this.total = res.data.pageVO.total;
                //페이지이동에 필요한 데이터 담기
                this.page = this.pages.page;
                this.searchTitle = this.pages.cri.searchTitle;
                this.searchContent = this.pages.cri.searchContent;
                this.prev = this.pages.prev;
                this.pageStart = this.pages.pageStart;
                this.pageEnd = this.pages.pageEnd;
                this.realEnd = this.pages.realEnd;
            }).catch(err => {
                console.log(err)
                console.log(err.data)
            })


        },
        thisPage(target) {
            this.page = target.innerHTML;
            this.get();
        },
        getDetail(j_no) {
            this.$router.push({
                path: '/jobPostingDetail',
                name: 'jobPostingDetail',
                params: { 'j_no': j_no }
            })
        },

        goBeforePage() {
            if (this.page > 1) {
                this.page = this.page - 1;
                this.getTop();
            } else {
                alert("첫번째 페이지입니다.");
            }
        },
        thisPage(target) {
            this.page = target.innerHTML;
            this.getTop();
        },
        goNextPage() {
            if (this.page < this.realEnd) {
                this.page = this.page + 1;
                this.getTop();
            } else {
                alert("마지막 페이지입니다.");
            }
        },
    },


    mounted() {
        this.getTop()
    },


};
</script>
   
<style>
.inner {
    display: flex;
    justify-content: center;
    position: relative;
    width: 1300px;
    margin: 0 auto;
}

.inner .main_page ul {
    list-style: none;
    margin-top: 15px;
}

.main_page_btn {
    display: flex;
    padding-left: 12px;
    width: 100%;
    height: 40px;
    border-radius: 8px;
    box-sizing: border-box;
    color: var(--color_primary);
    font-size: 14px;
    letter-spacing: -1px;
    text-align: left;
    align-items: center;
}

.main_page_btn a {
    display: inline-block;
    width: 120px;
    font-weight: bold;
    display: flex;
    padding-left: 12px;
    height: 40px;
    border-radius: 8px;
    box-sizing: border-box;

}

.main_page_btn .on {
    font-weight: bold;
    background-color: #FFB973;
}

.card_detail {
    position: relative;
    z-index: 5;
    padding: 24px 20px 20px;
    height: 100%;
    box-sizing: border-box;
    letter-spacing: -1px;
    display: block;
    overflow: hidden;
    position: relative;
    margin: 10px 15px;
    width: 228px;
    height: 280px;
    border: solid 1px #eaedf4;
    border-radius: 8px;
    box-sizing: border-box;
    background-color: #fff;
}

.card_detail .logo {
    display: flex;
    overflow: hidden;
    margin-bottom: 12px;
    width: 56px;
    height: 56px;
    border: 1px solid #eaedf4;
    border-radius: 50%;
    box-sizing: border-box;
    align-items: center;
    justify-content: center;
}

.card_detail .box_bubble .txt {
    display: inline-block;
    position: relative;
    z-index: 10;
    margin-right: 4px;
    padding: 0 4px;
    height: 20px;
    border-radius: 4px;
    box-sizing: border-box;
    font-size: 12px;
    letter-spacing: 0.5px;
    line-height: 20px;
    background: #f4f6fa;
}


.btn_prev {
    display: block;
    width: 32px;
    height: 32px;
    border-radius: 16px;
    background-color: rgba(255, 255, 255, 0.5);
    box-shadow: 0 4px 6px 0 rgba(55, 63, 87, 0.1);
    -webkit-backdrop-filter: blur(3px);
    backdrop-filter: blur(3px);
    text-align: center;
}

.btn_next {
    display: block;
    width: 32px;
    height: 32px;
    border-radius: 16px;
    background-color: rgba(255, 255, 255, 0.5);
    box-shadow: 0 4px 6px 0 rgba(55, 63, 87, 0.1);
    -webkit-backdrop-filter: blur(3px);
    backdrop-filter: blur(3px);
}

.go_front{
    position: absolute;
    top: 120px;
    left:100px;
    z-index: 100;
}
.go_front .l_arrow{
    margin-left: 2px;
    border-width: 0 0 2px 2px;
    display: block;
    position: absolute;
    top: 50%;
    left: 50%;
    width: 7px;
    height: 7px;
    border-style: solid;
    transform: translate(-50%, -50%) rotate(45deg);
    content: "";
}
.go_back{
    position: absolute;
    top: 120px;
    left:890px;
    z-index: 100;
}

.go_back .r_arrow{
    margin-left: -2px;
    border-width: 2px 2px 0 0;
    display: block;
    position: absolute;
    top: 50%;
    left: 50%;
    width: 7px;
    height: 7px;
    border-style: solid;
    transform: translate(-50%, -50%) rotate(45deg);
    content: "";
}




.wrap_service_aside {
    margin-left: 120px;
}


.cont_top .wrap_service_aside .area_matching {
    display: grid;
    position: relative;
    overflow: hidden;
    margin-bottom: 16px;
    width: 292px;
    height: 240px;
    padding-bottom: 30px;
    border-radius: 8px;
    box-sizing: border-box;
    background: orange;
    grid-template-rows: 1fr auto 40px;
    place-content: end center;
    place-items: end center;
}

.cont_top .wrap_service_aside .area_matching:before {
    display: block;
    content: ""
}


.cont_top .wrap_service_aside .area_matching.banner02:before {
    width: 156px;
    height: 80px;
    margin-bottom: 11px;
    background: url('../img/first_image.png') 50% 50% no-repeat;
}


.cont_top .wrap_service_aside .area_matching .title {
    display: block;
    color: #fff;
    font-size: 20px;
    font-weight: bold;
    letter-spacing: -1px;
    line-height: 30px;
    text-align: center;
    position: relative;
}

.cont_top .wrap_service_aside .area_matching .title b {
    color: #abfcff;
    text-decoration: underline;
    text-underline-offset: 4px
}



.cont_top .wrap_service_aside .area_matching .btn {
    display: flex;
    width: 160px;
    height: 40px;
    border-radius: 4px;
    font-size: 14px;
    font-weight: bold;
    letter-spacing: -1px;
    background: #fff;
    justify-content: center;
    align-items: center
}
</style>
   