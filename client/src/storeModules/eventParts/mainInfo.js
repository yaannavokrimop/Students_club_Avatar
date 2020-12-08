import { HTTP } from "@/http-common";

const state = {
    mainInfo: {
        name: '',
        shortName: '',
        status: '',
        type: '',
        typeOfActivity: '',
        dateFrom: '',
        dateTo: '',
        timeFrom: '',
        timeTo: '',
        dateFlag: false,
    },
    clearMainInfo: {
        name: '',
        shortName: '',
        status: '',
        type: '',
        typeOfActivity: '',
        dateFrom: '',
        dateTo: '',
        timeFrom: '',
        timeTo: '',
        dateFlag: false,
    }
};

const mutations = {
    SET_MAININFO (state, mainInfo) {
        state.mainInfo = {...mainInfo};
    },
    CLEAR_MAININFO (state) {
        state.mainInfo = {...state.clearMainInfo}
    }
};

const actions = {
    getMainInfo({ commit }, id){
        return HTTP
            .get('/event/mainInfo/' + id)
            .then((response) => {
                commit("SET_MAININFO", response.data);
                //return (response.data);
            })
            .catch(error => console.error(error));
    },

    putMainInfo({id, mainInfo}){
        HTTP
            .put('event/mainInfo/' + id, mainInfo)
            .then(() => console.log('Main info saved successfully'))
            .catch(error => console.error(error))
    }
};

const getters = {
    storeMainInfo: state => state.mainInfo
};

export default {
    state,
    mutations,
    actions,
    getters
};