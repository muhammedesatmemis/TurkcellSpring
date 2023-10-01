package com.turkcell.spring.first.entities.dtos;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForListingDto {
    @Id
    private int categoryId;
    private String categoryName;
}
