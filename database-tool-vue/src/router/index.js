import { createRouter, createWebHashHistory} from 'vue-router';

const routes = [
    {
        path:'/',
        component: () => import('../components/Home.vue')
    },
    {
        path:'/table',
        component: () => import('../components/Database.vue')
    },
]

const router = createRouter({
    history: createWebHashHistory(),  // hash路由模式
    // history: createWebHistory(),  // history路由模式
    routes
});

export default router;
