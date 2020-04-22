package com.publicarttrail.trails.services;

class ArtworkNotFoundException extends RuntimeException {
    ArtworkNotFoundException(long id) {
        super("Couldn't find an Artwork with id: " + id);
    }

    ArtworkNotFoundException(String name) {
        super("Couldn't find an Artwork with id: " + name);
    }
}
