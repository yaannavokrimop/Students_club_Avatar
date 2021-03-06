import { HTTP } from "@/http-common";

const state = {
    preview: {
        shortDescription: '',
        description: '',
        purpose: '',
        tasks: '',
        site: '',
        comment: ''
    },
    clearPreview: {
        shortDescription: '',
        description: '',
        purpose: '',
        tasks: '',
        site: '',
        comment: ''
    }
};

const mutations = {
    SET_PREVIEW(state, preview) {
        state.preview = preview;
    },
    EDIT_PREVIEW(state, preview) {
        state.preview = {...state.preview, ...preview};
    },
    CLEAR_PREVIEW(state) {
        state.preview = {...state.clearPreview};
    }
};

const actions = {
    getPreview({commit}, id) {
        return HTTP
            .get('/preview/' + id)
            .then((response) => {
                commit("SET_PREVIEW", response.data);
            })
            .catch(error => console.error(error));
    },

    updatePreview({commit, dispatch}, {id, preview}) {
        HTTP
            .post('/preview/' + id, preview)
            .then((response) => {
                commit("EDIT_PREVIEW", preview);
                console.log(response.data);
                dispatch("showSuccess", "Успешно сохранено");
            })
            .catch(error => {
                console.error(error);
                dispatch("showError", error);
            });
    }
};

const getters = {
    storePreview: state => state.preview
};

export default {
    state,
    mutations,
    actions,
    getters
};