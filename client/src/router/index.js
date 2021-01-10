import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Edit from '../views/Edit.vue'
import Feedback from '../views/Feedback.vue'
import Moderator from '../views/Moderator.vue'
import Login from '../views/Login.vue'
import Welcome from '../views/Welcome.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/edit',
        name: 'Editor',
        component: Edit
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/feedback/:id',
        name: 'Feedback',
        component: Feedback
    },
    {
        path: '/moderator',
        name: 'Noderator',
        component: Moderator
    },
    {
        path: '/welcome',
        name: 'Welcome',
        component: Welcome
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
