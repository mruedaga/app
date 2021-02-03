<template>
  <b-container fluid>
    <b-form>
      <b-row>
        <b-col>
          <h1>{{ currentPoll.title }}</h1>
        </b-col>
      </b-row>

      <div>
        <b-table striped hover :items="currentPoll.questions"></b-table>
      </div>
      <b-progress class="mt-2" :max="100" height="2rem" show-value>
        <b-progress-bar :value="75" variant="success"></b-progress-bar>
        <b-progress-bar :value="25" variant="warning"></b-progress-bar>
      </b-progress>
    </b-form>
  </b-container>
</template>

<script>
import {mapState} from 'vuex';

export default {
  name: 'VerticalQuestions',
  props: ['chapado'],
  data: function () {
    return {
      bgVariants: ["info", "info", "info", "info"],
      txtVariants: ["white", "white", "white", "white"]
    }
  },
  computed: {
    ...mapState([
      'currentPoll'
    ])
  },
  methods: {
    vote: function (idx) {
      this.$emit('voteOption', idx)
    }
  }
}
</script>

<style scoped>
</style>