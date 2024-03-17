package com.harsh.coderhack.services;

import java.util.List;

import com.harsh.coderhack.dto.UserResponseDto;

/**
 * This interface represents the service layer for managing users in the CoderHack application.
 */
public interface UserService {

    /**
     * Retrieves a list of all users.
     *
     * @return A list of UserResponseDto objects representing all users.
     */
    List<UserResponseDto> getAllUsers();

    /**
     * Retrieves information about a specific user.
     *
     * @param userId The unique identifier of the user.
     * @return A UserResponseDto object containing information about the user.
     */
    UserResponseDto getUser(int userId);
    

    /**
     * Creates a new user with the given userId and username.
     *
     * @param userId   The unique identifier for the new user.
     * @param username The username of the new user.
     * @return A UserResponseDto object representing the created user.
     */
    UserResponseDto createUser(int userId, String username);

    /**
     * Updates the score of a user with the given userId.
     *
     * @param userId The unique identifier of the user whose score is to be updated.
     * @param score  The new score of the user.
     * @return A UserResponseDto object representing the user with the updated score.
     */
    UserResponseDto updateScoreOfUser(int userId, double score);

    /**
     * Deregisters a user from the contest.
     *
     * @param userId The unique identifier of the user to be deregistered.
     */
    void deregisterUserFromTheContest(int userId);

}
