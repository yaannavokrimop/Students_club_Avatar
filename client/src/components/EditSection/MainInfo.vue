<template>
    <v-row class="pa-0">
        <v-col class="pa-0">
            <StyledCard>
                <template #title>
                    Основное
                </template>
                <template #card-text class="pb-0">
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Название</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="storeMainInfo.name" placeholder="Название" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Краткое название</span></v-col>
                        <v-col class="py-0">
                            <v-text-field v-model="mainInfo.shortName" placeholder="Краткое название" dense
                                          outlined></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Начало</span></v-col>
                        <v-col cols="4" class="py-0">
                            <v-menu v-model="menuDateFrom"
                                    :close-on-content-click="false"
                                    :nudge-right="40"
                                    transition="scale-transition"
                                    offset-y
                                    min-width="290px">
                                <template v-slot:activator="{ on, attrs }">
                                    <v-text-field v-model="mainInfo.dateFrom"
                                                  placeholder="Начало"
                                                  readonly
                                                  outlined
                                                  dense
                                                  v-bind="attrs"
                                                  v-on="on"></v-text-field>
                                </template>
                                <v-date-picker v-model="mainInfo.dateFrom"
                                               @input="menuDateFrom = false"></v-date-picker>
                            </v-menu>
                        </v-col>
                        <v-col cols="4" class="py-0">
                            <v-text-field outlined
                                          dense
                                          v-model="mainInfo.timeFrom"
                                          placeholder="Время"
                                          type="time"></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Окончание</span></v-col>
                        <v-col cols="4" class="py-0">
                            <v-menu v-model="menuDateTo"
                                    :close-on-content-click="false"
                                    :nudge-right="40"
                                    transition="scale-transition"
                                    offset-y
                                    min-width="290px">
                                <template v-slot:activator="{ on, attrs }">
                                    <v-text-field v-model="mainInfo.dateTo"
                                                  placeholder="Окончание"
                                                  readonly
                                                  outlined
                                                  dense
                                                  v-bind="attrs"
                                                  v-on="on"></v-text-field>
                                </template>
                                <v-date-picker v-model="mainInfo.dateTo"
                                               @input="menuDateTo = false"></v-date-picker>
                            </v-menu>
                        </v-col>
                        <v-col cols="4" class="py-0">
                            <v-text-field outlined
                                          dense
                                          v-model="mainInfo.timeTo"
                                          placeholder="Время"
                                          type="time"></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"></v-col>
                        <v-col class="py-0">
                            <v-switch
                                    v-model="mainInfo.dateFlag"
                                    label="Примерные сроки"
                            ></v-switch>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Статус</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="mainInfo.status"
                                            :items="['Ведомственный', 'Всероссийский', 'Городской', 'Групповой', 'Кафедральный', 'Межвузовский', 'Международный', 'Общественный']"
                                            placeholder="Статус" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Тип</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="mainInfo.type"
                                            :items="['Акция', 'Вебинар', 'Вечер', 'Дебаты', 'Заседание', 'Игра', 'Митап', 'Семинар']"
                                            placeholder="Тип" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Вид деятельности</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="mainInfo.typeOfActivity"
                                            :items="['Бизнес', 'Внеучебная', 'Карьера', 'Международная', 'Наука и инновации', 'Образование', 'Проектная', 'Социальная']"
                                            placeholder="Вид деятельности" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                </template>
                <template #buttons>
                    <v-container class="pt-0">
                        <v-row class="px-5" justify="end">
                            <v-btn depressed @click="onSave" class="btn-accent">
                                Сохранить
                            </v-btn>
                        </v-row>
                    </v-container>
                </template>
            </StyledCard>
        </v-col>
        <v-col class="pa-0 mr-2" cols="4" v-if="showHelp">
            <StyledCard closable :close="toggleHelp" :color="color">
                <template #title>
                    Подсказки
                </template>
                <template #card-text>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Название</v-expansion-panel-header>
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
                            <v-expansion-panel-header :color="color">Краткое название</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Примерные сроки</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Даты проведения</v-expansion-panel-header>
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
    import { mapActions, mapGetters } from "vuex";
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
                dateTo: '',
                timeFrom: '',
                timeTo: '',
                dateFlag: false,
            },
            // event: {},
            id: '',
            menuDateFrom: false,
            menuDateTo: false,
            showHelp: true,
            color: 'rgba(246, 246, 246, 1)'
        }),
      computed: {
          ...mapGetters(['storeMainInfo'])
      },
        methods: {
            ...mapActions(['putMainInfo', 'getMainInfo']),
            toggleHelp() {
                this.showHelp = !this.showHelp
            },
            onSave(){
                // this.putMainInfo(this.id, this.mainInfo);
            }
        },
        watch: {
            $route: {
                immediate: true,
                handler() {
                    this.id = this.$route.params.id;
                    this.getMainInfo(this.id).then(() => {
                        this.mainInfo = {...this.mainInfo, ...this.storeMainInfo};
                    })
                }
            }
        }
    }
</script>

<style scoped>
</style>