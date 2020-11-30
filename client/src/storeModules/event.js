//import { HTTP } from "@/http-common";

const state = {
    eventShortEmpty: {
        name: '',
        dateTo: '',
        dateFrom: '',
        dateFlag: false,
    },
    //id: '',
    events: [],
    nextId: 0,
    currentId: 0,
};

const mutations = {
    // SET_ID (state, id) {
    //     state.id = id;
    // },

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
            state.events.slice(index, 1);
        }
    }
};

const actions = {
    // createEvent({ commit }, { name, dateFrom, dateTo, dateFlag }) {
    //     HTTP
    //         .post('/event/create', { name, dateFrom, dateTo, dateFlag })
    //         .then((response) => {
    //             console.log('Event created successfully');
    //             commit("SET_ID", response.data);
    //         })
    //         .catch(error => console.error(error))
    // },

    createEvent({ commit }, event) {
        commit('ADD_EVENT', event);
        return state.currentId;
    },

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
    //id: state => state.id,
    events: state => state.events,
    currentId: state => state.currentId,
    eventShortEmpty: state => state.eventShortEmpty
};

export default {
    state,
    mutations,
    actions,
    getters
};