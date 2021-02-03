<template>
  <b-container fluid>
    <b-row class="justify-content-md-center">
      <b-col col lg="4">
        <b-button-toolbar aria-label="toolbar">
          <b-button-group class="mr-1" size="mg">
            <b-button variant="success" @click="save">Save</b-button>
          </b-button-group>
          <b-button-group class="mr-1" size="mg">
            <b-button variant="dark" @click="reset">Reset</b-button>
          </b-button-group>
          <b-input-group class="mr-1" size="mg">
            <b-form-input v-model="code" class="text-right" placeholder="xxxx-yyyy"></b-form-input>
            <b-button variant="info" size="mg  " @click="retrieve">Retrieve</b-button>
          </b-input-group>
        </b-button-toolbar>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: 'EditButtons',
  props: {},
  computed: {},
  methods: {
    save: function () {
      this.$emit('save')
    },
    reset: function () {
      this.$emit('reset')
    },
    retrieve: function () {
      if (this.code && this.code) {
        this.$emit('retrieve', this.code)
      }
    }
  },
  data() {
    return {
      code: ''
    }
  }
}
</script>
