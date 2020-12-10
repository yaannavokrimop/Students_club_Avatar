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
                commit("SET_NAME", response.data.name);
                //return (response.data);
            })
            .catch(error => console.error(error));
    },

    putMainInfo( { commit, dispatch },{id, mainInfo}){
        HTTP
            .post('event/mainInfo/' + id, mainInfo)
            .then(() => {
                commit("SET_MAININFO", mainInfo);
                commit("SET_NAME", mainInfo.name);
                console.log('Main info saved successfully');
                dispatch("showSuccess", "Успешно сохранено");
            })
            .catch(error => {
                console.error(error);
                dispatch("showError", error);
            })
    }
};

const getters = {
    storeMainInfo: state => state.mainInfo,
    eventDateFrom: state => state.mainInfo.dateFrom,
    eventDateTo: state => state.mainInfo.dateTo
};

export default {
    state,
    mutations,
    actions,
    getters
};