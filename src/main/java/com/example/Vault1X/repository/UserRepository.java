package com.example.Vault1X.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Vault1X.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    // Find user by email
    Optional<Users> findByEmail(String email);

    // Find user by username
    Optional<Users> findByUserName(String userName);

    // // Check if email exists
    // boolean existsByEmail(String email);

    // // Check if username exists
    // boolean existsByUsername(String username);
}
