<template>
  <StyledCard>
    <template #title>Список мероприятий</template>
    <template #card-text>
      <v-row class="px-5">
        <v-col cols="12">
          <v-data-table
              :headers="headers"
              :items="events"
              :items-per-page="25"
              fixed-header
          >
            <template v-slot:item.systemStatus="{ item }">
              <v-chip
                  :color="getColor(item.systemStatus)"
                  dark
              >
                {{ getStatusLabel(item.systemStatus) }}
              </v-chip>
            </template>
            <template v-slot:item.actions="{ item }">
              <v-icon
                  class="mr-2"
                  @click="editItem(item)"
              >
                mdi-pencil
              </v-icon>
              <v-icon v-if="item.systemStatus === 'DRAFT'"
                  @click="deleteItem(item)"
              >
                mdi-delete
              </v-icon>
            </template>
            <template #no-data>
              <span>Нет доступных мероприятий</span>
            </template>
          </v-data-table>
        </v-col>
      </v-row>
    </template>
  </StyledCard>
</template>

<script>
// import {HTTP} from "@/http-common";
import {mapGetters, mapActions } from "vuex";

import StyledCard from "@/components/StyledCard";

export default {
  components: {StyledCard},
  data: () => ({
    headers: [
      {text: 'Название', value: 'name'},
      {text: 'Начало', value: 'dateFrom'},
      {text: 'Окончание', value: 'dateTo'},
      {text: 'Статус', value: 'systemStatus'},
      {text: '', value: 'actions'}
    ]
  }),
  computed: {...mapGetters(['events'])},
  methods: {
    ...mapActions(['deleteEvent', 'getEvents']),
    getColor (status) {
      switch (status) {
        case 'draft': return 'grey'
      }
    },
    getStatusLabel (status) {
      switch (status) {
        case 'draft': return 'Черновик';
          case 'DRAFT':return 'Черновик'
      }
    },
    editItem (item){
      this.$router.push({name: 'event', params: {id: item.id}});
    },
    deleteItem (item){
      this.deleteEvent(item.id);
    }
  },
  created: function () {
      this.getEvents();
  }
}
</script>

<style scoped>

</style>