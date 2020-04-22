package com.publicarttrail.trails.preload;

import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.entities.TrailArtwork;
import com.publicarttrail.trails.services.ArtworksService;
import com.publicarttrail.trails.services.TrailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j     // Creates a logger for us
@Component // Allows Spring to find this file
@Transactional
@Order(2)  // Runs before loading artworks
class LoadTrails implements CommandLineRunner {
    private final TrailsService ts;
    private final ArtworksService as;

    public LoadTrails(TrailsService ts, ArtworksService as) {
        this.ts = ts;
        this.as = as;
    }

    @Override
    public void run(String... args) {
        log.info("Preloading trail: Royal Fort Gardens");
        ts.add(new Trail("Royal Fort Gardens",
                new TrailArtwork(as.getArtworkByName("Tyndall Gates"), 1),
                new TrailArtwork(as.getArtworkByName("Follow Me"), 2),
                new TrailArtwork(as.getArtworkByName("Hollow"), 3),
                new TrailArtwork(as.getArtworkByName("Royal Fort House"), 4),
                new TrailArtwork(as.getArtworkByName("Metal Owl"), 5),
                new TrailArtwork(as.getArtworkByName("H H Wills Physics Laboratory"), 6),
                new TrailArtwork(as.getArtworkByName("Vertical Garden"), 7),
                new TrailArtwork(as.getArtworkByName("Lizard"), 8)));

        log.info("Preloading trail: University of Bristol");
        ts.add(new Trail("University of Bristol",
                new TrailArtwork(as.getArtworkByName("Goldney Hall"), 1),
                new TrailArtwork(as.getArtworkByName("Manor Hall"), 2),
                new TrailArtwork(as.getArtworkByName("The White Rabbit"), 3),
                new TrailArtwork(as.getArtworkByName("Richmond Building"), 4),
                new TrailArtwork(as.getArtworkByName("Beacon House"), 5),
                new TrailArtwork(as.getArtworkByName("H H Wills Physics Laboratory"), 6),
                new TrailArtwork(as.getArtworkByName("Royal Fort House"), 7),
                new TrailArtwork(as.getArtworkByName("Ivy Gate"), 8),
                new TrailArtwork(as.getArtworkByName("Vertical Garden"), 9)));
    }
}
