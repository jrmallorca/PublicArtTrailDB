package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "TrailArtwork")
@Table(name = "trail_artwork")
public class TrailArtwork implements Comparable<TrailArtwork> {
    @EmbeddedId
    private TrailArtworkID id;

    @JsonBackReference
    @ManyToOne
    @MapsId("trailID")
    @JoinColumn(name = "trail_id", referencedColumnName = "id")
    private Trail trail;

    @JsonBackReference
    @ManyToOne
    @MapsId("artworkID")
    @JoinColumn(name = "artwork_id", referencedColumnName = "id")
    private Artwork artwork;

    @Column(name = "artwork_rank")
    private int artworkRank;

    public TrailArtwork() {}

    public TrailArtwork(Trail trail, Artwork artwork, int artworkRank) {
        id = new TrailArtworkID(trail.getId(), artwork.getId());
        this.trail = trail;
        this.artwork = artwork;
        this.artworkRank = artworkRank;
    }

    @Override
    public int compareTo(TrailArtwork ta) {
        return this.artworkRank - ta.getArtworkRank();
    }
}
