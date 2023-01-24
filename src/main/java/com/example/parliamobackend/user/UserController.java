package com.example.parliamobackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/user")
public class UserController {


    private final UserServiceImpl userService;


    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

   /* @GetMapping("/encode")
    public String testEncoding() {

        bcrypt.bCryptPasswordEncoder().matches("", "");

        return bcrypt.bCryptPasswordEncoder().encode("password");
    }*/
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
            return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){
            return userService.addNewUser(user);
    }

       /* @PostMapping("/sendmessage/{id}/{receiverid}")
        public User sendMessage(@PathVariable("id") Long userId, @PathVariable("receiverid") Long receiverId, Message message){
            return userService.sendMessage(userId, receiverId, message);
        }*/




        // Postman -- { "email" : "hej@hejsan.se", "password" : "123", "username" : "benny", "credit" : "1000L",
        // "enabled" : "true", "accountNonExpired" : "true", "accountNonLocked" : "true", "credentialsNonExpired" :
        // "true","role":"ADMIN"}


}
