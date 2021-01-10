<template>
  <b-row>
    <b-col>
      <b-card border-variant="light" class="text-center">
        <b-card-body>
          <center>
            <qr-code :text="url"/>
          </center>
        </b-card-body>
        <b-card-footer>
          <b-card-text>{{ url }}</b-card-text>
          <span class="btn btn-info text-white copy-btn ml-auto" @click.stop.prevent="copyURL">Copy</span>
          <input id="input-hidden-url" :value="url" type="hidden">
        </b-card-footer>
      </b-card>
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: 'UrlGenerator',
  computed: {
    url() {
      let feedback = this.$router.resolve('feedback');
      return `${window.location.origin}${feedback.href}/${this.$store.state.currentPoll.id}`
    }
  },
  methods: {
    copyURL() {
      let testingCodeToCopy = document.querySelector('#input-hidden-url')
      testingCodeToCopy.setAttribute('type', 'text')
      testingCodeToCopy.select()
      try {
        var successful = document.execCommand('copy');
        var msg = successful ? 'successful' : 'unsuccessful';
        alert('URL was copied ' + msg);
      } catch (err) {
        alert('Oops, unable to copy');
      }
      /* unselect the range */
      testingCodeToCopy.setAttribute('type', 'hidden')
      window.getSelection().removeAllRanges()
    }
  }
}
</script>
