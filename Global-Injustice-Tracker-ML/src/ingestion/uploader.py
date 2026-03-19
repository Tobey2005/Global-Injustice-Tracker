import requests

SPRING_BASE_URL = "http://localhost:8080/api/internal/countrypopulation"

def upload_population_data(cleaned_data: list):
    response = requests.post(
        f"{SPRING_BASE_URL}/bulk",
        json = cleaned_data,
        timeout = 30
    )

    if response.status_code != 200:
        raise Exception(
            f"Upload failed: {response.status_code} - {response.text}"

        )
    
    return response.json()


