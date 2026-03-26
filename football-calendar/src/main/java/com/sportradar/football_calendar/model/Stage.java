package com.sportradar.football_calendar.model;
import jakarta.persistence.*;

@Entity 
@Table(name = "stage") 
public class Stage {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    private String name;
    private Integer ordering;
    
            }