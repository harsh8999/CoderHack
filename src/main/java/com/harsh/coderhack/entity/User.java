package com.harsh.coderhack.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Document(collation = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class User {

    @Id
    int id;

    String username;

    double score;
    
    Set<Badge> badges;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.score = 0D;
        this.badges = new HashSet<Badge>();
    }
}
