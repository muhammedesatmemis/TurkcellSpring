package com.turkcell.orderservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatedOrderResponse {
    private short orderId;
    private String inventoryCode;
    private short stockAmount;
    private Boolean hasStock;
}
