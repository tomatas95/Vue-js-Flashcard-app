package com.ku.flashcardsapi.Controller;

import com.ku.flashcardsapi.DTO.FlashcardSetDto;
import com.ku.flashcardsapi.Model.FlashcardSet;
import com.ku.flashcardsapi.Service.FlashcardSetService;
import com.ku.flashcardsapi.Service.UserService;
import com.ku.flashcardsapi.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/flashcardset")
public class FlashcardSetController {

    @Autowired
    private JwtTokenUtil tokenUtil;
    @Autowired
    private FlashcardSetService flashcardSetService;

    @GetMapping("")
    public List<FlashcardSetDto> getAllFlashcardSets(HttpServletRequest request) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        return flashcardSetService.getAllFlashcardSetsByUserId(userId);
    }

    @GetMapping("/{flashcardSetId}")
    public ResponseEntity<FlashcardSetDto> getFlashcardSetById(HttpServletRequest request, @PathVariable Long flashcardSetId) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        FlashcardSetDto flashcardSet = flashcardSetService.getFlashcardSetById(flashcardSetId, userId);
        return ResponseEntity.ok(flashcardSet);
    }

    @PostMapping("")
    public ResponseEntity<FlashcardSetDto> createFlashcardSet(HttpServletRequest request, @RequestBody FlashcardSetDto flashcardSet) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        FlashcardSetDto createdFlashcardSet = flashcardSetService.createFlashcardSet(flashcardSet, userId);
        return ResponseEntity.ok(createdFlashcardSet);
    }


    @PutMapping("/{flashcardSetId}")
    public ResponseEntity<FlashcardSetDto> updateFlashcardSet(HttpServletRequest request, @PathVariable Long flashcardSetId, @RequestBody FlashcardSetDto flashcardSet) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        FlashcardSetDto updatedFlashcardSet = flashcardSetService.updateFlashcardSet(flashcardSetId, flashcardSet, userId);
        return ResponseEntity.ok(updatedFlashcardSet);
    }

    @DeleteMapping("/{flashcardSetId}")
    public ResponseEntity<Void> deleteFlashcardSet(HttpServletRequest request, @PathVariable Long flashcardSetId) {
        Long userId = tokenUtil.getUserIdFromToken(request);
        flashcardSetService.deleteFlashcardSet(flashcardSetId, userId);
        return ResponseEntity.noContent().build();
    }

}