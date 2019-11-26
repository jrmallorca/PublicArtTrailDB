package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// A table within the database
@Data
@Entity
public class Trail {
    @Id // Indicate that this is the primary key of the table
    @GeneratedValue // Auto-increment in the table (We don't need to provide a table as it's automatically generated for us)
    private long id; // Primary key
    private String name;
    @OneToMany(mappedBy = "trail", cascade = CascadeType.ALL)
    @JsonManagedReference // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    // ^^This is needed to stop the infinite recursion
    private List<Artwork> artworks;

    public Trail() {}

    // Custom constructor when an instance is to be created but we don't have an id
    public Trail(String name, Artwork... artworks) {
        this.name = name;
        this.artworks = Stream.of(artworks).collect(Collectors.toList());
        this.artworks.forEach(x -> x.setTrail(this));
    }
}
