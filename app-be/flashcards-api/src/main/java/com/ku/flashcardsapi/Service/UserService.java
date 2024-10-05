package com.ku.flashcardsapi.Service;

import com.ku.flashcardsapi.DTO.UserDto;
import com.ku.flashcardsapi.Exception.ResourceNotFoundException;
import com.ku.flashcardsapi.Mapper.UserMapper;
import com.ku.flashcardsapi.Model.User;
import com.ku.flashcardsapi.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserDtoById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);
        User createdUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDto(createdUser);
    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        User userToUpdate = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        UserMapper.INSTANCE.updateUserFromDto(userDto, userToUpdate);
        userRepository.save(userToUpdate);
        return UserMapper.INSTANCE.userToUserDto(userToUpdate);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
