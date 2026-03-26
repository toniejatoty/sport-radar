package com.sportradar.football_calendar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "_event_metadate_id")
    private Event_metadata _event_metadate;
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

    public Integer getId() {
        return id;
    }

    public Event_metadata getEvent_metadate() {
        return _event_metadate;
    }

    public Teams getHomeTeam() {
        return _homeTeam;
    }

    public Teams getAwayTeam() {
        return _awayTeam;
    }

    public Result getResult() {
        return _result;
    }

    public Stage getStage() {
        return _stage;
    }

    public Group getGroup() {
        return _group;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEvent_metadate(Event_metadata _event_metadate) {
        this._event_metadate = _event_metadate;
    }

    public void setHomeTeam(Teams _homeTeam) {
        this._homeTeam = _homeTeam;
    }

    public void setAwayTeam(Teams _awayTeam) {
        this._awayTeam = _awayTeam;
    }

    public void setResult(Result _result) {
        this._result = _result;
    }

    public void setStage(Stage _stage) {
        this._stage = _stage;
    }

    public void setGroup(Group _group) {
        this._group = _group;
    }

}
