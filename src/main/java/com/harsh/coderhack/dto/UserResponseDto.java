package com.harsh.coderhack.dto;

import java.util.Set;

import com.harsh.coderhack.entity.Badge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
    
    String id;
    String username;
    Double score;
    Set<Badge> badges;

}
