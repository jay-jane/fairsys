<template>
  <!-- <UserHeader v-if="ut_no == 1 || ut_no == null" class="userHeader"  :key="ut_no"></UserHeader> -->
  <!-- <CompanyHeader v-if="ut_no == 2" class="companyHeader" :key="ut_no"></CompanyHeader> -->
  <AdminHeader></AdminHeader>
  <Side></Side>
  <router-view />
  <Footer></Footer>
</template>

<script>
import UserHeader from './layouts/UserHeader.vue';
import CompanyHeader from './layouts/CompanyHeader.vue';
import Footer from './layouts/Footer.vue';
import Side from './layouts/Side.vue';
import AdminHeader from './layouts/AdminHeader.vue';



export default {
  components: {
    UserHeader,
    CompanyHeader,
    AdminHeader,
    Footer,
    Side,
  },
  data() {
    return {
      user_id: '',
      user_pw: '',
      com_id: '',
      com_pw: '',
      ut_no: this.$store.state.ut_no,
    }
  },
  methods: {
    checkUser() {
      const sessionUtNo = sessionStorage.getItem("ut_no")
      console.log("sessionUtNo:" + sessionUtNo)
      if (sessionUtNo == 1 || sessionUtNo == null) {
        this.$store.commit("setUtNo", 1)
        this.ut_no = this.$store.state.ut_no
        console.log(this.ut_no)
      } else {
        this.$store.commit("setUtNo", 2)
        this.ut_no = this.$store.state.ut_no
        console.log(this.ut_no)
      }
    },
  },
  created() {
    this.checkUser()
  },
  watch: {
    'ut_no': function () {
      console.log(this.ut_no)
      this.checkUser();
    }
  },

}

</script>

<style>
.name {
  display: none;
}
</style>
