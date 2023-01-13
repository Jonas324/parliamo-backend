package com.example.parliamobackend.message;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface MessageService {

    ResponseEntity<Message>addNewMessage(Message message);
    ResponseEntity<List<Message>>readAllMessages();

    ResponseEntity<List<Message>> readMessage(Long senderId, Long receiverId);
//    ResponseEntity<Set<Message>>readAllMessages(Long id);

}
