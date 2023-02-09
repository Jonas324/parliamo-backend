package com.example.parliamobackend.message;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MessageService {

    ResponseEntity<Message>addNewMessage(Message message);

    ResponseEntity<Message>readMessage(Long id);

    List<List<Message>> findBySenderIdAndReceiverId(Long senderId, Long receiverId);

    Optional<Message> readConversation(Message message);

    ResponseEntity<List<Message>> readAllMessages();
}
