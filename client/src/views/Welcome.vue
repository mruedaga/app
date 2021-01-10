<template>
  <b-container>
    <b-jumbotron header="Welcome" lead="Welcome to EasyFeedback, preparing your environment">

    </b-jumbotron>
  </b-container>
</template>

<script>
export default {
  name: "Welcome",
  mounted() {
    this.$router.push('Edit')
  }
}
</script>

<style scoped>

</style>