import Vue from 'vue'
import VueRouter from 'vue-router'

import Event from "./views/Event"
import EventsList from "./views/EventsList";

import MainInfo from "./components/EditSection/MainInfo";
import Characteristics from "./components/EditSection/Characteristics";
import Preview from "./components/EditSection/Preview";
import Members from "./components/EditSection/Members";
import Location from "./components/EditSection/Location";
import Resume from "./components/EditSection/Resume";

import CauseDocument from "./components/DocumentsSection/CauseDocument";
import Requests from "./components/DocumentsSection/Requests";
import Decree from "./components/DocumentsSection/Decree";

Vue.use(VueRouter);

const routes = [
  { path: '/eventsList', component: EventsList },
  {
    path: '/event/:id',
    name: 'event',
    redirect: '/event/:id/main',
    component: Event,
    children: [
      { path: 'main', name: 'main', component: MainInfo },
      { path: 'characteristics', component: Characteristics },
      { path: 'preview', component: Preview },
      { path: 'members', component: Members },
      { path: 'location', component: Location },
      { path: 'resume', component: Resume },
      { path: 'causeDocument', component: CauseDocument },
      { path: 'requests', component: Requests },
      { path: 'decree', component: Decree },
    ]
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    //component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
  },
];

const router = new VueRouter({
  mode: 'history',
  routes
});


router.push('/eventsList');

export default router
