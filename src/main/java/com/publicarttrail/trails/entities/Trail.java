package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data   // Creates all getters, setters, etc. for all attributes
@Entity // Indicate that this is a table
public class Trail {
    @Id                                                 // Indicate that this is the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in the table (We don't need to provide a table as it's automatically generated for us)
    @Column(name = "id")
    private long id;     // Primary key

    @Column(name = "name")
    private String name;

    // Values for zooming in the general area of the trail
    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @JsonManagedReference // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
                          // ^^This is needed to stop the infinite recursion when doing a GET request from Postman
    @OneToMany(mappedBy = "trail", cascade = CascadeType.ALL)
    private List<Artwork> artworks;

    public Trail() {}

    // Custom constructor when an instance is to be created but we don't have an id
    public Trail(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
