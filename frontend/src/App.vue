<template>
  <Header></Header>
  <Side></Side>
  <router-view />
  <Footer></Footer>
</template>

<script>
import Header from './layouts/Header.vue';
import Footer from './layouts/Footer.vue';
import Side from './layouts/Side.vue';


export default {
  components: {
    Header,
    Footer,
    Side,
  }
}

</script>

<style>
@import url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCC-Ganpan.woff2');
#app {
    font-family: 'KCC-Ganpan';
    font-weight: normal;
    font-style: normal;
}
</style>
