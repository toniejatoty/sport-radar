package com.sportradar.football_calendar.model;
import jakarta.persistence.*;

@Entity 
@Table(name = "scoreByPeriods") 
public class ScoreByPeriods {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "result_id")
    private Result _result;
    private Integer home_team_score;
    private String away_team_score;
    private java.time.LocalDate date; 
    
            }