<template>
  <div class="login" id="login">
    <h1>{{ msg }}</h1>
    <button type="button" class="btn btn-primary">Login</button>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      msg: 'Welcome to Your Login Page'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
