package com.example.ringsteam.exceptions;

public class PlayNotFoundException extends RuntimeException {

    public PlayNotFoundException() {

        super("Could not find this game for this user");
    }
}
