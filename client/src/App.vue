<template>
    <v-app>
        <!--<div id="nav">
          <router-link to="/">Home</router-link> |
          <router-link to="/about">About</router-link>
        </div>
        <router-view/>-->

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
        background: rgba(197, 202, 233, 1);
    }
</style>
