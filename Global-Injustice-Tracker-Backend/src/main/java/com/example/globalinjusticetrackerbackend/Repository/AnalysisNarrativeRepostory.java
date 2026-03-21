package com.example.globalinjusticetrackerbackend.Repository;

import com.example.globalinjusticetrackerbackend.Model.AnalysisFeatureContribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisNarrativeRepostory extends JpaRepository<AnalysisFeatureContribution, Long> {
}
