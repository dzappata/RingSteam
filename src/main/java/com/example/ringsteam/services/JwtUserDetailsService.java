package com.example.ringsteam.services;

import com.example.ringsteam.models.UserSteam;
import com.example.ringsteam.repositories.UserRepository;
import com.example.ringsteam.util.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    public static final String USER = "USER";
    public static final String ROLE_USER = "ROLE_" + USER;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final UserSteam client = userRepository.findByUsername(username);
        if (client == null) {
            throw new UsernameNotFoundException("User not found");
        }
        final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority(JwtUserDetailsService.ROLE_USER));
        return new JwtUserDetails(client.getId(), username, client.hashCode(), roles);
    }

}
