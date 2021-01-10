<template>
  <b-container>
    <b-row class="justify-content-md-center">
      <b-col>
        <b-form inline fluid>
            <b-form-input
                id="input-title"
                v-model="poll.title"
                placeholder="Title"
                required
                type="text"
                size="lg"
            ></b-form-input>
        </b-form>
      </b-col>
    </b-row>
    <b-row>
      <b-col md="3" sm="12" v-for="index in 4" :key="index">
        <b-card>
          <b-card-title class="d-flex justify-content-center">Q{{index}}</b-card-title>
          <b-card-body>
            <b-form-input v-if="poll.questions.length>index-1"
                          :id="'question-'+index" size="20"
                          v-model="poll.questions[index-1].question"
                          placeholder="Question"
                          type="text"
                          max="10"/>
            <b-form-input v-if="poll.questions.length<index"
                          disabled
                          type="text"/>
          </b-card-body>
          <b-card-footer>
            <b-button :disabled="index<3 || (index==3 && poll.questions.length!=2) || (index==4 && poll.questions.length!=3)" @click="addMore">
              <b-icon-plus-circle/>
            </b-button>
            <b-button :disabled="index<3 || (index==3 && poll.questions.length!=3) || (index==4 && poll.questions.length!=4)" @click="removeQuestion(index-1)">
              <b-icon-x-circle-fill/>
            </b-button>
          </b-card-footer>
        </b-card>
      </b-col>
    </b-row>

  </b-container>
</template>

<script>
export default {
  name: 'EditSource',
  props: ['poll'],
  methods: {
    addMore() {
      this.$store.commit('addQuestion')
    },
    removeQuestion(idx) {
      this.$store.commit('removeQuestion', idx)
    }
  }
}
</script>
