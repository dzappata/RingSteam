package com.example.ringsteam.services;

import com.example.ringsteam.exceptions.UserNotFoundException;
import com.example.ringsteam.models.UserSteam;
import com.example.ringsteam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserSteam> getAllUsers() {
        return userRepository.findAll();
    }

    public UserSteam getUser(long id) {
        Optional<UserSteam> user = userRepository.findById(id);
        return user.orElseThrow(()-> new UserNotFoundException(id));
    }

    public void addUser(UserSteam user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(long id, UserSteam user) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.save(user);
    }

    public Optional<UserSteam> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
