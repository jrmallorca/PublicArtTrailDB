package com.publicarttrail.trails.controllers;

import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.services.TrailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller handles the user inputs. The actual logic lies in the Service layer
@RestController
@RequestMapping("/trails")
public class TrailsController {
    private final TrailsService s;

    public TrailsController(TrailsService s) {
        this.s = s;
    }

    @GetMapping
    public List<Trail> getTrails() {
        return s.getTrails();
    }

    @GetMapping("/{id}")
    public Trail getById(@PathVariable int id) {
        return s.getTrailById(id);
    }

    @PostMapping
    public void postTrail(@RequestBody Trail t) {
        s.add(t);
    }

    @PutMapping("/{id}")
    public void replaceTrail(@RequestBody Trail t, @PathVariable int id) {
        s.replace(t, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        s.delete(id);
    }
}