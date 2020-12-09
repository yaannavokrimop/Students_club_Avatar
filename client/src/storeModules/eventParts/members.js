import { HTTP } from "@/http-common";

const state = {
    members: {
        invited: '',
        contact: '',
        sideOrganizers: '',
        organisers: [],
    },
    clearMembers: {
        invited: '',
        contact: '',
        sideOrganizers: '',
        organisers: [],
    }
};

const mutations = {
    SET_MEMBERS(state, members) {
        state.members = {...members};
    },

    CLEAR_MEMBERS(state) {
        state.members = {...state.clearMembers};
    }
};

const actions = {
    getMembers ({commit}, id) {
        return HTTP
            .get('/members/event/' + id)
            .then((response) => {
                commit("SET_MEMBERS", response.data);
            })
            .catch(error => console.error(error));
    },

    putMembers({commit}, {id, members}) {
        return HTTP
            .post('/members/event/' + id, members)
            .then(() => {
                commit("SET_MEMBERS", members);
                console.log('Members saved successfully');
            })
            .catch(error => console.error(error));
    }
};

const getters = {
    storeMembers: state => state.members
};

export default {
    state,
    mutations,
    actions,
    getters
};