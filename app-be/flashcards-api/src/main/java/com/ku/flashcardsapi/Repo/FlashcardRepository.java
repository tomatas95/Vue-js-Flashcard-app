package com.ku.flashcardsapi.Repo;

import com.ku.flashcardsapi.Model.Flashcard;
import com.ku.flashcardsapi.Model.FlashcardSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findByFlashcardSetId(Long flashcardSetId);
}
