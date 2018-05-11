import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Profile from '@/components/Profile'
import Content from '@/components/Content'

Vue.use(Router)

export default new Router({
  mode: 'history',
  canReuse: false,
  routes: [
    {
      path: '/',
      component: Index,
      children: [
        {
          path: '/',
          name: 'user-content',
          component: Content
        },
        {
          path: 'profile',
          name: 'profile',
          component: Profile
        }
      ]
    }
  ]
})
