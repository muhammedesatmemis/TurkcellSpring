package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employee_territories")
@Data
public class EmployeeTerritory {

    @Id
    @ManyToOne()
    @MapsId("employeeId")
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne()
    @MapsId("territoryId")
    @JoinColumn(name = "territory_id")
    private Territory territory;
}
