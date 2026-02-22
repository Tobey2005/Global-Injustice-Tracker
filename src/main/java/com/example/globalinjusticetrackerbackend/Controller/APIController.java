package com.example.globalinjusticetrackerbackend.Controller;


import com.example.globalinjusticetrackerbackend.DTO.CountryDTO;
import com.example.globalinjusticetrackerbackend.DTO.PopulationHistoryDTO;
import com.example.globalinjusticetrackerbackend.Service.CountryService;
import com.example.globalinjusticetrackerbackend.Service.PopulationHistoryService;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class APIController {

    private final PopulationHistoryService populationHistoryService;

    public APIController(PopulationHistoryService populationHistoryService) {
        this.populationHistoryService = populationHistoryService;
    }



    @PostMapping("/internal/countrypopulation")
    public ResponseEntity<Void> uploadPopulationHistory(@RequestBody List<PopulationHistoryDTO> rows) {

        populationHistoryService.saveAllRows(rows);


        return ResponseEntity.ok().build();
    }
}
