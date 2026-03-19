ALTER TABLE population_history
DROP
COLUMN population;

ALTER TABLE population_history
    ADD population BIGINT NOT NULL;