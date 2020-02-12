package com.publicarttrail.trails.preload;

import com.publicarttrail.trails.entities.Artwork;
import com.publicarttrail.trails.services.ArtworksService;
import com.publicarttrail.trails.services.TrailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // Allows Spring to find this file
@Slf4j     // Creates a logger for us
@Order(2)  // Runs after loading trails
class LoadArtworks implements CommandLineRunner {
    private final TrailsService ts;
    private final ArtworksService as;

    public LoadArtworks(TrailsService ts, ArtworksService as) {
        this.ts = ts;
        this.as = as;
    }

    @Override
    public void run(String... args) throws IOException {
        log.info("Preloading artwork: Tyndall Gates");
        as.add(new Artwork(
                "Tyndall Gates",
                "Humphry Repton",
                "English landscape designer Humphry Repton laid out the main garden in 1800. It is almost impossible to visualize, but in Repton’s " +
                        "time the driveway swept uninterrupted from this point, down through open parklands to Queens Road. These wrought iron gates and stone " +
                        "pillars gates (grate 2 listed) stood at that point; but were relocated.\n\n"
                        +
                        "This lists status identifies the feature as mid to late 18th century, having large square rusticated piers and spear-headed railings and " +
                        "attached gates.\n\n"
                        +
                        "The main gates are permanently open, but there is an ambition to make them operational again.\n\n",
                51.458417,
                -2.603188,
                ts.getTrailById(1),
                as.imgToBase64("error_image.png")));

        log.info("Preloading artwork: Physics Building");
        as.add(new Artwork(
                "Physics Building",
                "George Oatlay",
                "This gothic style building -HH Wills Physics Laboratory to give is its full title – was designed by Sir George Oatlay, " +
                        "who also designed many University edifices including Wills Memorial Building at the top of Park Street. It was the first part of " +
                        "a conceived series of the gardens under their foundations!\n"
                        +
                        "The building was opened in 1927 and used materials that Harry Wills stipulated should be of “such quality that no repairs are " +
                        "requires for 50 years; hence bronze window frames to avoid rust... the best brick with cement mortar; and Keen’s cement plaster... " +
                        "as it does not flake like lime”.\n",
                51.458470,
                -2.602058,
                ts.getTrailById(1),
                as.imgToBase64("physics_building.png")));

        log.info("Preloading artwork: Hollow");
        as.add(new Artwork(
                "Hollow",
                "Katie Paterson",
                "In 2016 a new public artwork called ‘Hollow’, made from tree sample form across the world was installed within Royal Fort Garden. " +
                        "‘Hollow’ was commissioned to mark the opening of the University’s Life Sciences building in 2016 and is produced by Bristol-based " +
                        "public art producers, Situations.\n"
                        +
                        "Created by artist, Katie Paterson, the sample took three years to amass, many of which have been donated by private collectors, " +
                        "arboretums and botanic gardens across the world. Over 10,000 unique tree species have been gathered spanning millions of years, " +
                        "representing a miniature forest of all the world’s forests and telling the history of the planet through the immensity of tree " +
                        "specimens. \n",
                51.457470,
                -2.600915,
                ts.getTrailById(1),
                as.imgToBase64("hollow.png")));

        log.info("Preloading artwork: Follow Me");
        as.add(new Artwork(
                "Follow Me",
                "Jeppe Hein",
                "In 2009 a new public sculpture by internationally acclaimed artist, Jeppe Hein, was unveiled as part of the University’s centenary celebrations. " +
                        "Entitled “Follow Me’, the work is permanently sited in Royal Fort Gardens. The artwork was produced by Bristol-based public art producers, " +
                        "Situations.\n\n"
                        +
                        "The artwork comprises a square labyrinth of 76 vertical polished steel plates sited at the base of an incline leading down from Royal Fort " +
                        "House. Visitors are encouraged to enter the labyrinth to experience the effect of the work. Jeppe Hein was inspired by the history of the " +
                        "gardens-particularly the designs of 18th-century landscape Repton.\n\n",
                51.457620,
                -2.602613,
                ts.getTrailById(1),
                as.imgToBase64("follow_me.png")));

        log.info("Preloading artwork: Lizard");
        as.add(new Artwork(
                "Lizard",
                "Metalgnu",
                "N/A",
                51.458830,
                -2.600851,
                ts.getTrailById(1),
                as.imgToBase64("lizard.png")));

        log.info("Preloading artwork: Vertical Garden");
        as.add(new Artwork(
                "Vertical Garden",
                "N/A",
                "N/A",
                51.458858,
                -2.600813,
                ts.getTrailById(1),
                as.imgToBase64("vertical_garden.png")));

        log.info("Preloading artwork: Royal Fort House");
        as.add(new Artwork(
                "Royal Fort House",
                "Thomas Tyndall",
                "Royal fort house was built in 1758-62 on the site of a Civil War fortification for Thomas Tyndall, a wealthy Bristol merchant, and his " +
                        "young wife Alicia.\n\n"
                        +
                        "Its three facades in three different classical styles: Baroque, Palladian and Rococo, were a compromise after three separate architects: " +
                        "Thomas Paty, John Wallis and James Bridges, had submitted designs. Bridges ultimately pulled the three together with a wooden model that " +
                        "survives in the house. Thomas Paty's firm actually built the house, creating brilliantly figurative Rococo plaster work and wood carving " +
                        "for the reception rooms, but it was Alicia who projected the Paty team of craftsmen into this poetic invention.\n\n",
                51.458318,
                -2.603357,
                ts.getTrailById(1),
                as.imgToBase64("royal_fort_house.png")));

        log.info("Preloading artwork: Metal Owl");
        as.add(new Artwork(
                "Metal Owl",
                "Metalgnu",
                "N/A",
                51.457987,
                -2.602257,
                ts.getTrailById(1),
                as.imgToBase64("owl.png")));
    }
}
