package com.publicarttrail.trails.repositories;

import com.publicarttrail.trails.entities.Trail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Get the CRUD operations and implement them in the Service layer
@Repository
public interface TrailsRepository extends JpaRepository<Trail, Long> {
    Optional<Trail> findByName(String name);
}
