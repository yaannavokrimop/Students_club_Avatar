<template>
    <v-row class="pa-0">
        <v-col class="pa-0">
            <StyledCard>
                <template #title>
                    Участники
                </template>
                <template #card-text class="pb-0">
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Приглашаются к участию</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="members.invited" placeholder="Название" rows="2" dense outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Контактное лицо</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="members.contact" placeholder="Название" rows="2" dense outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Сторонние организаторы</span></v-col>
                        <v-col class="py-0">
                            <v-textarea v-model="members.sideOrganizers" placeholder="Название" rows="2" dense outlined></v-textarea>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="4" class="pt-2"><span>Организаторы</span></v-col>
                        <v-col class="py-0">
                           <AddOrganiserDialog @addOrganiser="addOrganiser"/>
                        </v-col>
                    </v-row>
                    <v-row class="px-5">
                        <v-col cols="12">
                           <v-data-table
                                   :headers="headers"
                                   :items="members.organisers"
                                   :items-per-page="5"
                                   fixed-header
                                   hide-default-footer
                           >
                               <template #no-data>
                                   <span>Нет организаторов</span>
                               </template>
                           </v-data-table>
                        </v-col>
                    </v-row>
                </template>
                <template #buttons>
                    <v-container class="pt-0">
                        <v-row class="px-5" justify="end">
                            <v-btn depressed @click="onSave" class="btn-accent">
                                Сохранить
                            </v-btn>
                        </v-row>
                    </v-container>
                </template>
            </StyledCard>
        </v-col>
      <v-col class="pa-0 mr-3" cols="4">
        <StyledCard closable color="background" class="mr-3">
          <template #title>
            Подсказки
          </template>
          <template #card-text>
            <v-expansion-panels accordion flat>
              <v-expansion-panel>
                <v-expansion-panel-header color="background">Приглашаются к участию</v-expansion-panel-header>
                <v-expansion-panel-content>
                  Ответь на вопрос: кого мы приглашаем на мероприятие?
                  Это могут быть: студенты ИТМО, преподаватели ИТМО, другие сотрудники ИТМО, студенты других вузов,
                  все граждане, любой прошедший регистрацию и т.п.
                  <br>

                  Примечание: пиши с заглавной буквы

                </v-expansion-panel-content>
              </v-expansion-panel>
              <v-expansion-panel>
                <v-expansion-panel-header color="background">Контактное лицо</v-expansion-panel-header>
                <v-expansion-panel-content>
                  Пиши имя, фамилию, отчество, должность/роль в мероприятии
                  (руководитель клуба, сотрудник/начальник отдела, главный организатор турнира и т.д.),
                  номер телефона и/или почту контактного лица.
                  <br>
                  Кстати:
                  <ul>
                    <li>контактных лиц может быть несколько, желательно пояснить, к кому с каким вопросом обращаться</li>
                    <li>можно указать аудиторию и корпус, ссылку на соцсеть</li>
                    <li>если контактных лиц несколько, то можно указать, по каким вопрсам кто из них поможет</li>
                  </ul>

                </v-expansion-panel-content>
              </v-expansion-panel>
              <v-expansion-panel>
                <v-expansion-panel-header color="background">Сторонние организаторы</v-expansion-panel-header>
                <v-expansion-panel-content>
                  Перечисли организаторов на уровне организаций, подразделений, партнёров.
                  Если их несколько, то лучше не через запятую, а отделить новой строкой.
                  Наиболее важный по вкладу и власти организатор идёт первым.

                </v-expansion-panel-content>
              </v-expansion-panel>
              <v-expansion-panel>
                <v-expansion-panel-header color="background">Организаторы</v-expansion-panel-header>
                <v-expansion-panel-content>

                </v-expansion-panel-content>
              </v-expansion-panel>

            </v-expansion-panels>
          </template>
        </StyledCard>
      </v-col>
    </v-row>
</template>

<script>
    import { mapActions, mapGetters } from "vuex";

    import StyledCard from "../StyledCard";
    import AddOrganiserDialog from "../Dialogs/AddOrganiserDialog";

    export default {
        name: "Members",
        components: { StyledCard, AddOrganiserDialog },

        data: () => ({
            id: '',
            members: {
                invited: '',
                contact: '',
                sideOrganizers: '',
                organisers: [],
            },
            headers: [
                { text: 'Таб. номер', value: 'number', sortable: false },
                { text: 'ФИО', value: 'name', sortable: false },
                { text: 'Роль', value: 'role', sortable: false },
                { text: 'Комментарий', value: 'comment', sortable: false }
            ],
        }),
        computed: {
            ...mapGetters(['storeMembers'])
        },
        methods: {
            ...mapActions(['getMembers', 'putMembers']),
            onSave() {
                this.putMembers({id:this.id, members:this.members});
            },
            addOrganiser(organiser){
                this.members.organisers.push({...organiser})
            }
        },
        watch: {
            $route: {
                immediate: true,
                handler() {
                    this.id = this.$route.params.id;
                    if (JSON.stringify(this.storeMembers) === JSON.stringify(this.members)){
                        this.getMembers(this.id).then(() => {
                            this.members = {...this.members, ...this.storeMembers};
                        })
                    }
                    else {
                        this.members = {...this.storeMembers}
                    }
                }
            }
        }
    }
</script>

<style scoped>
</style>