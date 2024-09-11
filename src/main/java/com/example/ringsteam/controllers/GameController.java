package com.example.ringsteam.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.ringsteam.models.Game;
import com.example.ringsteam.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGame(Model model) {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
//        model.addAttribute("games", gameService.getAllGames());
//        return "gameslist";
    }

    @GetMapping("/games/{id}")
    public Game getGame(@PathVariable long id, Model model) {
        return gameService.getGame(id);
//        model.addAttribute("game", gameService.getGame(id));
//        return "gamepage";
    }

    @PostMapping("/games")
    public void createGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

    @PutMapping("/games/{id}")
    public void updateGame(@PathVariable long id, @RequestBody Game game) {
        gameService.updateGame(id, game);
    }

    @DeleteMapping("games/{id}")
    public void deleteGame(@PathVariable long id) {
        gameService.deleteGame(id);
    }
}
