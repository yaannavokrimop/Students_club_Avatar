<template>
  <v-dialog v-model="visible" width="800">
    <StyledCard>
      <template #title>Заявка на помещение</template>
      <template #card-text>
        <v-form ref="form">
          <v-container class="pb-0 pt-5">
            <v-row class="px-5">
              <v-col cols="4" class="py-0"><span>Корпус</span></v-col>
              <v-col cols="8" class="py-0">
                <v-autocomplete v-model="request.building"
                                :items="buildings"
                                placeholder="Корпус" dense outlined></v-autocomplete>
              </v-col>
            </v-row>
            <v-row class="px-5">
              <v-col cols="4" class="py-0"><span>Аудитория</span></v-col>
              <v-col cols="8" class="py-0">
                <v-autocomplete v-model="request.room"
                                :items="rooms"
                                placeholder="Аудитория" dense outlined></v-autocomplete>
              </v-col>
            </v-row>
            <v-row class="px-5">
              <v-col cols="4" class="pt-2"><span>Дата</span></v-col>
              <v-col cols="4" class="py-0">
                <v-menu v-model="menuDate"
                        :close-on-content-click="false"
                        :nudge-right="40"
                        transition="scale-transition"
                        offset-y
                        min-width="290px">
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field v-model="request.date"
                                  placeholder="Дата"
                                  readonly
                                  outlined
                                  dense
                                  v-bind="attrs"
                                  v-on="on"></v-text-field>
                  </template>
                  <v-date-picker v-model="request.date"
                                 @input="menuDate = false"></v-date-picker>
                </v-menu>
              </v-col>
            </v-row>
            <v-row class="px-5">
              <v-col cols="4" class="pt-2"><span>Время начала и окончания</span></v-col>
              <v-col cols="4" class="py-0">
                <v-text-field outlined
                              dense
                              v-model="request.timeFrom"
                              type="time"></v-text-field>
              </v-col>
              <v-col cols="4" class="py-0">
                <v-text-field outlined
                              dense
                              v-model="request.timeTo"
                              type="time"></v-text-field>
              </v-col>
            </v-row>
            <v-row class="px-5">
              <v-col cols="4" class="pt-2"><span>Количество участников</span></v-col>
              <v-col class="py-0">
                <v-text-field v-model="request.numberOfMembers" placeholder="Количество участников" dense
                              outlined></v-text-field>
              </v-col>
            </v-row>
            <v-row class="px-5">
              <v-col cols="4" class="pt-2"><span>Комментарий</span></v-col>
              <v-col class="py-0">
                <v-textarea v-model="request.comment" placeholder="Комментарий" rows="1" dense
                            outlined></v-textarea>
              </v-col>
            </v-row>
            <v-row class="px-5">
              <v-col cols="4" class="pt-2"><span>Оборудование</span></v-col>
              <v-col class="py-0">
                <div v-for="equipment in equipments" :key="equipment">
                  <v-checkbox
                      v-model="request.equipments"
                      :label="equipment"
                      :value="equipment"
                      hide-details
                      class="py-2"
                  ></v-checkbox>
                </div>
              </v-col>
            </v-row>
          </v-container>
        </v-form>
      </template>
      <template #buttons>
        <v-row class="mr-8 py-3">
          <v-spacer></v-spacer>
          <v-btn @click="onAddRequest" depressed class="btn-accent">
            Добавить
          </v-btn>
        </v-row>
      </template>
    </StyledCard>
  </v-dialog>
</template>

<script>
import StyledCard from "@/components/StyledCard";
import {mapGetters} from 'vuex';

export default {
  components: {StyledCard},
  props: {propVisible: Boolean, roomRequest: Object},
  data: () => ({
    visible: false,
    menuDate: false,
    request: {
      name: 'roomRequest',
      building: '',
      room: '',
      date: '',
      timeFrom: '',
      timeTo: '',
      numberOfMembers: '',
      comment: '',
      equipments: []
    },
    equipments: ['Компьютер стационарный', 'Проектор', 'Вывод звука', 'Микрофон', 'Ноутбук']
  }),
  computed: {...mapGetters(['buildings', 'rooms'])},
  methods: {
    onAddRequest() {
      this.$emit('addRequest', this.request);
      this.visible = false;
      this.$refs.form.reset();
    },
    closeDialog() {
      this.$emit('close');
      this.$refs.form.reset();
    }
  },
  watch: {
    propVisible(propVisible) {
      if (propVisible) {
        this.visible = propVisible;
        this.request = {...this.request, ...this.roomRequest};
      }
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