package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="region")
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id")
    private short regionId;

    @Column(name = "region_description")
    private String regionDescription;

    @OneToMany(mappedBy = "region")
    private Territory territories;
}
