<template>
  <div>
    <h1>{{ msg }}</h1>
    <button type="button" class="btn btn-primary" v-on:click="testAxios">Test</button>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'user-content',
  data () {
    return {
      msg: 'Welcome to Your User Manager Content'
    }
  },
  methods: {
    testAxios: function () {
      this.$http.get('/users/search').then(function (response) {
        console.log(response)
      }).catch(function (error) {
        console.log(error)
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
