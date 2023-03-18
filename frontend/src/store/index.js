import { createStore } from 'vuex'
import {createVuexPersistedState} from "vue-persistedstate";

export default createStore({
  plugins: [createVuexPersistedState()],

  state: {
    logInOut:'로그인',
  },
  
  mutations: {
    setLogInOut(state,data){
      state.logInOut= data;
    }
  },
  actions: {
  },
  modules: {
  },

})