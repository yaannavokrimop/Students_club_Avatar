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
        <v-col class="pa-0 mr-3" cols="4">
            <StyledCard closable :color="color">
                <template #title>
                    Подсказки
                </template>
                <template #card-text>
                    <v-expansion-panels accordion flat>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Краткое описание</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Это короткое описание мероприятия.
                              Его задача - парой предложений ввести в курс дела и успеть показать его крутость
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Описание</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Описание будет видно на сайте ITMO.Students
                              <br>
                              Задачи описания:
                              <ol>
                                <li>Объяснить, что и ради чего будет происходить</li>
                                <li>Кому и почему это может быть интересно</li>
                                <li>К чему быть готовыми участникам</li>
                                <li>Вызвать желание участвовать у тех, кто там действительно нужен</li>
                                <li>Дать почувствовать вкус задумки организаторов, помочь уловить вашу мотивацию</li>
                              </ol>

                              Важно: Не упоминайте даты проведения и место, так как они указаны в
                              специальных разделах. Разве только в случае, когда место или время очень
                              важны и без них не описать задумку.

                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Цель</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Отражается в ИСУ, но не видна на сайте ITMO.Students.
                              Ответь на вопрос: зачем проводится это мероприятие? Нужно сформулировать общо и ёмко.

                              Попробуй формулировки, начинающиеся так:
                              <ul>
                                <li>Развитие.... в Университете ИТМО</li>
                                <li>Повышение уровня/показателей...</li>
                                <li>Расширение компетенций/полномочий...</li>
                                <li>Углубление понимание... среди студентов ИТМО</li>
                                <li>Поддержка талантливых студентов в...</li>
                                <li>Просвещение и повышение грамотности среди молодых людей в области....</li>
                                <li>Обновление…</li>
                              </ul>

                              Примечание: если одно предложение, то не ставь точку

                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Задачи</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Отражается в ИСУ, не видны на сайте ITMO.Students. Ответь на вопрос: как достигается эта цель?
                              <br>
                              Логичный вопрос: чьи задачи мы описываем, организаторов или участников?
                              <br>
                              Ответ: Как хочешь, главное, чтобы цель была общая.
                              <br>

                              Рекомендуем более полно описывать задачи участников.
                              Можешь разделить и пометить задачи участников и задачи организаторов.
                              <br>

                              Примечание: пиши с заглавной буквы, через точку с запятой, с новой строки каждое, последний пункт завершай точкой

                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Сайт</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Укажи ссылки на интернет-ресурсы мероприятия. Это может быть так же группа в ВК или инстаграм.

                            </v-expansion-panel-content>
                        </v-expansion-panel>
                        <v-expansion-panel>
                            <v-expansion-panel-header :color="color">Комментарий</v-expansion-panel-header>
                            <v-expansion-panel-content>
                              Можно указать, что важно знать участникам и волонтерам об особенностях мероприятия
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