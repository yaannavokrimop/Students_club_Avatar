import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { store } from './store.js'
import { VueMaskDirective } from 'v-mask'

import router from './router'

import './assets/global.css'

Vue.config.productionTip = false;
Vue.directive('mask', VueMaskDirective);

new Vue({
  store,
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app');
