package com.turkcell.spring.first.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data // getter+setter
@Table(name="categories")
@Entity
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

