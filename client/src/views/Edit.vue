<template>
  <div>
    <b-container fluid>
      <b-row>
        <b-col><user-panel></user-panel></b-col>
      </b-row>
      <b-row>
        <b-col>
          <edit-source :poll="currentPoll"/>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <edit-buttons v-on:reset="resetSource" v-on:retrieve="retrieveCode" v-on:save="saveSource"/>
        </b-col>
      </b-row>
    </b-container>

    <b-modal id="modal-comms-error" centered ok-only size="lg" title="Error">
      <p>Server busy (or down). Try Later</p>
    </b-modal>

  </div>
</template>
<script>
import {mapState} from 'vuex';

import EditSource from '../components/EditSource.vue'
import EditButtons from '../components/EditButtons.vue'
import UserPanel from "@/components/UserPanel";

export default {
  name: 'Edit',
  components: {
    UserPanel,
    EditSource,
    EditButtons
  },
  data() {
    return {
      code: ''
    }
  },
  computed: {
    ...mapState([
      'currentPoll'
    ])
  },
  methods: {

    async saveSource() {
      try {
        let response = await this.$store.state.apiService.generateCode(this.$store.state.currentPoll);
        await this.$store.commit('updateModel', response.data);
        this.$router.push('moderator');
      } catch (e) {
        console.log(e)
        this.$bvModal.show('modal-comms-error')
      }
    },

    async retrieveCode(code) {
      try {
        let response = await this.$store.state.apiService.getEasyFeedback(code);
        await this.$store.commit('updateModel', response.data);
        this.$router.push('moderator');
      } catch (e) {
        console.log(e)
        this.$bvModal.show('modal-comms-error')
      }
    },

    async resetSource() {
      this.$store.commit('resetSource');
    },

    simulateVote(idx) {
      this.$store.commit('simulateVote', idx);
    }
  },
  mounted: function () {
    this.resetSource()
  }
}
</script>

