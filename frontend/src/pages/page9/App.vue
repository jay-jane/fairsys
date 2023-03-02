
<template>

  <nav id="top">
    <ul>
      <li><a href="#"><img src="#"></a></li>
      <li><a href="#">채용정보</a></li>
      <li><a href="#">기업/연봉</a></li>
      <li><a href="#">마이페이지</a></li>
      <li><a href="#">로그인</a></li>
    </ul>
  </nav>
  <div>
    <div class="container">
      <div class="btn-group">
        <button class="btn" :class="{ active: isNoticeActive }" @click="showNotice">Q&A</button>
        <button class="btn" :class="{ active: isQnaActive }" @click="showQna">문의하기</button>
      </div>

      <div v-if="isNoticeActive" class="list-container">
        <h2>Q&A</h2>
        <ul id="list_ul">
          <li v-for="(notice, index) in notices" :key="index">
            <span class="num">{{ index + 1 }}</span>
            <a href="#">{{ notice.title }}</a>
            <span class="date">{{ notice.date }}</span>
          </li>
        </ul>
      </div>

      <div v-if="isQnaActive" class="list-container">
        <h2>문의하기</h2>
        <a href="page10">글 작성하기</A>
        <ul>
          <li v-for="(qna, index) in qnas" :key="index">
            <span class="num">{{ index + 1 }}</span>
            <a href="#">{{ qna.title }}</a>
            <span class="author">{{ qna.author }}</span>
            <span class="date">{{ qna.date }}</span>
          </li>
        </ul>
      </div>
    </div>
  </div>
  
  <div id="bottom">


  </div>
</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      isNoticeActive: true,
      isQnaActive: false,
      notices: [
        { title: "제목1", date: "2023-02-28" },
        { title: "제목2", date: "2023-02-27" },
        { title: "제목3", date: "2023-02-26" },
      ],
      qnas: [
        { title: "제목1", author: "작성자1", date: "2023-02-28" },
        { title: "제목2", author: "작성자2", date: "2023-02-27" },
        { title: "제목3", author: "작성자3", date: "2023-02-26" },
      ],
    };
  },
  methods: {
    showNotice() {
      this.isNoticeActive = true;
      this.isQnaActive = false;
    },
    showQna() {
      this.isNoticeActive = false;
      this.isQnaActive = true;
    }
  }
};
</script>

<style>
  #top{
    background-color: blue;
  }

  #top ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: space-around;
  }

  #top li {
    display: inline-block;
    padding: 10px;
  }

  #top a {
    color: white;
    text-decoration: none;
  }

  /* 리스트 디자인 */

  .list-container {
    background-color: aquamarine;
    border: 1px solid black;
  }

  #list_ul{
    border: 1px solid red;
    list-style-type: none;
    text-align: center;
  }

  #list_ul span{
    border: 1px solid salmon;
  }

  #list_ul a{
    border: 1px solid red;
  }

  .btn-group{
    text-align: center;
  }
</style>

