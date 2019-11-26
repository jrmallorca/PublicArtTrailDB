package com.publicarttrail.trails.controllers;

import com.publicarttrail.trails.entities.Artwork;
import com.publicarttrail.trails.services.ArtworksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artwork")
public class ArtworksController {
    private final ArtworksService s;

    public ArtworksController(ArtworksService s) {
        this.s = s;
    }

    // Aggregate root
    @GetMapping
    public List<Artwork> getArtworks() {
        return s.getArtworks();
    }

    @GetMapping("/{id}")
    public Artwork getById(@PathVariable(required = true) long id) {
        return s.getArtworkById(id);
    }

    @PostMapping
    public void postArtwork(@RequestBody Artwork t) {
        s.add(t);
    }

    @PutMapping("/{id}")
    public void replaceArtwork(@RequestBody Artwork t, @PathVariable long id) {
        s.replace(t, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        s.delete(id);
    }
}
