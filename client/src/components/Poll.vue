<template>
  <div>
    <div class="position-relative p-4 bg-secondary" v-if="voto">
      <p class="text-light" v-if="currentPoll.state== 'STARTED'" >
        <b-alert show variant="success">
          <h4 class="alert-heading">Thanks for participating!</h4>
          <p>
            Currently the poll is still <b>OPEN</b>, please wait a few minutes for all members to give us feedback.
          </p>
          <hr>
        </b-alert>
      </p>
      <p class="text-light" v-if="currentPoll.state != 'STARTED'" >
        <b-alert show variant="warning">
          <h4 class="alert-heading">Thanks for participating!</h4>
          <p>
            Currently the poll is <b>CLOSED</b>, thanks for sharing your opinion.
          </p>
          <hr>
        </b-alert>
      </p>
    </div>
    <b-row>
        <AnswersBarchart :chart-data="chartData" :options="chartOptions"></AnswersBarchart>
    </b-row>
    <div class="position-relative p-4 bg-secondary" v-if="!voto">
      <p class="text-light font-weight-bold">
        Please choose an answer
      </p>
      <b-card :title=currentPoll.title>
        <b-col v-for="(item,index) in currentPoll.questions" :key="item.question" sm="10">
          <label>{{index+1}}. </label>
          <b-button class="m-3" style="width: 300px;" variant="outline-primary" @click="vote(index)" size="lg" pill>
            {{ item.question }}
          </b-button>
        </b-col>
      </b-card>
    </div>
  </div>
</template>

<script>
import {mapState} from 'vuex';

export default {
  name: 'Poll',
  props: ['voto'],
  data() {
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
      this.$data.voto = true
      this.$emit('voteOption', idx)
    }
  }
}
</script>

<style scoped>
.question {
  font-size: 4vw
}

.vote {
  font-size: 4vw
}
</style>