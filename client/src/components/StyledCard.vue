<template>
    <v-card class="rounded-lg">
        <v-card-title>
            <slot name="title"/>
        </v-card-title>
        <v-divider class="mx-3"/>
        <v-card-text class="text--primary pl-6">
            <slot name="card-text"/>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: "StyledCard",
        props: ['title'],
        data: () => ({
        })
    }
</script>

<style scoped>
    @import url("https://fonts.googleapis.com/css?family=Oswald");

    .v-divider {
        border-color: rgba(197, 202, 233, 1) !important;
        border-top-width: unset
    }

    .v-card__title {
        font-family: "Oswald", Helvetica, Arial;
        font-weight: 700;
        font-size: 22px;
        letter-spacing: 2px;
        padding-bottom: 8px;
        padding-left: 22px;
    }

    .theme--light.v-list-item:not(.v-list-item--active) {
        min-height: 25px;
        font-family: "Roboto";
        font-size: 16px;
        font-weight: 500;
        color: rgba(96, 96, 96, 1) !important;
        padding: 0;
    }

</style>