package com.example.ringsteam.models;

import java.io.Serializable;
import java.util.Objects;

public class PlayID implements Serializable {

    private long iduser;
    private long idgame;

    public PlayID() {

    }

    public PlayID(long iduser, long idgame) {
        this.iduser = iduser;
        this.idgame = idgame;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public long getIdgame() {
        return idgame;
    }

    public void setIdgame(long idgame) {
        this.idgame = idgame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayID playID = (PlayID) o;
        return iduser == playID.iduser && idgame == playID.idgame;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, idgame);
    }
}

