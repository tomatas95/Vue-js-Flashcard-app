<template>
  <div class="about-container">
    <section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://images.unsplash.com/photo-1554252117-53f26a5ebdbd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1740&q=80"
          class="img-fluid" alt="Image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form @submit.prevent="handleSubmit">
          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
            <p class="lead fw-normal mb-0 me-3">Login to use Flashcards App!</p>
          </div>

          <div class="divider d-flex align-items-center my-4">
          </div>

          <div class="form-outline mb-4" :class="{ 'has-danger': errors.email }">
            <input type="email" id="email" class="form-control form-control-lg"
            placeholder="Enter a valid email address" required v-model="email" />
          <label class="form-label" for="email">Email address</label>
          <div class="form-control-feedback" v-if="errors.email">{{ errors.email }}</div>
        </div>

        <div class="form-outline mb-3" :class="{ 'has-danger': errors.password }">
          <input type="password" id="password" class="form-control form-control-lg"
            placeholder="Enter password" required v-model="password" />
          <label class="form-label" for="password">Password</label>
          <div class="form-control-feedback" v-if="errors.password">{{ errors.password }}</div>
        </div>

          <div class="d-flex justify-content-between align-items-center">
            <div class="form-check mb-0">
              <input class="form-check-input me-2" type="checkbox" value="" id="remember" />
              <label class="form-check-label" for="remember">
                Remember me
              </label>
            </div>
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? 
                <router-link class="link-danger" :to="{name: 'Register'}">Take me to the Register page!</router-link>
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
      email: '',
      password: '',
      errors: {
        email: '',
        password: '',
      },
    };
  },
  methods: {
    validateForm() {
      let isValid = true;

      // Reset errors
      this.errors.email = '';
      this.errors.password = '';

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
        this.$router.push({ name: 'Flashcards' });

      }
    },
  },

}
</script>


<!-- Don't use any styles, look  for bootstrap classes -->
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