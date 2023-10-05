package com.turkcell.spring.first.entities.dtos.order;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderForDeleteDto {


    @NotBlank(message = "orderId  girmek zorunludur.")
    private int orderId;
}
