package com.example.parliamobackend.user;

import com.example.parliamobackend.message.Message;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserServiceImpl userService;
    private final UserRepository userRepository;


    @Autowired
    public UserController(UserServiceImpl userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;

    }

   /* @GetMapping("/encode")
    public String testEncoding() {

        bcrypt.bCryptPasswordEncoder().matches("", "");

        return bcrypt.bCryptPasswordEncoder().encode("password");
    }*/
    @CrossOrigin
    @GetMapping("/getUser/{username}")
    public User getUserByName(@PathVariable String username){
        return userService.getUserByName(username);
    }




    @CrossOrigin
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUser(){
            return userService.getAllUsers();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "user deleted";
    }
    /*@CrossOrigin
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){
            return userService.addNewUser(user);
    }*/

//    /*@GetMapping("/register")
//    public String displayRegisterUser(User user) {    // THIS ARGUMENT MUST EXIST
//
//        return "register";
//    }*/
//
////    @CrossOrigin
////    @PostMapping("/register")
////    public ResponseEntity<String> registerUser(@RequestBody User user, BindingResult result, Model model) {
////        System.out.println(user.getPassword() );
////        // TODO Check if @Valid should be used instead of RequestBody. Also where to specify pass requirements.
////
////        user.setUsername(user.getUsername());
////        user.setPassword(appPasswordConfig.bCryptPasswordEncoder().encode(user.getPassword()));
////        user.setAccountNonExpired(true);
////        user.setAccountNonLocked(true);
////        user.setCredentialsNonExpired(true);
////        user.setEnabled(true);
////
////        // IF no errors
////        System.out.println(user);
////        userRepository.save(user);
////        // model.addAttribute("user", userModel);
////
////        return new ResponseEntity<String>("User registred", HttpStatus.OK);
////    }
//




}
