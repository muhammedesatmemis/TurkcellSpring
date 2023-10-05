package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="products")
@Data

public class Product {
    @Column(name="product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short productID;

    @Column(name="product_name")
    private String productName;  //varchar=string


    @ManyToMany
    @JoinColumn(name="supplier_id")
    private Supplier supplier;


    @ManyToMany
    @JoinColumn(name="category_id")
    private Category category;


    @Column(name="quantity_per_unit")
    private String quantityPerUnit;


    @Column(name="unit_price")
    private float unitPrice;


    @Column(name="units_in_stock")
    private short unitsInStock;


    @Column(name="units_on_order")
    private short unitsOnOrder;


    @Column(name="reorder_level")
    private short reorderLevel;


    @Column(name="discontinued")
    private int discontinued;

    @Column(name="quantity_unit")
    private String quantityUnit;
}
