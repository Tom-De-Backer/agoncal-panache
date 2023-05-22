package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.jpa.Customer;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CustomerRepositoryTest {
    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindCustomer() throws SQLException {
        Customer customer = new Customer("first name", "last name", "email");

        repository.persist(customer);
        assertNotNull(customer.getId());

        Customer foundCustomer = repository.findById(customer.getId());
        assertEquals("first name", foundCustomer.getFirstName());

    }

}