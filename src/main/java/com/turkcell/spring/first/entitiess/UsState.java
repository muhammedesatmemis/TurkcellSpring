package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="us_states")
@Data
public class UsState {
    @Id
    @Column(name= "state_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short stateId;

    @Column(name= "state_name")
    private String stateName;

    @Column(name= "state_abbr")
    private String stateAbbr;

    @Column(name= "state_region")
    private String stateRegion;
}

