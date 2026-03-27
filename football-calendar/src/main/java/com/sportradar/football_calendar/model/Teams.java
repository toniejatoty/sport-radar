package com.sportradar.football_calendar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String officialName;
    private String slug;
    private String abbreviation;
    private String teamCountryCode;
    private Integer stagePosition;
    private String team_information;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setTeamCountryCode(String teamCountryCode) {
        this.teamCountryCode = teamCountryCode;
    }

    public void setStagePosition(Integer stagePosition) {
        this.stagePosition = stagePosition;
    }

    public void setTeam_information(String team_information) {
        this.team_information = team_information;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOfficialName() {
        return officialName;
    }

    public String getSlug() {
        return slug;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getTeamCountryCode() {
        return teamCountryCode;
    }

    public Integer getStagePosition() {
        return stagePosition;
    }

    public String getTeam_information() {
        return team_information;
    }

}
