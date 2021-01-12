<template>
  <b-card @click="vote()"
          border-variant="primary" class="text-center"  :body-bg-variant="bgVariant" :body-text-variant="txtVariant">
    <b-card-body>
      <b-card-text>
        <div class="question">
          <svg
              height="100%"
              preserveAspectRatio="xMinYMin meet"
              width="100%"
          >
            <foreignObject height="100%" width="100%">
              <div xmlns="http://www.w3.org/1999/xhtml">
                <p> {{ item.question }} </p>
              </div>
            </foreignObject>
          </svg>
        </div>
      </b-card-text>
      <b-card-text><p class="vote"> {{item.votes}} </p></b-card-text>
    </b-card-body>
    <b-card-footer>
      <b-button class="mb-2" size="lg" variant="primary">
        <b-icon-check-circle></b-icon-person-circle>
      </b-button>
    </b-card-footer>
  </b-card>
</template>

<script>
export default {
  name: 'QuestionButton',
  props: [
    'item',
    'chapado',
    'bgVariant',
    'txtVariant'
  ],
  methods: {
    vote() {
      this.$emit('voteOption', this.item.id)
    }
  }
}
</script>

<style>
.question
{
resize: both;
margin: 0;
padding: 0;
height: 100 %;
width: 100 %;
overflow: visible;
}
</style>