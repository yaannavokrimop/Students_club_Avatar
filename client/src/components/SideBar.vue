<template>
    <v-navigation-drawer
            :color="color"
            :mini-variant="true"
            mini-variant-width="65"
            app
    >
        <v-list nav class="py-1">
            <v-list-item class="px-0 my-2">
                <v-list-item-avatar>
                    <img src="https://randomuser.me/api/portraits/women/21.jpg">
                </v-list-item-avatar>
            </v-list-item>

            <v-divider/>

            <v-list-item to="/event" class="my-2 " :ripple="false" >
                <v-list-item-icon>
                    <v-icon color="white">mdi-plus</v-icon>
                </v-list-item-icon>
            </v-list-item>

            <v-list-item to="/eventsList" class="my-2" :ripple="false">
                <v-list-item-icon>
                    <v-icon color="white">mdi-format-list-bulleted-square</v-icon>
                </v-list-item-icon>
            </v-list-item>

            <v-divider/>

            <v-list-item class="px-1">
                <v-list-item-icon>
                    <v-icon color="white">mdi-calendar-edit</v-icon>
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
    .v-icon {
        font-size: 30px !important;
    }
    .v-divider {
        border-color: rgba(255, 255, 255, 0.32) !important;
        border-top-width: medium
    }
    .v-list-item__icon {
        margin: 9px 0;
    }
</style>