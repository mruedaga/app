<template>
  <b-container fluid>
    <b-form>
      <b-row>
        <b-col>
          <h1>{{ currentPoll.title }}</h1>
        </b-col>
      </b-row>

      <b-row>
        <b-table striped hover :items="currentPoll.questions"></b-table>
      </b-row>

      <b-row>
        <AnswersBarchart :chart-data="chartData" :options="chartOptions"></AnswersBarchart>
      </b-row>
    </b-form>
  </b-container>
</template>

<script>
import {mapState} from 'vuex';
import AnswersBarchart from '../components/AnswersBarchart.vue'

export default {
  name: 'VerticalQuestions',
  props: ['chapado'],
  components: {
    AnswersBarchart
  },
  data() {
    return {
      bgVariants: ["info", "info", "info", "info"],
      txtVariants: ["white", "white", "white", "white"],
      chartData: {},
      chartOptions: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    }
  },
  computed: {
    ...mapState([
      'currentPoll'
    ])
  },
  watch: {
    currentPoll(newValue) {
      let labels = newValue.questions.map(x => x.question);
      let data = newValue.questions.map(x => x.votes);
      console.log(labels)
      this.chartData = {
        labels: labels,
        datasets: [{
          label: '# of Votes',
          data: data,
          borderWidth: 1,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)'
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)'
          ]
        }],
      }
    }
  }
}
</script>

<style scoped>
</style>