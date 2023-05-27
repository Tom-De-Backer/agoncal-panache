package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.persistence.EntityNotFoundException;
import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class PublisherRepositoryTest {
    @Test
    @TestTransaction
    public void shouldCreateAndFindPublisher() {
        Long count = Publisher.count();
        int size = Publisher.listAll().size();
        assertEquals(count, size);

        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        assertEquals(count + 1, Publisher.count());

        publisher = Publisher.findById(publisher.id);
        publisher = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
        assertEquals("name", publisher.name);
         assertTrue(Publisher.findContainingName("name").size() >= 1);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }

}