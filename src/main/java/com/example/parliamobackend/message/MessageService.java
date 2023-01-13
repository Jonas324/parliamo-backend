package com.example.parliamobackend.message;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    ResponseEntity<Message>addNewMessage(Message message);
    ResponseEntity<List<Message>>readAllMessages();

    Optional<Message> readConversation(Message message);
//    ResponseEntity<Set<Message>>readAllMessages(Long id);

}
