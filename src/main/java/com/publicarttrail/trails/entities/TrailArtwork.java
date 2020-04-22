package com.publicarttrail.trails.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Entity(name = "TrailArtwork")
@Table(name = "trail_artwork")
public class TrailArtwork implements Serializable, Comparable<TrailArtwork> {
    @JsonBackReference
    @Id
    @ManyToOne
    @JoinColumn(name = "trail_id")
    private Trail trail;

    @JsonBackReference
    @Id
    @ManyToOne
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;

    @Column(name = "artwork_rank")
    private int artworkRank;

    public TrailArtwork(Artwork artwork, int artworkRank) {
        this.artwork = artwork;
        this.artworkRank = artworkRank;
    }

    @Override
    public int compareTo(TrailArtwork ta) {
        return this.artworkRank - ta.getArtworkRank();
    }
}
