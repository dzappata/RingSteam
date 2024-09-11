package com.example.ringsteam.services;

import com.example.ringsteam.exceptions.PlayNotFoundException;
import com.example.ringsteam.models.Play;
import com.example.ringsteam.models.PlayID;
import com.example.ringsteam.repositories.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayService {

    @Autowired
    private PlayRepository playRepository;

    //Aggiunta di un gioco per uno specifico utente
    public void addGameUser(long idUser, long idGame) {
        Play newGameUser = new Play(idUser,idGame,0);
        playRepository.save(newGameUser);
    }

    //Lista dei giochi di uno specifico utente
    public List<Play> getAllGameUser(long idUser) {
        return playRepository.findPlayByIduser(idUser);
    }

    //Lista dei giochi con cui uno specifio utente ha giocato
    public List<Play> getAllGameUserPlayed(long idUser) {
        return playRepository.findPlayedGamesByIdUser(idUser);
    }

    //Modifica del numero di ore di gioco di un utente per un gioco specifico
    public void editHoursPlayed(long idUser, long idGame, double hours) {
        PlayID idPlay = new PlayID(idUser,idGame);
        Play editPlay=playRepository.findById(idPlay).orElseThrow(()-> new PlayNotFoundException());

        editPlay.setTotalhours(hours);
        playRepository.save(editPlay);
    }

    //Statistiche di ore totali per ogni gioco
    public double getTotalHoursGame(long idGame) {
        return playRepository.getTotalHoursGame(idGame);
    }

}
