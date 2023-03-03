<template>
  <editor-menu-bar :editor="editor" />
  <editor-content :editor="editor" />
</template>
  
<script>
import { Editor, EditorContent, EditorMenuBar } from '@tiptap/vue-3'
import StarterKit from '@tiptap/starter-kit'

export default {
  components: {
    EditorMenuBar,
    EditorContent,
  },

  data() {
    return {
      editor: null
    }
  },

  mounted() {
    this.editor = new Editor({
      content: '<p>I’m running Tiptap with Vue.js. 🎉</p>',
      extensions: [
        StarterKit,
      ],
    })
  },

  beforeUnmount() {
    this.editor.destroy()
  },
}
</script>