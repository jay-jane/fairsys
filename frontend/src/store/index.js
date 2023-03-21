import { createStore } from 'vuex'
import {createVuexPersistedState} from "vue-persistedstate";

export default createStore({
  plugins: [createVuexPersistedState()],

  //공통으로 관리할 데이터
  state: {
    logInOut:'로그인',
    qa_no:0  //qna글번호
  },
  
  //state를 변경할때 사용하는 함수의 모음이며 비동기에 대한 처리를 담당안함
  mutations: {
    setLogInOut(state,data){
      state.logInOut= data;
    },
    setQnaDetailNo(state,data){
      state.qa_no= data;
    }
  },

  //비동기 처리하는 함수들의 모음
  actions: {
  },

  //추가 라이브러리를 적용할때 사용
  modules: {
  },

})