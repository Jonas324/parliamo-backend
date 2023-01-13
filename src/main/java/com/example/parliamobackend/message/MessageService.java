package com.example.parliamobackend.message;

import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface MessageService {

    ResponseEntity<Message>addNewMessage(Message message);
    ResponseEntity<Message>readMessage(Long id);
//    ResponseEntity<Set<Message>>readAllMessages(Long id);

}
