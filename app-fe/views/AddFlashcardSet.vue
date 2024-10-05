<template>
  <div class="background-container">
    <div class="add-flashcard-set-container">
      <div class="add-flashcard-set-card">
        <h2 class="text-center mb-4">Create a new flashcard set</h2>
        <div class="row mb-3">
          <div class="col">
            <label for="title" class="form-label">Enter flashcard set's title</label>
            <input type="text" class="form-control" id="title" placeholder='Enter a Title, like "History - The WW2 War."'>
            <span class="form-helper-text input-line">title</span>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col">
            <label for="description" class="form-label">Enter flashcard set's description</label>
            <input type="text" class="form-control" id="description" placeholder="Add a Description...">
            <span class="form-helper-text input-line">description</span>
          </div>
        </div>
        <h4 class="text-center my-4">Enter your flashcards below:</h4>
        <div v-for="(flashcard, index) in flashcards" :key="index" class="flashcard-grid">
        <div class="flashcard-grid">
          <div class="flashcard">
            <div class="form-group mb-3" style="width: calc(50% - 7.5px);">
                <label :for="'term'+index" class="form-label">Enter Term</label>
                <input type="text" class="form-control input-line" :id="'term'+index" required>
              <span class="form-helper-text input-line">Term</span>

            </div>
            <div class="form-group definition" style="width: calc(50% - 7.5px);">
                <label :for="'definition'+index" class="form-label">Enter Definition</label>
                <button type="button" class="btn btn-outline-danger btn-sm delete-set" @click="removeFlashcard(index)">
                  <i class="bi bi-trash"></i> Delete
                </button>
                <input type="text" class="form-control input-line" :id="'definition'+index" required>
              <span class="form-helper-text input-line">Definition</span>
            </div>
          </div>
        </div>
    </div>
        <div class="flashcard display-flex">
        <button class="btn btn-md btn-outline-primary add-card-btn"  type="button" @click="addFlashcard" style="float: right;">
            <i class="bi bi-plus-lg"></i> Add Card</button>
        </div>       
    
        <div class="d-grid gap-2 mt-4 mx-auto">
            <button class="btn btn-primary btn-create" type="button" :disabled="disableCreateButton">Create</button>
            </div>
        </div>
    </div>
  </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        flashcards: []
      };
    },
    methods: {
      addFlashcard() {
        this.flashcards.push({});
      },
      removeFlashcard(index) {
        this.flashcards.splice(index, 1);
      }
    },
    computed: {
  disableCreateButton() {
    return this.flashcards.length === 0
  }
},
  };
  </script>
  <style>
  
  .flashcard {
  display: flex;
  justify-content: center;
  align-items: center;
}

.flashcard:hover {
  border-color: orange;
}

.delete-set{
    float: right;
  }

.input-line {
  display: block;
  width: 100%;
  border-top: 2px solid orange;
  margin-top: 10px;
  transition: background-color 0.3s ease;
  
}

.btn-create {
    width: 40%;
  max-width: 500px;  
  margin: 0 auto;
}
.form-helper-text {
    color: #888888;
    font-size: 12px;
    text-transform: uppercase;
  }

  
.add-flashcard-set-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-color: #F7F7F7;
  }
  
  .definition{
    position: relative;
    bottom: 8px
  }
  .add-flashcard-set-card {
    background-color: #FFFFFF;
  padding: 30px;
  border-radius: 10px;
  width: 80%;
  max-width: 800px;
  margin: 0 auto;
  }
  
  .flashcard {
    background-color: #FFFFFF;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.2);
    margin-bottom: 20px;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  
  .form-group {
    margin-bottom: 0;
  }
  .display-flex {
  display: flex;
  justify-content: center;
}
.background-container{
  height: 800px;
}
  </style>
  