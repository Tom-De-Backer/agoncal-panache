package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PublisherRepositoryTest {
    @Test
    @TestTransaction
    public void shouldCreateAndFindPublisher() {
        Publisher publisher = new Publisher("name");

        publisher.persist(publisher);
        assertNotNull(publisher.id);

        publisher = publisher.findById(publisher.id);
        assertEquals("name", publisher.name);

    }

}