import Vue from 'vue'
import Vuex from 'vuex'

import {BootstrapVue, IconsPlugin} from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import VueRouter from 'vue-router'

import App from './App.vue'
import router from './router'

import axios from 'axios'
import ApiService from './services/ApiService.js'

import VueQRCodeComponent from 'vue-qrcode-component'


Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(Vuex)

// Register the Vue component
Vue.component('qr-code', VueQRCodeComponent)


const emptyModel = {
    title: "The title",
    questions: [
        {
            id:0,
            question:"Yes",
            votes:0
        },
        {
            id:1,
            question:"No",
            votes:0
        },
    ]
}

const http = axios.create({
    withCredentials: true,
    baseURL: process.env.VUE_APP_API_URL
})
http.interceptors.request.use( function (config){
    return config;
}, function(err){
    return Promise.reject(err)
})
http.interceptors.response.use( function (response){
    return response;
}, function(err){
    if( err.response.status == 401 || err.response.status == 403){
        router.push( 'login')
    }
    return Promise.reject(err)
})

const apiService = new ApiService(http)

const store = new Vuex.Store({
    state: {
        apiService: apiService,
        currentPoll: emptyModel,
        user:{
            name: '',
            email:''
        }
    },
    mutations: {
        updateTitle(state, title) {
            state.currentPoll.title = title;
        },
        resetSource(state) {
            state.currentPoll = emptyModel;
        },
        simulateVote(state, idx) {
            state.currentPoll.questions[idx].votes++;
            //force a refresh
            state.currentPoll = JSON.parse(JSON.stringify(state.currentPoll, undefined, 4));
        },
        resetCounters(state) {
            var arr = state.currentJson.questions.map(() => 0)
            state.currentVotes = arr;
        },
        updateModel(state, data) {
            state.currentPoll = data
        },
        addQuestion(state){
            state.currentPoll.questions.push({
                id: state.currentPoll.questions.length,
                question:"Your Question",
                votes:0
            })
        },
        removeQuestion(state, idx){
            state.currentPoll.questions.splice(idx,1)
        },
        newUser(state, user){
            state.user.name = user
        }
    },
    actions:{
        async fetchUser(context){
            try {
                const user = await context.state.apiService.loadUser()
                context.commit('newUser', user.data)
            }catch(e){
                //router.push('Home')
            }
        }
    }
})

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
