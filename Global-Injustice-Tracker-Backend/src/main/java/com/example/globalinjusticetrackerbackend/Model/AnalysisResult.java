package com.example.globalinjusticetrackerbackend.Model;


import com.example.globalinjusticetrackerbackend.Enum.AnomalyType;
import com.example.globalinjusticetrackerbackend.Enum.Severity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_analysis_result",
                columnNames = {"country_id", "period_start", "period_end", "anomaly_type", "model_version"}
        )
})
public class AnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "public_id")
    private UUID publicId;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(nullable = false, name = "period_start")
    private LocalDate periodStart;

    @Column(nullable = false, name = "period_end")
    private LocalDate periodEnd;


    @Column(nullable = false, name = "anomaly_type")
    @Enumerated(EnumType.STRING)
    private AnomalyType anomalyType;

    @Column(nullable = false, name = "anomaly_score")
    private Double anomalyScore;

    @Column(nullable = false, name = "is_anomaly")
    private Boolean isAnomaly;

    @Column()
    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Column(nullable = false, name = "model_version")
    private String modelVersion;

    @Column(nullable = false, name = "analysed_at")
    private LocalDateTime analysedAt;

    @PrePersist
    protected void onCreate() {
        this.analysedAt = LocalDateTime.now();
        this.publicId = UUID.randomUUID();
    }

    @OneToMany(mappedBy = "analysisResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnalysisFeatureContribution> featureContributions = new ArrayList<>();

    @OneToMany(mappedBy = "analysisResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnalysisNarrative> narratives = new ArrayList<>();





    public AnalysisResult() {}

    public AnalysisResult(Country country, LocalDate periodStart, LocalDate periodEnd, AnomalyType anomalyType, Double anomalyScore, Boolean isAnomaly, Severity severity, String modelVersion) {
        this.country = country;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.anomalyType = anomalyType;
        this.anomalyScore = anomalyScore;
        this.isAnomaly = isAnomaly;
        this.severity = severity;
        this.modelVersion = modelVersion;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public AnomalyType getAnomalyType() {
        return anomalyType;
    }

    public void setAnomalyType(AnomalyType anomalyType) {
        this.anomalyType = anomalyType;
    }

    public Double getAnomalyScore() {
        return anomalyScore;
    }

    public void setAnomalyScore(Double anomalyScore) {
        this.anomalyScore = anomalyScore;
    }

    public Boolean getIsAnomaly() {
        return isAnomaly;
    }

    public void setIsAnomaly(Boolean isAnomaly) {
        this.isAnomaly = isAnomaly;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public LocalDateTime getAnalysedAt() {
        return analysedAt;
    }

    public List<AnalysisNarrative> getNarratives() {
        return narratives;
    }

    public void setNarratives(List<AnalysisNarrative> narratives) {
        this.narratives = narratives;
    }

    public List<AnalysisFeatureContribution> getFeatureContributions() {
        return featureContributions;
    }

    public void setFeatureContributions(List<AnalysisFeatureContribution> featureContributions) {
        this.featureContributions = featureContributions;
    }






}
