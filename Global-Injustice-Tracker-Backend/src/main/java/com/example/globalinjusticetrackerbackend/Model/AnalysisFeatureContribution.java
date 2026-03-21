package com.example.globalinjusticetrackerbackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class AnalysisFeatureContribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "analysis_result_id", nullable = false)
    private AnalysisResult analysisResult;

    @Column(nullable = false, name = "feature_name")
    private String featureName;

    @Column(name = "feature_value")
    private Double featureValue;

    @Column(name = "contribution_score", nullable = false)
    private Double contributionScore;
}
