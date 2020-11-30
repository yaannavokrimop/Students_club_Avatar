<template>
  <v-row>
    <v-col class="pa-0">
      <StyledCard>
        <template #title>
          Места проведения
        </template>
        <template #card-text>
          <div class="pr-6 pl-3">
            <v-sheet height="650">
              <v-toolbar height="40" flat>
                <v-row>
                  <AddLocationDialog @addLocation="addLocation" :askForData="multipleDays"/>
                  <v-btn v-if="event.locations.length" depressed @click="onSave" class="btn-accent ml-4">
                    Сохранить
                  </v-btn>
                  <v-spacer></v-spacer>
                  <v-btn v-if="event.locations.length" fab text small color="grey darken-2" @click="prev">
                    <v-icon small>
                      mdi-chevron-left
                    </v-icon>
                  </v-btn>
                  <v-btn v-if="event.locations.length" fab text small color="grey darken-2" @click="next" class="mr-3">
                    <v-icon small>
                      mdi-chevron-right
                    </v-icon>
                  </v-btn>
                  <v-menu v-if="event.locations.length" bottom right>
                    <template v-slot:activator="{ on, attrs }">
                      <v-btn class="btn-light mr-5"
                             depressed
                             v-bind="attrs"
                             v-on="on">
                        <span>{{ typeToLabel[type] }}</span>
                        <v-icon right>
                          mdi-menu-down
                        </v-icon>
                      </v-btn>
                    </template>
                    <v-list>
                      <v-list-item @click="changeCalenderType('category')">
                        <v-list-item-title>Один день</v-list-item-title>
                      </v-list-item>
                      <v-list-item @click="changeCalenderType('week')">
                        <v-list-item-title>Неделя</v-list-item-title>
                      </v-list-item>
                      <v-list-item @click="changeCalenderType('month')">
                        <v-list-item-title>Месяц</v-list-item-title>
                      </v-list-item>
                      <v-list-item @click="changeCalenderType('4day')">
                        <v-list-item-title>Четыре дня</v-list-item-title>
                      </v-list-item>
                    </v-list>
                  </v-menu>
                </v-row>
              </v-toolbar>
              <v-calendar v-if="locationsCalendar.length"
                          ref="calendar"
                          v-model="focus"
                          color="primary"
                          :type="type"
                          :events="locationsCalendar"
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
    type: 'category',
    typeToLabel: {
      month: 'Месяц',
      week: 'Неделя',
      category: 'Один день',
      '4day': 'Четыре дня',
    },
    menuDate: false,
    today: '2020-11-12',
    focus: '',
    firstInterval: 8,
    locations: [],
    locationsCalendar: [],
    id: '',
    event: {}
  }),
  methods: {
    ...mapActions(['getEvent', 'editEvent']),
    addLocation(location) {
      const newLocation = {...location};
      if (!this.multipleDays) {
        newLocation.date = this.event.dateFrom;
      }

      this.event.locations.push(newLocation);
      this.parseLocation(newLocation)
    },
    parseLocation(item) {
      let name;
      if (item.address) {
        name = item.address
      } else if (this.type !== 'category') {
        name = item.building + ' ' + item.room;
      } else name = item.room;
      this.locationsCalendar.push({
        name: name,
        start: item.date + ' ' + item.timeFrom,
        end: item.date + ' ' + item.timeTo,
        category: item.address ? item.address : item.building,
      })
    },
    prev() {
      this.$refs.calendar.prev()
    },
    next() {
      this.$refs.calendar.next()
    },
    changeCalenderType(type) {
      this.type = type;
      this.locationsCalendar = [];
      this.event.locations.forEach((item) => this.parseLocation(item));
    },
    onSave() {
      this.editEvent(this.event);
    }
  },
  computed: {
    multipleDays() {
      return this.event.dateFrom !== this.event.dateTo;
    }
  },
  watch: {
    $route: {
      immediate: true,
      handler() {
        this.id = this.$route.params.id;
        this.getEvent(+this.id).then(event => {
          this.event = {locations: [], ...event};
          this.today = this.event.dateFrom;
          this.event.locations.forEach((item) => this.parseLocation(item));
        })
      }
    }
  }
}
</script>

<style scoped>
.theme--light.v-calendar-daily {
  border: none;
}

::v-deep .v-calendar-daily_head-day-label {
  height: 40px;
}

::v-deep .v-btn--fab.v-size--default {
  height: 40px;
  width: 40px;
}
</style>