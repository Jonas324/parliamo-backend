package com.example.parliamobackend.user;

import com.example.parliamobackend.message.Message;
import com.example.parliamobackend.message.MessageRepository;
import com.example.parliamobackend.message.MessageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final MessageServiceImpl messageService;

    public UserServiceImpl(UserRepository userRepository,
                           MessageRepository messageRepository,
                           MessageServiceImpl messageService) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.messageService = messageService;
    }

    @Override
    public ResponseEntity addNewUser(User user) {
        Optional<User> userOptional = userRepository.findByName(user.getName());
        if (userOptional.isPresent()){
            throw new IllegalStateException("username taken");
        }
        User newUser = new User();
        newUser.setName(user.getName());
        userRepository.save(newUser);

        return new ResponseEntity("User added" + newUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> userList = new ArrayList<>(userRepository.findAll());

            return new ResponseEntity<>(userList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@Override
    public User sendMessage(Long userId, Long receiverId, Message message) {
        Set<Message> conversation;
        User user = userRepository.findById(userId).get();
        User receiver = userRepository.findById(receiverId).get();

         messageService.addNewMessage(userId, receiverId, message);

//        Message _message = new Message();
//        _message.setSenderId(userId);
//        _message.setReceiverId(receiverId);
//        _message.setContent(message.getContent());
//        _message.setPosted(message.getPosted());
//        messageRepository.save(_message);
//        conversation.add(_message);

        conversation = user.getConversations();
        user.setConversations(conversation);
        return userRepository.save(user);
    }*/
}
