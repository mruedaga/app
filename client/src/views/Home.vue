<template>
  <div class="home">
    <b-jumbotron >
      <template slot="header">
        <b-container>Easy-Feedback</b-container>
      </template>
      <template slot="lead">
        <b-container>With Easy-Feedback your audience can give to you feedback about a question in an easy way
        </b-container>
      </template>
    </b-jumbotron>
    <b-container>
      <b-row>
        <b-col sm="12" lg="3" md="3" xl="3">
          <b-card title="Easy" tag="article">
            <b-card-text>
              Create an EasyFeedback with up to 4 questions in only a few clicks
            </b-card-text>
          </b-card>
        </b-col>
        <b-col sm="12" lg="3" md="3" xl="3">
          <b-card title="Let's vote" tag="article">
            <b-card-text>
              <p>Start the poll, share the personalized url with your users and see in realtime what your users think about your question</p>
            </b-card-text>
          </b-card>
        </b-col>
        <b-col sm="12" lg="3" md="3" xl="3">
          <b-card title="Stop the poll" tag="article">
            <b-card-text>
              Close the poll when you have enough feedback and continue with your presentation
            </b-card-text>
          </b-card>
        </b-col>
        <b-col sm="12" lg="3" md="3" xl="3">
          <b-card title="Unlimited questions" tag="article">
            <b-card-text>
              Create as many EasyFeedbacks as you want
            </b-card-text>
          </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
export default {
  name: 'Home',
  components: {}
}
</script>

