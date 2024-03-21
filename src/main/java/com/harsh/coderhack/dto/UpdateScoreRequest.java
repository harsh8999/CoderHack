package com.harsh.coderhack.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * DTO (Data Transfer Object) representing the request to update a user's score.
 * Contains the new score value.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateScoreRequest {
    
    /**
     * The new score value to be updated for the user.
     */
    Double score;

}
