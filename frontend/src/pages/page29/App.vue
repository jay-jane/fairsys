<!-- 재윤 - 쪽지 상세 페이지 -->
<template>
  <div id="message_wrap">
    <div class="title_wrap">
      <h3>받은 쪽지</h3>
    </div>
    <div class="msg_header">
      <dl class="msg_info">
        <dt id="sender_title">보낸 사람</dt>
        <dd>
          <span class="title">
            <span>이이이(id)</span>
          </span>
        </dd>
        <dt id="date_title">보낸시간</dt>
        <dd id="receive_date">23-03-06 [14:57]</dd>
      </dl>
    </div>
    <div id="readbody" class="msg_content">
      안녕 ! ! ! !
    </div>
  </div>
  <div class="msg_menu">
    <button type="button" class="" @click="msg_list">목록</button>
    <button type="button" class="" @click="msg_delete">삭제</button>
  </div>
</template>

<script>

export default {
  name: 'App',
  methods: {
    msg_list() {
      location.href = "page21";
    },
    msg_delete() {
      alert('삭제 이벤트');
    },
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
* {
  padding: 0;
  margin: 0;
  list-style: none;
  text-decoration: none;
  box-sizing: border-box;
  font-family: 'Noto Sans KR', sans-serif;
}

.title_wrap {
  height: 30px;
    border-bottom: 1px solid #e7e8eb;
    position: relative;
    z-index: 5;
    overflow: hidden;
}

.msg_header {
  margin-top: 20px;
  padding-left: 15px;
  min-width: 460px;
  overflow: hidden;
  position: relative;
  border-bottom: 1px solid #e8e8e8;
  padding: 0 0 0 19px;
  margin-bottom: 20px;
  zoom: 1;
}

.msg_info {
  font-size: 12px;
  line-height: 18px;
  padding: 8px 20px 6px 0;
}
.msg_info dt {
  float: left;
  width: 67px;
  font-weight: bold;
  color: #333;
}
.msg_info dd {
  height: 18px;
  padding: 3px 0 2px;
}

.msg_content {
  height: auto;
  border: 0;
  padding: 17px 0 17px 15px;
  overflow: hidden;
  background-color: #fff;
  font-size: 12px;
  color: #333;
  line-height: 18px;
  clear: both;
  text-align: left;
  word-wrap: break-word;
  word-break: break-all;
  width: 460px;
  zoom: 1;
}

.msg_menu {
  border-top: 1px solid #e8e8e8;
  padding: 10px 14px;
  overflow: hidden;
  margin-top: 36px;
  font-size: 11px;
  letter-spacing: -1px;
  color: #858585;
  position: relative;
  line-height: 16px;
  min-height: 17px;
  white-space: nowrap;
}

</style>
