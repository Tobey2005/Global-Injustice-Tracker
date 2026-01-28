package com.example.globalinjusticetrackerbackend.Specification;

import com.example.globalinjusticetrackerbackend.Model.Event;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;



public class EventSpecification {

    private EventSpecification() {}

    public static Specification<Event> countryEquals(String country) {
        return (root, query, cb) ->{
            if (!StringUtils.hasText(country)) {
                return cb.conjunction();
            }
            return cb.equal(root.get("country"), country);

        };
    }

    public static Specification<Event> dateOnOrAfter (LocalDate from) {
        return (root, query, cb) -> {
            if (from == null) {
                return cb.conjunction();
            }
            return cb.greaterThanOrEqualTo(root.get("date"), from);
        };
    }

    public static Specification<Event> dateOnOrBefore (LocalDate to) {
        return (root, query, cb) -> {
            if (to == null) {
                return cb.conjunction();
            }

            return cb.lessThanOrEqualTo(root.get("date"), to);
        };
    }





}


