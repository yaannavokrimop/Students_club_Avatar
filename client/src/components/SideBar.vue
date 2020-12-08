<template>
    <v-navigation-drawer
            :mini-variant="true"
            mini-variant-width="65"
            app
    >
        <v-list nav>
            <v-list-item class="px-0 my-2">
                <v-list-item-avatar>
                    <img src="https://randomuser.me/api/portraits/women/21.jpg">
                </v-list-item-avatar>
            </v-list-item>

            <v-divider/>

          <v-tooltip bottom>
            <template v-slot:activator="{ on }">
            <v-list-item class="v-list-item--link my-2" :ripple="false" @click="onCreateEvent">
                <v-list-item-icon v-on="on">
                    <v-icon color="white">mdi-plus</v-icon>
                    <CreateEventDialog :propVisible="dialogVisible" @close="onCreateEvent"/>
                </v-list-item-icon>
            </v-list-item>
            </template>
            Добавить новое мероприятие
          </v-tooltip>

          <v-tooltip bottom>
            <template v-slot:activator="{ on }">
            <v-list-item to="/eventsList" @click="clearEvent" class="my-2" :ripple="false">
                <v-list-item-icon v-on="on">
                    <v-icon color="white">mdi-format-list-bulleted-square</v-icon>
                </v-list-item-icon>
            </v-list-item>
            </template>
            Список мероприятий
          </v-tooltip>

            <v-divider/>
          <v-tooltip bottom>
            <template v-slot:activator="{ on }">
            <v-list-item to="/event" :ripple="false" class="my-2">
                <v-list-item-icon v-on="on">
<!--                    <v-badge overlap icon="mdi-close" color="error" @click="myclick">-->
                        <v-icon color="white">mdi-calendar-edit</v-icon>
<!--                    </v-badge>-->
                </v-list-item-icon>
            </v-list-item>
            </template>
            Редактирование мероприятия
          </v-tooltip>

          <v-divider class="margin"/>

          <v-list-item class="my-2" :ripple="false">
            <v-list-item-icon>
              <v-icon color="white">mdi-exit-to-app</v-icon>
            </v-list-item-icon>
          </v-list-item>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
import {mapActions} from 'vuex';
    import CreateEventDialog from "./Dialogs/CreateEventDialog";
    export default {
        name: "SideBar",
        data: () => ({
            dialogVisible: false
        }),
        components: { CreateEventDialog },
        methods: {
            ...mapActions(['clearEvent']),
            onCreateEvent(){
                this.dialogVisible = !this.dialogVisible;
            }
        }
    }
</script>

<style scoped>
    .v-navigation-drawer {
        background-color: rgba(121, 134, 203, 1) !important;
    }

    ::v-deep .v-navigation-drawer__border {
        display: none;
    }

    .v-icon {
        font-size: 30px !important;
    }

    .v-divider {
        border-color: rgba(255, 255, 255, 0.32) !important;
        border-top-width: 3px
    }

    .v-list-item__icon {
        margin: 9px 0;
    }

    .margin {
      margin-top: 280px
    }
</style>