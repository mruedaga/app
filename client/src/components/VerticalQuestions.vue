<template>
  <b-container fluid>
    <b-form>
      <b-row>
        <b-col>
          <h1>{{ currentPoll.title }}</h1>
        </b-col>
      </b-row>
      <b-row v-for="(item,index) in currentPoll.questions" :key="item.question">
        <b-col lg="12" md="12" sm="12" xl="12">
          <b-card border-variant="primary" class="text-center">
            <b-card-body :body-bg-variant="bgVariants[index]" :body-text-variant="txtVariants[index]">
              <b-card-text class="question">
                <h1>{{item.question}} ̣
                  <b-badge variant="light">{{item.votes}}</b-badge>
                </h1>
              </b-card-text>
            </b-card-body>
          </b-card>
        </b-col>
      </b-row>
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