package com.example.globalinjusticetrackerbackend.Model;


import com.example.globalinjusticetrackerbackend.Enum.Audience;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AnalysisNarrative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "analysis_result_id", nullable = false)
    private AnalysisResult analysisResult;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Audience audience;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String narrative;

    @Column(name = "generated_at")
    private LocalDateTime generatedAt;

    @PrePersist
    protected void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public AnalysisNarrative() {}

    public AnalysisNarrative(AnalysisResult analysisResult, Audience audience, String narrative) {
        this.analysisResult = analysisResult;
        this.audience = audience;
        this.narrative = narrative;
    }

    public Long getId() {
        return id;
    }

    public AnalysisResult getAnalysisResult() {
        return analysisResult;
    }

    public void setAnalysisResult(AnalysisResult analysisResult) {
        this.analysisResult = analysisResult;
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

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }


}
