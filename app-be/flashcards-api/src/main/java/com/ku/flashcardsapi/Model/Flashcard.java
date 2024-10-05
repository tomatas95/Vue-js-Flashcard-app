package com.ku.flashcardsapi.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "flashcardSet_id")
    private FlashcardSet flashcardSet;

    @Column(unique = true, length = 1000)
    @NotNull
    private String name;

    @Column(length = 1000)
    @NotNull
    private String definition;

    @Column
    private boolean isKnown;

    public Flashcard(FlashcardSet flashcardSet, String name, String definition, boolean isKnown) {
        this.flashcardSet = flashcardSet;
        this.name = name;
        this.definition = definition;
        this.isKnown = isKnown;
    }

    public Flashcard() {
    }

    public long getId() {
        return id;
    }

    public FlashcardSet getFlashcardSet() {
        return flashcardSet;
    }

    public void setFlashcardSet(FlashcardSet flashcardSet) {
        this.flashcardSet = flashcardSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
