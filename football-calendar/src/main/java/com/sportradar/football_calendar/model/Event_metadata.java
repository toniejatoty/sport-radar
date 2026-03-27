package com.sportradar.football_calendar.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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

    public Integer getId() {
        return id;
    }

    public Integer getSeason() {
        return season;
    }

    public String getStatus() {
        return status;
    }

    public LocalTime getTimeVenueUTC() {
        return timeVenueUTC;
    }

    public LocalDate getDateVenue() {
        return dateVenue;
    }

    public String getStadium() {
        return stadium;
    }

    public Integer getGroup() {
        return group;
    }

    public String getOriginCompetitionId() {
        return originCompetitionId;
    }

    public String getOriginCompetitionName() {
        return originCompetitionName;
    }

    public String getEvent_descritpion() {
        return event_descritpion;
    }

    public String getVenue_datails() {
        return venue_datails;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimeVenueUTC(LocalTime timeVenueUTC) {
        this.timeVenueUTC = timeVenueUTC;
    }

    public void setDateVenue(LocalDate dateVenue) {
        this.dateVenue = dateVenue;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public void setOriginCompetitionId(String originCompetitionId) {
        this.originCompetitionId = originCompetitionId;
    }

    public void setOriginCompetitionName(String originCompetitionName) {
        this.originCompetitionName = originCompetitionName;
    }

    public void setEvent_descritpion(String event_descritpion) {
        this.event_descritpion = event_descritpion;
    }

    public void setVenue_datails(String venue_datails) {
        this.venue_datails = venue_datails;
    }

            
}