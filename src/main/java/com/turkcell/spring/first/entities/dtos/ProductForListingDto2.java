package com.turkcell.spring.first.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForListingDto2 {

    private int productId;
    private String productName;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
}

