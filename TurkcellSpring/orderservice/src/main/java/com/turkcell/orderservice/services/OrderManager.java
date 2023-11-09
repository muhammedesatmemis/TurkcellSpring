package com.turkcell.orderservice.services;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.orderservice.dtos.responses.CreatedOrderResponse;
import com.turkcell.orderservice.entities.Order;
import com.turkcell.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService{
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public Boolean submitOrder(CreateOrderRequest request) {
        Boolean hasStock = webClientBuilder.build()
                .get()
                .uri("http://product-service/api/v1/products/check-stock",
                        (uriBuilder) -> uriBuilder
                                .queryParam("invCode",request.getInventoryCode())
                                .queryParam("requiredStock",request.getAmount())
                                .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        return hasStock;
    }

    @Override
    public CreatedOrderResponse submitOrder2(CreateOrderRequest request) {
        Boolean hasStock = webClientBuilder.build()
                .get()
                .uri("http://product-service/api/v1/products/check-stock",
                        (uriBuilder) -> uriBuilder
                                .queryParam("invCode",request.getInventoryCode())
                                .queryParam("requiredStock",request.getAmount())
                                .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        int getStockAmount = webClientBuilder.build()
                .get()
                .uri("http://product-service/api/v1/products/get-stock",
                        (uriBuilder) -> uriBuilder
                                .queryParam("invCode",request.getInventoryCode())
                                .build())
                .retrieve()
                .bodyToMono(int.class)
                .block();
        short getStockAmountToShort  = (short) getStockAmount;

        Order order = Order.builder()
                .inventoryCode(request.getInventoryCode())
                .amount(request.getAmount())
                .build();
        order = orderRepository.save(order);
        CreatedOrderResponse response = CreatedOrderResponse.builder()
                .orderId(order.getOrderId())
                .inventoryCode(order.getInventoryCode())
                .stockAmount(getStockAmountToShort)
                .hasStock(hasStock)
                .build();
        return response;
    }

    @Override
    public List<CreatedOrderResponse> submitOrder3(List<CreateOrderRequest> request) {
        List<CreatedOrderResponse> responses = new ArrayList<>();
        request.forEach(createOrderRequest -> responses.add(submitOrder2(createOrderRequest)));
        return responses;
    }
}
