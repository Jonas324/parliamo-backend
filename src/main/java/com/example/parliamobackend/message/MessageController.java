package com.example.parliamobackend.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageServiceImpl messageService;

    @Autowired
    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message){
        return messageService.addNewMessage(message);
    }

    @GetMapping
    ResponseEntity<List<Message>> readAllMessages(){
        return messageService.readAllMessages();
    }

    @GetMapping("/readMessages")
    public ResponseEntity<List<Message>> readMessage(Long senderId, Long receiverId){
        return messageService.readMessage(senderId, receiverId);
    }
}
