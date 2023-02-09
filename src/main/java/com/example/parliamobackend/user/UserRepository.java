package com.example.parliamobackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT s FROM User s WHERE s.username = ?1")
    Optional<User> findUserByUsername(String username);

    @Query("SELECT s FROM User s WHERE s.username = ?1")
    User findByUsername(String username);
}
