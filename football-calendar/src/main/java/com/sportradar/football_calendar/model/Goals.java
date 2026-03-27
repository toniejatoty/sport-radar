package com.sportradar.football_calendar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "goals")
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "_result_id")
    private Result _result;
    private Integer minute_scored;
    private String player_name;

}
