package com.turkcell.spring.first.controllers;


import com.turkcell.spring.first.business.abstracts.OrderService;
import com.turkcell.spring.first.entities.Order;
import com.turkcell.spring.first.entities.dtos.order.OrderForCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
// localhost:8080/orders/action
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    // localhost:8080/orders
    @GetMapping()
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // localhost:8080/orders/getOrder/10251
    @GetMapping("getOrder/{orderId}")
    public Order getOrder(@PathVariable("orderId") int orderId) {
        return orderService.getOrder(orderId);
    }



    // localhost:8080/orders/addOrder
    // Post
    //    {
    //        "orderId": 500,
    //        "customerId": "Aşil",
    //        "employeeId": 3
    //     }
    @PostMapping("addOrder")
    public ResponseEntity addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return new ResponseEntity("Sipariş eklendi", HttpStatus.CREATED);
    }

    @PostMapping("addOrderExceptions")
    public ResponseEntity addOrder(@RequestBody OrderForCreateDto orderForCreateDto) {
        orderService.addOrderForExceptions(orderForCreateDto);
        return new ResponseEntity("Siparişe gemi ülkesi eklendi", HttpStatus.CREATED);
    }

    // localhost:8080/orders/updateOrder/10248
    // Put
    //    {
    //        "orderId": 10248,
    //        "customerId": "Aşil",
    //     }
    @PostMapping("updateOrder/{orderId}")
    public ResponseEntity updateOrder(@PathVariable("orderId") int orderId,@RequestBody Order updatedOrder) {
        orderService.updateOrder(orderId,updatedOrder);
        return new ResponseEntity("Sipariş gönderildi", HttpStatus.OK);
    }

    // localhost:8080/orders/deleteOrder/2000
    // Delete
    @PostMapping("deleteOrder/{orderId})")
    public ResponseEntity deleteOrder(@PathVariable("orderId") int orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity("Sipariş silindi", HttpStatus.OK);
    }







}
