package com.example.trails.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// A table within the database
@Entity
public class Trail {
    @Id // Indicate that this is the primary key of the table
    @GeneratedValue // Auto-increment in the table (We don't need to provide a table as it's automatically generated for us)
    private long id; // Primary key
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
