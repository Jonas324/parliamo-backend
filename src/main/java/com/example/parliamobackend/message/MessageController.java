package com.example.parliamobackend.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageServiceImpl messageService;


    @Autowired
    public MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }


//    @PostMapping
//    public ResponseEntity<Message> sendMessage(@RequestBody Message message){
//        return messageService.addNewMessage(message);
//    }

//    @GetMapping
//    ResponseEntity<List<Message>> readAllMessages(){
//        return messageService.readAllMessages();
//    }

    @GetMapping("/readMessages/{id}")
    public Optional<Message> readConversation(@PathVariable("id")Message message){
        return messageService.readConversation(message);
    }

//    @GetMapping
//    public ResponseEntity<List<Message>> getConversation(Long receiverId, Long senderId){
//        return messageService.readConversation(receiverId, senderId);
//    }

//    @GetMapping
//    public ResponseEntity<List<Message>> readConversation(
//            @RequestParam Long receiverId, Long senderId){
//        return messageService.readConversation(receiverId, senderId);
//    }

//    @GetMapping
//    public ResponseEntity<List<Message>> readConversation(@RequestParam Long receiverId,
//                                                          @RequestParam Long senderId){
//        return messageService.findByReceiverIdAndSenderId(receiverId, senderId);
//    }
}
