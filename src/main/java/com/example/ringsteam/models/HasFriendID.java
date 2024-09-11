package com.example.ringsteam.models;

import java.io.Serializable;
import java.util.Objects;

public class HasFriendID implements Serializable {

    private long iduser;
    private long idfriend;

    public HasFriendID(){

    }

    public HasFriendID(long iduser, long idfriend) {
        this.iduser = iduser;
        this.idfriend = idfriend;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public long getIdfriend() {
        return idfriend;
    }

    public void setIdfriend(long idfriend) {
        this.idfriend = idfriend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HasFriendID that = (HasFriendID) o;
        return iduser == that.iduser && idfriend == that.idfriend;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, idfriend);
    }
}
