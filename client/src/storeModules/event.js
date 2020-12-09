import { HTTP } from "@/http-common";

const state = {
    eventShortEmpty: {
        name: '',
        dateTo: '',
        dateFrom: '',
        dateFlag: false,
    },
    id: '',
    name: '',
    events: [],
    nextId: 0,
    currentId: 0,

    buildings: [
        'Ломоносова',
        'Кронверкский',
        'Гривцова',
        'Чайковского',
    ],
    rooms: [
        'ITMO Place',
        'Актовый зал',
        'Коворкинг',
        'Переговорная (268)',
        'Переговорная в ректорском холле (254)',
        'Ауд. 206',
        'Ауд. 302',
        'Ауд. 314'
    ]
};

const mutations = {
    SET_ID (state, id) {
        state.id = id;
    },
    SET_NAME(state, name) {
        state.name = name;
    },

    SET_EVENTS(state, events) {
        state.events = events;
    },

    CLEAR_NAME(state) {
        state.name = '';
    },

    // ADD_EVENT(state, event) {
    //     state.events.push({...event, id: state.nextId});
    //     state.currentId = state.nextId;
    //     state.nextId++;
    // },

    EDIT_EVENT(state, event){
        const index = state.events.findIndex(x => x.id === event.id);
        if (index > -1){
            state.events[index] = {...state.events[index], ...event}
        }
    },
    DELETE_EVENT(state, id) {
        const index = state.events.findIndex(x => x.id === id);
        if (index > -1){
            state.events.splice(index, 1);
        }
    }
};

const actions = {
    createEvent({ commit }, event) {
        return HTTP
            .post('/event/create', event)
            .then((response) => {
                console.log('Event created successfully');
                commit("SET_ID", response.data);
            })
            .catch(error => console.error(error))
    },

    getEvents({commit, dispatch}) {
        HTTP
            .get('/event/all')
            .then((response) => {
                commit("SET_EVENTS", response.data);
        }).catch(error => {
            console.log(error);
            dispatch("showError", error);
        });
    },

        /* createEvent({ commit }, event) {
         commit('ADD_EVENT', event);
         return state.currentId;
     },*/

    // getEvent(context, id){
    //     const index = state.events.findIndex(x => x.id === id);
    //     if (index > -1){
    //         return state.events[index]
    //     }
    // },

    editEvent({ commit }, newEvent){
        commit('EDIT_EVENT', newEvent);
    },

    deleteEvent({ commit }, id){
        commit('DELETE_EVENT', id);
    },

    clearEvent({ commit }){
        commit('CLEAR_MAININFO');
        commit('CLEAR_PREVIEW');
        commit('CLEAR_NAME');
        commit('CLEAR_MEMBERS');
    }

};

const getters = {
    id: state => state.id,
    events: state => state.events,
    currentId: state => state.currentId,
    eventShortEmpty: state => state.eventShortEmpty,
    currentEventName: state => state.name,

    buildings: state => state.buildings,
    rooms: state => state.rooms
};

export default {
    state,
    mutations,
    actions,
    getters
};