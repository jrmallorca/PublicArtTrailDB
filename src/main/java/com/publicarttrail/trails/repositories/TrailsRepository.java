package com.publicarttrail.trails.repositories;

import com.publicarttrail.trails.entities.Trail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Get the CRUD operations and implement them in the Service layer
@Repository
public interface TrailsRepository extends CrudRepository<Trail, Long> {}
