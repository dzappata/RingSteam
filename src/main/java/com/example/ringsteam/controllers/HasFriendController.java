package com.example.ringsteam.controllers;

import com.example.ringsteam.models.User;
import com.example.ringsteam.services.HasFriendService;
import com.example.ringsteam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class HasFriendController {

    @Autowired
    private HasFriendService hasFriendService;

    @Autowired
    private UserService userService;

    //Lista degli amici di un utente
    @GetMapping("users/{idUser}/friends")
    public ResponseEntity<List<User>> getAllFriends(@PathVariable long idUser) {
        List<User> friends = new ArrayList<>();
        hasFriendService.getAllFriends(idUser).forEach(friend -> { friends.add(userService.getUser(friend.getIdfriend())); } );
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    //Aggiungi un amico
    @PostMapping("users/{idUser}/addfriend")
    public void addFriend(@PathVariable long idUser, @RequestParam("idfriend") long idfriend) {
        hasFriendService.addFriend(idUser, idfriend);
    }

    //Cancella un amico
    @DeleteMapping("users/{idUser}/delfriend")
    public void deleteFriend(@PathVariable long idUser, @RequestParam("idfriend") long idfriend) {
        hasFriendService.deleteFriend(idUser, idfriend);
    }
}
