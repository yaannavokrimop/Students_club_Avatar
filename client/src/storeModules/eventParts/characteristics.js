import { HTTP } from "@/http-common";

const state = {
    charact: {
        membersNumber: '',
        periodicity: '',
        category: '',
        publicity: '',
        format: '',
        language: ''
    },
    clearCharact: {
        membersNumber: '',
        periodicity: '',
        category: '',
        publicity: '',
        format: '',
        language: ''
    },
    characts: []
};

const mutations = {
    SET_CHARACT(state, charact) {
        state.charact = charact;
    },
    EDIT_CHARACT(state, charact) {
        state.charact = {...state.charact, ...charact};
    },
    CLEAR_CHARACT(state) {
        state.charact = {...state.clearCharact};
    }
};

const actions = {
    getCharact({commit}, id) {
        return HTTP
            .get('/characteristic/' + id)
            .then((response) => {
                commit("SET_CHARACT", response.data);
            })
            .catch(error => console.error(error));
    },

    editCharact({commit}, {id, charact}) {
        HTTP
            .post('/characteristic/add/' + id, charact)
            .then((response) => {
                commit("EDIT_CHARACT", charact);
                console.log(response.data);
            })
            .catch(error => console.error(error));
    }
};

const getters = {
    storeCharact: state => state.charact
};

export default {
    state,
    mutations,
    actions,
    getters
};