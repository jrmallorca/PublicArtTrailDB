package com.publicarttrail.trails.preload;

import com.publicarttrail.trails.entities.TrailArtwork;
import com.publicarttrail.trails.repositories.TrailArtworkRepository;
import com.publicarttrail.trails.services.ArtworksService;
import com.publicarttrail.trails.services.TrailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j     // Creates a logger for us
@Component // Allows Spring to find this file
@Transactional
@Order(3)  // Runs before loading artworks
public class LoadTrailArtwork implements CommandLineRunner {
    private final TrailArtworkRepository tar;
    private final TrailsService ts;
    private final ArtworksService as;

    public LoadTrailArtwork(TrailArtworkRepository tar,
                            TrailsService ts,
                            ArtworksService as) {
        this.tar = tar;
        this.ts = ts;
        this.as = as;
    }

    @Override
    public void run(String... args) {
        Set<TrailArtwork> trailArtworks = new HashSet<>();
        int counter = 1;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Tyndall Gates"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Follow Me"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Hollow"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Royal Fort House"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Metal Owl"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("H H Wills Physics Laboratory"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Vertical Garden"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Lizard"),
                counter));

        counter = 1; // New trail
        trailArtworks.add(new TrailArtwork(ts.getTrailByName("Royal Fort Gardens"),
                as.getArtworkByName("Vertical Garden"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("Goldney Hall"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("Manor Hall"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("The White Rabbit"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("Richmond Building"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("Beacon House"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("H H Wills Physics Laboratory"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("Royal Fort House"),
                counter));
        counter++;

        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("Ivy Gate"),
                counter));
        counter++;
        
        trailArtworks.add(new TrailArtwork(ts.getTrailByName("University of Bristol"),
                as.getArtworkByName("Vertical Garden"),
                counter));

        for (TrailArtwork ta : trailArtworks) {
            tar.save(ta);
        }
    }
}
