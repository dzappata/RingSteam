package com.example.ringsteam.advices;

import com.example.ringsteam.exceptions.PlayNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlayNotFoundAdvice {

    @ExceptionHandler(PlayNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String playNotFoundHandler(PlayNotFoundException ex) {
        return ex.getMessage();
    }
}
