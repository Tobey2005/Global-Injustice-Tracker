package com.example.globalinjusticetrackerbackend.DTO;

import com.example.globalinjusticetrackerbackend.Enum.Audience;

import java.util.UUID;

public class AnalysisNarrativeDTO {

    private UUID analysisResultPublicId;

    private Audience audience;

    private String narrative;

    public AnalysisNarrativeDTO() {}

    public AnalysisNarrativeDTO(UUID analysisResultPublicId, Audience audience, String narrative) {
        this.analysisResultPublicId = analysisResultPublicId;
        this.audience = audience;
        this.narrative = narrative;
    }

    public UUID getAnalysisResultPublicId() {
        return analysisResultPublicId;
    }

    public void setAnalysisResultPublicId(UUID analysisResultPublicId) {
        this.analysisResultPublicId = analysisResultPublicId;
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }




}
