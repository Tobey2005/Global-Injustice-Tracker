package com.example.globalinjusticetrackerbackend.Controller;


import com.example.globalinjusticetrackerbackend.DTO.PagedResponse;
import com.example.globalinjusticetrackerbackend.Model.Event;
import com.example.globalinjusticetrackerbackend.Service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/search_events")
    public PagedResponse<Event> retrieveEvents(@RequestParam(required = false)String country,
                                      @RequestParam(required = false)LocalDate from,
                                      @RequestParam(required = false)LocalDate to,
                                      @RequestParam(defaultValue = "0")int page,
                                      @RequestParam(defaultValue = "20")int size) {

        PagedResponse<Event> result = eventService.getAllEvents(page, size, country, from, to);

        return result;

    }



}
