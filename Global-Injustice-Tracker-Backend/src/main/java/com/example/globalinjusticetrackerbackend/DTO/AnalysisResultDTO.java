package com.example.globalinjusticetrackerbackend.DTO;

import com.example.globalinjusticetrackerbackend.Enum.AnomalyType;
import com.example.globalinjusticetrackerbackend.Enum.Severity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnalysisResultDTO {

    private String countryCode;

    private LocalDate periodStart;

    private LocalDate periodEnd;

    private AnomalyType anomalyType;

    private Double anomalyScore;

    private Boolean isAnomaly;

    private Severity severity;

    private String modelVersion;

    //private List<AnalysisFeatureContributionDTO> featureContributions = new ArrayList<>();


    public AnalysisResultDTO(String countryCode, LocalDate periodStart, LocalDate periodEnd, AnomalyType anomalyType, Double anomalyScore, Boolean isAnomaly, Severity severity, String modelVersion ) {
        this.countryCode = countryCode;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.anomalyType = anomalyType;
        this.anomalyScore = anomalyScore;
        this.isAnomaly = isAnomaly;
        this.severity = severity;
        this.modelVersion = modelVersion;
    }

    public AnalysisResultDTO() {}

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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



}
