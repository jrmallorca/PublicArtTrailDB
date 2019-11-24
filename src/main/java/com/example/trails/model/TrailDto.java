package com.example.trails.model;

// Trail DTO (Data Transfer Object)
// This is what we transfer from the Postman application to be turned into the actual Trail object
public class TrailDto {

    private long id;
    private String name;
    private String artworks; // TODO: Change this to List<Artwork> later

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtworks() {
        return artworks;
    }

    public void setArtworks(String artworks) {
        this.artworks = artworks;
    }
}
