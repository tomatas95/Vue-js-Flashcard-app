<template>
  <div class="background-container bg-dark">
    <div class="maincontainer">
      <transition name="slide">
        <div class="thecard" :class="{ 'is-flipped': flipped }">
          <div class="front" @click="flipCard">
            <p>{{ cards[currentCardIndex].front }}</p>
          </div>
          <div class="back" @click="flipCard">
            <p>{{ cards[currentCardIndex].back }}</p>
          </div>
        </div>
      </transition>
      <div class="pagination">
        <button class="flashcard-btn circle-danger mt-2" style="vertical-align: middle;" @click="markAsIncorrect"><i class="text-danger bi bi-x"></i></button>
        <span class="flashcardset-amount">{{ currentCardIndex + 1 }}/{{ cards.length }}</span>
        <button class=" flashcard-btn circle-success mt-2" style="vertical-align: middle;" @click="markAsCorrect"><i class="text-success bi bi-check"></i> </button>
        <template v-if="completed">
          <router-link :to="{ name: 'FinishFlashcard', query: { correctAnswers, incorrectAnswers }}" :cards="cards">
            <button class="mt-2">Finish</button>
          </router-link>
        </template>
      </div>
      <span class="input-line"></span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      completed: false,
      flipped: false,
      cards: [
        { front: "World War 2 Date", back: "1939 - 1945" },
        { front: "Second American President", back: "John Adams" },
      ],
      currentCardIndex: 0,
      correctAnswers: 0,
      incorrectAnswers: 0,
      cardObjects: [],
    };
  },
  methods: {
    markAsCorrect() {
      const card = {
        Definition: this.cards[this.currentCardIndex].front,
        Term: this.cards[this.currentCardIndex].back,
        knows_answer: true,
      };
      this.cardObjects.push(card);
      this.correctAnswers++;
      this.goToNextCard();
    },
    markAsIncorrect() {
      const card = {
        Definition: this.cards[this.currentCardIndex].front,
        Term: this.cards[this.currentCardIndex].back,
        knows_answer: false,
      };
      this.cardObjects.push(card);
      this.incorrectAnswers++;
      this.goToNextCard();
    },
    goToNextCard() {
      if (this.currentCardIndex < this.cards.length - 1) {
        this.currentCardIndex++;
        this.flipped = false;
      } else {
        this.completed = true;
        this.$router.push({
        name : 'FinishFlashcard',
query: {
correctAnswers: this.correctAnswers,
incorrectAnswers: this.incorrectAnswers,
},
params: {
cards: this.cardObjects,
},
});
}
},
flipCard() {
this.flipped = !this.flipped;
},
},
};
</script>
  
  <style>
.circle-success:before{
    border: 2px solid green;
}

.circle-danger:before{
    border: 2px solid red;
}
.flashcard-btn {
  position: relative;
  border-radius: 50%;
  padding: 5px;
  border: 2px solid #000;
}

.flashcard-btn i {
  font-size: 1.5rem;
}   
  .flashcard-btn::before {
  content: '';
  position: absolute;
  top: 14px;
  left: 17px;
  width: 30px;
  height: 30px;
  border-radius: 50%;
}

  .flashcardset-amount{
    padding-left: 10px;
    padding-right: 10px;
    padding-top: 20px;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    color: white;
  }
  .pagination{
    display: flex;
    justify-content: center;
    text-align: center;
  }
  
  .background-container {
    width: 100%;
    height: 800px;
  }
  .maincontainer {
    position: absolute;
    width: 500px;
    height: 400px;
    background: none;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    transition: background-color 0.3s ease;

  }
  .thecard {
    position: relative;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border-radius: 10px;
    transform-style: preserve-3d;
    transition: all 0.8s ease, transform 0.3s ease;
  }
  
  .thecard.is-flipped {
    transform: rotateY(180deg);
  }
  
  .front {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border-radius: 10px;
    backface-visibility: hidden;
    overflow: hidden;
    color: #000;
    background: #fafafa;
    display: flex;
    align-items: center;
    justify-content: center;
    transition: background-color 0.3s ease;

  }
  
  .back {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border-radius: 10px;
    backface-visibility: hidden;
    overflow: hidden;
    background: #A0A0A0;
    color: #333;
    text-align: center;
    transform: rotateY(180deg);
    display: flex;
    align-items: center;
    justify-content: center;
    transition: background-color 0.3s ease;

  }
  
  .front p,
  .back p {
    font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
    font-weight: bold;
    font-size: 26px;
    text-align: center;
  }

  .pagination button {
  font-size: 20px;
  padding: 10px 20px;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.pagination button:hover,
.pagination button:active {
  background-color: #333;
  color: #fff;
  transform: translateY(-2px);
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
  transition: all 0.3s ease;
}

.correct-incorrect-counters {
  display: flex;
  justify-content: center;
  margin-top: 10px;
}

.correct-incorrect-counters {
  display: flex;
  align-items: center;
}

.counter-divider {
  height: 10px;
  width: 1px;
  background-color: #999;
  margin: 0 10px;
}
</style>
  