package com.publicarttrail.trails.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class TrailArtworkID implements Serializable {
    @Column(name = "trail_id")
    private long trailID;

    @Column(name = "artwork_id")
    private long artworkID;

    public TrailArtworkID() {}

    public TrailArtworkID(long trailID, long artworkID) {
        this.trailID = trailID;
        this.artworkID = artworkID;
    }
}
