package com.example.parliamobackend.message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public ResponseEntity<Message> addNewMessage(Long senderId,
                                                 Long receiverId,
                                                 Message message) {
        Message newMessage = new Message();

        newMessage.setSenderId(senderId);
        newMessage.setReceiverId(receiverId);
        newMessage.setContent(message.getContent());
        newMessage.setPosted(message.getPosted());
        messageRepository.save(newMessage);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Message> readMessage(Long id) {
        return null;
    }



//    @Override
//    public ResponseEntity<List<Message>> findByReceiverIdAndSenderId(Long sendId, Long receiverId) {
//        return null;
//    }

//    @Override
//    public ResponseEntity<List<Message>> readConversation(Long senderId, Long receiverId) {
//        return null;
//    }

//    @Override
//    public ResponseEntity<List<Message>> readAllMessages(Long receiverId, Long senderId) {
//
//        List<Message> conversation = new ArrayList<>();
//        conversation.add(messageRepository.findByReceiverIdAndSenderId(receiverId, senderId));
//
//        return new ResponseEntity<>(conversation, HttpStatus.OK);
//    }

//    @Override
//    public ResponseEntity<List<Message>> findByReceiverIdAndSenderId(Long receiverId, Long senderId) {
//        List<Message> readConversation = new ArrayList<>();
//        readConversation.add((Message) messageRepository.findByReceiverIdAndSenderId(receiverId, senderId));
//        return new ResponseEntity<>(readConversation, HttpStatus.OK);
//    }

//    @Override
//    public ResponseEntity<List<Message>> readConversation(Long recieverId, Long senderId){
//        List<Message> conversation = new ArrayList<>();
//        conversation.add(messageRepository.findByReceiverIdAndSenderId(recieverId, senderId));
//
//        return new ResponseEntity<>(conversation, HttpStatus.OK);
//    }


//    @Override
//    public ResponseEntity<List<Message>> readAllMessages(){
//
//        try {
//            List<Message> messageList = new ArrayList<>(messageRepository.findAll());
//
//            return new ResponseEntity<>(messageList, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @Override
    public Optional<Message> readConversation(Message message) {
            Optional<Message> messageList = messageRepository.findById(message.getId());
            return messageList;
    }

}
