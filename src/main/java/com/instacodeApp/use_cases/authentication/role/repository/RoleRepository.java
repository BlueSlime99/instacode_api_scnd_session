package com.instacodeApp.use_cases.authentication.role.repository;

import com.instacodeApp.use_cases.authentication.role.domain.Role;
import com.instacodeApp.use_cases.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role);
}
