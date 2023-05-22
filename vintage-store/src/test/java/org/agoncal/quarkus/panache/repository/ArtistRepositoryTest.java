package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.jdbc.Artist;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindArtist() {
        Artist artist = new Artist("name", "bio");

        repository.persist(artist);
        assertNotNull(artist.getId());

        Artist foundArtist = repository.findById(artist.getId());
        assertEquals("name", foundArtist.getName());

    }
}
