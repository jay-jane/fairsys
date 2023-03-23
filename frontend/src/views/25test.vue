<template>
  <div>
    <h1 v-show="showHeader">Hello, World!</h1>
    <p v-show="showParagraph">This is some text.</p>
    <button @click="toggleVisibility">Toggle Visibility</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      showHeader: true,
      showParagraph: false,
    };
  },
  methods: {
    toggleVisibility() {
      this.showHeader = !this.showHeader;
      this.showParagraph = !this.showParagraph;
    },
  },
};
</script>