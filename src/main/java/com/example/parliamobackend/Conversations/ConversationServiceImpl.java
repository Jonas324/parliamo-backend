package com.example.parliamobackend.Conversations;

import com.example.parliamobackend.message.Message;
import com.example.parliamobackend.user.User;
import com.example.parliamobackend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ConversationServiceImpl implements ConversationService{
    private final UserRepository userRepository;
    private final ConversationRepository conversationRepository;
    @Autowired
    public ConversationServiceImpl(UserRepository userRepository,
                                   ConversationRepository conversationRepository) {
        this.userRepository = userRepository;
        this.conversationRepository = conversationRepository;
    }


    @Override
    public ResponseEntity<String> createConversation(Long user1, Long user2) {

        Conversation conversation = new Conversation();
        conversation.setUser1(user1);
        conversation.setUser2(user2);
        conversationRepository.save(conversation);


        User _user1 = new User();
        User _user2 = new User();

        List<Conversation> _user1Conversation =  _user1.getConversations();
        _user1Conversation.add(conversation);
        List<Conversation> _user2Conversation =  _user2.getConversations();
        _user2Conversation.add(conversation);

        userRepository.save(_user1);
        userRepository.save(_user2);


        return new ResponseEntity<>("Conversation created successfully" + conversation, HttpStatus.OK);
    }
}
