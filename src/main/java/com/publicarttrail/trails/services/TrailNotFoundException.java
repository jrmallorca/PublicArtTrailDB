package com.publicarttrail.trails.services;

class TrailNotFoundException extends RuntimeException {
    TrailNotFoundException(long id) {
        super("Couldn't find a Trail with id: " + id);
    }

    TrailNotFoundException(String name) {
        super("Couldn't find a Trail with id: " + name);
    }
}