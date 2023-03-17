<template>
    <div id="bottom">
        중앙정보처리 채용 박람회<br />
        서울 강남구 테헤란로 7길 7(역삼동 에스코빌딩 6층) / 대표자:정현경<br />
        TEL:02-561-1911 / FAX:02-538-2613
    </div>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style>
 @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
* {padding: 0; margin: 0; font-family: 'Noto Sans KR', sans-serif; text-decoration: none;}



/* footer 디자인 */
#bottom {
  height: 200px;
  background-color: #263238;
  top: 0;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center; /* 속성이 적용된 요소내의 자식들을 수직방향으로 정렬 */
}

</style>
