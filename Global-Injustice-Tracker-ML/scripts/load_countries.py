from ingestion.population_info import extract_population
from ingestion.transformer import transform_population
from ingestion.uploader import upload_population_data



def run_pipeline():
    print("Starting pipline")

    for year in range(2000, 2027):
        raw_data = extract_population(year)
        
        upload_population_data (raw_data)


    print("population load completed successfully")


if __name__ == "__main__":
    run_pipeline()