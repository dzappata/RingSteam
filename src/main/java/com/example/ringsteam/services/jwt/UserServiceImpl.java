package com.example.ringsteam.services.jwt;

import com.example.ringsteam.models.UserSteam;
import com.example.ringsteam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Write logic to fetch customer from DB
        UserSteam user = userRepository.findUserSteamByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with username: " + username));

        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
