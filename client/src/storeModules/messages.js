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
    showMessage({commit}, {message, color}) {
        commit('SET_TEXT', message);
        commit('SET_VISIBLE', true)
        commit('SET_COLOR', color)
    },
    closeMessage({commit}) {
        commit('SET_VISIBLE', false);
    },
    showSuccess({dispatch}, message) {
        dispatch('showMessage', { message, color: 'success' });
    },
    showError({dispatch}, message) {
        dispatch('showMessage', { message: message.message, color: 'error'});
    }
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