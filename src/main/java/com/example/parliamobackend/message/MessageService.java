package com.example.parliamobackend.message;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface MessageService {

    ResponseEntity<Message>addNewMessage(Long senderId,
                                         Long receiverId,
                                         Message message);
    ResponseEntity<Message>readMessage(Long id);
//    ResponseEntity<Set<Message>>readAllMessages(Long id);
//    ResponseEntity<List<Message>> findByReceiverIdAndSenderId(Long sendId, Long receiverId);
//    ResponseEntity<List<Message>>readConversation(Long senderId, Long receiverId);

    Optional<Message> readConversation(Message message);
}
