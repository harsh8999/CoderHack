package com.harsh.coderhack.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harsh.coderhack.dto.UserResponseDto;
import com.harsh.coderhack.entity.User;
import com.harsh.coderhack.exception.ResourceNotFoundException;
import com.harsh.coderhack.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        users.forEach(user -> userResponseDtos.add(new UserResponseDto(user.getId(), user.getUsername(), user.getScore(), user.getBadges())));
        // sort the users based on score
        userResponseDtos.sort((a, b) -> b.getScore().compareTo(a.getScore()));
        return userResponseDtos;
    }

    @Override
    public UserResponseDto getUser(String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId));
        UserResponseDto userResponseDto = new UserResponseDto(user.getId(), user.getUsername(), user.getScore(), user.getBadges());
        
        return userResponseDto;
    }

    @Override
    public UserResponseDto createUser(String username) {
        User newUser = new User(username);
        // User savedUser = userRepository.save(newUser);
        User savedUser = userRepository.insert(newUser);
        UserResponseDto userResponseDto = new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getScore(), savedUser.getBadges());
        
        return userResponseDto;
    }

    @Override
    public UserResponseDto updateScoreOfUser(String userId, double score) throws ResourceNotFoundException {
        if(score < 0) {
            throw new RuntimeException("Score Cannot be Less Than 0!!!");
        }
        if(score > 100) {
            throw new RuntimeException("Score Cannot be More Than 100!!!");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId));
        // update the score
        user.setScore(score);
        // update the batch accordingly
        user.updateBadges();

        // update the user in DB
        User updatedUser = userRepository.save(user);

        return new UserResponseDto(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getScore(), updatedUser.getBadges());

    }

    @Override
    public void deregisterUserFromTheContest(String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User ID", userId));
        userRepository.delete(user);
    }
    
}
