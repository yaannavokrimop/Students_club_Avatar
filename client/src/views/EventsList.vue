<template>
    <div>
        <span>Events List</span>
        <span> {{ this.events }} </span>
    </div>
</template>

<script>
import {HTTP} from "@/http-common";

export default {
    name: "EventsList",
    data: () => ({
        events: ''
    }),
    created: function () {
        HTTP.get('/event/all').then((response) => {
            this.events = response.data;
        }).catch(error => console.log(error));
    }
}
</script>

<style scoped>

</style>