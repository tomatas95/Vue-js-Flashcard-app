package com.ku.flashcardsapi.Mapper;

import com.ku.flashcardsapi.DTO.UserDto;
import com.ku.flashcardsapi.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    void updateUserFromDto(UserDto userDto, @MappingTarget User user);
}
