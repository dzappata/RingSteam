package com.example.ringsteam.services;

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
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final UserSteam client = userRepository.findByUsername(username);
        if (client == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(client.getUsername(), client.getPassword(), Collections.emptyList());
    }

}
