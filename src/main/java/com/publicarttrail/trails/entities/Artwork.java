package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data   // Creates all getters, setters, etc. for all attributes
@RequiredArgsConstructor
@Entity(name = "Artwork") // Indicate that this is a table
@Table(name = "artwork")
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

    @Lob // Large object
    @Column(name = "image")
    private String image;

    // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    // ^^This is needed to stop the infinite recursion when doing a GET request from Postman
    @JsonManagedReference
    @OneToMany(
            mappedBy = "artwork",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TrailArtwork> trailArtwork = new ArrayList<>();

    // Custom constructor when an instance is to be created but we don't have an id
    public Artwork(String name,
                   String creator,
                   String description,
                   double latitude,
                   double longitude,
                   String image) {
        this.name = name;
        this.creator = creator;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }
}
