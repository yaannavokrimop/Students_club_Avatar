<template>
    <div>
        <v-dialog v-model="dialog" width="700">
            <template v-slot:activator="{ on, attrs }">
                <v-btn v-bind="attrs"
                       v-on="on"
                       depressed block class="btn-light">
                    <v-icon class="mr-4">mdi-plus</v-icon>
                    Добавить место проведения
                </v-btn>
            </template>
            <StyledCard>
                <template #title>Добавить место проведения</template>
                <template #card-text>
                    <v-container class="pb-0 pt-5">
                        <v-row class="px-5">
                            <v-col cols="4" class="py-0"><span>Адрес</span></v-col>
                            <v-col cols="8" class="py-0">
                                <v-text-field v-model="location.address" placeholder="Адрес" dense
                                              outlined></v-text-field>
                            </v-col>
                        </v-row>
                        <v-row v-if="askForData" class="px-5">
                            <v-col cols="4" class="pt-2"><span>Дата</span></v-col>
                            <v-col cols="4" class="py-0">
                                <v-menu v-model="menuDate"
                                        :close-on-content-click="false"
                                        :nudge-right="40"
                                        transition="scale-transition"
                                        offset-y
                                        min-width="290px">
                                    <template v-slot:activator="{ on, attrs }">
                                        <v-text-field v-model="location.date"
                                                      placeholder="Дата"
                                                      readonly
                                                      outlined
                                                      dense
                                                      v-bind="attrs"
                                                      v-on="on"></v-text-field>
                                    </template>
                                    <v-date-picker v-model="location.date"
                                                   @input="menuDate = false"></v-date-picker>
                                </v-menu>
                            </v-col>
                        </v-row>
                        <v-row class="px-5">
                            <v-col cols="4" class="pt-2"><span>Время начала и окончания</span></v-col>
                            <v-col cols="4" class="py-0">
                                <v-text-field outlined
                                              dense
                                              v-model="location.timeFrom"
                                              type="time"></v-text-field>
                            </v-col>
                            <v-col cols="4" class="py-0">
                                <v-text-field outlined
                                              dense
                                              v-model="location.timeTo"
                                              type="time"></v-text-field>
                            </v-col>
                        </v-row>
                    </v-container>
                </template>
                <template #buttons>
                    <v-row class="mr-8 py-3">
                        <v-spacer></v-spacer>
                        <v-btn depressed class="btn-accent">
                            Добавить
                        </v-btn>
                    </v-row>
                </template>
            </StyledCard>

        </v-dialog>
    </div>
</template>

<script>
    import StyledCard from "../StyledCard";

    export default {
        components: {StyledCard},
        props: {
            askForData: Boolean
        },
        data: () => ({
            dialog: false,
            location: {
                address: '',
                date: '',
                timeFrom: '',
                timeTo: '',
            },
        })
    }
</script>

<style scoped>

</style>