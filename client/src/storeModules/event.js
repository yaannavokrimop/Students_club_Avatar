import { HTTP } from "@/http-common";

const state = {
    eventShortEmpty: {
        name: '',
        dateTo: '',
        dateFrom: '',
        dateFlag: false,
    },
    id: '',
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

    ADD_EVENT(state, event) {
        state.events.push({...event, id: state.nextId});
        state.currentId = state.nextId;
        state.nextId++;
    },
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
        HTTP
            .post('/event/create', event)
            .then((response) => {
                console.log('Event created successfully');
                commit("SET_ID", response.data);
            })
            .catch(error => console.error(error))
    },

   /* createEvent({ commit }, event) {
        commit('ADD_EVENT', event);
        return state.currentId;
    },*/

    getEvent(context, id){
        const index = state.events.findIndex(x => x.id === id);
        if (index > -1){
            return state.events[index]
        }
    },

    editEvent({ commit }, newEvent){
        commit('EDIT_EVENT', newEvent);
    },

    deleteEvent({ commit }, id){
        commit('DELETE_EVENT', id);
    }

};

const getters = {
    id: state => state.id,
    events: state => state.events,
    currentId: state => state.currentId,
    eventShortEmpty: state => state.eventShortEmpty,

    buildings: state => state.buildings,
    rooms: state => state.rooms
};

export default {
    state,
    mutations,
    actions,
    getters
};