package com.example.globalinjusticetrackerbackend.Repository;
import com.example.globalinjusticetrackerbackend.Model.PopulationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PopulationHistoryRepository extends JpaRepository<PopulationHistory, Long> {

    @Modifying
    @Query(value = """
            INSERT INTO population_history (country_id, year, population)
            VALUES (:country_id, :year, :population)
            ON CONFLICT (country_id, year)
            DO UPDATE SET population = EXCLUDED.population
            """, nativeQuery = true
    )
    void upsertPopulationHistory(
            @Param("country_id") long country_id,
            @Param("year") int year,
            @Param("population") long population
            );



}
