package com.example.parliamobackend.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public interface UserService {

    ResponseEntity addNewUser(User user);
    ResponseEntity<List<User>> getAllUsers();

}
