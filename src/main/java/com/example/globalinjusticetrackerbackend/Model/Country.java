package com.example.globalinjusticetrackerbackend.Model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int population;

    private String continent;

    @ManyToMany(mappedBy="countries")
    private Set<Event> Events = new HashSet<>();

    public Country() {}

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Set<Event> getEvents() {
        return Events;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }



}
