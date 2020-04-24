package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(
            mappedBy = "trail",
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    private Set<TrailArtwork> trailArtworks;

    public Trail(String name) {
        this.name = name;
    }
}
