package com.ku.flashcardsapi.Service;

import com.ku.flashcardsapi.DTO.FlashcardDto;
import com.ku.flashcardsapi.DTO.FlashcardSetDto;
import com.ku.flashcardsapi.Exception.ResourceNotFoundException;
import com.ku.flashcardsapi.Mapper.FlashcardSetMapper;
import com.ku.flashcardsapi.Model.Flashcard;
import com.ku.flashcardsapi.Model.FlashcardSet;
import com.ku.flashcardsapi.Model.User;
import com.ku.flashcardsapi.Repo.FlashcardRepository;
import com.ku.flashcardsapi.Repo.FlashcardSetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;

    @Autowired
    private FlashcardSetService flashcardSetService;

    private ModelMapper modelMapper = new ModelMapper();

    public FlashcardDto createFlashcard(FlashcardDto flashcardDto, Long userId) {
        //Check if user has access to the set
        flashcardSetService.getFlashcardSetById(flashcardDto.getFlashcardSetId(), userId);

        Flashcard flashcard = modelMapper.map(flashcardDto, Flashcard.class);
        Flashcard createdFlashcard = flashcardRepository.save(flashcard);
        return modelMapper.map(createdFlashcard, FlashcardDto.class);
    }

    public FlashcardDto getFlashcardById(Long id, Long userId) {
        Flashcard flashcard = flashcardRepository.findById(id)
                .stream()
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException());

        //Check if user has access to the set
        flashcardSetService.getFlashcardSetById(flashcard.getFlashcardSet().getId(), userId);
        return modelMapper.map(flashcard, FlashcardDto.class);
    }

    public List<FlashcardDto> getFlashcardsByFlashcardSetId(Long flashcardSetId, Long userId) {
        flashcardSetService.getFlashcardSetById(flashcardSetId, userId);
        List<Flashcard> flashcards = flashcardRepository.findByFlashcardSetId(flashcardSetId);
        return flashcards.stream().map(flashcard -> modelMapper.map(flashcard, FlashcardDto.class)).collect(Collectors.toList());
    }

    public void deleteFlashcard(Long id, Long userId) {
        Flashcard flashcard = flashcardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        flashcardSetService.getFlashcardSetById(flashcard.getFlashcardSet().getId(), userId);
        flashcardRepository.delete(flashcard);
    }

    public FlashcardDto updateFlashcard(Long id, FlashcardDto flashcardDto, Long userId) {
        Flashcard flashcard = flashcardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        flashcardSetService.getFlashcardSetById(flashcard.getFlashcardSet().getId(), userId);
        modelMapper.map(flashcardDto, flashcard);
        Flashcard updatedFlashcard = flashcardRepository.save(flashcard);
        return modelMapper.map(updatedFlashcard, FlashcardDto.class);
    }
}

