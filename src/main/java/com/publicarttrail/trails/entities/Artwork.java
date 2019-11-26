package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Artwork {
    @Id // Indicate that this is the primary key of the table
    @GeneratedValue // Auto-increment in the table (We don't need to provide a table as it's automatically generated for us)
    private long id; // Primary key
    private String name;
    // private Image image; // Edit later
    private String creator;
    @Column(columnDefinition="TEXT")
    private String description;
    private double latitude, longitude;

    @ManyToOne // Many artworks to one trail
    @JoinColumn // Entity is the owner of the relationship and the corresponding table has a column with a foreign key to the referenced table
    @JsonBackReference // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    // ^^This is needed to stop the infinite recursion
    private Trail trail;

    Artwork() {}

    public Artwork(String name, String creator, String description, double latitude, double longitude) {
        this.name = name;
        this.creator = creator;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
