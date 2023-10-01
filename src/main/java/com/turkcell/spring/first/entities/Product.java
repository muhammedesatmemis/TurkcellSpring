package com.turkcell.spring.first.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="products")
@Entity
public class Product {
    @Id
    @Column(name="product_id")
    private int productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="supplier_id")
    private int supplierId;

    @ManyToOne()
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @Column(name="units_on_order")
    private int unitsOnOrder;

    @Column(name="reorder_level")
    private int reorderLevel;

    @Column(name="discontinued")
    private int discontinued;


}
