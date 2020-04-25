package com.publicarttrail.trails.repositories;

import com.publicarttrail.trails.entities.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtworksRepository extends JpaRepository<Artwork, Integer> {
    Optional<Artwork> findByName(String name);
}
