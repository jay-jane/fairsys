import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import DataBinding from '../views/DataBinding.vue'
import Inquiry from '../views/Inquiry.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
    // path: 유저가 접속하는 url주소 정의
    // name: views 폴더의 vue 파일 내부 사용할 클래스 명
    // component: import한 vue 파일의 이름
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/databinding',
    name: 'dataBinding',
    component: DataBinding
  },
  {
    path: '/Inquiry',
    name: 'inquiry',
    component:Inquiry
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
