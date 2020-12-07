<template>
    <div>
        <v-dialog v-model="dialog" width="700">
            <template v-slot:activator="{ on, attrs }">
                <v-btn v-bind="attrs"
                       v-on="on"
                       depressed block class="btn-light">
                    <v-icon class="mr-4">mdi-plus</v-icon>
                    Добавить организатора
                </v-btn>
            </template>
            <StyledCard>
                <template #title>
                    Добавление организатора
                </template>
                <template #card-text>
                    <v-form ref="form">
                    <v-container class="pb-0 pt-5">
                        <v-row class="px-5">
                            <v-col cols="3" class="pt-2"><span>Таб. номер</span></v-col>
                            <v-col class="py-0">
                                <v-text-field v-model="organiser.number"
                                              placeholder="Таб. номер"
                                              dense
                                              outlined
                                ></v-text-field>
                            </v-col>
                        </v-row>
                        <v-row class="px-5">
                            <v-col cols="3" class="pt-2"><span>ФИО</span></v-col>
                            <v-col class="py-0">
                                <v-text-field v-model="organiser.name"
                                              placeholder="ФИО"
                                              dense
                                              outlined
                                ></v-text-field>
                            </v-col>
                        </v-row>
                        <v-row class="px-5">
                            <v-col cols="3" class="pt-2"><span>Роль</span></v-col>
                            <v-col class="py-0">
                                <v-textarea v-model="organiser.role" placeholder="Роль" rows="1" dense outlined></v-textarea>
                            </v-col>
                        </v-row>
                        <v-row class="px-5">
                            <v-col cols="3" class="pt-2"><span>Комментарий</span></v-col>
                            <v-col class="py-0">
                                <v-textarea v-model="organiser.comment" placeholder="Комментарий" rows="2" dense outlined hide-details></v-textarea>
                            </v-col>
                        </v-row>
                    </v-container>
                    </v-form>
                </template>
                <template #buttons>
                    <v-row class="mr-8 py-3">
                        <v-spacer></v-spacer>
                        <v-btn @click="onAddOrganiser" depressed class="btn-accent">
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
        components: { StyledCard },
        data: () => ({
            organiser: {
                number: '',
                name: '',
                role: '',
                comment: ''
            },
            dialog: false
        }),
        methods: {
            onAddOrganiser(){
                this.$emit('addOrganiser', this.organiser);
                this.$refs.form.reset();
                this.dialog = false;
            }
        }
    }
</script>

<style scoped>

</style>