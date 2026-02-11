package com.example.globalinjusticetrackerbackend.Model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String eventType;

    @ManyToMany(mappedBy = "eventTypes")
    private Set<Event> events = new HashSet<>();

    public EventType() {}

    public EventType(String eventType) {
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Set<Event> getEvents() {
        return events;
    }


}
