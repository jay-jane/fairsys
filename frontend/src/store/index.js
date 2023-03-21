import { createStore } from 'vuex'
import {createVuexPersistedState} from "vue-persistedstate";

export default createStore({
  plugins: [createVuexPersistedState()],

  state: {
    logInOut:'로그인',
    ut_no:'',
  },
  
  mutations: {
    setLogInOut(state,data){
      state.logInOut= data;
    },
    setUtNo(state, data){
      state.ut_no=data;
    }
  },
  actions: {
  },
  modules: {
  },

})