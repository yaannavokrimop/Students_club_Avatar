<template>
    <v-row>
        <v-col class="pt-0" cols="8">
            <StyledCard>
                <template #title>
                    Основное
                </template>
            </StyledCard>
        </v-col>

        <v-col class="pt-0">
            <StyledCard>
                <template #title>
                    Подсказки
                </template>
            </StyledCard>
        </v-col>
    </v-row>
</template>

<script>
    import StyledCard from "../StyledCard";

    export default {
        name: "MainInfo",
        components: {StyledCard},
        data: () => ({})
    }
</script>

<style scoped>

</style>