import Vue from 'vue'
import VueRouter from 'vue-router'

import Event from "./views/Event"
import EventsList from "./views/EventsList";

// Мероприятие, секция "Редактирование"
import MainInfo from "./components/EditSection/MainInfo";
import Characteristics from "./components/EditSection/Characteristics";
import Preview from "./components/EditSection/Preview";
import Members from "./components/EditSection/Members";
import Location from "./components/EditSection/Location";
import Timetable from "./components/EditSection/Timetable";
import Resume from "./components/EditSection/Resume";

// Мероприятие, секция "Документы"
import CauseDocument from "./components/DocumentsSection/CauseDocument";
import Requests from "./components/DocumentsSection/Requests";
import Decree from "./components/DocumentsSection/Decree";

Vue.use(VueRouter);

const routes = [
  {
    path: '/eventsList',
    component: EventsList
  },
  {
    path: '/event',
    redirect: '/event/main',
    component: Event,
    children: [
      { path: '/event/main', component: MainInfo },
      { path: '/event/characteristics', component: Characteristics },
      { path: '/event/preview', component: Preview },
      { path: '/event/members', component: Members },
      { path: '/event/location', component: Location },
      { path: '/event/timetable', component: Timetable },
      { path: '/event/resume', component: Resume },
      { path: '/event/causeDocument', component: CauseDocument },
      { path: '/event/requests', component: Requests },
      { path: '/event/decree', component: Decree },
    ]
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    //component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
  }
];

const router = new VueRouter({
  routes
});


router.push('/event/main');

export default router
