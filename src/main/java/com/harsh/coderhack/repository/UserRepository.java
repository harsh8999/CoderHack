package com.harsh.coderhack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harsh.coderhack.entity.User;

public interface UserRepository extends MongoRepository<User, Integer> {
    
}
