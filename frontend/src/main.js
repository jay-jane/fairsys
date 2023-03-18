import {createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/index'
import axios from 'axios'

window.Kakao.init("0d488246e5fc1d67c5210897750622f2");//발급 받은 앱키
const app = createApp(App).use(store).use(router);
app.config.globalProperties.axios = axios;
app.mount('#app');
