package com.example.globalinjusticetrackerbackend.Service;

import com.example.globalinjusticetrackerbackend.DTO.PagedResponse;
import com.example.globalinjusticetrackerbackend.Model.Event;
import com.example.globalinjusticetrackerbackend.Repository.EventRepository;
import com.example.globalinjusticetrackerbackend.Specification.EventSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;



@Service
public class EventService {

    private final EventRepository eventRepository;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;

    }

    public PagedResponse<Event> getAllEvents(int page, int size,  String country, LocalDate from, LocalDate to) {

        if (from != null && to != null && from.isAfter(to)) {
            throw new IllegalArgumentException("From must be after to");
        }

        int safeSize = Math.min(size, 100);



        Specification<Event> spec =Specification.where(
                EventSpecification.countryEquals(country)
                .and(EventSpecification.dateOnOrAfter(from))
                .and(EventSpecification.dateOnOrBefore(to)));

        Pageable pageable = PageRequest.of(page, safeSize);
        Page<Event> events = eventRepository.findAll(spec, pageable);

        PagedResponse<Event> response = new PagedResponse<>(events.getContent(), events.getNumber(), events.getSize(),  events.getTotalElements(), events.getTotalPages(), events.hasNext());


        return response;

    }

    






}
