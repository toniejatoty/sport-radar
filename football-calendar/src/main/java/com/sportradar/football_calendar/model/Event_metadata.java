package com.sportradar.football_calendar.model;
import jakarta.persistence.*;

@Entity 
@Table(name = "event_metadate") 
public class Event_metadata {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private Integer season;
    private String status;
    private java.time.LocalTime timeVenueUTC;
    private java.time.LocalDate dateVenue;
    private String stadium;
    @Column(name="[group]")
    private Integer group;
    private String originCompetitionId;
    private String originCompetitionName;
    private String event_descritpion;
    private String venue_datails;

            }