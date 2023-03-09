<template>
    <div class="dataBinding">
        <h1>Hello, {{ title }}</h1>
    </div>
</template>
<script>

export default {
  name: 'dataBinding',
  data() {
    return {
      title: '테스트'
    }
  }
}

</script>