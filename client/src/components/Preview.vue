<template>
  <b-container fluid>
    <b-row>
      <b-col>
        <h1>{{ poll.title }}</h1>
      </b-col>
    </b-row>
    <b-row>
      <b-col v-for="(item) in poll.questions" :key="item.id" lg="3" md="12" sm="12" xl="3">
        <question-button
            :bg-variant="bgVariants[item.id]"
            :item="item" :on-voteOption="vote"
            :txt-variant="txtVariants[item.id]"
        />
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import QuestionButton from '../components/QuestionButton.vue'

export default {
  name: 'Preview',
  props: ['chapado', 'poll'],
  components: {
    QuestionButton
  },
  data() {
    return {
      bgVariants: ["info", "warning", "primary", "secondary"],
      txtVariants: ["white", "white", "white", "white"]
    }
  },
  methods: {
    vote: function (idx) {
      this.$emit('voteOption', idx)
    }
  }
}
</script>

<style>
</style>