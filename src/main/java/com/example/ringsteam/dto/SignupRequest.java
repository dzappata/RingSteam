package com.example.ringsteam.dto;

public class SignupRequest {

    private String username;
    private String password;
    private String emailaddress;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmail(String emailaddress) {
        this.emailaddress = emailaddress;
    }
}
