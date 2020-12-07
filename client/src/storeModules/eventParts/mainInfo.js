import { HTTP } from "@/http-common";

const state = {
    storeMainInfo: {
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
        state.storeMainInfo = mainInfo;
    }
};

const actions = {
    getMainInfo({ commit }, id){
        HTTP
            .get('/event/mainInfo' + id)
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
    storeMainInfo: state => state.storeMainInfo
};

export default {
    state,
    mutations,
    actions,
    getters
};