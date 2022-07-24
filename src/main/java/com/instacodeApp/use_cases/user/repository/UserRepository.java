package com.instacodeApp.use_cases.user.repository;

import com.instacodeApp.use_cases.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User getByEmail(String email);
    User getByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
    //User getUserByName(String username);

}
