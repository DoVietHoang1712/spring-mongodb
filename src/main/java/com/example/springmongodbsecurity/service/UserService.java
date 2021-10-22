package com.example.springmongodbsecurity.service;

import com.example.springmongodbsecurity.model.User;
import com.example.springmongodbsecurity.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class);
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {return userRepository.findByUsername(username);}

    public Optional<User> findById(String id) {return userRepository.findById((id));}

    public User save(User user) {
        return userRepository.save(user);
    }
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    /**
     * Check is the user exists given the username: naturalId
     */
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
