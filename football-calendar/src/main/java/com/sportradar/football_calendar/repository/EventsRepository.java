package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
 
}
