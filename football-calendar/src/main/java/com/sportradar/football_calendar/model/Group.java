package com.sportradar.football_calendar.model;
import jakarta.persistence.*;

@Entity 
@Table(name = "group") 
public class Group {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private String name;
    
            }