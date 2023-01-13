package com.example.parliamobackend.message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public ResponseEntity<Message> readMessage(Long id) {
        return null;
    }
}
