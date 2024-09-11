package com.example.ringsteam.controllers;

import com.example.ringsteam.models.User;
import com.example.ringsteam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(Model model) {
        return userService.getAllUsers();
//        model.addAttribute("users", userService.getAllUsers());
//        return "userslist";
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id, Model model) {
        return userService.getUser(id);
//        model.addAttribute("user", userService.getUser(id));
//        return "userpage";
    }

    @PostMapping("/users")
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
