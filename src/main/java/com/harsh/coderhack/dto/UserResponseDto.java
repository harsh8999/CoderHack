package com.harsh.coderhack.dto;

import java.util.Set;

import com.harsh.coderhack.entity.Badge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * DTO (Data Transfer Object) representing the response for a user.
 * Contains user information such as ID, username, score, and badges.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
    /**
     * The ID of the user.
     */
    String id;

    /**
     * The username of the user.
     */
    String username;

    /**
     * The score of the user.
     */
    Double score;

    /**
     * The set of badges associated with the user.
     */
    Set<Badge> badges;

}
