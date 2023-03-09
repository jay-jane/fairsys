import { createWebHistory, createRouter } from "vue-router";
// import VueRouter from 'vue-router' 
import Page8 from '../../page8/App.vue';
import Page35 from '../../page35/App.vue';

const routes = [

    { path: '/page8', name: 'page8', component: Page8 },
    { path: '/page35', name: 'page35', component: Page35 }  ,
]


// const router = new VueRouter({
//     mode: 'history',
//     base: process.env.BASE_URL,
//     routes
//   })
  

const router = createRouter({

    history: createWebHistory(process.env.BASE_URL),
    routes,
    
});

export {router} ;
