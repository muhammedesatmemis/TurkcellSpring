package com.turkcell.spring.starter.entities;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "categories")
@Entity
public class Category {

    @Id
    @Column(name= "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy= "category")
    private Product products;
}
