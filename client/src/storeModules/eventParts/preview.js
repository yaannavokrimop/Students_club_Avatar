import { HTTP } from "@/http-common";

const state = {
    preview: {
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

    updatePreview({commit}, id, preview) {
        commit("EDIT_PREVIEW", preview);
        HTTP
            .put('/preview/' + id, preview)
            .then((response) => {
                console.log(response.data);
            })
            .catch(error => console.error(error));
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