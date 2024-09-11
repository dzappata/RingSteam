package com.example.ringsteam.services;

import com.example.ringsteam.exceptions.UserNotFoundException;
import com.example.ringsteam.models.User;
import com.example.ringsteam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new UserNotFoundException(id));
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(long id, User user) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.save(user);
    }
}
