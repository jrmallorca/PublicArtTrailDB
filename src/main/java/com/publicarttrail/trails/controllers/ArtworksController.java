package com.publicarttrail.trails.controllers;

import com.publicarttrail.trails.entities.Artwork;
import com.publicarttrail.trails.services.ArtworksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller handles the user inputs. The actual logic lies in the Service layer
@RestController
@RequestMapping("/artworks")
public class ArtworksController {
    private final ArtworksService s;

    public ArtworksController(ArtworksService s) {
        this.s = s;
    }

    @GetMapping
    public List<Artwork> getArtworks() {
        return s.getArtworks();
    }

    @GetMapping("/{id}")
    public Artwork getById(@PathVariable int id) {
        return s.getArtworkById(id);
    }

    @PostMapping
    public void postArtwork(@RequestBody Artwork a) {
        s.add(a);
    }

    @PutMapping("/{id}")
    public void replaceArtwork(@RequestBody Artwork a, @PathVariable int id) {
        s.replace(a, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        s.delete(id);
    }
}
