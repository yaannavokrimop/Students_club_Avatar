<template>
    <v-container class="main-container pa-0">
        <v-row>
            <v-col class="pa-0" cols="3">
                <StyledCard :color="color" class="mx-3">
                    <template #title>
                        Редактирование
                    </template>
                    <template #subtitle>
                        {{event.name}}
                    </template>
                    <template #card-text>
                        <v-list class="pt-0 pb-4" :color="color" dense>
                            <v-list-item :to="`/event/${id}/main`" class="my-1 px-6">Основное</v-list-item>
                            <v-list-item :to="`/event/${id}/characteristics`" class="my-1 px-6">Характеристики</v-list-item>
                            <v-list-item :to="`/event/${id}/preview`" class="my-1 px-6">Анонс</v-list-item>
                            <v-list-item :to="`/event/${id}/members`" class="my-1 px-6">Участники</v-list-item>
                            <v-list-item :to="`/event/${id}/location`" class="my-1 px-6">Места проведения</v-list-item>
                            <v-list-item :to="`/event/${id}/requests`" class="my-1 px-6">Заявки</v-list-item>
                            <v-list-item :to="`/event/${id}/resume`" class="mt-1 px-6" disabled>Итоги</v-list-item>
                        </v-list>
                    </template>
                    <template #buttons>
                        <v-divider class="mx-3"/>
                        <v-container class="">
                            <v-col class="pa-0 ma-0" align="center" justify="center">
                                <v-btn depressed block class="btn-light">
                                  Отправить в ИСУ
                                </v-btn>
                            </v-col>
                        </v-container>
                    </template>
                </StyledCard>
            </v-col>

            <v-col class="pa-0" style="height: 100%">
                <router-view/>
            </v-col>

        </v-row>
    </v-container>
</template>

<script>
    import StyledCard from "../components/StyledCard";
    import { mapGetters, mapActions } from "vuex";

    export default {
        name: "Event",
        components: {
            StyledCard
        },
        data: () => ({
            id: '',
            event: {},
            color: 'rgba(246, 246, 246, 1)'
        }),
        computed: {
            ...mapGetters(['currentId'])
        },
        methods: {
            ...mapActions(['getEvent'])
        },
        watch: {
            $route: {
                immediate: true,
                handler() {
                    this.id = this.$route.params.id;
                    this.getEvent(+this.id).then(event => {
                        this.event = {...event};
                    })
                }
            }
        }
    }
</script>

<style scoped>
    @import url("https://fonts.googleapis.com/css?family=Oswald");

    .main-container {
        height: 100%;
        max-width: 2000px
    }

    .v-divider {
        border-color: rgba(232, 234, 246, 1) !important;
        border-top-width: 2px
    }

    .theme--light.v-list-item:not(.v-list-item--active),
    .v-list-item--link, ::v-deep .v-list-item {
        min-height: 25px;
        /*font-family: "Roboto", serif;
        font-size: 14px;
        font-weight: 400;*/
        /* color: rgba(96, 96, 96, 1) !important; */
        padding: 0;
    }

    .v-list-group {
        width: 100%;
    }

    ::v-deep .v-list-group__header {
        padding-right: 16px;
    }

    .theme--light.v-list-item--active {
        color: rgba(57, 73, 171, 1) !important;
    }

    .theme--light.v-list-item--active::before {
        opacity: 0;
    }

    .v-btn {
        color: rgba(57, 73, 171, 1) !important;
    }

    .row {
        height: 100%
    }

    /* .theme--light.v-btn:not(.v-btn--flat):not(.v-btn--text):not(.v-btn--outlined)  { */
    /* background-color: #E8EAF6 !important; */
    /* } */
</style>