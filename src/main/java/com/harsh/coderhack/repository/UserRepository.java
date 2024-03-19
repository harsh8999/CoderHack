package com.harsh.coderhack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.harsh.coderhack.entity.User;

/**
 * This interface represents a repository for managing User entities in the MongoDB database.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
