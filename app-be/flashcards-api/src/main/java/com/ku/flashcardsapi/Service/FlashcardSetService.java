package com.ku.flashcardsapi.Service;

import com.ku.flashcardsapi.DTO.FlashcardSetDto;
import com.ku.flashcardsapi.Exception.ResourceNotFoundException;
import com.ku.flashcardsapi.Mapper.FlashcardSetMapper;
import com.ku.flashcardsapi.Model.FlashcardSet;
import com.ku.flashcardsapi.Model.User;
import com.ku.flashcardsapi.Repo.FlashcardSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlashcardSetService {

    @Autowired
    private FlashcardSetRepository flashcardSetRepository;
    @Autowired
    private UserService userService;

    public List<FlashcardSetDto> getAllFlashcardSetsByUserId(Long userId) {
        return flashcardSetRepository.findByUserId(userId).stream()
                .map(FlashcardSetMapper.INSTANCE::flashcardSetToFlashcardSetDto)
                .collect(Collectors.toList());
    }

    public FlashcardSetDto getFlashcardSetById(Long id, Long userId) {
        return getAllFlashcardSetsByUserId(userId).stream()
                .filter(set -> set.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("FlashcardSet not found with id " + id));
    }

    public FlashcardSet getFlashcardSetById(Long id) {
        return flashcardSetRepository.findById(id).stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("FlashcardSet not found with id " + id));
    }

    public FlashcardSetDto createFlashcardSet(FlashcardSetDto flashcardSetDto, Long userId) {
        User user = userService.getUserById(userId);

        FlashcardSet flashcardSet = FlashcardSetMapper.INSTANCE.flashcardSetDtoToFlashcardSet(flashcardSetDto);
        flashcardSet.setUser(user);

        FlashcardSet createdFlashcardSet = flashcardSetRepository.save(flashcardSet);
        return FlashcardSetMapper.INSTANCE.flashcardSetToFlashcardSetDto(createdFlashcardSet);
    }

    public FlashcardSetDto updateFlashcardSet(Long id, FlashcardSetDto flashcardSetDto, Long userId) {
        FlashcardSet flashcardSetToUpdate = flashcardSetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FlashcardSet not found with id " + id));
        FlashcardSetMapper.INSTANCE.updateFlashcardSetFromDto(flashcardSetDto, flashcardSetToUpdate);
        flashcardSetRepository.save(flashcardSetToUpdate);
        return FlashcardSetMapper.INSTANCE.flashcardSetToFlashcardSetDto(flashcardSetToUpdate);
    }


    public void deleteFlashcardSet(Long id, Long userId) {
        FlashcardSetDto flashcardSetDto = getFlashcardSetById(id, userId);
        if (flashcardSetDto == null) {
            throw new ResourceNotFoundException("FlashcardSet not found with id " + id);
        }
        flashcardSetRepository.deleteById(id);
    }
}
