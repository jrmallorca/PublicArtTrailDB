package com.publicarttrail.trails.preload;

import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.services.ArtworksService;
import com.publicarttrail.trails.services.TrailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j     // Creates a logger for us
@Component // Allows Spring to find this file
@Order(2)  // Runs before loading artworks
class LoadTrails implements CommandLineRunner {
    private final TrailsService ts;

    public LoadTrails(TrailsService ts) {
        this.ts = ts;
    }

    @Override
    public void run(String... args) {
        log.info("Preloading trail: Royal Fort Gardens");
        ts.add(new Trail("Royal Fort Gardens"));

        log.info("Preloading trail: University of Bristol");
        ts.add(new Trail("University of Bristol"));
    }
}
