package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.Event_metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Event_metadataRepository extends JpaRepository<Event_metadata, Integer> {
 
}
