package com.publicarttrail.trails.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TrailNotFoundAdvice {
    @ResponseBody // Advice is rendered straight into the response body.
    @ExceptionHandler(TrailNotFoundException.class) // Advice only responds when exception is thrown
    @ResponseStatus(HttpStatus.NOT_FOUND) // Issue an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
    String trailNotFoundHandler(TrailNotFoundException e) {
        return e.getMessage();
    }
}