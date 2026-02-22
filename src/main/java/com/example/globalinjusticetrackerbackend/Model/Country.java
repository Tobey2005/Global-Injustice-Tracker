package com.example.globalinjusticetrackerbackend.Model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "country",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_country",
                columnNames = {"name", "continent"}
        )
)
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String countryCode;



    private String continent;

    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch =  FetchType.LAZY
    )


    private Set<PopulationHistory> populationHistory;

    @ManyToMany(mappedBy="countries")
    private Set<Event> Events = new HashSet<>();

    public Country() {}

    public Country(String name, String countryCode, String continent) {
        this.name = name;
        this.continent = continent;
        this.countryCode = countryCode;

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

    public Set<Event> getEvents() {
        return Events;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }





}
