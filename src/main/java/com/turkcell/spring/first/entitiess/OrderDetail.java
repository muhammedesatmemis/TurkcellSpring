package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_details")
@Data
public class OrderDetail {
    @ManyToOne()
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "unit_price")
    private float unit_price;

    @Column(name = "quantity")
    private short quantity;

    @Column(name = "discount")
    private float discount;
}

