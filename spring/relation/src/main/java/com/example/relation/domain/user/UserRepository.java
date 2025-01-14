package com.example.relation.domain.user;

import com.example.relation.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    // Service 계층에서의 Validation Check
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
