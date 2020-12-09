const state = {
    msgText: '',
    msgColor: 'primary',
    msgVisible: false
};

const mutations = {
    SET_TEXT(state, text) {
        state.msgText = text;
    },
    SET_COLOR(state, color) {
        state.msgColor = color;
    },
    SET_VISIBLE(state, visible) {
        state.msgVisible = visible;
    }
};

const actions = {
    showMessage({ commit }, message){
        commit('SET_TEXT', message);
        commit('SET_VISIBLE', true)
    },
    closeMessage({ commit }) {
        commit('SET_VISIBLE', false);
    },
};

const getters = {
    msgText: state => state.msgText,
    msgColor: state => state.msgColor,
    msgVisible: state => state.msgVisible
};

export default {
    state,
    mutations,
    actions,
    getters
};