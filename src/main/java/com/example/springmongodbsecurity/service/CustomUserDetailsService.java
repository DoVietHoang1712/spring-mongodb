package com.example.springmongodbsecurity.service;

import com.example.springmongodbsecurity.model.CustomUserDetails;
import com.example.springmongodbsecurity.model.User;
import com.example.springmongodbsecurity.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> dbUser = userRepository.findByUsername(username);
        logger.info("Fetched user : " +dbUser + " by " + username);
        return dbUser.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }

    public UserDetails loadUserById(String id) throws UsernameNotFoundException {
        Optional<User> dbUser = userRepository.findById(id);
        logger.info("Fetched user : " +dbUser + " by " + id);
        return dbUser.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(("Id not found")));
    }
}
