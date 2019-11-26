package com.publicarttrail.trails;

import com.publicarttrail.trails.entities.Artwork;
import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.repositories.ArtworksRepository;
import com.publicarttrail.trails.repositories.TrailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@Slf4j
class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(TrailsRepository tr) {
        return args -> {
            tr.save(new Trail("Royal Fort Gardens",
                        new Artwork("Hollow",
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
                            -2.600915),
                        new Artwork("Physics Building",
                                "George Oatlay",
                                "This gothic style building -HH Wills Physics Laboratory to give is its full title – was designed by Sir George Oatlay, " +
                                        "who also designed many University edifices including Wills Memorial Building at the top of Park Street. It was the first part of " +
                                        "a conceived series of the gardens under their foundations!\n"
                                        +
                                        "The building was opened in 1927 and used materials that Harry Wills stipulated should be of “such quality that no repairs are " +
                                        "requires for 50 years; hence bronze window frames to avoid rust... the best brick with cement mortar; and Keen’s cement plaster... " +
                                        "as it does not flake like lime”.\n",
                                51.458470,
                                -2.602058)));
            tr.save(new Trail( "Random",
                        new Artwork("Derp", "Idk", "Desc", 51.455842, -2.604503),
                        new Artwork("Herp", "sesfef", "sdfsfsaqw", 51.452305, -2.598946)));
        };
    }
}
