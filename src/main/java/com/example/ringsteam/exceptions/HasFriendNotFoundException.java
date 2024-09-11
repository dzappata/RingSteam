package com.example.ringsteam.exceptions;

public class HasFriendNotFoundException extends RuntimeException {

    public HasFriendNotFoundException() {

        super("Could not find this friend in this user list");
    }
}
