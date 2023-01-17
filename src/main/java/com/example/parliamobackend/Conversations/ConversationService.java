package com.example.parliamobackend.Conversations;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ConversationService {
    ResponseEntity<String> createConversation(Long user1, Long user2);

}
