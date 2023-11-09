package com.turkcell.orderservice.controllers;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.orderservice.dtos.responses.CreatedOrderResponse;
import com.turkcell.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RequestMapping("api/v1/orders")
@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final WebClient.Builder webClientBuilder;
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Boolean> submitOrder(@RequestBody CreateOrderRequest request)
    {
        boolean hasStock = orderService.submitOrder(request);

        return new ResponseEntity<>(hasStock, hasStock ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
    @PostMapping("isOrderValid")
    public CreatedOrderResponse isOrderValid(@RequestBody CreateOrderRequest request)
    {
        return orderService.submitOrder2(request);
    }
    @PostMapping("isOrderValid2")
    public List<CreatedOrderResponse> isOrderValid2(@RequestBody List<CreateOrderRequest> request)
    {
        return orderService.submitOrder3(request);
    }

}
