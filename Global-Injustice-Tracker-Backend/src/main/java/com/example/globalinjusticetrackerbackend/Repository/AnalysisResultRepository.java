package com.example.globalinjusticetrackerbackend.Repository;

import com.example.globalinjusticetrackerbackend.Model.AnalysisResult;
import com.example.globalinjusticetrackerbackend.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnalysisResultRepository extends JpaRepository<AnalysisResult, Long> {


    List<AnalysisResult> findByCountry(Country country);
    List<AnalysisResult> findByIsAnomalyTrue();
    Optional<AnalysisResult> findByPublicId(UUID analysisResultPublicId);

}
