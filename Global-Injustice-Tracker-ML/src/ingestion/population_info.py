import requests
import json
from pathlib import Path
import wbgapi as wb

RAW_FOLDER = Path(__file__).parent / "raw"

def extract_population(year):

    name_code = get_country_names()
    
    
    
    raw = list(wb.data.fetch(
        'SP.POP.TOTL',
        time = year,
        skipAggs = True
        ))

    data = []

    for e in raw:
        e['time'] = int(''.join(filter(str.isdigit, e['time'])))
        data.append({
            "country_code" : e['economy'], 
            "country" : name_code[e['economy']], 
            "population" : e['value'], 
            "year" : e['time']})

    #RAW_FOLDER.mkdir(exist_ok=True)
    #with open(RAW_FOLDER / f"population_{year}.json", "w", encoding="utf-8") as f:
       # json.dump(data, f, indent = 2)

    print(data)


    return data


def get_country_names():
    country_names = wb.economy.list(skipAggs=True)
    
    return {c['id']:c['value'] for c in country_names}

    




extract_population(2020)


    
    

    