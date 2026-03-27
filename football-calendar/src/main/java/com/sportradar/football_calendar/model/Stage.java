package com.sportradar.football_calendar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stage")
public class Stage {

    @Id
    private String id;
    private String name;
    private Integer ordering;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

}
