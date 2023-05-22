package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Entity;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Entity
public class Publisher extends PanacheEntity {

    // ======================================
    // =             Attributes             =
    // ======================================

    public String name;

    public Instant createdDate = Instant.now();

    // ======================================
    // =           Constructors             =
    // ======================================

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    // ======================================
    // =              Methods               =
    // ======================================
//
//    public static List<Publisher> findContainingName(String name) {
//        return Publisher.list("name like ?1", "%" + name + "%");
//    }
//
//    public static Optional<Publisher> findByName(String name) {
//        return Publisher.find("name", name).firstResultOptional();
//    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", id=" + id +
                '}';
    }
}