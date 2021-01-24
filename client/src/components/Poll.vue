<template>
  <div>
    <div class="position-relative p-4 bg-secondary">
      <p class="text-light font-weight-bold">
        Please choose an answer
      </p>
      <b-card :title=currentPoll.title >
        <b-col v-for="(item,index) in currentPoll.questions" :key="item.question"  sm="10" >
          <label>{{index+1}}. </label>
          <b-button class ="m-3" style="width: 300px;" variant="outline-primary" @click="vote(index)" size="lg" pill>
            {{ item.question }}
          </b-button>
        </b-col>
        <b-progress class="mt-2" :max="100" height="2rem" show-value>
          <b-progress-bar :value="75" variant="success"></b-progress-bar>
          <b-progress-bar :value="25" variant="warning"></b-progress-bar>
        </b-progress>
      </b-card>
    </div>
  </div>
</template>

<script>
import {mapState} from 'vuex';

export default {
  name: 'Poll',
  props: ['chapado'],
  data: function () {
    return {
      voto: false,
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
      this.$data.voto=true
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