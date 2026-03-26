package com.sportradar.football_calendar.model;
import jakarta.persistence.*;

@Entity 
@Table(name = "Events") 
public class Events {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    @ManyToOne 
    @JoinColumn(name = "_event_metadate_id") 
    private Integer _event_metadate;
    @ManyToOne 
    @JoinColumn(name = "_homeTeam_id") 
    private Teams _homeTeam;
    @ManyToOne 
    @JoinColumn(name = "_awayTeam_id") 
    private Teams _awayTeam;
    @ManyToOne 
    @JoinColumn(name = "_result_id") 
    private Result _result;
    @ManyToOne 
    @JoinColumn(name = "_stage_id") 
    private Stage _stage;
    @ManyToOne 
    @JoinColumn(name = "_group_id") 
    private Group _group;
              }