package com.turkcell.spring.first.entities.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryForUpdateDto {
    @NotBlank(message = "Kategori adı girmek zorunludur.")
    @Size(min=3, message = "kategori alanı minimum 3 karakter olmalıdır.")
    private String categoryName;

    @NotBlank(message = "Açıklama alanı zorunludur.")
    @Size(max= 50)
    private String description;

    @DecimalMin(value = "0.0",inclusive = true)
    @DecimalMax(value = "1.0",inclusive = true)
    private int discontinued;
}
