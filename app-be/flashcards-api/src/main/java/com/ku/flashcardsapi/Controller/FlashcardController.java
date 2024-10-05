package com.ku.flashcardsapi.Controller;

import com.ku.flashcardsapi.DTO.FlashcardDto;
import com.ku.flashcardsapi.DTO.FlashcardSetDto;
import com.ku.flashcardsapi.Service.FlashcardService;
import com.ku.flashcardsapi.Service.FlashcardSetService;
import com.ku.flashcardsapi.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/flashcard")
public class FlashcardController {

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private FlashcardService flashcardService;

    @GetMapping("/GetByFlashcardSetId/{flashcardSetId}")
    public List<FlashcardDto> getAllFlashcardsByFlashcardSetId(HttpServletRequest request, @PathVariable Long flashcardSetId) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        return flashcardService.getFlashcardsByFlashcardSetId(flashcardSetId, userId);
    }

    @GetMapping("/{flashcardId}")
    public ResponseEntity<FlashcardDto> getFlashcardById(HttpServletRequest request, @PathVariable Long flashcardId) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        FlashcardDto flashcard = flashcardService.getFlashcardById(flashcardId, userId);
        return ResponseEntity.ok(flashcard);
    }

    @PostMapping("")
    public ResponseEntity<FlashcardDto> createFlashcard(HttpServletRequest request, @RequestBody FlashcardDto flashcard) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        FlashcardDto createdFlashcard = flashcardService.createFlashcard(flashcard, userId);
        return ResponseEntity.ok(createdFlashcard);
    }

    @PutMapping("/{flashcardId}")
    public ResponseEntity<FlashcardDto> updateFlashcard(HttpServletRequest request, @PathVariable Long flashcardId, @RequestBody FlashcardDto flashcard) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        FlashcardDto updatedFlashcard = flashcardService.updateFlashcard(flashcardId, flashcard, userId);
        return ResponseEntity.ok(updatedFlashcard);
    }

    @DeleteMapping("/{flashcardId}")
    public ResponseEntity<Void> deleteFlashcard(HttpServletRequest request, @PathVariable Long flashcardId) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        flashcardService.deleteFlashcard(flashcardId, userId);
        return ResponseEntity.noContent().build();
    }
}
