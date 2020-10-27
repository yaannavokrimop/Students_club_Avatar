<template>
    <div>
        <StyledCard closable :close="toggleHelp" v-if="showHelp">
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
    </div>
</template>

<script>
    import StyledCard from "./StyledCard";

    export default {
        name: "Help",
        components: {StyledCard},
        data: () => ({
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

</style>