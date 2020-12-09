import Vue from 'vue';
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
            light: {
                primary: '#7986cb',
                secondary: '#E8EAF6',
                accent: '#3949AB'
            },
        },
    },
});
