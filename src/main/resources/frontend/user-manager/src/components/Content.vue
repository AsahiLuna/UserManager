<template>
  <div class="content" id="content">
    <h1>{{ msg }}</h1>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'content',
  data () {
    return {
      msg: 'Welcome to Your User Manager Content'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
