<template>
    <div>
        <v-dialog
                v-model="dialog"
                width="700"
        >
            <template v-slot:activator="{ on, attrs }">
                <v-icon color="white"
                        v-bind="attrs"
                        v-on="on">mdi-plus
                </v-icon>
            </template>
            <StyledCard>
                <template #title>
                    Новое мероприятие
                </template>
                <template #card-text>
                    <v-container>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Название</span></v-col>
                        <v-col class="py-0">
                            <v-text-field :v-model="eventShort.name" placeholder="Краткое название" dense
                                          outlined></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Начало</span></v-col>
                        <v-col cols="3" class="py-0">
                            <v-menu
                                    v-model="menuDateFrom"
                                    :close-on-content-click="false"
                                    :nudge-right="40"
                                    transition="scale-transition"
                                    offset-y
                                    min-width="290px"
                            >
                                <template v-slot:activator="{ on, attrs }">
                                    <v-text-field
                                            v-model="eventShort.dateFrom"
                                            placeholder="Начало"
                                            readonly
                                            outlined
                                            dense
                                            v-bind="attrs"
                                            v-on="on"
                                    ></v-text-field>
                                </template>
                                <v-date-picker
                                        v-model="eventShort.dateFrom"
                                        @input="menuDateFrom = false"
                                ></v-date-picker>
                            </v-menu>
                        </v-col>
                        -
                        <v-col cols="3" class="py-0">
                            <v-menu
                                    v-model="menuDateTo"
                                    :close-on-content-click="false"
                                    :nudge-right="40"
                                    transition="scale-transition"
                                    offset-y
                                    min-width="290px"
                            >
                                <template v-slot:activator="{ on, attrs }">
                                    <v-text-field
                                            v-model="eventShort.dateTo"
                                            placeholder="Окончание"
                                            readonly
                                            outlined
                                            dense
                                            v-bind="attrs"
                                            v-on="on"
                                    ></v-text-field>
                                </template>
                                <v-date-picker
                                        v-model="eventShort.dateTo"
                                        @input="menuDateTo = false"
                                ></v-date-picker>
                            </v-menu>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-switch
                                v-model="eventShort.dateFlag"
                                label="Примерные сроки"
                        ></v-switch>
                    </v-row>
                    </v-container>
                </template>
                <template #buttons>
                    <v-btn class="mt-2" depressed block text>
                        Отправить в ИСУ
                    </v-btn>
                </template>
            </StyledCard>
        </v-dialog>
    </div>
</template>

<script>
    import StyledCard from './StyledCard'

    export default {
        name: "CreateEventDialog",
        components: {StyledCard},
        data: () => ({
            eventShort: {
                name: '',
                dateTo: '',
                dateFrom: '',
                dateFlag: false,
            },

            dialog: false,
            menuDateFrom: false,
            menuDateTo: false,
        })
    }
</script>

<style scoped>

</style>