package com.example.ringsteam.controllers;

import com.example.ringsteam.models.UserSteam;
import com.example.ringsteam.services.HasFriendService;
import com.example.ringsteam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HasFriendController {

    private final HasFriendService hasFriendService;
    private final UserService userService;

    @Autowired
    public HasFriendController(HasFriendService hasFriendService, UserService userService) {
        this.hasFriendService = hasFriendService;
        this.userService = userService;
    }

    //Lista degli amici di un utente
    @GetMapping("users/{idUser}/friends")
    public ResponseEntity<List<UserSteam>> getAllFriends(@PathVariable long idUser) {
        List<UserSteam> friends = new ArrayList<>();
        hasFriendService.getAllFriends(idUser).forEach(friend -> { friends.add(userService.getUser(friend.getIdfriend())); } );
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    //Aggiungi un amico
    @PostMapping("users/{idUser}/{idFriend}/addfriend")
    public void addFriend(@PathVariable long idUser, @PathVariable long idFriend) {
        hasFriendService.addFriend(idUser, idFriend);
    }

    //Cancella un amico
    @DeleteMapping("users/{idUser}/{idFriend}/delfriend")
    public void deleteFriend(@PathVariable long idUser, @PathVariable long idFriend) {
        hasFriendService.deleteFriend(idUser, idFriend);
    }
}
