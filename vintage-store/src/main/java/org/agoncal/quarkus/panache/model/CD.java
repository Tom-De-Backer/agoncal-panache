package org.agoncal.quarkus.panache.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CD extends Item {
    @Column(name = "music_company")
    public String musicCompany;

    @Column(length = 100)
    public String genre;

    @OneToMany(mappedBy = "cd", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    public List<Track> tracks = new ArrayList<>();
}
