<template>
  <b-container fluid>
      <b-row>
        <b-col>
          <h1>{{ currentPoll.title }}</h1>
        </b-col>
      </b-row>
      <b-row>
        <b-col  @click="vote(index)" v-for="(item,index) in currentPoll.questions" :key="item.question" lg="3" md="12" sm="12" xl="3">
          <b-card border-variant="primary" class="text-center">
            <b-card-body :body-bg-variant="bgVariants[index]" :body-text-variant="txtVariants[index]">
              <b-card-text>
                <div class="question">
                  <svg
                      height="100%"
                      preserveAspectRatio="xMinYMin meet"
                      width="100%"
                  >
                    <foreignObject height="100%" width="100%">
                      <div xmlns="http://www.w3.org/1999/xhtml">
                        <p>{{ item.question }}</p>
                      </div>
                    </foreignObject>
                  </svg>
                </div>
              </b-card-text>
              <b-card-text><p class="vote">{{ item.votes }}</p></b-card-text>
            </b-card-body>
            <b-card-footer>
              <b-button v-if="!voto" class="mb-2" size="lg" variant="primary" :disabled="chapado">
                <b-icon-check-circle/>
              </b-button>
            </b-card-footer>
          </b-card>
        </b-col>
      </b-row>
  </b-container>
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