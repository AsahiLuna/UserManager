<template>
  <div class="container">
    <el-tag
      v-if="getSearchName != ''"
      :key="tag"
      v-for="tag in [getSearchName]"
      closable
      :disable-transitions="false"
      @close="handleClose(tag)">
      {{tag}}
    </el-tag>
    <el-row type="flex" class="row-bg" justify="center">
      <div class="user-table">
        <transition name="el-zoom-in-top">
          <el-table
            v-show="!isTableLoading" class="transition-table"
            v-loading="isTableLoading"
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
              label="手机号码">
            </el-table-column>
            <el-table-column
              width="180"
              label="操作">
              <template slot-scope="scope">
                <el-button v-if="!isDeletedUserContent"
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button v-if="!isDeletedUserContent"
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                <el-button v-if="isDeletedUserContent"
                  size="mini"
                  type="success"
                  @click="handleCancelDelete(scope.$index, scope.row)">找回用户</el-button>
              </template>
            </el-table-column>
          </el-table>
        </transition>
        <div class="block">
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
        <el-row type="flex" class="row-bg" justify="end">
          <el-switch
            v-model="isDeletedUserContent"
            active-text="找回用户"
            inactive-text="查看用户">
          </el-switch>
        </el-row>
      </div>
    </el-row>
    <router-view/>
  </div>
</template>

<script>
import moment from 'moment'

export default {
  name: 'user-content',
  data () {
    return {
      isDeletedUserContent: false,
      accessToken: '',
      isTableLoading: true,
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
    isDeleted: function () {
      return this.isDeletedUserContent ? 1 : 0
    },
    getSearchName: function () {
      return this.$store.state.searchName
    },
    getAuthorization: function () {
      return this.$store.state.accessToken
    }
  },
  watch: {
    isDeleted: function (val) {
      this.searchUsers()
    },
    getSearchName: function (val) {
      this.searchName = val
      this.searchUsers()
    },
    getAuthorization: function (val) {
      this.accessToken = val
      this.searchUsers()
    }
  },
  methods: {
    searchUsers: function () {
      this.isTableLoading = true
      var _this = this
      this.$http.get('/users/search', {
        params: {
          name: this.searchName,
          pageNumber: this.pageNumber,
          pageSize: this.pageSize,
          isDeleted: this.isDeleted
        },
        headers: {'Authorization': _this.$store.state.accessToken}
      }).then(function (response) {
        _this.users = response.data.content
        _this.totalPages = response.data.totalPages
        _this.totalElements = response.data.totalElements
        _this.numberOfElements = response.data.numberOfElements
        _this.isLastPage = response.data.last
        _this.isFirstPage = response.data.first
        _this.isTableLoading = false
      }).catch(function (error) {
        _this.checkResponseError(error)
      })
    },
    handleClose: function (tag) {
      this.$store.commit('search', '')
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
      this.$confirm('此操作将删除该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        this.$http.delete('/users/' + row['id'], {
          headers: {'Authorization': _this.$store.state.accessToken}
        }).then(function (response) {
          _this.searchUsers()
          _this.$message({
            type: 'success',
            message: '删除成功!'
          })
        }).catch(function (error) {
          _this.$message({
            type: 'error',
            message: error.response.data
          })
          _this.checkResponseError()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleCancelDelete: function (index, row) {
      var _this = this
      this.$confirm('此操作将取消删除该用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        this.$http.patch('/users/' + row['id'], {
          headers: {'Authorization': _this.$store.state.accessToken}
        }).then(function (response) {
          _this.searchUsers()
          _this.$message({
            type: 'success',
            message: '找回成功!'
          })
        }).catch(function (error) {
          _this.$message({
            type: 'error',
            message: error.response.data
          })
          _this.checkResponseError()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消找回'
        })
      })
    },
    checkResponseError (error) {
      this.$message({
        type: 'error',
        message: error.response.data
      })
      if (error.response.data.message === 'Access Denied') {
        this.$store.commit('login', true)
      }
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
