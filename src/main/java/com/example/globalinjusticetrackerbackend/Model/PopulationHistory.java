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
    private long population;

    @Column(nullable = false)
    private int year;


    public PopulationHistory() {}

    public PopulationHistory(int population, int year) {
        this.population = population;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public long getPopulation() {
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

}
