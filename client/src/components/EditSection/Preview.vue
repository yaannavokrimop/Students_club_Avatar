<template>
    <v-row>
        <v-col class="pt-0">
            <StyledCard>
                <template #title>
                    Анонс
                </template>
                <template #card-text>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Краткое описание</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="preview.shortDescription" placeholder="Краткое описание" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Описание</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="preview.description" placeholder="Описание" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Цель</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="preview.purpose" placeholder="Цель" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Задачи</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="preview.tasks" placeholder="Задачи" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Сайт</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="preview.site" placeholder="Сайт" rows="1" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="py-0"><span>Комментарий</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="preview.comment" placeholder="Комментарий" rows="1" dense
                                        outlined></v-textarea>
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
        <v-col class="pt-0" cols="4">
            <StyledCard closable>
                <template #title>
                    Подсказки
                </template>
                <template #card-text>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Краткое описание</v-expansion-panel-header>
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
                            <v-expansion-panel-header>Описание</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Цель</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Задачи</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Сайт</v-expansion-panel-header>
                            <v-expansion-panel-content>
                                Примерные сроки используются, если нужно указать, что указанные даты проведения
                                неокончательные и могут быть отредактрированы в дальнейшем
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header>Комментарий</v-expansion-panel-header>
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
            }
        })
    }
</script>

<style scoped>

</style>