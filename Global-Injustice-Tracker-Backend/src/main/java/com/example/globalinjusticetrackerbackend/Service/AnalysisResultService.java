package com.example.globalinjusticetrackerbackend.Service;

import com.example.globalinjusticetrackerbackend.DTO.AnalysisResultDTO;
import com.example.globalinjusticetrackerbackend.Model.AnalysisResult;
import com.example.globalinjusticetrackerbackend.Repository.AnalysisResultRepository;
import com.example.globalinjusticetrackerbackend.Repository.CountryRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalysisResultService {

    private final CountryRepository countryRepository;
    private final AnalysisResultRepository analysisResultRepository;

    public AnalysisResultService(CountryRepository countryRepository, AnalysisResultRepository analysisResultRepository) {
        this.countryRepository = countryRepository;
        this.analysisResultRepository = analysisResultRepository;
    }

    public void saveAnalysisResult(AnalysisResultDTO analysisResultDTO) {
        AnalysisResult analysisResult = new AnalysisResult(
                countryRepository.findByCountryCode(analysisResultDTO.getCountryCode()).orElseThrow(() -> new RuntimeException("Country not found")),
                analysisResultDTO.getPeriodStart(),
                analysisResultDTO.getPeriodEnd(),
                analysisResultDTO.getAnomalyType(),
                analysisResultDTO.getAnomalyScore(),
                analysisResultDTO.getIsAnomaly(),
                analysisResultDTO.getSeverity(),
                analysisResultDTO.getModelVersion()
        );

        analysisResultRepository.save(analysisResult);
    }
    @Transactional
    public void saveAllAnalysisResults(List<AnalysisResultDTO> analysisResultDTOList) {
        List<AnalysisResult> analysisResults = analysisResultDTOList.stream()
                .map(dto -> new AnalysisResult(
                        countryRepository.findByCountryCode(dto.getCountryCode()).orElseThrow(() -> new RuntimeException("Country not found")),
                        dto.getPeriodStart(),
                        dto.getPeriodEnd(),
                        dto.getAnomalyType(),
                        dto.getAnomalyScore(),
                        dto.getIsAnomaly(),
                        dto.getSeverity(),
                        dto.getModelVersion()

                ))

                .collect(Collectors.toList());

        analysisResultRepository.saveAll(analysisResults);
    }

    public List<AnalysisResultDTO> getAnalysisResultsForCountry(String countryCode) {

        List<AnalysisResult> analysisResults = analysisResultRepository.findByCountry(countryRepository.findByCountryCode(countryCode).orElseThrow(() -> new RuntimeException("Country not found")));

        List<AnalysisResultDTO> analysisResultDTOList = analysisResults.stream()
                .map(results -> new AnalysisResultDTO(
                        results.getCountry().getCountryCode(),
                        results.getPeriodStart(),
                        results.getPeriodEnd(),
                        results.getAnomalyType(),
                        results.getAnomalyScore(),
                        results.getIsAnomaly(),
                        results.getSeverity(),
                        results.getModelVersion()

                ))

                .collect(Collectors.toList());

        return analysisResultDTOList;
    }
}

