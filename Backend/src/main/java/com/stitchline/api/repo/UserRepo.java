package com.stitchline.api.repo;

import com.stitchline.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
    @Query("{'userName' : ?0, 'password' : ?1}")
    Optional<User> findByUserNameAndPassword(String userName, String password);

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

    Optional<User> deleteByEmail(String email);

    Optional<User> findAllByUserName(String userName);
}
