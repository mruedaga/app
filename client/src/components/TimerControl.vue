<template>
  <b-container fluid>
    <b-row>
      <b-col>
        <b-button @click="startTimer" > Start <b-icon-play></b-icon-play></b-button>
      </b-col>
      <b-col>
        <b-button @click="stopTimer" > Stop <b-icon-stop></b-icon-stop></b-button>
      </b-col>
      <b-col>
        <b-button @click="resetCounter" > Reset <b-icon-reply></b-icon-reply></b-button>
      </b-col>
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