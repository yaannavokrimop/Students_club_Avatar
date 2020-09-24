<template>
    <v-app>
        <SideBar/>
        <v-main class="main-style">



        </v-main>
    </v-app>
</template>

<script>
    import SideBar from "./components/SideBar"

    export default {
        name: 'App',
        components: {
            SideBar
        },
        data: () => ({

        }),
    };
</script>

<style scoped>
    .main-style {
        background: rgba(197, 202, 233, 1);
    }
</style>
