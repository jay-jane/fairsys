<template>
  <div class="home">
    <Inquiry></Inquiry>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Inquiry from './Inquiry.vue';

export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    Inquiry
  }
}
</script>
