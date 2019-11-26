package com.publicarttrail.trails.repositories;

import com.publicarttrail.trails.entities.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworksRepository extends JpaRepository<Artwork, Long> {}
