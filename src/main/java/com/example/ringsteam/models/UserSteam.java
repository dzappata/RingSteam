package com.example.ringsteam.models;

import jakarta.persistence.*;

@Entity
@Table(name ="usersteam")
public class UserSteam {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String username;
    private String emailaddress;
    private String phonenumber;
    private String password;

    public UserSteam() {

    }

    public UserSteam(String username, String emailAddress, String phonenumber, String password) {
        this.username = username;
        this.emailaddress = emailAddress;
        this.phonenumber = phonenumber;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
