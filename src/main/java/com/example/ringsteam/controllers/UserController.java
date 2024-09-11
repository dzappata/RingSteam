package com.example.ringsteam.controllers;

import com.example.ringsteam.models.User;
import com.example.ringsteam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("/users/addnew")
    public void createUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
