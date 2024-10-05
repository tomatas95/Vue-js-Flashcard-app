package com.ku.flashcardsapi.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ku.flashcardsapi.Model.FlashcardSet;
import com.sun.istack.NotNull;

import javax.persistence.*;

public class FlashcardDto {

    private String name;
    private Long id;
    @JsonProperty("flashcardSetId")
    private Long flashcardSetId;
    private String definition;
    private boolean isKnown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlashcardSetId() {
        return flashcardSetId;
    }

    public void setFlashcardSetId(Long flashcardSetId) {
        this.flashcardSetId = flashcardSetId;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public boolean isKnown() {
        return isKnown;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }
}
