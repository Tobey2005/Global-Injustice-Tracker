package com.example.globalinjusticetrackerbackend.DTO;

import java.time.LocalDate;

public class EventDTO {

    private final String country;
    private final String event;
    private final LocalDate eventDate;

    public EventDTO(String country, String event, LocalDate eventDate) {
        this.country = country;
        this.event = event;
        this.eventDate = eventDate;
    }

    public String getCountry() {
        return country;
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

}
