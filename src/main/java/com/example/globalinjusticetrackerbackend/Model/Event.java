package com.example.globalinjusticetrackerbackend.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String source;
    private String country;
    private LocalDate date;
    private String eventType;
    private LocalDateTime createdAt;

    public Event() {}

    public Event(String source, String country, LocalDate date, String eventType, LocalDateTime createdAt) {}

    public int getId() {
        return id;
    }



    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

    }

    public String toString(String source, String country, LocalDate date, String eventType, LocalDateTime createdAt) {
        return "Event Information: " + "source = " + source + "country = " + country + "date = " + date + "eventType = " + eventType + "createdAt = " + createdAt.toString();
    }




}
