<template>
    <v-row>
        <v-col class="pt-0">
            <StyledCard>
                <template #title>
                    Места проведения
                </template>
                <template #card-text>
                    <v-sheet height="450">
                        <v-calendar ref="calendar"
                                    v-model="focus"
                                    color="primary"
                                    type="category"
                                    category-show-all
                                    :events="events"
                                    :start="today"
                                    :value="today"
                                    locale="ru"
                                    firstInterval="8"
                                    :intervalCount="24 - 8"
                        >
                        </v-calendar>
                    </v-sheet>
                </template>
            </StyledCard>

        </v-col>
    </v-row>
</template>

<script>
    import StyledCard from "../StyledCard";

    export default {
        name: "Timetable",
        components: {StyledCard},
        data: () => ({
            today: '2020-10-17',
            focus: '',
            events: [
                {
                    name: 'Ауд. 111',
                    start: '2020-10-17 09:15',
                    end: '2020-10-17 11:00',
                    category: 'Кронверкский',
                    color: 'blue'
                },
                {
                    name: 'Ауд. 23',
                    start: '2020-10-17 09:00',
                    end: '2020-10-17 10:40',
                    category: 'Кронверкский',
                    color: 'green'
                },
                {
                    name: 'Ауд. 456',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронверкский',
                    color: 'cyan'
                },
                {
                    name: 'Ауд. 222',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронверкский',
                    color: 'cyan'
                },
                {
                    name: 'Ауд. 333',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронверкский',
                    color: 'cyan'
                },
                {
                    name: 'Кронв. Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв. Акт. зал',
                    color: 'cyan'
                },
                {
                    name: 'Кронв. Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв. Акт. зал',
                    color: 'cyan'
                },
                {
                    name: 'Кронв. Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв. Акт. зал',
                    color: 'cyan'
                },
                {
                    name: 'Кронв. Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв. Акт. зал',
                    color: 'cyan'
                },
                {
                    name: 'Кронв. Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв. Акт. зал',
                    color: 'cyan'
                },
                {
                    name: 'Кронв. Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв. Акт. зал',
                    color: 'cyan'
                }
            ],
        }),
    }
</script>

<style scoped>

</style>