<template>
    <v-row class="pa-0">
        <v-col class="pa-0">
            <StyledCard class=" mr-5">
                <template #title>
                    Участники
                </template>
                <template #card-text class="pb-0">
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Приглашаются к участию</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="members.invited" placeholder="Название" rows="2" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Контактное лицо</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="members.contact" placeholder="Название" rows="2" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Сторонние организаторы</span></v-col>
                        <v-col class="py-0">
                            <v-textarea :v-model="members.organizers" placeholder="Название" rows="2" dense
                                        outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Организаторы</span></v-col>
                        <v-col class="py-0">
                            <v-btn depressed block class="btn-light"> <v-icon class="mr-4">mdi-plus</v-icon> Добавить организатора</v-btn>
                        </v-col>
                    </v-row>
                </template>
                <template #buttons>
                    <v-container class="pt-0">
                        <v-row class="px-5" justify="end">
                            <v-btn depressed @click="saveMembers" class="btn-accent">
                                Сохранить
                            </v-btn>
                        </v-row>
                    </v-container>
                </template>
            </StyledCard>
        </v-col>
    </v-row>
</template>

<script>
    import StyledCard from "../StyledCard";
    export default {
        name: "Members",
        components: { StyledCard },

        data: () => ({
            members: {
                invited: '',
                contact: '',
                organizers: '',
            }
        }),

        methods: {
            saveMembers(){

            }
        }
    }
</script>

<style scoped>

</style>