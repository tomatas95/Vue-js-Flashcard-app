package com.ku.flashcardsapi.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FlashcardSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Many-to-one relationship with User
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 50)
    @NotNull
    private String name;

    // One-to-many relationship with FlashcardSet
    @OneToMany(mappedBy = "flashcardSet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flashcard> flascards = new ArrayList<>();

    public FlashcardSet() {
    }

    public FlashcardSet(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public List<Flashcard> getFlascards() {
        return flascards;
    }

    public void setFlascards(List<Flashcard> flascards) {
        this.flascards = flascards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
