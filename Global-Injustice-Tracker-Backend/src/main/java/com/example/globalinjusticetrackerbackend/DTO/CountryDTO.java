package com.example.globalinjusticetrackerbackend.DTO;

import com.example.globalinjusticetrackerbackend.Model.Country;

public class CountryDTO {

    public String name;
    public long population;
    public String continent;



    public CountryDTO(String name, long population, String continent) {
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

}
