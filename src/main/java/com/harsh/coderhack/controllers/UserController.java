package com.harsh.coderhack.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.coderhack.dto.UpdateScoreRequest;
import com.harsh.coderhack.dto.UserRequestDto;
import com.harsh.coderhack.dto.UserResponseDto;
import com.harsh.coderhack.services.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller class responsible for handling user-related HTTP requests.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;

    /**
     * Constructor for UserController.
     *
     * @param userService the UserService instance to be injected
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles HTTP POST request to create a new user.
     *
     * @param userRequestDto the request body containing user information
     * @return ResponseEntity containing the created user's information and HTTP status
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> postMethodName(@RequestBody UserRequestDto userRequestDto) {
        // UserResponseDto userResponseDto = userService.createUser(userRequestDto.getId(), userRequestDto.getUsername());
        UserResponseDto userResponseDto = userService.createUser(userRequestDto.getUsername());
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    /**
     * Handles HTTP GET request to retrieve all users.
     *
     * @return ResponseEntity containing the list of users and HTTP status
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    /**
     * Handles HTTP GET request to retrieve a user by ID.
     *
     * @param userId the ID of the user to retrieve
     * @return ResponseEntity containing the user's information and HTTP status
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
    
    /**
     * Handles HTTP PUT request to update a user's score.
     *
     * @param userId the ID of the user to update
     * @param updateScoreRequest the request body containing the new score
     * @return ResponseEntity containing the updated user's information and HTTP status
     */
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateScore(@PathVariable String userId, @RequestBody UpdateScoreRequest updateScoreRequest) {
        return new ResponseEntity(userService.updateScoreOfUser(userId, updateScoreRequest.getScore()), HttpStatus.OK);
    }

    /**
     * Handles HTTP DELETE request to deregister a user from the contest.
     *
     * @param userId the ID of the user to deregister
     * @return ResponseEntity containing a message confirming deregistration and HTTP status
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userService.deregisterUserFromTheContest(userId);
        return new ResponseEntity("User deregistered..", HttpStatus.OK);
    }

}
