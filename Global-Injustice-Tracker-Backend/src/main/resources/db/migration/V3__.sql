ALTER TABLE population_history
    ADD CONSTRAINT unique_country_id_year UNIQUE (country_id, year);