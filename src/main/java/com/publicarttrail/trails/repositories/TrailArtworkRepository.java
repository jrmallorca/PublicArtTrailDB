package com.publicarttrail.trails.repositories;

import com.publicarttrail.trails.entities.TrailArtwork;
import com.publicarttrail.trails.entities.TrailArtworkPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailArtworkRepository extends JpaRepository<TrailArtwork, TrailArtworkPK> {}
