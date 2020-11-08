import { HTTP } from "../http-common";

const state = {
    mainInfo: {
        name: '',
        shortName: '',
        status: '',
        type: '',
        typeOfActivity: '',
        dateFrom: '',
        dateTo: ''
    }
};

const mutations = {
    SET_MAININFO (state, mainInfo) {
        state.mainInfo = mainInfo;
    }
};

const actions = {
    getMainInfo({ commit }){
        HTTP
            .get('/event/mainInfo')
            .then((response) => {
                commit("SET_MAININFO", response.data);
            })
            .catch(error => console.error(error));
    },

    putMainInfo({ id, mainInfo }){
        HTTP
            .put('event/mainInfo/' + id, mainInfo)
            .then(() => console.log('Main info saved successfully'))
            .catch(error => console.error(error))
    }
};

const getters = {
    mainInfo: state => state.mainInfo
};

export default {
    state,
    mutations,
    actions,
    getters
};