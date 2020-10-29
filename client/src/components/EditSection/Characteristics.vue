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
                            <v-text-field :v-model="charact.membersNumber" placeholder="Количество участников" dense outlined></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Периодичность</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="charact.periodicity"
                                            :items="['Ежегодные', 'Ежеквартальные', 'Ежемесячные', 'Интенсивные', 'Прочие мероприятия', 'Разовые', 'Семестровые', 'Юбилейные']"
                                            placeholder="Периодичность" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Категория</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="charact.category"
                                            :items="['Ежегодные', 'Ежеквартальные', 'Ежемесячные', 'Интенсивные', 'Прочие мероприятия', 'Разовые', 'Семестровые', 'Юбилейные']"
                                            placeholder="Категория" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Публичность</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="charact.publicity"
                                            :items="['Ежегодные', 'Ежеквартальные', 'Ежемесячные', 'Интенсивные', 'Прочие мероприятия', 'Разовые', 'Семестровые', 'Юбилейные']"
                                            placeholder="Публичность" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Формат проведения</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="charact.format"
                                            :items="['Ежегодные', 'Ежеквартальные', 'Ежемесячные', 'Интенсивные', 'Прочие мероприятия', 'Разовые', 'Семестровые', 'Юбилейные']"
                                            placeholder="Формат проведения" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Основной язык проведения</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete :v-model="charact.language"
                                            :items="['Ежегодные', 'Ежеквартальные', 'Ежемесячные', 'Интенсивные', 'Прочие мероприятия', 'Разовые', 'Семестровые', 'Юбилейные']"
                                            placeholder="Основной язык проведения" dense outlined></v-autocomplete>
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
        <v-col  class="pa-0" cols="4">
            <StyledCard closable :color="color">
                <template #title>
                    Подсказки
                </template>
                <template #card-text>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Количество участников (план)</v-expansion-panel-header>
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
                            <v-expansion-panel-header :color="color">Периодичность</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Категория</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Публичность</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Формат проведения</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Основной язык проведения</v-expansion-panel-header>
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
            color: 'rgba(246, 246, 246, 1)'
        })
    }
</script>

<style scoped>

    .v-btn {
        background-color: #3949AB !important;
        color: white
    }

</style>