package com.sportradar.football_calendar.model;
import jakarta.persistence.*;

@Entity 
@Table(name = "result") 
public class Result {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private Integer homeGoals;
    private Integer awayGoals;
    @ManyToOne 
    @JoinColumn(name = "_winnerId") 
    private Teams _winnerId;
    private String message;
            }

