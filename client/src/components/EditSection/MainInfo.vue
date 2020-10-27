<template>
    <v-row>
        <v-col class="pt-0">
            <StyledCard>
                <template #title>
                    Основное
                </template>
                <template #card-text>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Название</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="mainInfo.name" placeholder="Название" rows="2" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Краткое название</span></v-col>
                        <v-col class="py-0">
                            <v-text-field :v-model="mainInfo.shortName" placeholder="Краткое название" dense
                                          outlined></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Статус</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="mainInfo.status"
                                            :items="['Ведомственный', 'Всероссийский', 'Городской', 'Групповой', 'Кафедральный', 'Межвузовский', 'Международный', 'Общественный']"
                                            placeholder="Статус" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Тип</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="mainInfo.type"
                                            :items="['Акция', 'Вебинар', 'Вечер', 'Дебаты', 'Заседание', 'Игра', 'Митап', 'Семинар']"
                                            placeholder="Тип" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Вид деятельности</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="mainInfo.typeOfActivity"
                                            :items="['Бизнес', 'Внеучебная', 'Карьера', 'Международная', 'Наука и инновации', 'Образование', 'Проектная', 'Социальная']"
                                            placeholder="Вид деятельности" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Начало</span></v-col>
                        <v-col cols="4" class="py-0">
                            <v-menu
                                    v-model="menu"
                                    :close-on-content-click="false"
                                    :nudge-right="40"
                                    transition="scale-transition"
                                    offset-y
                                    min-width="290px"
                            >
                                <template v-slot:activator="{ on, attrs }">
                                    <v-text-field
                                            v-model="mainInfo.dateFrom"
                                            placeholder="Начало"
                                            readonly
                                            outlined
                                            dense
                                            v-bind="attrs"
                                            v-on="on"
                                    ></v-text-field>
                                </template>
                                <v-date-picker
                                        v-model="mainInfo.dateFrom"
                                        @input="menu = false"
                                ></v-date-picker>
                            </v-menu>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Окончание</span></v-col>
                        <v-col cols="4" class="py-0">
                            <v-menu
                                    v-model="menu"
                                    :close-on-content-click="false"
                                    :nudge-right="40"
                                    transition="scale-transition"
                                    offset-y
                                    min-width="290px"
                            >
                                <template v-slot:activator="{ on, attrs }">
                                    <v-text-field
                                            v-model="mainInfo.dateTo"
                                            placeholder="Окончание"
                                            readonly
                                            outlined
                                            dense
                                            v-bind="attrs"
                                            v-on="on"
                                    ></v-text-field>
                                </template>
                                <v-date-picker
                                        v-model="mainInfo.dateTo"
                                        @input="menu = false"
                                ></v-date-picker>
                            </v-menu>
                        </v-col>
                        <v-col cols="4" class="py-0">
                            <v-text-field
                                    outlined
                                    dense
                                    placeholder="Время"
                                    type="time"
                            ></v-text-field>
                        </v-col>
                    </v-row>
                </template>
                <template #buttons>
                    <v-container class="pt-0">
                        <v-row class="px-5" justify="end">
                            <v-btn depressed>
                                Сохранить
                            </v-btn>
                        </v-row>
                    </v-container>
                </template>
            </StyledCard>
        </v-col>
        <v-col class="pt-0" cols="4" v-if="showHelp">
            <StyledCard closable :close="toggleHelp" >
                <template #title>
                    Подсказки
                </template>
                <template #card-text>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Название</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                <div>
                                    Полное название включает как творческое имя в кавычках ("День донора"), так и
                                    статусное описание
                                    мероприятия: международная научная конференция, всероссийский
                                    турнир, благотворительная акция и т.д.
                                </div>
                                <div>
                                    Для периодичсеких мероприятий не стоит указывать год/сезон/месяц.
                                </div>
                            </v-expansion-panel-content>
                        </v-expansion-panel>
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
                    </v-expansion-panels>
                </template>
            </StyledCard>


        </v-col>
        <v-fab-transition>
            <v-tooltip bottom>
                <template v-slot:activator="{ on }">
                    <v-btn
                            v-show="!showHelp"
                            bottom
                            right
                            fab
                            @click="toggleHelp"
                            v-on="on"
                    >
                        <v-icon>mdi-help</v-icon>
                    </v-btn>
                </template>
                Открыть подсказки
            </v-tooltip>
        </v-fab-transition>

    </v-row>
</template>

<script>
    import StyledCard from "../StyledCard";
    //import Help from "../Help";

    export default {
        name: "MainInfo",
        components: { StyledCard, /*Help*/ },
        data: () => ({
            mainInfo: {
                name: '',
                shortName: '',
                status: '',
                type: '',
                typeOfActivity: '',
                dateFrom: '',
                dateTo: ''
            },
            menu: false,
            showHelp: true
        }),
        methods: {
            toggleHelp() {
                this.showHelp = !this.showHelp
            }
        }
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

    .v-btn {
        background-color: #3949AB !important;
        color: white
    }

    button, input, select, textarea, .v-input {
        font-size: 14px;
    }
</style>