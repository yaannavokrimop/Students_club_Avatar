<template>
    <v-row class="pa-0">
        <v-col class="pa-0">
            <StyledCard>
                <template #title>
                    Характеристики
                </template>
                <template #card-text>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Количество участников (план)</span></v-col>
                        <v-col class="py-0">
                            <v-text-field v-model="event.membersNumber" placeholder="Количество участников" dense
                                          outlined></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Периодичность</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="event.periodicity"
                                            :items="['Ежегодные', 'Ежеквартальные', 'Ежемесячные', 'Интенсивные', 'Прочие мероприятия', 'Разовые', 'Семестровые', 'Юбилейные']"
                                            placeholder="Периодичность" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Категория</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="event.category"
                                            :items="['Внутреннее', 'В РФ', 'За рубежом', 'МООС']"
                                            placeholder="Категория" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Публичность</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="event.publicity"
                                            :items="['Открытое', 'Закрытое']"
                                            placeholder="Публичность" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Формат проведения</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="event.format"
                                            :items="['Очно', 'Онлайн', 'Смешанные']"
                                            placeholder="Формат проведения" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Основной язык проведения</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="event.language"
                                            :items="[ 'Русский', 'Английский', 'Русский + Английский', 'Испанский', 'Итальянский', 'Казахский', 'Китайский', 'Немецкий', 'Польский', 'Украинский', 'Французский' ]"
                                            placeholder="Основной язык проведения" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                  <v-row class="px-7">
                    <v-btn depressed block class="btn-light">
                      <v-icon class="mr-4">mdi-plus</v-icon>
                      Добавить характеристику
                    </v-btn>
                  </v-row>
                </template>
                <template #buttons>
                    <v-container class="pt-3">
                        <v-row class="px-5" justify="end">
                            <v-btn @click="onSave" depressed class="btn-accent">
                                Сохранить
                            </v-btn>
                        </v-row>
                    </v-container>
                </template>
            </StyledCard>
        </v-col>
        <v-col class="pa-0" cols="4">
            <StyledCard closable :color="color">
                <template #title>
                    Подсказки
                </template>
                <template #card-text>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Количество участников (план)</v-expansion-panel-header>
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
                            <v-expansion-panel-header>Периодичность</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Категория</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Публичность</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Формат проведения</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Основной язык проведения</v-expansion-panel-header>
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
    import {mapActions} from "vuex";

    export default {
        name: "Characteristics",
        components: {StyledCard},
        data: () => ({
            charact: {
                membersNumber: '',
                periodicity: '',
                category: '',
                publicity: '',
                format: '',
                language: ''
            },
            id: '',
            event: {},
            color: 'rgba(246, 246, 246, 1)'
        }),
        methods: {
            ...mapActions(['getEvent', 'editEvent']),
            onSave() {
                this.editEvent(this.event);
            }
        },
        watch: {
            $route: {
                immediate: true,
                handler() {
                    this.id = this.$route.params.id;
                    this.getEvent(+this.id).then(event => {
                        this.event = {...this.charact, ...event};
                    })
                }
            }
        }
    }
</script>

<style scoped>
</style>