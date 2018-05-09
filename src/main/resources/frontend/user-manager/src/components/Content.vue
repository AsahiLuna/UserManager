<template>
  <div class="container">
    <!-- <button type="button" class="btn btn-primary" v-on:click="searchUsers">Test</button> -->
    <div class="user-table">
      <!-- <table class="table table-hover table-bordered">
        <thead>
          <tr>
            <th class="col-md-1">Id</th>
            <th class="col-md-1">Name</th>
            <th class="col-md-1">Gender</th>
            <th class="col-md-2">BirthDate</th>
            <th class="col-md-2">Email</th>
            <th class="col-md-1">Phone Number</th>
            <th class="col-md-2">Updated Date</th>
            <th class="col-md-1">Operation</th>
          </tr>
        </thead>
        <tbody>
          <tr v-bind:key="user.id" v-for="(user, index) in users">
            <td>{{index + 1}}</td>
            <td>{{user.name}}</td>
            <td>{{user.gender}}</td>
            <td>{{user.birthDate | formatDate}}</td>
            <td>{{user.email}}</td>
            <td>{{user.phoneNumber}}</td>
            <td>{{user.updatedDate | formatDate}}</td>
            <td>
              <a v-on:click="goEditProfile(user.id)" class="btn btn-info btn-sm">
                <span class="glyphicon glyphicon-pencil"></span>
              </a>
               <a v-on:click="deleteUser(user.id)" class="btn btn-danger btn-sm">
                <span class="glyphicon glyphicon-trash"></span>
              </a>
            </td>
          </tr>
        </tbody>
      </table> -->
      <el-table
        :data="users"
        border
        style="width: 100%">
        <el-table-column
          prop="name"
          label="姓名"
          width="180">
        </el-table-column>
        <el-table-column
          prop="gender"
          label="性别"
          width="180">
        </el-table-column>
        <el-table-column
          prop="birthDate"
          :formatter="dateFormat"
          label="出生日期">
        </el-table-column>
      </el-table>
    </div>
    <router-view/>
  </div>
</template>

<script>
import moment from 'moment'

export default {
  name: 'user-content',
  data () {
    return {
      users: [{
        id: String,
        name: String,
        gender: String,
        birthDate: Date,
        createdDate: Date,
        updatedDate: Date,
        email: String,
        phoneNumber: String,
        deleted: Boolean
      }],
      msg: 'Welcome to Your User Manager Content'
    }
  },
  mounted: function () {
    this.searchUsers()
  },
  methods: {
    searchUsers: function () {
      var _this = this
      this.$http.get('/users/search').then(function (response) {
        _this.users = response.data.content
      }).catch(function (error) {
        console.log(error)
      })
    },
    goEditProfile: function (userId) {
      this.$router.push({name: 'profile', params: {userId: userId}})
    },
    deleteUser: function (userId) {
      var _this = this
      this.$http.delete('/users/' + userId).then(function (response) {
        _this.searchUsers()
      }).catch(function (error) {
        console.log(error)
      })
    },
    dateFormat: function (row, column) {
      var date = row[column.property]
      if (date === undefined) {
        return ''
      }
      return moment(new Date(date)).format('YYYY-MM-DD', moment.ISO_8601)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
