package com.publicarttrail.trails.services;

import com.publicarttrail.trails.entities.Artwork;
import com.publicarttrail.trails.repositories.ArtworksRepository;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

// Implementations of the repository interface methods
@Service
public class ArtworksService {
    private final ArtworksRepository r; // Repository required to call the CRUD operations

    public ArtworksService(ArtworksRepository r) {
        this.r = r;
    }

    // Create
    public void add(Artwork a) {
        r.save(a);
    }

    // Read
    public List<Artwork> getArtworks() {
        return r.findAll();
    }

    // Read
    public Artwork getArtworkById(long id) {
        Optional<Artwork> a = r.findById(id);
        return a.orElseThrow(() -> new ArtworkNotFoundException(id));
    }

    // Update/Create
    // TODO: May need to create methods for specific attributes of artwork (e.g. just editing name)
    public void replace(Artwork a, long id) {
        r.findById(id)
            .map(artwork -> { // Update
                artwork.setName(a.getName());
                artwork.setCreator(a.getCreator());
                artwork.setDescription(a.getDescription());
                artwork.setLatitude(a.getLatitude());
                artwork.setLongitude(a.getLongitude());
                artwork.setTrail(a.getTrail());
                return r.save(artwork);
            })
            .orElseGet(() -> { // Create
                a.setId(id);
                return r.save(a);
            });
    }

    public byte[] imgToBytes(String pathname) {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File(pathname));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(bImage, "png", bos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] data = bos.toByteArray();
        return data;
    }

    // Delete
    public void delete(long id) {
        r.deleteById(id);
    }
}
