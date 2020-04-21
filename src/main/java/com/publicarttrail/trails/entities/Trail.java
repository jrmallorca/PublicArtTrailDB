package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data   // Creates all getters, setters, etc. for all attributes
@Entity(name = "Trail") // Indicate that this is a table
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
    private List<TrailArtwork> artworks = new ArrayList<>();

    public Trail() {}

    // Custom constructor when an instance is to be created but we don't have an id
    public Trail(String name) {
        this.name = name;
    }

    public void addArtwork(Artwork artwork, int artworkRank) {
        TrailArtwork ta = new TrailArtwork(this, artwork, artworkRank);
        artworks.add(ta);
        artwork.getTrails().add(ta);
    }

    public void removeArtwork(Artwork artwork) {
        for (Iterator<TrailArtwork> iterator = artworks.iterator();
             iterator.hasNext(); ) {
            TrailArtwork ta = iterator.next();

            if (ta.getTrail().equals(this) &&
                    ta.getArtwork().equals(artwork)) {
                iterator.remove();
                ta.getArtwork().getTrails().remove(ta);
                ta.setTrail(null);
                ta.setArtwork(null);
            }
        }
    }
}
