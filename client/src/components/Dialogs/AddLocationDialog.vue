<template>
  <v-dialog v-model="dialog" width="700">
    <template v-slot:activator="{ on, attrs }">
      <v-btn v-bind="attrs"
             v-on="on"
             depressed class="btn-light">
        <v-icon class="mr-4">mdi-plus</v-icon>
        Добавить
      </v-btn>
    </template>
    <StyledCard>
      <template #title>Добавить место проведения</template>
      <template #card-text>
        <v-form ref="form">
          <v-container class="pb-0 pt-5">
            <v-row class="px-8">
              <v-switch v-model="itmo" label="В ИТМО"></v-switch>
            </v-row>
            <v-row class="px-5" v-if="itmo">
              <v-col cols="4" class="py-0"><span>Корпус</span></v-col>
              <v-col cols="8" class="py-0">
                <v-autocomplete v-model="location.building"
                                :items="buildings"
                                placeholder="Корпус" dense outlined></v-autocomplete>
              </v-col>
            </v-row>
            <v-row class="px-5" v-if="itmo">
              <v-col cols="4" class="py-0"><span>Аудитория</span></v-col>
              <v-col cols="8" class="py-0">
                <v-autocomplete v-model="location.room"
                                :items="rooms"
                                placeholder="Аудитория" dense outlined></v-autocomplete>
              </v-col>
            </v-row>
            <v-row class="px-5" v-else>
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
        </v-form>
      </template>
      <template #buttons>
        <v-row class="mr-8 py-3">
          <v-spacer></v-spacer>
          <v-btn @click="onAddLocation" depressed class="btn-accent">
            Добавить
          </v-btn>
        </v-row>
      </template>
    </StyledCard>

  </v-dialog>
</template>

<script>
import StyledCard from "../StyledCard";
import {mapGetters} from "vuex";

export default {
  components: {StyledCard},
  props: {
    askForData: Boolean
  },
  data: () => ({
    dialog: false,
    itmo: false,
    location: {
      address: '',
      building: '',
      room: '',
      date: '',
      timeFrom: '',
      timeTo: '',
    },
    menuDate: false
  }),
  computed: {...mapGetters(['buildings', 'rooms'])},
  methods: {
    onAddLocation() {
      this.$emit('addLocation', this.location);
      this.dialog = false;
      this.$refs.form.reset();
    }
  }
}
</script>

<style scoped>

</style>