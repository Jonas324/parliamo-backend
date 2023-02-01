package com.example.parliamobackend.auth;

import com.example.parliamobackend.user.User;
import com.example.parliamobackend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

//    private final AuthenticationManager authenticationManager;
//
//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordEncoder;

    private final AuthenticationService service;

    @Autowired
    public AuthController(AuthenticationService service) {
        this.service = service;
    }

    //    @Autowired
//    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
       return ResponseEntity.ok(service.authenticate(request));
    }

}
