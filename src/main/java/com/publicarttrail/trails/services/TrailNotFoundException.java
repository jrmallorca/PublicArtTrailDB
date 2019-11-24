package com.publicarttrail.trails.services;

public class TrailNotFoundException extends RuntimeException {
    public TrailNotFoundException(String message) {
        super(message);
    }
}