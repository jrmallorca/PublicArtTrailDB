package com.publicarttrail.trails.services;

import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.repositories.TrailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Implementations of the repository interface methods
// TODO: 13/02/2020 Consider adding a getByName() method
@Service
public class TrailsService {
    private final TrailsRepository r; // Repository required to call the CRUD operations

    public TrailsService(TrailsRepository r) {
        this.r = r;
    }

    // Create
    public void add(Trail t) {
        r.save(t);
    }

    // Read
    // TODO: 21/04/2020 May need to see about Comparable
    public List<Trail> getTrails() {
        return r.findAll();
    }

    // Read
    public Trail getTrailById(long id) {
        Optional<Trail> t = r.findById(id);
        return t.orElseThrow(() -> new TrailNotFoundException(id));
    }

    // Read
    public Trail getTrailByName(String name) {
        Optional<Trail> t = r.findByName(name);
        return t.orElseThrow(() -> new TrailNotFoundException(name));
    }

    // Update/Create
    // TODO: May need to create methods for specific attributes of trail (e.g. just editing name)
    public void replace(Trail t, long id) {
        r.findById(id)
            .map(trail -> {    // Update
                trail.setName(t.getName());
                return r.save(trail);
            })
            .orElseGet(() -> { // Create
                t.setId(id);
                return r.save(t);
            });
    }

    // Delete
    public void delete(long id) {
        r.deleteById(id);
    }
}