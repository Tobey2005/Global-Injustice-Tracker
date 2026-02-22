package com.example.globalinjusticetrackerbackend.Model;


import jakarta.persistence.*;

@Entity
@Table(
        name = "population_history",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_country_year",
                columnNames = {"country_id", "year"}
        )
)
public class PopulationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            nullable = false
    )
    private Country country;
    @Column(nullable = false)
    private int population;

    @Column(nullable = false)
    private int year;

    private String country_code;

    public PopulationHistory() {}

    public PopulationHistory(int population, int year, String country_code) {
        this.population = population;
        this.year = year;
        this.country_code = country_code;
    }

    public Long getId() {
        return id;
    }

    public int getPopulation() {
        return population;
    }

    public int getYear() {
        return year;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

}
