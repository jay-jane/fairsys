import { createRouter, createWebHistory } from 'vue-router';
import Main from '../views/1Main.vue';

const routes = [
  {
    path: '/',
    name: 'main',
    component: Main
    // path: 유저가 접속하는 url주소 정의
    // name: views 폴더의 vue 파일 내부 사용할 클래스 명
    // component: import한 vue 파일의 이름
  },
  {
    path: '/2',
    name: 'login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/2Login.vue')
  },
  {
    path: '/3',
    name: 'join',
    component: () => import('../views/3Join.vue')
  },
  {
    path: '/33',
    name: 'join1',
    component: () => import('../views/3join1.vue')
  },
  {
    path: '/4',
    name: 'jobPosting',
    component: () => import('../views/4JobPosting.vue')
  },
  {
    path: '/5',
    name: 'jobPostingDetail',
    component: () => import('../views/5JobPostingDetail.vue')
  },
  {
    path: '/6',
    name: 'mypage',
    component: () => import('../views/6MyPage.vue')
  },
  {
    path: '/7',
    name: 'resumeRegist',
    component: () => import('../views/7ResumeRegist.vue')
  },
  {
    path: '/8',
    name: 'resumeModify',
    component: () => import('../views/8ResumeModify.vue')
  },
  {
    path: '/9',
    name: 'userInfoModify',
    component: () => import('../views/9UserInfoModify.vue')
  },
  {
    path: '/10',
    name: 'applyStatus',
    component: () => import('../views/10ApplyStatus.vue')
  },
  {
    path: '/11',
    name: 'questionList',
    component: () => import('../views/11QuestionList.vue')
  },
  {
    path: '/12',
    name: 'questionDetail',
    component: () => import('../views/12QuestionDetail.vue')
  },
  {
    path: '/13',
    name: 'questionWrite',
    component: () => import('../views/13QuestionWrite.vue')
  },
  {
    path: '/14',
    name: 'accountDelete',
    component: () => import('../views/14AccountDelete.vue')
  },
  {
    path: '/15',
    name: 'jobPostingAndApplicants',
    component: () => import('../views/15JobPostingAndApplicants.vue')
  },
  {
    path: '/16',
    name: 'jobPostingRegist',
    component: () => import('../views/16JobPostingRegist.vue')
  },
  {
    path: '/16-1',
    name: 'jobPostingModify',
    component: () => import('../views/16-1JobPostingModify.vue')
  },
  {
    path: '/17',
    name: 'adminMain',
    component: () => import('../views/17AdminMain.vue')
  },
  {
    path: '/18',
    name: 'adminCompanyList',
    component: () => import('../views/18AdminCompanyList.vue')
  },
  {
    path: '/19',
    name: 'adminCompanyManage',
    component: () => import('../views/19AdminCompanyManage.vue')
  },
  {
    path: '/20',
    name: 'adminUserList',
    component: () => import('../views/20AdminUserList.vue')
  },
  {
    path: '/21',
    name: 'adminStatistics',
    component: () => import('../views/21AdminStatistics.vue')
  },
  {
    path: '/test',
    name: 'test',
    component: () => import('../views/22Test.vue')
  },


  {
    path: '/25',
    name: '25',
    component: () => import('../views/25test.vue')
  },
  

  {
    path: '/26',
    name: '26',
    component: () => import('../views/26test.vue')
  },
  

  {
    path: '/99',
    name: 'test',
    component: () => import('../views/99TestList.vue')
  },

];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
