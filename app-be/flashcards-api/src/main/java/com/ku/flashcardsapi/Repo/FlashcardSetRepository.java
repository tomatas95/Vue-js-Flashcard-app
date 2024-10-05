package com.ku.flashcardsapi.Repo;

import com.ku.flashcardsapi.Model.FlashcardSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardSetRepository extends JpaRepository<FlashcardSet, Long> {
    List<FlashcardSet> findByUserId(Long userId);
}
