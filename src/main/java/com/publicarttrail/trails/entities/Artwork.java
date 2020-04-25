package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data // Creates all getters, setters, etc. for all attributes
@RequiredArgsConstructor
@Entity(name = "Artwork") // Indicate that this is a table
@Table(name = "artwork")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    @JsonBackReference
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
