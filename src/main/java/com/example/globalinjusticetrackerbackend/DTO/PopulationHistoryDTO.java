package com.example.globalinjusticetrackerbackend.DTO;

public class PopulationHistoryDTO {

    public String country;
    public int population;
    public int year;
    public String country_code;

    public PopulationHistoryDTO(String country, int population, int year, String country_code) {
        this.population = population;
        this.year = year;
        this.country_code = country_code;
        this.country = country;

    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
