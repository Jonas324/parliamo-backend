package com.example.parliamobackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;



    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
