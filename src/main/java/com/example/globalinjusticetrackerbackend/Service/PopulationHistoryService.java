package com.example.globalinjusticetrackerbackend.Service;


import com.example.globalinjusticetrackerbackend.DTO.PopulationHistoryDTO;
import com.example.globalinjusticetrackerbackend.Model.Country;
import com.example.globalinjusticetrackerbackend.Model.PopulationHistory;
import com.example.globalinjusticetrackerbackend.Repository.CountryRepository;
import com.example.globalinjusticetrackerbackend.Repository.PopulationHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PopulationHistoryService {

    private final PopulationHistoryRepository populationHistoryRepository;
    private final CountryRepository countryRepository;

    public PopulationHistoryService(PopulationHistoryRepository populationHistoryRepository, CountryRepository countryRepository) {
        this.populationHistoryRepository = populationHistoryRepository;
        this.countryRepository = countryRepository;
    }


    @Transactional
    public void saveAllRows(List<PopulationHistoryDTO> rows) {
        for (PopulationHistoryDTO populationHistoryDTO : rows) {

            Country country = countryRepository
                    .findByCountryCode(populationHistoryDTO.getCountryCode())
                    .orElseGet(() -> {
                        Country newCountry = new Country();
                        newCountry.setCountryCode(populationHistoryDTO.getCountryCode());
                        newCountry.setName(populationHistoryDTO.getCountry());
                        return countryRepository.save(newCountry);
                    });



            populationHistoryRepository.upsertPopulationHistory(
                    populationHistoryDTO.getCountryCode(),
                    populationHistoryDTO.getYear(),
                    populationHistoryDTO.getPopulation());


        }
    }
}
