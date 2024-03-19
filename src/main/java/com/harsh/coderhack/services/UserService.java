package com.harsh.coderhack.services;

import java.util.List;

import com.harsh.coderhack.dto.UserResponseDto;
import com.harsh.coderhack.exception.ResourceNotFoundException;

/**
 * This interface represents the service layer for managing users in the CoderHack application.
 */
public interface UserService {

    /**
     * Retrieves a list of all users.
     * Sorted on based of score.
     *
     * @return A list of {@link UserResponseDto} objects representing all users.
     */
    List<UserResponseDto> getAllUsers();

    /**
     * Retrieves information about a specific user.
     *
     * @param userId The unique identifier of the user.
     * @return A {@link UserResponseDto} object containing information about the user.
     * @throws ResourceNotFoundException if the user with the given ID is not found.
     */
    UserResponseDto getUser(String userId) throws ResourceNotFoundException;
    

    /**
     * Creates a new user with the given userId and username.
     *
     * @param userId   The unique identifier for the new user.
     * @param username The username of the new user.
     * @return A {@link UserResponseDto} object representing the created user.
     */
    // UserResponseDto createUser(int userId, String username);
    UserResponseDto createUser(String username);

    /**
     * Updates the score of a user with the given userId.
     *
     * @param userId The unique identifier of the user whose score is to be updated.
     * @param score  The new score of the user.
     * @return A {@link UserResponseDto} object representing the user with the updated score.
     * @throws ResourceNotFoundException if the user with the given ID is not found.
     */
    UserResponseDto updateScoreOfUser(String userId, double score) throws ResourceNotFoundException;

    /**
     * Deregisters a user from the contest.
     *
     * @param userId The unique identifier of the user to be deregistered.
     * @throws ResourceNotFoundException if the user with the given ID is not found.
     */
    void deregisterUserFromTheContest(String userId) throws ResourceNotFoundException;
}
