package com.publicarttrail.trails.services;

import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.repositories.TrailsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// Implementations of the repository interface methods
@Component
public class TrailsService {
    private final TrailsRepository r;

    public TrailsService(TrailsRepository r) {
        this.r = r;
    }

    public List<Trail> getTrails() {
        return r.findAll();
    }

    public Trail getTrailById(long id) {
        Optional<Trail> t = r.findById(id);
        return t.orElseThrow(() -> new TrailNotFoundException(id));
    }

    public void add(Trail t) {
        r.save(t);
    }

    public void replace(Trail t, long id) {
        r.findById(id)
            .map(trail -> {
                trail.setName(t.getName());
                trail.setArtworks(t.getArtworks());
                return r.save(trail);
            })
            .orElseGet(() -> {
                t.setId(id);
                return r.save(t);
            });
    }

    public void delete(long id) {
        r.deleteById(id);
    }
}