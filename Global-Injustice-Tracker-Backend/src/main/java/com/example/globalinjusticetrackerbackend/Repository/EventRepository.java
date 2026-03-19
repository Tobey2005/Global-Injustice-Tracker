package com.example.globalinjusticetrackerbackend.Repository;

import com.example.globalinjusticetrackerbackend.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepository extends JpaRepository<Event, Integer>, JpaSpecificationExecutor<Event> {



}
