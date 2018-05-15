// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import Vuex from 'vuex'
import '../theme/index.css'

Vue.use(Vuex)

Vue.use(ElementUI, { size: 'small' })

Vue.prototype.$http = axios

Vue.config.productionTip = false

const store = new Vuex.Store({
  state: {
    searchName: '',
    displayLoginDialog: false,
    accessToken: ''
  },
  mutations: {
    search (state, name) {
      state.searchName = name
    },
    login (state, value) {
      state.displayLoginDialog = value
    },
    token (state, value) {
      state.accessToken = value
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
