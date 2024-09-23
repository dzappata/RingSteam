package com.example.ringsteam.services;

import com.example.ringsteam.dto.SignupRequest;
import com.example.ringsteam.models.UserSteam;
import com.example.ringsteam.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(SignupRequest signupRequest) {
        //Check if user already exist
        if(userRepository.existsUserSteamByUsername(signupRequest.getUsername())) {
            return false;
        }

        UserSteam user = new UserSteam();
        BeanUtils.copyProperties(signupRequest, user);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
        return true;
    }
}
