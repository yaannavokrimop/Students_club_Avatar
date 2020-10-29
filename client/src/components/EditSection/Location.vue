<template>
    <v-row>
        <v-col class="pa-0">
            <StyledCard>
                <template #title>
                    Места проведения
                </template>
                <template #card-text>
                    <v-sheet height="500">
                        <v-calendar ref="calendar"
                                    v-model="focus"
                                    color="primary"
                                    type="category"
                                    category-show-all
                                    :events="events"
                                    :start="today"
                                    :value="today"
                                    locale="ru"
                                    :firstInterval="firstInterval"
                                    :intervalCount="24 - firstInterval"
                                    flat depressed
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
        name: "Location",
        components: {StyledCard},
        data: () => ({
            today: '2020-10-17',
            focus: '',
            firstInterval: 8,
            events: [
                {
                    name: '111',
                    start: '2020-10-17 09:00',
                    end: '2020-10-17 09:15',
                    category: 'Кронв 111',
                    color: 'blue'
                },
                {
                    name: '23',
                    start: '2020-10-17 09:00',
                    end: '2020-10-17 10:40',
                    category: 'Кронв 23',
                    color: 'green'
                },
                {
                    name: '456',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв 456',
                    color: 'cyan'
                },
                {
                    name: '222',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв 222',
                    color: 'cyan'
                },
                {
                    name: '333',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв 333',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал1',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал2',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал3',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал4',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал5',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал6',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал7',
                    color: 'cyan'
                },
                {
                    name: 'Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал8',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал9',
                    color: 'cyan'
                },
                {
                    name: 'Кронв Акт. зал',
                    start: '2020-10-17 10:05',
                    end: '2020-10-17 11:15',
                    category: 'Кронв Акт. зал10',
                    color: 'cyan'
                }
            ],
        }),
        methods: {
            getEventColor(event) {
                return event.color
            },
        }
    }
</script>

<style scoped>
    .theme--light.v-calendar-daily {
        border: none
    }
</style>