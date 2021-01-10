<template>
  <div class="edit">
    <b-container fluid>
      <b-row v-if="$store.state.currentPoll">
        <b-col>
          <poll v-bind:chapado="chapado" v-on:voteOption="vote"/>
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
      interval: null
    }
  },
  computed : {
    chapado(){
      console.log(!this.$store.state.currentPoll.state || this.$store.state.currentPoll.state!='STARTED')
      return !this.$store.state.currentPoll.state || this.$store.state.currentPoll.state!='STARTED'
    }
  },
  methods: {
    vote(idx) {
      this.$store.state.apiService.voteEasyFeedback(this.$store.state.currentPoll.id, idx);
      this.$data.chapado = true;
    },
    async updatePoll() {
      let uuid = this.$route.params.id;
      let response = await this.$store.state.apiService.getEasyFeedback(uuid);
      await this.$store.commit('updateModel', response.data);
    }
  },
  async mounted() {
    if (this.$route.params.id) {
      this.interval = setInterval(() => {
        this.updatePoll();
      }, 1000)
      this.updatePoll();
    }
  }
}
</script>

