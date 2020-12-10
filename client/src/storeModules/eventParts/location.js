import { HTTP } from "@/http-common";

const state = {
    location: {
        address: '',
        building: '',
        room: '',
        date: '',
        timeFrom: '',
        timeTo: '',
    },
    clearLocation: {
        address: '',
        building: '',
        room: '',
        date: '',
        timeFrom: '',
        timeTo: '',
    },
    locations: []
};

const mutations = {
    SET_LOCATIONS(state, locations) {
        state.locations = locations;
    },
    ADD_LOCATION(state, location) {
        state.locations.push(location);
    },
    CLEAR_LOCATIONS(state) {
        state.locations = [];
    },
    CLEAR_LOCATION(state) {
        state.location = {...state.location, ...state.clearLocation};
    }
};

const actions = {
    getLocations({commit}, id) {
        return HTTP
            .get('/address/all/' + id)
            .then((response) => {
                commit("SET_LOCATIONS", response.data);
            })
            .catch(error => console.error(error));
    },

    putLocation({commit}, {id, location}) {
        HTTP
            .post('/address/add/' + id, location)
            .then((response) => {
                commit("ADD_LOCATION", location);
                console.log(response.data);
            })
            .catch(error => console.error(error));
    }
};

const getters = {
    storeLocations: state => state.locations
};

export default {
    state,
    mutations,
    actions,
    getters
};