<template>
  <b-jumbotron>
    <template #header>Creación/Edición Feedback</template>
    <b-container fluid v-if="$store.state.user.name">
        <h5><b-avatar variant="dark"></b-avatar> {{$store.state.user.name}} </h5>
    </b-container>
  </b-jumbotron>
</template>

<script>
export default {
  name: "UserPanel",
  mounted() {
    this.$store.dispatch('fetchUser')
  }
}
</script>

<style scoped>

</style>