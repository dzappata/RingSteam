package com.example.ringsteam.services;

import com.example.ringsteam.exceptions.GameNotFoundException;
import com.example.ringsteam.models.Game;
import com.example.ringsteam.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGame(long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElseThrow(()-> new GameNotFoundException(id));
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(long id, Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(long id) {
        gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
        gameRepository.deleteById(id);
    }
}
