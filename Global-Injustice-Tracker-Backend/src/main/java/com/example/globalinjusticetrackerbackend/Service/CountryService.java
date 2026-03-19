package com.example.globalinjusticetrackerbackend.Service;


import com.example.globalinjusticetrackerbackend.DTO.CountryDTO;
import com.example.globalinjusticetrackerbackend.DTO.PopulationHistoryDTO;
import com.example.globalinjusticetrackerbackend.Model.Country;
import com.example.globalinjusticetrackerbackend.Repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void saveAllCountries(List<PopulationHistoryDTO> rows) {

        for (PopulationHistoryDTO populationHistoryDTO : rows) {
            Country country = new Country();
            country.setName (populationHistoryDTO.getCountry());
        }






    }




}
