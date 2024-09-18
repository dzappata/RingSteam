package com.example.ringsteam.dto;

public class LoginResponse{
    private String jwt;
    private String username;
    private long id;

    public LoginResponse(String jwt, String username, long id) {
        this.jwt = jwt;
        this.username = username;
        this.id = id;
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

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
