package com.example.springmongodbsecurity.service;

import com.example.springmongodbsecurity.model.User;
import com.example.springmongodbsecurity.model.payload.RegistrationRequest;
import com.example.springmongodbsecurity.repository.RoleRepository;
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
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    public Optional<User> createUser(RegistrationRequest registrationRequest) {
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setUsername(registrationRequest.getUsername());
        user.setGender(registrationRequest.getGender().getText());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        // user.addRole(registrationRequest.getRole());
        User u = this.save(user);
        return Optional.ofNullable(u);
    }


}
