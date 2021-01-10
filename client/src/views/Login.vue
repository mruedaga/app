<template>
  <div>
    <b-container>
      <b-jumbotron header="Identification"
                   lead="In order to access our service, you need to authenticate against some identification provider">
        <p>We don't store any information about you. We need only your username to isolate yours EasyFeedbacks</p>
        <login-panel/>
      </b-jumbotron>
    </b-container>
  </div>
</template>

<script>
import LoginPanel from "@/components/LoginPanel";

export default {
  name: "Login",
  components: {LoginPanel}
}
</script>

<style scoped>

</style>