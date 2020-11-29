<template>
    <v-card flat tile :color="color" height="100%">
        <v-card-title>
            <slot name="title"/>
            <v-spacer/>
            <v-btn icon size="10" v-if="closable" @click="close">
                <v-icon>mdi-close</v-icon>
            </v-btn>
        </v-card-title>

        <v-divider class="mx-3"/>

        <v-card-text v-if="hasSubtitle" class="subtitle px-6">
            <slot name="subtitle"/>
        </v-card-text>

        <v-divider class="mx-3" v-if="hasSubtitle"/>

        <v-card-text class="text--primary px-0 pb-0">
            <slot name="card-text"/>
        </v-card-text>

        <slot name="buttons"/>


    </v-card>
</template>

<script>
    export default {
        name: "StyledCard",
        props: {
            title: String,
            closable: Boolean,
            close: Function,
            color: String
        },
        data: () => ({
        }),
        computed: {
            hasSubtitle(){
                return !!this.$slots.subtitle
            },
        },
    }
</script>

<style scoped>
    @import url("https://fonts.googleapis.com/css?family=Oswald");

    .v-divider {
         border-color: rgba(216, 216, 216, 1) !important;
         border-top-width: 2px
     }

    .v-card__title {
        font-family: "Oswald", Helvetica, Arial;
        font-weight: 700 !important;
        font-size: 22px !important;
        letter-spacing: 2px !important;

        height: 56px !important;
        padding-bottom: 8px !important;
        padding-left: 22px !important;
    }

    .subtitle {
        /*font-family: "Roboto";*/
        font-size: 14px;
        font-weight: 400;
        color: black !important;
    }

    .theme--light.v-list-item:not(.v-list-item--active) {
        min-height: 25px;
        font-family: "Roboto";
        font-size: 16px;
        font-weight: 500;
        /* color: rgba(96, 96, 96, 1) !important; */
        padding: 0;
    }

    .v-btn--icon {
        height: 30px;
        width: 30px;
    }

</style>