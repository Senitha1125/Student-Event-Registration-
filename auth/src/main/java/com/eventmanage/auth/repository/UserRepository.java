package com.eventmanage.auth.repository;

import com.eventmanage.auth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends JpaRepository<User, Long>  {
    User findByEmail(String email);
}