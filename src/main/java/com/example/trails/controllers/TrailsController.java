package com.example.trails.controllers;

import com.example.trails.entities.Trail;
import com.example.trails.model.TrailDto;
import com.example.trails.services.TrailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// Controller handles the user inputs. The actual logic lies in the Service layer
@RestController
@RequestMapping("/trails")
public class TrailsController {
    @Autowired
    TrailsService s;

    @GetMapping
    public List<Trail> getTrails() {
        return s.getTrails();
    }
    @PostMapping
    public void postTrails(@RequestBody TrailDto dto) {
        s.add(dto);
    }
    @GetMapping("/{id}")
    public Trail getById(@PathVariable(required = true) long id) {
        return s.getTrailById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        s.delete(id);
    }
}