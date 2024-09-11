package com.example.ringsteam.models;

import jakarta.persistence.*;

@Entity
@Table(name ="play")
@IdClass(PlayID.class)
public class Play {

    @Id
    private long iduser;
    @Id
    private long idgame;

    private double totalhours;

    public Play() {

    }

    public Play( long iduser, long idgame, double totalHours) {
        this.iduser = iduser;
        this.idgame = idgame;
        this.totalhours = totalHours;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long idUser) {
        this.iduser = idUser;
    }

    public long getIdgame() {
        return idgame;
    }

    public void setIdgame(long idGame) {
        this.idgame = idGame;
    }

    public double getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(double totalHours) {
        this.totalhours = totalHours;
    }
}
