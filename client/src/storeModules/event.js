import { HTTP } from "@/http-common";

const state = {
    id: ''
};

const mutations = {
    SET_ID (state, id) {
        state.id = id;
    }
};

const actions = {
    createEvent({ commit }, { name, dateFrom, dateTo, dateFlag }) {
        HTTP
            .post('/event/create', { name, dateFrom, dateTo, dateFlag })
            .then((response) => {
                console.log('Event created successfully');
                commit("SET_ID", response.data);
            })
            .catch(error => console.error(error))
    },
};

const getters = {
    id: state => state.id
};

export default {
    state,
    mutations,
    actions,
    getters
};