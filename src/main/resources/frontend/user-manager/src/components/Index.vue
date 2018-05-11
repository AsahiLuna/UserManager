<template>
  <div class="index" id="index">
    <div id="root">
      <el-container>
        <el-aside>
          <el-row class="tac">
            <el-col :span="24">
              <h5>导航菜单</h5>
              <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">
                <el-submenu index="1">
                  <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>Search</span>
                  </template>
                  <el-menu-item-group>
                    <template slot="title">搜索</template>
                    <el-menu-item index="1-1">
                      <el-input v-model="inputSearchName" placeholder="请输入要搜索的用户姓名" @keyup.enter.native="searchByName()">
                        <el-button slot="append" icon="el-icon-search" @click="searchByName()"></el-button>
                      </el-input>
                    </el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-menu-item index="4" @click="addUser()">
                  <i class="el-icon-setting"></i>
                  <span slot="title">
                      Add User
                  </span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>
        <el-container>
          <el-header>
            <el-button round>
              <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
              </el-breadcrumb>
            </el-button>
          </el-header>
          <el-main>
            <router-view/>
          </el-main>
        </el-container>
      </el-container>
    </div>
  </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      active: false,
      inputSearchName: ''
    }
  },
  methods: {
    handleOpen: function (key, keyPath) {

    },
    handleClose: function (key, keyPath) {

    },
    searchByName: function () {
      this.$store.commit('search', this.inputSearchName)
    },
    addUser: function () {
      this.$router.push({name: 'profile'})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

</style>
