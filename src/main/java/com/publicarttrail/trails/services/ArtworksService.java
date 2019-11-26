package com.publicarttrail.trails.services;

import com.publicarttrail.trails.entities.Artwork;
import com.publicarttrail.trails.repositories.ArtworksRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ArtworksService {
    private final ArtworksRepository r;

    public ArtworksService(ArtworksRepository r) {
        this.r = r;
    }

    public List<Artwork> getArtworks() {
        return r.findAll();
    }

    public Artwork getArtworkById(long id) {
        Optional<Artwork> a = r.findById(id);
        return a.orElseThrow(() -> new ArtworkNotFoundException(id));
    }

    public void add(Artwork a) {
        r.save(a);
    }

    public void replace(Artwork a, long id) {
        r.findById(id)
            .map(artwork -> {
                artwork.setName(a.getName());
                artwork.setCreator(a.getCreator());
                artwork.setDescription(a.getDescription());
                artwork.setLatitude(a.getLatitude());
                artwork.setLongitude(a.getLongitude());
                return r.save(artwork);
            })
            .orElseGet(() -> {
                a.setId(id);
                return r.save(a);
            });
    }

    public void delete(long id) {
        r.deleteById(id);
    }
}
