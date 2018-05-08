import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Login from '@/components/Login'
import Content from '@/components/Content'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index,
      children: [
        {
          path: '/',
          name: 'login',
          component: Login
        },
        {
          path: 'content',
          name: 'content',
          component: Content
        }
      ]
    }
  ]
})
