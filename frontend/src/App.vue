<template>
  <Header></Header>
  
  <!-- <AdminHeader class="name"></AdminHeader> -->
  <Side></Side>
  <router-view />
  <Footer></Footer>
</template>

<script>
import Header from './layouts/Header.vue';
import Footer from './layouts/Footer.vue';
import Side from './layouts/Side.vue';
import AdminHeader from './layouts/AdminHeader.vue';


export default {
  components: {
    Header,
    AdminHeader,
    Footer,
    Side,
  }
}

</script>

<style>
.name{
  display: none;
}
</style>
