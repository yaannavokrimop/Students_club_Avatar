import Vue from 'vue'
import Vuex from 'vuex'

import validation from './storeModules/validation'

import event from './storeModules/event';
import characteristics from "./storeModules/eventParts/characteristics";
import location from "./storeModules/eventParts/location";
import mainInfo from './storeModules/eventParts/mainInfo';
import members from "./storeModules/eventParts/members";
import preview from "./storeModules/eventParts/preview";

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        validation,
        event,
        characteristics,
        location,
        mainInfo,
        members,
        preview
    }
});