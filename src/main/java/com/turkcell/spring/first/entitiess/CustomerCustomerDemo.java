package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customer_customer_demo")
@Data
public class CustomerCustomerDemo {

    @Id
    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name="customer_type_id")
    private CustomerDemographic customerDemographic;
}
