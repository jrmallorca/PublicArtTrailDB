package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Entity(name = "TrailArtwork")
@Table(name = "trail_artwork")
public class TrailArtwork implements Serializable {
    @EmbeddedId
    private TrailArtworkPK id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trailID")
    private Trail trail;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("artworkID")
    private Artwork artwork;

    @Column(name = "artwork_rank")
    private int artworkRank;

    public TrailArtwork(Trail trail, Artwork artwork, int artworkRank) {
        id = new TrailArtworkPK(trail.getId(), artwork.getId());
        this.trail = trail;
        this.artwork = artwork;
        this.artworkRank = artworkRank;
    }
}
