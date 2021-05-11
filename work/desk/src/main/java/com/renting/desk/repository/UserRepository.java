package com.renting.desk.repository;

import com.renting.desk.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
    Optional<User> findById(Long id);
}
