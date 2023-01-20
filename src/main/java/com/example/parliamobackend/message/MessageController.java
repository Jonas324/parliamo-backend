package com.example.parliamobackend.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageServiceImpl messageService;


    @Autowired
    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/readMessages/{id}")
    public Optional<Message> readConversation(@PathVariable("id")Message message){
        return messageService.readConversation(message);
    }


    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message){
        return messageService.addNewMessage(message);
    }


    @CrossOrigin
    @GetMapping("/{senderId}/{receiverId}")
    public List<List<Message>> findBySenderIdAndReceiverId(@PathVariable("senderId") Long senderId, @PathVariable("receiverId") Long receiverId){

        return messageService.findBySenderIdAndReceiverId(senderId, receiverId);
    }
}
