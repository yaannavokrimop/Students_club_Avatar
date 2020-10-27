<template>
    <v-app>
        <!--<div id="nav">
          <storeModules-link to="/">Home</storeModules-link> |
          <storeModules-link to="/about">About</storeModules-link>
        </div>
        <storeModules-view/>-->

        <SideBar/>
        <v-main class="main-style">
            <router-view/>
        </v-main>
    </v-app>
</template>

<script>
    import SideBar from "./components/SideBar";

    export default {
        components: {
            SideBar
        },
        data: () => ({

        })
    }
</script>

<style lang="scss" scoped>
    .main-style {
        background-color: rgba(232, 234, 246, 1);
    }
</style>
