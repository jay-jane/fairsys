<template>
  <Header></Header>
  <!-- <Side></Side> -->
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
</style>
