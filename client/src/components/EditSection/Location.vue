<template>
    <v-row>
        <v-col class="pa-0">
            <StyledCard>
                <template #title>
                    Места проведения
                </template>
                <template #card-text>
                    <div class="pr-6 pl-3">
                        <AddLocationDialog :askForData="multipleDays"/>
                        <v-sheet v-if="locations.length" height="500">
                            <v-calendar ref="calendar"
                                        v-model="focus"
                                        color="primary"
                                        type="category"
                                        category-show-all
                                        :events="locations"
                                        :start="today"
                                        :value="today"
                                        locale="ru"
                                        :firstInterval="firstInterval"
                                        :intervalCount="24 - firstInterval"
                                        flat depressed
                            >
                            </v-calendar>
                        </v-sheet>
                    </div>
                </template>
            </StyledCard>

        </v-col>
    </v-row>
</template>

<script>
    import {mapActions} from "vuex";

    import StyledCard from "../StyledCard";
    import AddLocationDialog from "../Dialogs/AddLocationDialog";

    export default {
        name: "Location",
        components: {StyledCard, AddLocationDialog},
        data: () => ({
            menuDate: false,
            today: '2020-11-12',
            focus: '',
            firstInterval: 8,
            locations: [
                /*{
                    name: '111',
                    start: '2020-10-17 09:00',
                    end: '2020-10-17 09:15',
                    category: 'Кронв 111',
                    color: 'blue'
                }*/
            ],
            id: '',
            event: {}
        }),
        methods: {
            ...mapActions(['getEvent', 'editEvent']),
            addLocation() {
                
            }
        },
        computed: {
            multipleDays(){
                return this.event.dateFrom !== this.event.dateTo;
            }
        },
        watch: {
            $route: {
                immediate: true,
                handler() {
                    this.id = this.$route.params.id;
                    this.getEvent(+this.id).then(event => {
                        this.event = {...this.location, ...event};
                        this.today = this.event.dateFrom;
                    })
                }
            }
        }
    }
</script>

<style scoped>
    .theme--light.v-calendar-daily {
        border: none
    }
</style>