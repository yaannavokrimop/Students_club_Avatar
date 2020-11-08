<template>
    <v-container class="main-container pa-0">
        <v-row>
            <v-col class="pa-0" cols="3">
                <StyledCard :color="color" class="mx-3">
                    <template #title>
                        Редактирование
                    </template>
                    <template #subtitle>
                        Выезд в приют
                    </template>
                    <template #card-text>
                        <v-list class="py-0 px-6" :color="color">
                            <v-list-item to="/event/main">Основное</v-list-item>
                            <v-list-item to="/event/characteristics" class="my-1">Характеристики</v-list-item>
                            <v-list-item to="/event/preview" class="my-1">Анонс</v-list-item>
                            <v-list-item to="/event/members" class="my-1">Участники</v-list-item>
                            <v-list-item to="/event/location" class="my-1">Места проведения</v-list-item>
                            <v-list-item to="/event/timetable" class="my-1">Расписание</v-list-item>
                            <v-list-item to="/event/resume" class="text--disabled mt-1 mb-3">Итоги</v-list-item>
                        </v-list>
                        <v-divider class="mx-3"/>
                        <v-list class="py-0 px-6" :color="color">
                            <v-list-item to="/event/causeDocument" class="mb-1 mt-3">Документ-основание</v-list-item>
                            <v-list-item to="/event/requests" class="my-1">Заявки</v-list-item>
                            <v-list-item to="/event/decree">Приказ</v-list-item>
                        </v-list>
                    </template>
                    <template #buttons>
                        <v-divider class="mx-3"/>
                        <v-container class="">
                            <v-col class="pa-0 ma-0" align="center" justify="center">
                                <v-btn depressed block>
                                    Сохранить все
                                </v-btn>
                                <v-btn class="mt-2" depressed block text>
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

    export default {
        name: "Event",
        components: {
            StyledCard
        },
        data: () => ({
            color: 'rgba(246, 246, 246, 1)'
        })
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
    .v-list-item--link {
        min-height: 25px;
        /*font-family: "Roboto", serif;
        font-size: 14px;
        font-weight: 400;*/
        /* color: rgba(96, 96, 96, 1) !important; */
        padding: 0;
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