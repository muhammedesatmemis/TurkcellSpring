package com.turkcell.spring.first.entities.dtos.order;

import lombok.Data;

import java.util.Date;

@Data
public class OrderForReadDto {


    private int orderId;
    private Date orderDate;
    private Date shippedDate;
    private String shipName;
    private String shipAddress;
}
