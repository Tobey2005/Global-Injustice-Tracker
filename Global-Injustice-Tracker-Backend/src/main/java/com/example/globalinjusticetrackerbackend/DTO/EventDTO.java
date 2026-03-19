package com.example.globalinjusticetrackerbackend.DTO;

import com.example.globalinjusticetrackerbackend.Model.Country;
import com.example.globalinjusticetrackerbackend.Model.EventType;

import java.time.LocalDate;
import java.util.Set;

public class EventDTO {

    private  Set<Country> countries;
    private  Set<EventType> eventTypes;
    private  String source;
    private  String event;
    private  LocalDate eventDate;

    public EventDTO(Set<Country> countries, Set<EventType> eventTypes, String source, String event, LocalDate eventDate) {
        this.countries = countries;
        this.event = event;
        this.eventDate = eventDate;
        this.source = source;
        this.eventTypes = eventTypes;
    }

    public Set<Country> getCountry() {
        return countries;
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getSource() {return source;}

    public Set<EventType> getEventTypes() {return eventTypes;}

}
