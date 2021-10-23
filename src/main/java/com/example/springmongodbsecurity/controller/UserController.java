package com.example.springmongodbsecurity.controller;

import com.example.springmongodbsecurity.exception.InvalidTokenRequestException;
import com.example.springmongodbsecurity.model.payload.ApiResponse;
import com.example.springmongodbsecurity.model.payload.RegistrationRequest;
import com.example.springmongodbsecurity.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody() RegistrationRequest registrationRequest) {
        System.out.println("1234");
        return userService.createUser(registrationRequest)
                .map(user -> {
                    logger.info("Registered User returned [API[: " + user);
                    return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
                })
                .orElseThrow(() -> new InvalidTokenRequestException("", "", "Error"));
    }
}
