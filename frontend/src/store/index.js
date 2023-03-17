import { createStore } from 'vuex'

export default createStore({
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
  }
})