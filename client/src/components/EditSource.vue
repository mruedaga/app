<template>
  <b-container fluid>
    <b-row class="mb-10">
      <b-col sm="4" >
        <b-form  @submit.stop.prevent>
          <b-input-group-append>
            <b-form-group
                id="input-group-1"
                label="Question:"
                label-for="input-1"
                description="Please fill th question you want to make">

              <b-form-input
                  id="input-title"
                  v-model="poll.title"
                  placeholder="Question"
                  required
                  type="text"
                  style="width:500px"
                  :state="titleSizeLimit"
              ></b-form-input>
              <b-form-invalid-feedback id="input-live-feedback">
                The question must be less than 50 characters
              </b-form-invalid-feedback>
            </b-form-group>

          </b-input-group-append>
          <b-button variant="primary" @click="addMore"><b-icon-plus-circle/> New answer</b-button>
        </b-form>
      </b-col>
      <b-media-body>
      <b-col v-for="index in 4" :key="index" sm="10" >
        <b-col sm="3" v-if="poll.questions.length>index-1">
          <label >Answer number: {{index}}
            <b-button
                variant="light"
                @click="removeQuestion(index-1)"
                v-if= "index > 2">

              <b-icon-trash/>
            </b-button>
          </label>
        </b-col>
        <b-col sm="5">
          <b-form-group>
            <b-form-input
                v-if="poll.questions.length>index-1"
                placeholder="Question"
                label-for="input-formatter"
                class="mb-3"
                size="sm"
                v-model="poll.questions[index-1].question"
                rows="2">
            </b-form-input>
            <b-form-invalid-feedback id="input-live-feedback">
              The answer must be less than 20 characters
            </b-form-invalid-feedback>
          </b-form-group>
        </b-col>
      </b-col>
      </b-media-body>
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
  },
  computed: {
    titleSizeLimit() {
      return this.poll.title.length > 4 && this.poll.title.length < 51
    },
    answerSizeLimit(index) {
      return this.poll.questions[index-1].question.length > 1 && this.poll.questions[index-1].question.length < 21
    }
  }
}
</script>
