package com.example.ringsteam.models;

import jakarta.persistence.*;

@Entity
@Table(name ="usersteam")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String username;
    private String emailaddress;
    private String phonenumber;

    public User() {

    }

    public User(String username, String emailAddress, String phonenumber) {
        this.username = username;
        this.emailaddress = emailAddress;
        this.phonenumber = phonenumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailAddress) {
        this.emailaddress = emailAddress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }
}
