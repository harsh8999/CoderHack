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


@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> postMethodName(@RequestBody UserRequestDto userRequestDto) {
        // UserResponseDto userResponseDto = userService.createUser(userRequestDto.getId(), userRequestDto.getUsername());
        UserResponseDto userResponseDto = userService.createUser(userRequestDto.getUsername());
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
    
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateScore(@PathVariable String userId, @RequestBody UpdateScoreRequest updateScoreRequest) {
        return new ResponseEntity(userService.updateScoreOfUser(userId, updateScoreRequest.getScore()), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userService.deregisterUserFromTheContest(userId);
        return new ResponseEntity("User deregistered..", HttpStatus.OK);
    }

}
