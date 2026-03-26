package com.sportradar.football_calendar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportradar.football_calendar.repository.Event_metadataRepository;
import com.sportradar.football_calendar.repository.EventsRepository;
import com.sportradar.football_calendar.repository.TeamsRepository;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class DataImportService {

    private final TeamsRepository teamRepository;
    private final EventsRepository eventRepository;
    private final Event_metadataRepository event_metadataRepository;
    private final ObjectMapper objectMapper;

    public DataImportService(TeamsRepository teamRepository, EventsRepository eventRepository,
            Event_metadataRepository event_metadataRepository,  ObjectMapper objectMapper) {
        this.teamRepository = teamRepository;
        this.eventRepository = eventRepository;
        this.objectMapper = objectMapper;
        this.event_metadataRepository = event_metadataRepository;
    }

    public void importDataFromJson(String filePath) {
        try {

            System.out.println("Starting import from file: " + filePath);

            
        } catch (Exception e) {
            System.err.println("Import error: " + e.getMessage());
        }
    }
}