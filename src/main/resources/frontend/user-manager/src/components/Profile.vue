<template>
  <div class="profile container" id="profile">
    <el-form :model="user" :rules="rules" ref="user" label-width="100px" class="demo-user">
      <el-form-item label="姓名" prop="name">
        <el-col :span="11">
          <el-input v-model="user.name"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-select v-model="user.gender" placeholder="请选择性别">
          <el-option label="男" value="male"></el-option>
          <el-option label="女" value="female"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期" required>
        <el-col :span="11">
          <el-form-item prop="birthDate">
            <el-date-picker type="date" placeholder="选择出生日期" v-model="user.birthDate" style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item label="电话号码" prop="phoneNumber">
        <el-col :span="11">
          <el-input v-model="user.phoneNumber" placeholder="请输入电话号码"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="电子邮箱" prop="email">
        <el-col :span="11">
          <el-input v-model="user.email" placeholder="请输入电子邮箱"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('user')">保存用户</el-button>
        <el-button @click="goBackToContent()">取消</el-button>
      </el-form-item>
    </el-form>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'profile',
  data () {
    return {
      rules: {
        name: [
          { required: true, message: '请输入用户名称', trigger: 'blur' },
          { min: 1, max: 12, message: '长度在 1 到 12 个字符', trigger: 'blur' }
        ],
        gender: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        birthDate: [
          { type: 'date', required: true, message: '请选择出生日期', trigger: 'change' }
        ],
        phoneNumber: [
          { required: true, message: '请输入电话号码', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入电子邮箱', trigger: 'blur' }
        ]
      },
      user: {
        id: this.$route.params.userId,
        name: '',
        gender: '',
        birthDate: '',
        createdDate: Date,
        updatedDate: Date,
        email: '',
        phoneNumber: '',
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
        gender: 'male',
        birthDate: '',
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
    },
    submitForm: function (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.saveUser()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
