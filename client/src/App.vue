<template>
  <v-app>

    <SideBar/>
    <v-main class="main-style">

      <v-snackbar v-model="snackbar" top app text :timeout="2000" :color="msgColor">
        {{ msgText }}
        <template v-slot:action="{ attrs }">
          <v-btn @click="snackbar = false"
                 icon fab x-small
                 v-bind="attrs">
            <v-icon :color="msgColor">mdi-close</v-icon>
          </v-btn>
        </template>
      </v-snackbar>

      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import {mapGetters} from 'vuex'
import SideBar from "./components/SideBar";

export default {
  components: {
    SideBar
  },
  data: () => ({}),
  computed: {
    ...mapGetters(['msgColor', 'msgText']),
    snackbar: {
      get() {
        return this.$store.getters.msgVisible;
      },
      set(val) {
        if (!val) {
          this.$store.dispatch('closeMessage');
        }
      }
    },
  }
}
</script>

<style lang="scss" scoped>
.main-style {
  background-color: rgba(232, 234, 246, 1);
}
</style>
