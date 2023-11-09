package com.turkcell.orderservice.services;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.orderservice.dtos.responses.CreatedOrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Boolean submitOrder(CreateOrderRequest request);
    CreatedOrderResponse submitOrder2(CreateOrderRequest request);
    List<CreatedOrderResponse> submitOrder3(List<CreateOrderRequest> request);
}
