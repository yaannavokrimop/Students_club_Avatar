<template>
    <v-navigation-drawer
            :color="color"
            :mini-variant=true
    >
        <v-list nav class="py-0">
            <v-list-item two-line class="px-0">
                <v-list-item-avatar>
                    <img src="https://randomuser.me/api/portraits/women/81.jpg">
                </v-list-item-avatar>
            </v-list-item>

            <v-divider class="divider-style"/>

            <v-list-item class="px-1" style="height: 40px">
                <v-list-item-icon>
                    <v-icon color="white" style="font-size: 30px;">mdi-plus</v-icon>
                </v-list-item-icon>
            </v-list-item>

            <v-list-item class="px-1">
                <v-list-item-icon>
                    <v-icon color="white" style="font-size: 30px;">mdi-format-list-bulleted-square</v-icon>
                </v-list-item-icon>
            </v-list-item>

            <v-divider class="divider-style"/>

            <v-list-item class="px-1" style="height: 40px">
                <v-list-item-icon>
                    <v-icon color="white" style="font-size: 30px;">mdi-calendar-edit</v-icon>
                </v-list-item-icon>
            </v-list-item>

        </v-list>
    </v-navigation-drawer>
</template>

<script>
    export default {
        name: "SideBar",
        data: () => ({
            color: '#3949AB',
        })
    }
</script>

<style scoped>
    .divider-style {
        border-color: rgba(255, 255, 255, 0.32) !important;
        border-top-width: medium
    }
</style>