<template>
    <b-button @click="loginGoogle" variant="outline-primary">Google Auth</b-button>
</template>

<script>
export default {
  name: "LoginPanel",
  methods: {
    loginGoogle(){
        window.location.href = process.env.VUE_APP_API_URL + `oauth/login/google`
    }
  }
}
</script>

<style scoped>

</style>