<template>
  <div id="app">
    <nav class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand ps-4" href="#">
      <img class="img-fluid" src=".\assets\AppLogo.png" alt="Netflix App" width="40" height="auto" />
    </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <router-link class="nav-item nav-link active" :to="{name: 'Home'}"><i class="bi bi-house-door-fill me-2"></i>Home</router-link>
          <router-link class="nav-item nav-link active" :to="{name: 'Flashcards'}"><i class="bi bi-bar-chart-line-fill me-2"></i>Flashcards</router-link>
        </div>
      </div>
      <div class="navbar-nav mx-4 ml-auto">
        <router-link class="loginMenu nav-item nav-link active" :to="{name: 'Login'}"><i class="bi bi-box-arrow-in-right me-2"></i>Login</router-link>
        <router-link class="loginMenu nav-item nav-link active" :to="{name: 'Register'}"><i class="bi bi-person-plus me-2"></i>Register</router-link>
  </div>
    </nav>
    <div id="app-body">
      <router-view />
    </div>
    <!-- <footer class="footer bg-dark text-white py-2 my-0" style="position: fixed; bottom: 0; width: 100%;">
      <div class="container">
        <div class="row">
          <div class="col-md-6 d-flex align-items-center gap-2">
            <a href="https://github.com/Saigunas/flashcards-webapp"><i class="bi bi-github h3 m-0"></i></a>
            <span>Flashcard App</span>
          </div>
          <div class="col-md-6 d-flex align-items-center justify-content-end">
            <span class="footer-information" style="margin-left: auto">Project was made by Karolis, Gvidas, Saigunas.</span>
          </div>
        </div>
      </div>
    </footer> -->
  </div>
</template>

<style scoped>
#app-body {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  min-height: 100%;
}
footer{
  opacity: 0.7;
}
</style>
