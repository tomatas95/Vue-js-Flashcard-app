<template>
  <div class="about-container">
    <section class="vh-100">
      <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-md-9 col-lg-6 col-xl-5">
            <img src="https://images.unsplash.com/photo-1588702547919-26089e690ecc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80"
              class="img-fluid" alt="Image">
          </div>
          <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
            <form @submit.prevent="handleSubmit">
              <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                <p class="lead fw-normal mb-0 me-3">Register to our Flashcards App!</p>
              </div>

              <div class="divider d-flex align-items-center my-4"></div>

              <div class="form-outline mb-4" :class="{ 'has-danger': errors.username }">
                <label class="form-label" for="username">Your Name</label>
                <input type="text" id="username" class="form-control form-control-lg"
                  placeholder="Enter your Name..." required v-model="username" />
                <div class="form-control-feedback" v-if="errors.username">{{ errors.username }}</div>
              </div>

              <div class="form-outline mb-4" :class="{ 'has-danger': errors.email }">
                <label class="form-label" for="email">Email address</label>
                <input type="email" id="email" class="form-control form-control-lg"
                  placeholder="Enter a valid email address..." required v-model="email" />
                <div class="form-control-feedback" v-if="errors.email">{{ errors.email }}</div>
              </div>

              <div class="form-outline mb-3" :class="{ 'has-danger': errors.password }">
                <label class="form-label" for="password">Password</label>
                <input type="password" id="password" class="form-control form-control-lg"
                  placeholder="Enter password..." required v-model="password" />
                <div class="form-control-feedback" v-if="errors.password">{{ errors.password }}</div>
              </div>

              <div class="text-center text-lg-start mt-4 pt-2">
                <button type="submit" class="btn btn-primary btn-lg"
                  style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>
                <p class="small fw-bold mt-2 pt-1 mb-0">Have an account already?
                  <router-link class="link-danger" :to="{name: 'Login'}">Take me to the Login page!</router-link>
                </p>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      email: '',
      password: '',
      errors: {
        username: '',
        email: '',
        password: '',
      },
    };
  },
  methods: {
    validateForm() {
      let isValid = true;

      // Reset errors
      this.errors.username = '';
      this.errors.email = '';
      this.errors.password = '';

      // Validate username
      if (!this.username) {
        this.errors.username = 'Username is required.';
        isValid = false;
      }else if (this.username.length < 3) {
        this.errors.password = 'Username must be at least 3 characters long.';
        isValid = false;
      }

      // Validate email
      if (!this.email) {
        this.errors.email = 'Email address is required.';
        isValid = false;
      } else if (!/\S+@\S+\.\S+/.test(this.email)) {
        this.errors.email = 'Please enter a valid email address.';
        isValid = false;
      }

      // Validate password
      if (!this.password) {
        this.errors.password = 'Password is required.';
        isValid = false;
      } else if (this.password.length < 6) {
        this.errors.password = 'Password must be at least 6 characters long.';
        isValid = false;
      }

      return isValid;
    },

    handleSubmit() {
      if (this.validateForm()) {
        // Perform registration logic here

        // Redirect to the Login page upon successful registration
        this.$router.push({ name: 'Login' });
      }
    },
  },
};
</script>

<!-- Don't use any styles, look for bootstrap classes -->
<style>
.divider:after,
.divider:before {
  content: "";
  flex: 1;
  height: 1px;
  background: #eee;
}

.h-custom {
  height: calc(100% - 73px);
}

.has-danger input,
.has-danger textarea {
  border-color: #dc3545;
}

.has-danger .form-control-feedback {
  color: #dc3545;
  display: block;
  font-size: 12px;
  margin-top: 4px;
}
</style>
