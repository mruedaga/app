<template>
  <b-container fluid>
    <b-row>
      <b-button-group vertical size="lg">
        <b-button variant="primary" @click="startTimer"> Start   <b-icon-play></b-icon-play></b-button>
        <b-button variant="warning" @click="stopTimer"> Stop     <b-icon-stop></b-icon-stop></b-button>
        <b-button variant="dark"    @click="resetCounter"> Reset <b-icon-reply></b-icon-reply></b-button>
      </b-button-group>
    </b-row>
  </b-container>
</template>(pfff

<script>
export default {
  name: "TimerControl",
  methods: {
    startTimer() {
      this.$emit('startTimer')
    },
    stopTimer() {
      this.$emit('stopTimer')
    },
    resetCounter() {
      this.$emit('resetCounter')
    }
  }
}
</script>

<style scoped>

</style>