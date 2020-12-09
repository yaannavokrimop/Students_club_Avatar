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
                            <v-text-field v-model="charact.membersNumber" placeholder="Количество участников" dense
                                          outlined></v-text-field>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Периодичность</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="charact.periodicity"
                                            :items="['Ежегодные', 'Ежеквартальные', 'Ежемесячные', 'Интенсивные', 'Прочие мероприятия', 'Разовые', 'Семестровые', 'Юбилейные']"
                                            placeholder="Периодичность" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Категория</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="charact.category"
                                            :items="['Внутреннее', 'В РФ', 'За рубежом', 'МООС']"
                                            placeholder="Категория" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Публичность</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="charact.publicity"
                                            :items="['Открытое', 'Закрытое']"
                                            placeholder="Публичность" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Формат проведения</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="charact.format"
                                            :items="['Очно', 'Онлайн', 'Смешанные']"
                                            placeholder="Формат проведения" dense outlined></v-autocomplete>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Основной язык проведения</span></v-col>
                        <v-col class="py-0">
                            <v-autocomplete v-model="charact.language"
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
        <v-col class="pa-0 mr-3" cols="4">
            <StyledCard closable :color="color">
                <template #title>
                    Подсказки
                </template>
                <template #card-text>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Количество участников (план)</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Сколько участников планируется на мероприятии? Старайся оценивать реально, не нужно завышать этот показатель.
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Периодичность</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Выбирай наиболее подходящий для этого мероприятия из предложенного списка
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Категория</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Внутреннее или внешнее мероприятие?
                              Это зависит от организатора, но не от площадки проведения или участников.
                              Внутреннее мероприятие проводится силами ИТМО, внешнее мероприятие проводится либо партнёрами Университета,
                              либо в сотрудничестве с ними на уровне организаторов
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Публичность</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Открытое или закрытое мероприятие?
                              На закрытое мероприятие заранее ограничен список лиц,
                              например, заседание клуба предполагает участниками только членов клуба.
                              Большинство мероприятий открытые
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Формат проведения</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Выбирай наиболее подходящий для этого мероприятия из предложенного списка
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Основной язык проведения</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Как правило, основным языком является русский.
                              Если все материалы для мероприятия и само мероприятие будут на иностранном языке, то укажи его
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
    import {mapActions, mapGetters} from "vuex";

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
            color: 'rgba(246, 246, 246, 1)'
        }),
        computed: {
            ...mapGetters(['storeCharact']),
        },
        methods: {
            ...mapActions(['getCharact', 'editCharact']),
            onSave() {
                this.editCharact({id:this.id, charact:this.charact});
            }
        },
        watch: {
            $route: {
                immediate: true,
                handler() {
                    if (JSON.stringify(this.storeCharact) === JSON.stringify(this.charact)){
                        this.id = this.$route.params.id;
                        this.getCharact(this.id).then(() => {
                            this.charact= {...this.charact, ...this.storeCharact};
                        })
                    }
                    else {
                        this.charact = {...this.storeCharact}
                    }
                }
            }
        }
    }
</script>

<style scoped>
</style>