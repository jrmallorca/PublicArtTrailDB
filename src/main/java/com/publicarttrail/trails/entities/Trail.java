package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data // Creates all getters, setters, etc. for all attributes
@RequiredArgsConstructor
@Entity(name = "Trail")
@Table(name = "trail")
public class Trail {
    @Id                                                 // Indicate that this is the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment in the table (We don't need to provide a table as it's automatically generated for us)
    @Column(name = "id")
    private long id;                                    // Primary key

    @Column(name = "name")
    private String name;

    // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    // ^^This is needed to stop the infinite recursion when doing a GET request from Postman
    @JsonManagedReference
    @OneToMany(
            mappedBy = "trail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TrailArtwork> trailArtworks;

    // Custom constructor when an instance is to be created but we don't have an id
    public Trail(String name, TrailArtwork... trailArtworks) {
        this.name = name;

        for (TrailArtwork ta : trailArtworks) {
            ta.setTrail(this);
            ta.getArtwork().getTrailArtwork().add(ta);
        }
        this.trailArtworks = Stream.of(trailArtworks).collect(Collectors.toList());
    }
}
