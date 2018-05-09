<template>
  <div class="profile" id="profile">
    <h1>{{ msg }}</h1>
    <button type="button" class="btn btn-primary">Login</button>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'profile',
  data () {
    return {
      msg: 'Welcome to Your profile Page'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
