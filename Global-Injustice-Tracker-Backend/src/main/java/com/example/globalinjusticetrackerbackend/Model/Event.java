package com.example.globalinjusticetrackerbackend.Model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String source;
    @ManyToMany
    @JoinTable(
            name = "country_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Set<Country> countries = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Event_EventType",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "event_type_id")
    )
    private Set<EventType> eventTypes = new HashSet<>();

    private LocalDate date;

    private LocalDateTime createdAt;

    public Event() {}

    public Event(String source, Set<Country> countries, LocalDate date, Set<Country> eventTypes, LocalDateTime createdAt) {}

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public Set<Country> getCountry() {
        return countries;
    }

    public void setCountry(Set<Country> countries) {

        this.countries = countries;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EventType> getEventType() {
        return eventTypes;
    }

    public void setEventType(Set<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

    }

    public String toString(String source, Set<Country> country, LocalDate date, String eventType, LocalDateTime createdAt) {
        return "Event Information: " + "source = " + source + "country = " + country + "date = " + date + "eventType = " + eventType + "createdAt = " + createdAt.toString();
    }




}
