package com.example.parliamobackend.message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public ResponseEntity<Message> addNewMessage(Message message) {
        Message newMessage = new Message();

        newMessage.setSenderId(message.getSenderId());
        newMessage.setReceiverId(message.getReceiverId());
        newMessage.setContent(message.getContent());
        newMessage.setPosted(message.getPosted());
        messageRepository.save(newMessage);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Message>> readAllMessages(){

        try {
            List<Message> messageList = new ArrayList<>(messageRepository.findAll());

            return new ResponseEntity<>(messageList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Optional<Message> readConversation(Message message) {
            Optional<Message> messageList = messageRepository.findById(message.getId());

            return messageList;

    }
}
