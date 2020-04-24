package com.publicarttrail.trails.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TrailArtworkPK implements Serializable {
    @Column(name = "trail_id")
    private long trailID;

    @Column(name = "artwork_id")
    private long artworkID;
}
