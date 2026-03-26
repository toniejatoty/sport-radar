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
    private Teams winner;
    private String message;

    public Integer getId() {
        return id;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public Teams getWinner() {
        return winner;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void setWinner(Teams _winnerId) {
        this.winner = _winnerId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
