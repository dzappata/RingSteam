package com.example.ringsteam.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name ="hasfriend")
@IdClass(HasFriendID.class)
public class HasFriend {

    @Id
    private long iduser;
    @Id
    private long idfriend;

    public HasFriend() {

    }

    public HasFriend(long iduser, long idfriend) {
        this.iduser = iduser;
        this.idfriend = idfriend;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long idUser) {
        this.iduser = idUser;
    }

    public long getIdfriend() {
        return idfriend;
    }

    public void setIdfriend(long idFriend) {
        this.idfriend = idFriend;
    }
}
