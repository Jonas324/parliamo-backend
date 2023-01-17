package com.example.parliamobackend.Conversations;

import com.example.parliamobackend.message.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    private final ConversationServiceImpl conversationService;
    @Autowired
    public ConversationController(ConversationServiceImpl conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping
    public ResponseEntity<String> createConversation(Long user1, Long user2){
        return conversationService.createConversation(user1, user2);
    }

}
