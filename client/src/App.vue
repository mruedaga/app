<template>
  <div id="app">
    <div>
      <b-navbar toggleable="xl" type="dark" variant="dark">
        <b-navbar-brand href="#">EasyFeedback</b-navbar-brand>
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item :to="{ path: '/'}">Home</b-nav-item>
            <b-nav-item to="/edit">Edit</b-nav-item>
            <b-nav-item to="/about">About</b-nav-item>
          </b-navbar-nav>

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <b-nav-item href="https://gitlab.com/easy-feedbac" target="_blank" right>Git Repository</b-nav-item>
          </b-navbar-nav>

        </b-collapse>
      </b-navbar>
    </div>
    <router-view/>
  </div>
</template>

<style>
</style>