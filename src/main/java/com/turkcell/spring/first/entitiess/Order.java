package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="orders")
@Data
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToMany()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "required_date")
    private Date requiredDate;

    @Column(name = "shipped_date")
    private Date shippedDate;

    @Column(name = "ship_via")
    private short shipVia;

    @Column(name = "freight")
    private double freight;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_address")
    private String shipAddress;

    @Column(name = "ship_city")
    private String shipCity;

    @Column(name = "ship_region")
    private String shipRegion;

    @Column(name = "ship_postal_code")
    private String shipPostalCode;

    @Column(name = "ship_country")
    private String shipCountry;
}
