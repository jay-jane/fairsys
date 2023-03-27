import { createRouter, createWebHistory } from "vue-router";
import Main from "../views/1Main.vue";

const routes = [
  {
    path: "/",
    name: "main",
    component: Main,
    // path: 유저가 접속하는 url주소 정의
    // name: views 폴더의 vue 파일 내부 사용할 클래스 명
    // component: import한 vue 파일의 이름
    
  },
  {
    path: "/main2",
    name: "main2",
    component: () =>
    import(/* webpackChunkName: "about" */ "../views/Main2.vue"),
  },
  {
    path: "/2",
    name: "login",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/2Login.vue"),
  },
  {
    path: "/3-1",
    name: "join",
    component: () => import("../views/3-1join.vue"),
  },
  {
    path: "/3-2",
    name: "join1",
    component: () => import("../views/3-2join.vue"),
  },
  {
    path: "/4",
    name: "jobPosting",
    component: () => import("../views/4JobPosting.vue"),
  },
  {
    path: "/jobPostingDetail/:j_no",
    name: "jobPostingDetail",
    component: () => import("../views/5JobPostingDetail.vue"),
  },
  {
    path: "/6/mypage",
    name: "mypage",
    component: () => import("../views/6MyPage.vue"),
  },
  {
    path: "/ResumeRegist",
    name: "ResumeRegist",

    component: () => import("../views/7ResumeRegist.vue"),
  },
  {
    path: "/ResumeModify/:user_no",
    name: "ResumeModify",
    component: () => import("../views/8ResumeModify.vue"),
  },
  {
    path: "/ResumeComModify/:user_no",
    name: "ResumeComModify",
    component: () => import("../views/8ResumeComModify.vue"),
  },
  {
    path: "/9-1",
    name: "userInfoModify",
    component: () => import("../views/9-1UserInfoModify.vue"),
  },
  {
    path: "/9-2",
    name: "CompanyInfoModify",
    component: () => import("../views/9-2CompanyInfoModify.vue"),
  },
  {

    path: "/ApplyStatus/",
    name: "ApplyStatus",
    component: () => import("../views/10ApplyStatus.vue"),
  },
  {
    path: "/11",
    name: "questionList",
    component: () => import("../views/11QuestionList.vue"),
  },
  {
    path: "/12/:qa_no",
    name: "questionDetail",
    component: () => import("../views/12QuestionDetail.vue"),
  },
  {
    path: "/13",
    name: "questionWrite",
    component: () => import("../views/13QuestionWrite.vue"),
  },
  {
    path: "/14",
    name: "accountDelete",
    component: () => import("../views/14AccountDelete.vue"),
  },
  {
    path: "/15",
    name: "jobPostingAndApplicants",
    component: () => import("../views/15JobPostingAndApplicants.vue"),
  },
  {
    path: "/registJobPosting/:com_id",
    name: "jobPostingRegist",
    component: () => import("../views/16JobPostingRegist.vue"),
  },
  {
    path: "/jobPostingModify/:j_no",
    name: "jobPostingModify",
    component: () => import("../views/16-1JobPostingModify.vue"),
  },
  {
    path: "/17",
    name: "adminMain",
    component: () => import("../views/17AdminMain.vue"),
  },
  {
    path: "/18",
    name: "adminCompanyList",
    component: () => import("../views/18AdminCompanyList.vue"),
  },
  {
    path: "/19",
    name: "adminCompanyManage",
    component: () => import("../views/19AdminCompanyManage.vue"),
  },
  {
    path: "/20",
    name: "adminUserList",
    component: () => import("../views/20AdminUserList.vue"),
  },
  {
    path: "/21",
    name: "adminStatistics",
    component: () => import("../views/21AdminStatistics.vue"),
  },
  {
    path: "/22/:com_id",
    name: "test",
    component: () => import("../views/22Test.vue"),
  },


  {
    path: '/ResumeUpdate:user_no',
    name: 'ResumeUpdate',
    component: () => import('../views/ResumeUpdate.vue')
  },
  {
    path: '/UserMyPage',
    name: 'userMyPage',
    component: () => import('../views/66MyPage.vue')
  },
  {
    path: '/UserMyPage1',
    name: 'userMyPage1',
    component: () => import('../views/67MyPage.vue')
  },

  {
    path: "/26",
    name: "26",
    component: () => import("../views/26test.vue"),
  },

  {
    path: "/27",
    name: "27",
    component: () => import("../views/27test.vue"),
  },


  {
    path: "/50/:com_id",
    name: "AdminCompanyDetail",
    component: () => import("../views/50AdminCompanyDetail.vue"),
  },



];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
