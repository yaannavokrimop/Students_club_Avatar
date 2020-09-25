<template>
    <v-row>
        <v-col class="pt-0" cols="8">
            <StyledCard>
                <template #title>
                    Основное
                </template>
                <template #card-text>
                    <v-row>
                        <v-col cols="4" class="py-0"><span>Название</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="mainInfo.name" placeholder="Название" rows="2" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4" class="py-0"><span>Краткое название</span></v-col>
                        <v-col class="py-0">
                            <v-text-field :v-model="mainInfo.shortName" placeholder="Краткое название" dense
                                          outlined></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4" class="py-0"><span>Статус</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="mainInfo.status"
                                            :items="['Ведомственный', 'Всероссийский', 'Городской', 'Групповой', 'Кафедральный', 'Межвузовский', 'Международный', 'Общественный']"
                                            placeholder="Статус" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4" class="py-0"><span>Тип</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="mainInfo.type"
                                            :items="['Акция', 'Вебинар', 'Вечер', 'Дебаты', 'Заседание', 'Игра', 'Митап', 'Семинар']"
                                            placeholder="Тип" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row>
                        <v-col cols="4" class="py-0"><span>Вид деятельности</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="mainInfo.typeOfActivity"
                                            :items="['Бизнес', 'Внеучебная', 'Карьера', 'Международная', 'Наука и инновации', 'Образование', 'Проектная', 'Социальная']"
                                            placeholder="Вид деятельности" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>

                </template>
            </StyledCard>
        </v-col>

        <v-col class="pt-0">
            <StyledCard>
                <template #title>
                    Подсказки
                </template>
                <template #default>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Краткое название</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Примерные сроки</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Даты проведения</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Сохранить черновик</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                    </v-expansion-panels>
                </template>
            </StyledCard>
        </v-col>
    </v-row>
</template>

<script>
    import StyledCard from "../StyledCard";

    export default {
        name: "MainInfo",
        components: {StyledCard},
        data: () => ({
            mainInfo: {
                name: '',
                shortName: '',
                status: '',
                type: '',
                typeOfActivity: '',
                dateFrom: '',
                dateTo: ''
            }
        })
    }
</script>

<style scoped>
    .v-expansion-panel-header {
        color: rgba(96, 96, 96, 1) !important;
    }

    .v-expansion-panel-content {
        color: rgba(96, 96, 96, 1) !important;
        font-size: 14px;
    }

    button, input, select, textarea {
        font-size: 14px;
    }
</style>