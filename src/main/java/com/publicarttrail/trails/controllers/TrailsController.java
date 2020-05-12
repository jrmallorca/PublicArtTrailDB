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

    @GetMapping()
    public Trail getById(@RequestParam int id) {
        return s.getTrailById(id);
    }

    @GetMapping()
    public Trail getByName(@RequestParam String name) {
        return s.getTrailByName(name);
    }

    @PostMapping
    public void postTrail(@RequestBody Trail t) {
        s.add(t);
    }

    @PutMapping()
    public void replaceTrail(@RequestParam int id, @RequestBody Trail t) {
        s.replace(t, id);
    }

    @DeleteMapping()
    public void delete(@RequestParam int id) {
        s.delete(id);
    }
}