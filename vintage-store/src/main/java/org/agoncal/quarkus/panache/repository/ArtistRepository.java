package org.agoncal.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.quarkus.jdbc.Artist;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {

}
