<template>
  <v-row class="pa-0">
    <v-col class="pa-0">
      <StyledCard class="">
        <template #title>
          Заявки
        </template>
        <template #card-text class="pb-0">
          <v-row class="px-5">
            <v-col cols="4">
              <v-card @click="roomDialog = true" :color="cardColor" flat height="150">
                <v-card-title class="text-uppercase pb-2">Помещение</v-card-title>
                <v-card-text>{{roomRequest.building}} {{roomRequest.room}}</v-card-text>
              </v-card>
              <RoomRequestDialog @save="addRequest" @close="onRoomsRequestClose" :roomRequest="roomRequest" :prop-visible="roomDialog"></RoomRequestDialog>
            </v-col>
            <v-col cols="4">

            </v-col>
          </v-row>
        </template>
      </StyledCard>
    </v-col>
    <v-col class="pa-0 mr-2" cols="4">
      <StyledCard closable :color="color">
        <template #title>
          Подсказки
        </template>
        <template #card-text>
          <v-expansion-panels accordion flat>
            <v-expansion-panel>
              <v-expansion-panel-header :color="color">Заявки</v-expansion-panel-header>
              <v-expansion-panel-content>
                <div>
                  Полное название включает как творческое имя в кавычках ("День донора"), так и
                  статусное описание
                  мероприятия: международная научная конференция, всероссийский
                  турнир, благотворительная акция и т.д.
                </div>
                <div>
                  Для периодичсеких мероприятий не стоит указывать год/сезон/месяц.
                </div>
              </v-expansion-panel-content>
            </v-expansion-panel>
            <v-expansion-panel>
              <v-expansion-panel-header :color="color">Заявка на помещения</v-expansion-panel-header>
              <v-expansion-panel-content>
                Примерные сроки используются, если нужно указать, что указанные даты проведения
                неокончательные и могут быть отредактрированы в дальнейшем
              </v-expansion-panel-content>
            </v-expansion-panel>
            <v-expansion-panel>
              <v-expansion-panel-header :color="color">Служебка на ключи</v-expansion-panel-header>
              <v-expansion-panel-content>
                Примерные сроки используются, если нужно указать, что указанные даты проведения
                неокончательные и могут быть отредактрированы в дальнейшем
              </v-expansion-panel-content>
            </v-expansion-panel>
          </v-expansion-panels>
        </template>
      </StyledCard>
    </v-col>
  </v-row>
</template>

<script>
import {mapActions} from 'vuex';

import StyledCard from "@/components/StyledCard";
import RoomRequestDialog from "@/components/Dialogs/RoomRequestDialog";

export default {
  components: { StyledCard, RoomRequestDialog },
  data: () => ({
    roomDialog: false,
    roomRequest: {
      building: '',
      room: '',
      date: ''
    },
    cardColor: '#7986CB',
    color: 'rgba(246, 246, 246, 1)',
    event: {}
  }),
  methods: {
    ...mapActions(['getEvent']),
    onRoomsRequestClose() {
        this.roomDialog = false;
    },
    addRequest(request) {
      this.event.requests.push({...request});
      this.roomRequest = ({...request});
    }
  },
  watch: {
    $route: {
      immediate: true,
      handler() {
        this.id = this.$route.params.id;
        this.getEvent(+this.id).then(event => {
          this.event = { requests: [], ...event};

          const location = this.event.locations.find(item => item.address === '');
          if (location) {
            this.roomRequest.building = location.building;
            this.roomRequest.room = location.room;
            this.roomRequest.date = location.date;
            this.roomRequest.timeFrom = location.timeFrom;
            this.roomRequest.timeTo = location.timeTo;
          }
        })
      }
    }
  }
}
</script>

<style scoped>
 .v-card__title {
   color: white;
   font-family: Roboto;
   font-size: 16px;
   font-weight: 400;
   line-height: 16px;
   letter-spacing: 0.05em;
 }
 .v-card__text {
   color: white !important;
 }

</style>