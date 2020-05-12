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

    @GetMapping()
    public Artwork getById(@RequestParam int id) {
        return s.getArtworkById(id);
    }

    @GetMapping()
    public Artwork getByName(@RequestParam String name) {
        return s.getArtworkByName(name);
    }

    @PostMapping
    public void postArtwork(@RequestBody Artwork a) {
        s.add(a);
    }

    @PutMapping()
    public void replaceArtwork(@RequestParam int id, @RequestBody Artwork a) {
        s.replace(a, id);
    }

    @DeleteMapping()
    public void delete(@RequestParam int id) {
        s.delete(id);
    }
}
