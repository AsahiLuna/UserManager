<template>
  <div class="profile container" id="profile">
    <h1 class="text-center">{{ msg }}</h1>
    <form class="form-horizontal col-sm-8" role="form">
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="name" v-model="user.name" placeholder="Please input your name">
        </div>
      </div>
      <div class="form-group">
        <label for="gender" class="col-sm-2 control-label">Gender</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="gender" v-model="user.gender" placeholder="Please select your gender">
        </div>
      </div>
      <div class="form-group">
        <label for="birth-date" class="col-sm-2 control-label">Birth Date</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="birth-date" v-model="user.birthDate" placeholder="Please select your Birth Date">
        </div>
      </div>
      <div class="form-group">
        <label for="phone-number" class="col-sm-2 control-label">Phone Number</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="phone-number" v-model="user.phoneNumber" placeholder="Please input your phone number">
        </div>
      </div>
      <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="email" v-model="user.email" placeholder="Please input your Email">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button v-on:click="saveUser" class="btn btn-primary">Save</button>
          <button v-on:click="goBackToContent" class="btn btn-warning">Cancel</button>
        </div>
      </div>
    </form>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'profile',
  data () {
    return {
      user: {
        id: this.$route.params.userId,
        name: String,
        gender: String,
        birthDate: Date,
        createdDate: Date,
        updatedDate: Date,
        email: String,
        phoneNumber: String,
        deleted: Boolean
      },
      msg: 'Welcome to Your profile Page'
    }
  },
  created: function () {
    if (this.$route.params.userId != null) {
      this.getUser()
    } else {
      this.user = {
        id: '',
        name: '',
        gender: 'unknown',
        birthDate: new Date(),
        createdDate: new Date(),
        updatedDate: new Date(),
        email: '',
        phoneNumber: '',
        deleted: false
      }
    }
  },
  methods: {
    getUser: function () {
      var _this = this
      if (_this.user.id != null) {
        this.$http.get('/users/' + _this.user.id).then(function (response) {
          _this.user = response.data
        }).catch(function (error) {
          console.log(error)
        })
      }
    },
    saveUser: function () {
      var _this = this
      this.$http.post('/users/save', _this.user).then(function (response) {
        _this.user = response.data
      }).catch(function (error) {
        console.log(error)
      })
      _this.goBackToContent()
    },
    goBackToContent: function () {
      this.$router.push({path: '/'})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
