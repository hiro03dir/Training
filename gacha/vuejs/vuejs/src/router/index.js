import {createRouter, createWebHistory} from 'vue-router'
import {createStore} from 'vuex'

import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Gacha from '../views/Gacha.vue'
import Character from '../views/Character.vue'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path:'/login',
        name: 'Login',
        component: Login
    },
    {
        path:'/gacha',
        name: 'Gacha',
        component: Gacha
    },
    {
        path:'/Character',
        name: 'Character',
        component: Character
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router

const store = createStore({
    state() {
        return {
            token:""
        }
    },
    mutations: {
        saveToken(state) {
            state.token = ""
        }
    },
    actions: {
        saveToken({commit},token) {
            commit("saaveToken",token)
        },
        removeToken({commit}, token) {
            commit("remeveToken");
        }
    },
    
})