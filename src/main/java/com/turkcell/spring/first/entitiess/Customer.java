package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="customers")
@Data
public class Customer {
    @Column(name="customer_id")
    @Id
    private String customerId;

    @ManyToMany(mappedBy= "customer")
    private Order orders;

    @OneToMany(mappedBy= "customer")
    private CustomerCustomerDemo customerCustomerDemos;


    @Column(name="company_name")
    private String companyName;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="contact_title")
    private String contactTitle;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="region")
    private String region;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="country")
    private String country;

    @Column(name="phone")
    private String phone;

    @Column(name="fax")
    private String fax;
}
