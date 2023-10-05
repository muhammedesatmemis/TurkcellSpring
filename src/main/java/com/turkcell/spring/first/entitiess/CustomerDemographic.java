package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="customer_demographics")
@Data
public class CustomerDemographic {
    @Id
    @Column(name = "customer_type_id")
    private String customerTypeId;

    @OneToMany(mappedBy= "customerDemographic")
    private CustomerCustomerDemo customerCustomerDemos;

    @Column(name = "customer_desc")
    private String customerDesc;

}