package com.publicarttrail.trails.services;

import com.publicarttrail.trails.entities.Artwork;
import com.publicarttrail.trails.repositories.ArtworksRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

// Implementations of the repository interface methods
@Service
public class ArtworksService {
    private final ArtworksRepository r; // Repository required to call the CRUD operations

    public ArtworksService(ArtworksRepository r) {
        this.r = r;
    }

    // Create
    public void add(Artwork a) {
        r.save(a);
    }

    // Read
    public List<Artwork> getArtworks() {
        return r.findAll();
    }

    // Read
    public Artwork getArtworkById(int id) {
        Optional<Artwork> a = r.findById(id);
        return a.orElseThrow(() -> new ArtworkNotFoundException(id));
    }

    // Read
    public Artwork getArtworkByName(String name) {
        Optional<Artwork> a = r.findByName(name);
        return a.orElseThrow(() -> new ArtworkNotFoundException(name));
    }

    // Update/Create
    // TODO: 21/04/2020 May need to edit for trailArtworks
    public void replace(Artwork a, int id) {
        r.findById(id)
            .map(artwork -> { // Update
                artwork.setName(a.getName());
                artwork.setCreator(a.getCreator());
                artwork.setDescription(a.getDescription());
                artwork.setLatitude(a.getLatitude());
                artwork.setLongitude(a.getLongitude());
                artwork.setImage(a.getImage());
                artwork.setTrailArtwork(a.getTrailArtwork());
                return r.save(artwork);
            })
            .orElseGet(() -> { // Create
                a.setId(id);
                return r.save(a);
            });
    }

    public String imgToBase64(String filename) throws IOException {
        return Base64.getEncoder()
                     .encodeToString(getClass()
                                    .getResourceAsStream("/images/" + filename)
                                    .readAllBytes());
    }

    // Delete
    public void delete(int id) {
        r.deleteById(id);
    }
}
