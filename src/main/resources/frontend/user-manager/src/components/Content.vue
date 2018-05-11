<template>
  <div class="container">
    <!-- <button type="button" class="btn btn-primary" v-on:click="searchUsers">Test</button> -->
    <div class="user-table">
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
          :formatter="genderFormat"
          width="80">
        </el-table-column>
        <el-table-column
          prop="birthDate"
          :formatter="dateFormat"
          width="100"
          label="出生日期">
        </el-table-column>
        <el-table-column
          prop="email"
          width="200"
          label="电子邮件">
        </el-table-column>
        <el-table-column
          prop="phoneNumber"
          width="180"
          label="联系方式">
        </el-table-column>
        <el-table-column
          width="180"
          label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
       <div class="block">
        <span class="demonstration">完整功能</span>
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNumber + 1"
          :page-sizes="[5, 10, 20, 50]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="totalElements">
        </el-pagination>
      </div>
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
      searchName: '',
      pageNumber: 0,
      pageSize: 5,
      totalPages: 0,
      totalElements: 0,
      numberOfElements: 0, // Current page's number of elements
      isLastPage: true,
      isFirstPage: true,
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
  computed: {
    getSearchName: function () {
      return this.$store.state.searchName
    }
  },
  watch: {
    getSearchName: function (val) {
      this.searchName = val
      this.searchUsers()
    }
  },
  methods: {
    searchUsers: function () {
      var _this = this
      this.$http.get('/users/search', {
        params: {
          name: this.searchName,
          pageNumber: this.pageNumber,
          pageSize: this.pageSize
        }
      }).then(function (response) {
        _this.users = response.data.content
        _this.totalPages = response.data.totalPages
        _this.totalElements = response.data.totalElements
        _this.numberOfElements = response.data.numberOfElements
        _this.isLastPage = response.data.last
        _this.isFirstPage = response.data.first
      }).catch(function (error) {
        console.log(error)
      })
    },
    handleSizeChange: function (pageSize) {
      this.pageSize = pageSize
      this.searchUsers()
    },
    handleCurrentChange: function (pageNumber) {
      this.pageNumber = pageNumber - 1
      this.searchUsers()
    },
    handleEdit: function (index, row) {
      this.$router.push({name: 'profile', params: {userId: row['id']}})
    },
    handleDelete: function (index, row) {
      var _this = this
      this.$http.delete('/users/' + row['id']).then(function (response) {
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
    },
    genderFormat: function (row, column) {
      var gender = row[column.property]
      if (gender === 'male') {
        return '男'
      } else if (gender === 'female') {
        return '女'
      } else {
        return '未知'
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
