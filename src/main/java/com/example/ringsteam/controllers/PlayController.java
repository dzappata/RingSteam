package com.example.ringsteam.controllers;

import com.example.ringsteam.models.Game;
import com.example.ringsteam.models.Play;
import com.example.ringsteam.services.GameService;
import com.example.ringsteam.services.PlayService;
import com.example.ringsteam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PlayController {

    @Autowired
    private PlayService playService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    //Lista dei giochi di uno specifico utente
    @GetMapping("users/{idUser}/games")
    public List<Game> getAllGameUser(@PathVariable long idUser, Model model){
        List<Game> gameList = new ArrayList<>();
        playService.getAllGameUser(idUser).forEach(game -> { gameList.add(gameService.getGame(game.getIdgame())); } );
        return gameList;
//        model.addAttribute("games", gameList);
//        model.addAttribute("nameuser", userService.getUser(idUser).getUsername());
//        return "usergameslist";
    }

    //Lista dei giochi con cui uno specifio utente ha giocato
    @GetMapping("users/{idUser}/playedgames")
    public List<Game> getPlayedGameUser(@PathVariable long idUser, Model model){
        List<Game> playedGameList = new ArrayList<>();
        playService.getAllGameUserPlayed(idUser).forEach(game -> { playedGameList.add(gameService.getGame(game.getIdgame())); } );
        return playedGameList;
//        model.addAttribute("games", playedGameList);
//        model.addAttribute("nameuser", userService.getUser(idUser).getUsername());
//        model.addAttribute("play", new Play());
//        return "usergameslist";
    }

    //Aggiunta di un gioco per uno specifico utente
    @PostMapping("users/{idUser}/{idGame}/addgame")
    public void addGameUser(@PathVariable long idUser, @PathVariable long idGame){
        playService.addGameUser(idUser,idGame);
    }

    //Modifica del numero di ore di gioco di un utente per un gioco specifico
    @PutMapping("users/{idUser}/{idGame}/edithours")
    public void editHoursPlayed(@PathVariable long idUser, @PathVariable long idGame, @RequestParam("hours") double hours){
        playService.editHoursPlayed(idUser,idGame,hours);
    }

    //Statistiche di ore totali per ogni gioco
    @GetMapping("games/{idGame}/totalhours")
    public double getTotalHoursGame(@PathVariable long idGame){
        return  playService.getTotalHoursGame(idGame);
    }
}
