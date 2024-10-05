<template>
    <div class="background-container bg-con bg-dark">
      <div class="finish-flashcard-container row d-flex justify-content-center align-items-center">
        <div class="col-md-8 col-lg-6 finish-card-body text-center">
          <div class="card finish-card">
            <div class="card-body">
              <h1 class="card-title text-success">Congratulations!</h1>
              <p class="card-text">
                You have completed the flashcard set. Here's how you did:
              </p>
              <div class="d-flex justify-content-center align-items-center">
                <div class="correct-indicator mr-2"></div>
                <span class="mr-4 text-dark mx-4">Correct: {{ correctAnswers }}
                    <div class="input-line"></div></span>
                <div class="incorrect-indicator mr-2"></div>
                <span class="text-dark mx-4">Incorrect: {{ incorrectAnswers }}
                    <div class="input-line"></div></span>
              </div>
              <div class="mt-4">
                <router-link to="flashcards" class="btn button-finish btn-outline-primary mx-4 my-4">
                <i class="bi bi-house-door-fill mr-2"></i> Go to Flashcard page
                <div class="input-line"></div>
                </router-link>
                <router-link to="LearnFlashcard" class="btn button-finish btn-outline-success">
                <i class="bi bi-book mr-2"></i> I want to retry
                <div class="input-line"></div>
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "CongratPage",
    props: {
      correctAnswers: {
        type: Number,
        required: true,
      },
      incorrectAnswers: {
        type: Number,
        required: true,
      },
    },
  };
  </script>
  
  <style>
  .finish-card {
    animation: zoom-in 0.5s;
    width: 80%;
    height: 50%;
    
  }
  
  .correct-indicator {
    width: 20px;
    height: 20px;
    border-radius: 50%;
    background-color: #28a745;
  }
  
  .incorrect-indicator {
    width: 20px;
    height: 20px;
    border-radius: 50%;
    background-color: #dc3545;
  }
  
  .correct-indicator:hover, .incorrect-indicator:hover {
    transform: scale(1.2);
  }
  
  .button-finish {
    border-radius: 30px;
  }
  
  .button-finish:hover {
    transform: translateY(-3px);
    transition: transform 0.2s ease;

  }
  
  @keyframes zoom-in {
    from {
      transform: scale(0.5);
      opacity: 0;
    }
    to {
      transform: scale(1);
      opacity: 1;
    }
  }
  .bg-con{
    overflow: hidden;
  }
  .finish-card-body{
    display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
  padding: 40px 0;
  }
  </style>
  