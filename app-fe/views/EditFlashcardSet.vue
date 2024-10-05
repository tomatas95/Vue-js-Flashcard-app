<template>
    <div class="background-container">
    <div class="add-flashcard-set-container">
      <div class="add-flashcard-set-card">
        <h2 class="text-center mb-4">Edit your Flashcard!</h2>
        <div class="row mb-3">
          <div class="col">
            <label for="title" class="form-label">Flashcard set's title</label>
            <input type="text" class="form-control" id="title"/>
            <span class="form-helper-text input-line">title</span>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col">
            <label for="description" class="form-label">Flashcard set's description</label>
            <input type="text" class="form-control" id="description"/>
            <span class="form-helper-text input-line">description</span>
          </div>
        </div>
        <h4 class="text-center my-4">Your flashcards below:</h4>
        <div v-for="(flashcard, index) in flashcards" :key="index" class="flashcard-grid">
          <div class="flashcard-grid">
            <div class="flashcard">
              <div class="form-group mb-3" style="width: calc(50% - 7.5px);">
                <label :for="'term'+index" class="form-label">Enter Term</label>
                <input type="text" class="form-control input-line" :id="'term'+index" required />
                <span class="form-helper-text input-line">Term</span>
              </div>
              <div class="form-group definition" style="width: calc(50% - 7.5px);">
                <label :for="'definition'+index" class="form-label">Enter Definition</label>
                <button type="button" class="btn btn-outline-danger btn-sm delete-set" @click="removeFlashcard(index)">
                  <i class="bi bi-trash"></i> Delete
                </button>
                <input type="text" class="form-control input-line" :id="'definition'+index" required />
                <span class="form-helper-text input-line">Definition</span>
              </div>
            </div>
          </div>
        </div>
        <div class="flashcard display-flex">
          <button class="btn btn-md btn-outline-primary add-card-btn" type="button" @click="addFlashcard" style="float: right;">
            <i class="bi bi-plus-lg"></i> Add Card
          </button>
        </div>       
        <div class="d-grid gap-2 mt-4 mx-auto">
          <button class="btn btn-primary btn-create" type="button" :disabled="disableCreateButton">Save Information</button>
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
  