<template>
  <div class="profile container" id="profile">
    <!-- <form class="form-horizontal col-sm-8" role="form">
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="name" v-model="user.name" placeholder="Please input your name">
        </div>
      </div>
      <div class="form-group">
        <label for="gender" class="col-sm-2 control-label">Gender</label>
        <div class="col-sm-10">
          <select v-model="user.gender" class="form-control">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="unknown">Unknown</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <label for="birth-date" class="col-sm-2 control-label">Birth Date</label>
        <div class="col-sm-10">
          <el-date-picker
            v-model="user.birthDate"
            type="date"
            placeholder="Select date">
          </el-date-picker>
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
    </form> -->
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
          { required: true, message: '请输入活动名称', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        gender: [
          { required: true, message: '请选择活动区域', trigger: 'change' }
        ],
        birthDate: [
          { type: 'date', required: true, message: '请选择出生日期', trigger: 'change' }
        ]
      },
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
