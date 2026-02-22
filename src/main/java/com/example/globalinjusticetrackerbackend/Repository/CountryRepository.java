package com.example.globalinjusticetrackerbackend.Repository;

import com.example.globalinjusticetrackerbackend.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Modifying
    @Query(value = """
        INSERT INTO country (name, continent) 
        VALUES (:name, :continent)
        ON CONFLICT (name, continent)
        DO UPDATE SET country = EXCLUDED.country
    """, nativeQuery = true)
    void upsertCountry(@Param("name") String name, @Param("continent") String continent);


    Optional<Country> findByCountryCode(String name);
}


