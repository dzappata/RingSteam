package com.example.ringsteam.advices;

import com.example.ringsteam.exceptions.HasFriendNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HasFriendNotFoundAdvice {

    @ExceptionHandler(HasFriendNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String hasFriendNotFoundHandler(HasFriendNotFoundException ex) {
        return ex.getMessage();
    }
}
