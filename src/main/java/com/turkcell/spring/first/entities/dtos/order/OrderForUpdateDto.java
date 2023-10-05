package com.turkcell.spring.first.entities.dtos.order;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class OrderForUpdateDto {

    @Id
    private int orderId;
    private Date orderDate;
    private Date shippedDate;
    private String shipName;
    private String shipAddress;
}
