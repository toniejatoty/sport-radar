package com.sportradar.football_calendar.model;
import jakarta.persistence.*;

@Entity 
@Table(name = "event_metadata") 
public class Event_metadata {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private Integer season;
    private String status;
    private java.time.LocalTime timeVenueUTC;
    private java.time.LocalDate daneVenue;
    private String stadium;
    private Integer group;
    private String originCompetitionId;
    private String originCompetitionName;
    private String event_description;
    private String venue_details;

            }