package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data   // Creates all getters, setters, etc. for all attributes
@Entity // Indicate that this is a table
public class Artwork {
    @Id                                                 // Indicate that this is the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in the table (We don't need to provide a table as it's automatically generated for us)
    @Column(name = "id")
    private long id;                                    // Primary key

    @Column(name = "name")
    private String name;

    @Column(name = "creator")
    private String creator;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @JsonBackReference             // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
                                   // ^^This is needed to stop the infinite recursion when doing a GET request from Postman
    @ManyToOne                     // Many artworks to one trail (This means this attribute is the owner entity)
    @JoinColumn(name = "trail_id") // Entity (Artwork) is the owner of the relationship and has a column with a foreign key (trail_id) to the referenced table (Trail)
    private Trail trail;

    public Artwork() {}

    // Custom constructor when an instance is to be created but we don't have an id
    public Artwork(String name, String creator, String description, double latitude, double longitude, Trail trail, byte[] image) {
        this.name = name;
        this.creator = creator;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.trail = trail;
        this.image = image;
    }
}
