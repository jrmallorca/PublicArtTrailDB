package com.publicarttrail.trails;

import com.publicarttrail.trails.config.TrailJpaConfig;
import com.publicarttrail.trails.entities.Trail;
import com.publicarttrail.trails.repositories.TrailsRepository;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {TrailJpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class HttpRequestTests {

    @Resource
    private TrailsRepository tr;

    @Test
    public void saveTrail_thenGetTrail() {
        Trail t1 = new Trail("Test Trail 1");
        tr.save(t1);

        Optional<Trail> test = tr.findByName("Test Trail 1");
        assertTrue(test.isPresent());
        assertEquals("Test Trail 1", test.get().getName());
    }
}
