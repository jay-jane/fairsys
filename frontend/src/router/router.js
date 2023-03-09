import { createWebHistory, createRouter } from "vue-router";
import Home from "../pages/page1/App.vue";
import Login from "../pages/page2/App.vue";

const routes = [

    {
        path : "/page1",    //브라우저에서 접속하는 url 주소
        component: Home     //지정된 path로 들어옸을대 보여줄 vue컴포넌트 (import한것)
    },
    {
        path : "/login",
        component : Login
    },
    {
        path : "/test1",
        component : () => import('../pages/page41/App.vue')
    }

]

const router = createRouter({
    history : createWebHistory(),
    routes
});

export default router;