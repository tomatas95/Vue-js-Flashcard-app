import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Flashcards from '../views/Flashcards.vue'
import LearnFlashcard from '../views/LearnFlashcard.vue'
import AddFlashcardSet from '../views/AddFlashcardSet.vue'
import EditFlashcardSet from '../views/EditFlashcardSet.vue'
import FinishFlashcard from '../views/FinishFlashcard.vue'

const routes = [{
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/flashcards',
        name: 'Flashcards',
        component: Flashcards
    },
    {
        path: '/learnFlashcard',
        name: 'LearnFlashcard',
        component: LearnFlashcard
    },
    {
        path: '/addflashcardset',
        name: 'AddFlashcardSet',
        component: AddFlashcardSet
    },
    {
        path: '/finishedflashcard',
        name: 'FinishFlashcard',
        component: FinishFlashcard,
        props: (route) => ({
            correctAnswers: parseInt(route.query.correctAnswers),
            incorrectAnswers: parseInt(route.query.incorrectAnswers),
        }),
    },
    {
        path: '/edit',
        name: 'edit',
        component: EditFlashcardSet
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router