import Vue from 'vue'
import Vuex from 'vuex'

import event from './storeModules/event'
import mainInfo from './storeModules/mainInfo'

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        event,
        mainInfo
    }
});