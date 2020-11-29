export default {
    state: {
        rules: {
            required: value => !!value || 'Обязательное поле'
        }
    },
    getters: {
        required: state => state.rules.required,
    },
    mutations: {},
    actions: {}
}