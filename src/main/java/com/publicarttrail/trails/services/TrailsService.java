package com.publicarttrail.trails.services;

import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.model.TrailDto;
import com.publicarttrail.trails.repositories.TrailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// Implementations of the repository interface methods
@Component
public class TrailsService {
    @Autowired
    TrailsRepository r;

    public void add(TrailDto dto) {
        r.save(toEntity(dto));
    }

    public void delete(long id) {
        r.deleteById(id);
    }

    public List<Trail> getTrails() {
        return (List<Trail>) r.findAll();
    }

    public Trail getTrailById(long id) {
        Optional<Trail> t = r.findById(id);
        return t.orElseThrow(() -> new TrailNotFoundException("Couldn't find a Trail with id: " + id));
    }

    private Trail toEntity(TrailDto dto) {
        Trail t = new Trail();
        t.setName(dto.getName());
        t.setArtworks(dto.getArtworks());
        return t;
    }
}