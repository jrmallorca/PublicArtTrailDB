package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data // Creates all getters, setters, etc. for all attributes
@RequiredArgsConstructor
@Entity(name = "Trail")
@Table(name = "trail")
public class Trail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "trail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TrailArtwork> trailArtworks = new ArrayList<>();

    public Trail(String name) {
        this.name = name;
    }
}
