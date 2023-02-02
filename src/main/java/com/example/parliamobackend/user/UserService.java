package com.example.parliamobackend.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    User getUserByName(String username);



    ResponseEntity<List<User>> getAllUsers();

    void deleteUserById(Long id);
    /* User sendMessage(Long userId, Long receiverId, Message message);*/

}
