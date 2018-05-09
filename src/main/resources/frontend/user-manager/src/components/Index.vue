<template>
  <div class="index" id="index">
    <div id="root">
      <div class="container">
        <div class="masthead">
            <h3 class="text-center">{{ msg }}</h3>
            <nav>
              <ul class="nav nav-justified">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#">Projects</a></li>
                  <li><a href="#">Services</a></li>
                  <li><a href="#">Downloads</a></li>
                  <li><a href="#">About</a></li>
                  <li>
                    <router-link id="goAddUserProfile" to="/profile">
                      <a>Add User</a>
                    </router-link>
                  </li>
              </ul>
            </nav>
        </div>
      </div>
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      msg: 'Welcome to Your User Manager'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
