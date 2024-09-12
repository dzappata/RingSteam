package com.example.ringsteam.controllers;

import com.example.ringsteam.models.Game;
import com.example.ringsteam.services.GameService;
import com.example.ringsteam.services.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //Lista dei giochi di uno specifico utente
    @GetMapping("users/{idUser}/games")
    public ResponseEntity<List<Game>> getAllGameUser(@PathVariable long idUser){
        List<Game> gameList = new ArrayList<>();
        playService.getAllGameUser(idUser).forEach(game -> { gameList.add(gameService.getGame(game.getIdgame())); } );
        return new ResponseEntity<>(gameList, HttpStatus.OK);
    }

    //Lista dei giochi con cui uno specifio utente ha giocato
    @GetMapping("users/{idUser}/playedgames")
    public ResponseEntity<List<Game>> getPlayedGameUser(@PathVariable long idUser){
        List<Game> playedGameList = new ArrayList<>();
        playService.getAllGameUserPlayed(idUser).forEach(game -> { playedGameList.add(gameService.getGame(game.getIdgame())); } );
        return new ResponseEntity<>(playedGameList, HttpStatus.OK);
    }

    //Aggiunta di un gioco per uno specifico utente
    @PostMapping("users/{idUser}/{idGame}/addgame")
    public void addGameUser(@PathVariable long idUser, @PathVariable long idGame){
        playService.addGameUser(idUser,idGame);
    }

    //Ore totali di gioco per singolo utente
    @GetMapping("/users/{idUser}/{idGame}/totalhours")
    public ResponseEntity<Double> getUserHoursGame(@PathVariable long idUser, @PathVariable long idGame){
        return new ResponseEntity<>(playService.getUserHoursGame(idUser,idGame), HttpStatus.OK);
    }

    //Modifica del numero di ore di gioco di un utente per un gioco specifico
    @PutMapping("users/{idUser}/{idGame}/edithours")
    public void editHoursPlayed(@PathVariable long idUser, @PathVariable long idGame, @RequestParam("hours") double hours){
        playService.editHoursPlayed(idUser,idGame,hours);
    }

    //Statistiche di ore totali per ogni gioco
    @GetMapping("games/{idGame}/totalhours")
    public ResponseEntity<Double> getTotalHoursGame(@PathVariable long idGame){
        return new ResponseEntity<>(playService.getTotalHoursGame(idGame), HttpStatus.OK);
    }
}
