package com.example.parliamobackend.user;

import com.example.parliamobackend.message.MessageRepository;
import com.example.parliamobackend.message.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final MessageServiceImpl messageService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           MessageRepository messageRepository,
                           MessageServiceImpl messageService) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.messageService = messageService;
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

    @Override
    public User getUserByName(String username){
        User user = userRepository.findByUsername(username);
                /*.orElseThrow(() -> new IllegalArgumentException("Customer not exist with id: " + username));*/
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // TODO - Exception Handling

        return userRepository.findByUsername(username);    // Query
    }

    @Override
    public void deleteUserById(Long id){
        boolean exists = userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("user with id" + id + "does not exists");
        }
        userRepository.deleteById(id);
    }

    /*@Override
    public User sendMessage(Long userId, Long receiverId, Message message) {
        Set<Message> conversation;
        User user = userRepository.findById(userId).get();
        User receiver = userRepository.findById(receiverId).get();

         messageService.addNewMessage(userId, receiverId, message);

        Message _message = new Message();
        _message.setSenderId(userId);
        _message.setReceiverId(receiverId);
        _message.setContent(message.getContent());
        _message.setPosted(message.getPosted());
        messageRepository.save(_message);
        conversation.add(_message);

        conversation = user.getConversations();
        user.setConversations(conversation);
        return userRepository.save(user);
    }*/
}
