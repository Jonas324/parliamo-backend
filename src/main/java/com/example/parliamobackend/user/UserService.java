package com.example.parliamobackend.user;

import com.example.parliamobackend.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    ResponseEntity addNewUser(User user);
    ResponseEntity<List<User>> getAllUsers();
    User sendMessage(Long userId, Long receiverId, Message message);

}
