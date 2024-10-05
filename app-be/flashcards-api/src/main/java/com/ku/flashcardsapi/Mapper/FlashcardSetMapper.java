package com.ku.flashcardsapi.Mapper;

import com.ku.flashcardsapi.DTO.FlashcardSetDto;
import com.ku.flashcardsapi.DTO.UserDto;
import com.ku.flashcardsapi.Model.FlashcardSet;
import com.ku.flashcardsapi.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlashcardSetMapper {

    FlashcardSetMapper INSTANCE = Mappers.getMapper(FlashcardSetMapper.class);

    FlashcardSetDto flashcardSetToFlashcardSetDto(FlashcardSet flashcardSet);

    FlashcardSet flashcardSetDtoToFlashcardSet(FlashcardSetDto flashcardSetDto);

    void updateFlashcardSetFromDto(FlashcardSetDto flashcardSetDto, @MappingTarget FlashcardSet flashcardSet);
}
