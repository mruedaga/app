<template>
  <b-container fluid v-if="$store.state.user.name">
      <h5>Welcome {{$store.state.user.name}} </h5>
  </b-container>
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