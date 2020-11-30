<template>
  <div>
    <v-dialog
        v-model="visible"
        width="700"
    >
      <StyledCard>
        <template #title>
          Новое мероприятие
        </template>
        <template #card-text>
          <v-form ref="form">
            <v-container class="pb-0 pt-5">
              <v-row class="px-5">
                <v-col cols="4" class="pt-2"><span>Название</span></v-col>
                <v-col class="py-0">
                  <v-text-field v-model="eventShort.name"
                                placeholder="Краткое название"
                                :rules="[required]"
                                dense
                                outlined
                  ></v-text-field>
                </v-col>
              </v-row>
              <v-row class="px-5 pb-0">
                <v-col cols="4" class="pt-2"><span>Начало</span></v-col>
                <v-col cols="3" class="py-0">
                  <v-menu
                      v-model="menuDateFrom"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      transition="scale-transition"
                      offset-y
                      min-width="290px"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                          v-model="eventShort.dateFrom"
                          placeholder="Начало"
                          :rules="[required]"
                          readonly
                          outlined
                          dense
                          v-bind="attrs"
                          v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                        v-model="eventShort.dateFrom"
                        @input="menuDateFrom = false"
                    ></v-date-picker>
                  </v-menu>
                </v-col>
                <span class="pt-2">-</span>
                <v-col cols="3" class="py-0">
                  <v-menu
                      v-model="menuDateTo"
                      :close-on-content-click="false"
                      :nudge-right="40"
                      transition="scale-transition"
                      offset-y
                      min-width="290px"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                          v-model="eventShort.dateTo"
                          placeholder="Окончание"
                          :rules="[required]"
                          readonly
                          outlined
                          dense
                          v-bind="attrs"
                          v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                        v-model="eventShort.dateTo"
                        @input="menuDateTo = false"
                    ></v-date-picker>
                  </v-menu>
                </v-col>
              </v-row>
              <v-row height="30" class="px-5">
                <v-switch
                    v-model="eventShort.dateFlag"
                    label="Примерные сроки"
                    hide-details
                ></v-switch>
              </v-row>
            </v-container>
          </v-form>
        </template>
        <template #buttons>
          <v-row class="mr-3 pb-3">
            <v-spacer></v-spacer>
            <v-btn @click="onCreateEvent()" depressed class="btn-accent">
              Добавить
            </v-btn>
          </v-row>
        </template>
      </StyledCard>
    </v-dialog>
  </div>
</template>

<script>
import {mapGetters, mapActions} from "vuex";
import StyledCard from '../StyledCard'

export default {
  name: "CreateEventDialog",
  components: {StyledCard},
  props: {propVisible: Boolean},
  data: () => ({
    eventShort: {
      name: '',
      dateTo: '',
      dateFrom: '',
      dateFlag: false,
    },

    visible: false,
    menuDateFrom: false,
    menuDateTo: false,
  }),
  computed: {
    ...mapGetters(['required', 'eventShortEmpty']),
  },
  methods: {
    ...mapActions(['createEvent']),
    onCreateEvent() {
      if (this.$refs.form.validate()) {
        //this.$store.dispatch('createEvent', this.eventShort);
        this.eventShort.systemStatus = 'draft';
        this.createEvent(this.eventShort).then(id => {
          this.visible = false;
          this.$refs.form.reset();
          this.$router.push({name: 'event', params: {id}});
        });
      }
    }
  },
  watch: {
    propVisible(propVisible) {
      propVisible === true ? this.visible = propVisible : null;
    },
    visible(visible) {
      if (visible === false) {
        this.$emit('close');
        this.$refs.form.reset();
      }
    }
  }
}
</script>

<style scoped>

</style>