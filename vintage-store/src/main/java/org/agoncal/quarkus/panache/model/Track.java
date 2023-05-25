package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "t_tracks")
public class Track extends PanacheEntity {
    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public Duration duration;

    @JoinColumn(name = "cd_fk")
    @ManyToOne
    public CD cd;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

}
