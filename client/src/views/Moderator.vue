<template #footer>
  <div class="edit">
    <b-container fluid>
      <b-row footer-tag="footer">
        <b-col lg="2" md="12" sm="12" xl="2">
          <timer-control v-on:startTimer="startTimer" v-on:stopTimer="stopTimer"
                         v-on:resetCounter="resetCounter"></timer-control>
        </b-col>
        <b-col lg="6" md="12" sm="12" xl="6">
          <vertical-questions/>
        </b-col>
        <b-col lg="4" md="12" sm="12" xl="4">
          <url-generator/>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
import UrlGenerator from '@/components/UrlGenerator.vue'
import VerticalQuestions from '@/components/VerticalQuestions.vue';
import TimerControl from '@/components/TimerControl.vue';

export default {
  name: 'Moderator',
  components: {
    UrlGenerator,
    VerticalQuestions,
    TimerControl
  },
  methods: {
    async startTimer() {
      await this.$store.state.apiService.startEasyFeedback(this.$store.state.currentPoll.id);
    },
    async stopTimer() {
      await this.$store.state.apiService.stopEasyFeedback(this.$store.state.currentPoll.id);
    },
    async resetCounter() {
      await this.$store.state.apiService.resetEasyFeedback(this.$store.state.currentPoll.id);
    },
  },
  mounted() {
    if (!this.$store.state.currentPoll.id) {
      this.$router.push('/')
      return
    }
    let uuid = this.$store.state.currentPoll.id;
    let me = this;
    this.$store.state.apiService.watchEasyFeedback(uuid, function (data) {
      me.$store.commit('updateModel', data);
    });
  }
}
</script>
