<template>
    <v-row>
        <v-col class="pa-0">
            <StyledCard>
                <template #title>
                    Анонс
                </template>
                <template #card-text>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Краткое описание</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="preview.shortDescription" placeholder="Краткое описание" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Описание</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="preview.description" placeholder="Описание" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Цель</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="preview.purpose" placeholder="Цель" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Задачи</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="preview.tasks" placeholder="Задачи" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Сайт</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="preview.site" placeholder="Сайт" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Комментарий</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="preview.comment" placeholder="Комментарий" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                </template>
                <template #buttons>
                    <v-container class="pt-0">
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
                            <v-expansion-panel-header :color="color">Краткое описание</v-expansion-panel-header>
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
                            <v-expansion-panel-header :color="color">Описание</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Цель</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Задачи</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Сайт</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Комментарий</v-expansion-panel-header>
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
    import { mapActions, mapGetters } from "vuex";
    export default {
        name: "Preview",
        components: {StyledCard},
        data: () => ({
            preview: {
                shortDescription: '',
                description: '',
                purpose: '',
                tasks: '',
                site: '',
                comment: ''
            },
            id: '',
            event: {},
            color: 'rgba(246, 246, 246, 1)'
        }),
        computed: {
            ...mapGetters(['storePreview']),
        },
        methods: {
            ...mapActions(['getPreview', 'updatePreview']),
            onSave() {
                this.updatePreview({id: this.id, preview: this.preview});
            }
        },
        watch: {
            $route: {
                immediate: true,
                handler() {
                    if (JSON.stringify(this.storePreview) === JSON.stringify(this.preview)){
                        this.id = this.$route.params.id;
                        this.getPreview(this.id).then(() => {
                            this.preview = {...this.preview, ...this.storePreview};
                        })
                    }
                    else {
                        this.preview = {...this.storePreview}
                    }
                }
            }
        }
    }
</script>

<style scoped>

</style>