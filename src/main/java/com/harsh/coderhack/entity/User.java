package com.harsh.coderhack.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Represents a user entity in the CoderHack application.
 */
@Document("user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class User {

    /**
     * The unique identifier of the user.
     */
    @Id
    Integer id;

    /**
     * The username of the user.
     */
    String username;

     /**
     * The score of the user.
     * Score (0 <= Score <= 100)
     */
    Double score;
    
    /**
     * The set of badges earned by the user.
     * Badges (Code Ninja, Code Champ, Code Master)
     */
    Set<Badge> badges;

    /**
     * Constructs a new User object with the given id and username.
     *
     * @param id       The unique identifier of the user.
     * @param username The username of the user.
     */
    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.score = 0D;
        this.badges = new HashSet<Badge>();
    }


    /**
     * Updates the badges of the user based on their score.
     */
    public void updateBadges() {
        // 1 <= Score <= 30 -> Code Ninja
        if(1 <= score && score < 30) badges.add(Badge.CODE_NINJA);

        // 30 <= Score <= 60 -> Code Champ
        else if(30 <= score && score < 60) badges.add(Badge.CODE_CHAMP);

        // 60 <= Score <= 100 -> Code Master
        else if(60 <= score && score <= 100) badges.add(Badge.CODE_MASTER);
    }
}
