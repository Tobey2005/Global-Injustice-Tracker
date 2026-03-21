package com.example.globalinjusticetrackerbackend.Controller;



import com.example.globalinjusticetrackerbackend.DTO.AnalysisResultDTO;
import com.example.globalinjusticetrackerbackend.DTO.PopulationHistoryDTO;
import com.example.globalinjusticetrackerbackend.Service.AnalysisResultService;
import com.example.globalinjusticetrackerbackend.Service.PopulationHistoryService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class APIController {

    private final PopulationHistoryService populationHistoryService;
    private final AnalysisResultService analysisResultService;

    public APIController(PopulationHistoryService populationHistoryService, AnalysisResultService analysisResultService) {
        this.populationHistoryService = populationHistoryService;
        this.analysisResultService = analysisResultService;
    }



    @PostMapping("/internal/countrypopulation/bulk")
    public ResponseEntity<Void> uploadPopulationHistory(@RequestBody List<PopulationHistoryDTO> rows) {

        populationHistoryService.saveAllRows(rows);


        return ResponseEntity.ok().build();
    }

    @PostMapping("/internal/analysisresults/bulk")
    public ResponseEntity<Void> uploadAnalysisResult(@RequestBody List<AnalysisResultDTO> rows) {

        analysisResultService.saveAllAnalysisResults(rows);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/public/analysisresults")
    public ResponseEntity<List<AnalysisResultDTO>> getAnalysisResults(@RequestParam String countryCode) {
        List<AnalysisResultDTO> analysisResultList = analysisResultService.getAnalysisResultsForCountry(countryCode);

        return ResponseEntity.ok(analysisResultList);
    }




}
