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
        Long count = repository.count();
        int size = repository.listAll().size();
        assertEquals(count, size);
        assertEquals(count, repository.listAllArtistsSorted().size());

        Artist artist = new Artist("name", "bio");

        repository.persist(artist);
        assertNotNull(artist.getId());

        assertEquals(count + 1, repository.count());

        artist = repository.findById(artist.getId());
        assertEquals("name", artist.getName());

        repository.deleteById(artist.getId());
        assertEquals(count, repository.count());

    }
}
