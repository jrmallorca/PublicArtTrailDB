package com.publicarttrail.trails.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ArtworkNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TrailNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ArtworkNotFoundHandler(ArtworkNotFoundException e) {
        return e.getMessage();
    }
}