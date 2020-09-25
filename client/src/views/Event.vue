<template>
    <v-container class="pt-2">
        <v-row>
            <v-col cols="3">
                <StyledCard>
                    <template #title>
                        Редактирование
                    </template>
                    <template #card-text>
                        <v-list class="pa-0">
                            <v-list-item to="/event/main">Основное</v-list-item>
                            <v-list-item to="/event/characteristics" class="my-3">Характеристики</v-list-item>
                            <v-list-item to="/event/preview" class="my-3">Анонс</v-list-item>
                            <v-list-item to="/event/members" class="my-3">Участники</v-list-item>
                            <v-list-item to="/event/location" class="my-3">Место проведения</v-list-item>
                            <v-list-item to="/event/timetable" class="my-3">Расписание</v-list-item>
                            <v-list-item to="/event/resume" class="text--disabled">Итоги</v-list-item>
                        </v-list>
                    </template>
                </StyledCard>

                <StyledCard class="mt-2">
                    <template #title>
                        Документы
                    </template>
                    <template #card-text>
                        <v-list class="pa-0">
                            <v-list-item to="/event/causeDocument">Документ-основание</v-list-item>
                            <v-list-item to="/event/requests" class="my-3">Заявки</v-list-item>
                            <v-list-item to="/event/decree">Приказ</v-list-item>
                        </v-list>
                    </template>
                </StyledCard>
            </v-col>

            <v-col>
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
        data: () => ({})
    }
</script>

<style scoped>
    @import url("https://fonts.googleapis.com/css?family=Oswald");

    .v-divider {
        border-color: rgba(197, 202, 233, 1) !important;
        border-top-width: unset
    }

    .v-card__title {
        font-family: "Oswald", Helvetica, Arial;
        font-weight: 700;
        font-size: 22px;
        letter-spacing: 2px;
        padding-bottom: 8px;
        padding-left: 22px;
    }

    .theme--light.v-list-item:not(.v-list-item--active),
    .v-list-item--link {
        min-height: 25px;
        font-family: "Roboto";
        font-size: 16px;
        font-weight: 500;
        color: rgba(96, 96, 96, 1) !important;
        padding: 0;
    }

    .theme--light.v-list-item--active {
        color: rgba(57, 73, 171, 1) !important;
    }

    .theme--light.v-list-item--active::before {
        opacity: 0;
    }
</style>