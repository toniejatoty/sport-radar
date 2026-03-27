package com.sportradar.football_calendar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "secondYellowCards")
public class SecondYellowCards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "_result_id")
    private Result _result;
    private Integer minute;
    private String player_name;

}
