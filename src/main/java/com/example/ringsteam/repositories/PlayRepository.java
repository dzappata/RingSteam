package com.example.ringsteam.repositories;

import com.example.ringsteam.models.Play;
import com.example.ringsteam.models.PlayID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayRepository extends JpaRepository<Play, PlayID> {

    List<Play> findPlayByIduser(long idUser);

    @Query(
            value = "SELECT * FROM play p WHERE p.iduser=?1 and p.totalhours>0",
            nativeQuery = true)
    List<Play> findPlayedGamesByIdUser(long idUser);

    @Query(
            value = "Select coalesce(SUM(p.totalhours),0) from play p where p.idgame=?1",
            nativeQuery = true)
    double getTotalHoursGame(long idGame);

    @Query(
            value = "Select coalesce(SUM(p.totalhours),0) from play p where p.iduser=?1 and p.idgame=?2",
            nativeQuery = true)
    double getUserHoursGame(long idUser, long idGame);



}
