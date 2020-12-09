<template>
  <v-app>
    <!--<div id="nav">
      <storeModules-link to="/">Home</storeModules-link> |
      <storeModules-link to="/about">About</storeModules-link>
    </div>
    <storeModules-view/>-->

    <SideBar/>
    <v-main class="main-style">

      <v-snackbar app v-model="snackbar" top :color="msgColor">
        <v-row class="pa-2">
          <span v-html="msgText"></span>
          <!--<v-btn :color="msgColor" dark depressed @click="snackbar = false">Закрыть</v-btn>-->
          <v-spacer></v-spacer>
          <v-btn @click="snackbar = false" icon fab x-small dark>
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </v-row>
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
