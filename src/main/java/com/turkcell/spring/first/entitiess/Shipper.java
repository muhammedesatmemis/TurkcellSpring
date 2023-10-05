package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="shippers")
@Data
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shipper_id")
    private short shipperId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone")
    private String phone;
}
