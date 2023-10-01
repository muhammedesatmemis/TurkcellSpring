package com.turkcell.spring.first.entities.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductForUpdate {

    @NotBlank(message = "Ürün Id girmek zorunludur.")
    @Size(min=3)
    private int productId;

    @NotBlank(message = "Ürün adı girmek zorunludur.")
    @Size(max= 50)
    private String productName;

    @NotBlank(message = "quantityPerUnit girmek zorunludur.")
    private String quantityPerUnit;

    @NotBlank(message = "unitPrice girmek zorunludur.")
    @DecimalMin(value = "0.0",inclusive = true)
    private double unitPrice;
}
