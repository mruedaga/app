<template>
  <div class="edit">
    <b-container fluid>
      <b-row v-if="$store.state.currentPoll">
        <b-col>
          <poll :voto="chapado" v-on:voteOption="vote"/>
        </b-col>
      </b-row>
      <b-row v-if="!$store.state.currentPoll">
        <b-col>
          Loading....
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
import Poll from '../components/Poll.vue';

export default {
  name: 'Feedback',
  components: {
    Poll
  },
  data() {
    return {
      voto: false,
      interval: null
    }
  },
  computed: {
    chapado() {
      return !this.$store.state.currentPoll.state || this.$store.state.currentPoll.state != 'STARTED' || this.voto
    }
  },
  methods: {
    vote(idx) {
      this.voto = true;
      this.$store.state.apiService.voteEasyFeedback(this.$store.state.currentPoll.id, idx);
    },
    async updatePoll() {
      let uuid = this.$route.params.id;
      let response = await this.$store.state.apiService.getEasyFeedback(uuid);
      await this.$store.commit('updateModel', response.data);
    }
  },
  async mounted() {
    if (this.$route.params.id) {
      let uuid = this.$route.params.id;
      let me = this;
      this.$store.state.apiService.watchEasyFeedback(uuid, function (data) {
        me.$store.commit('updateModel', data);
      });
    }
  }
}
</script>

