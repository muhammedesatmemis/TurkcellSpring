package com.turkcell.spring.first.business.concretes;

import com.turkcell.spring.first.business.abstracts.OrderService;
import com.turkcell.spring.first.business.exceptions.BusinessException;
import com.turkcell.spring.first.entities.Order;
import com.turkcell.spring.first.entities.dtos.order.OrderForCreateDto;
import com.turkcell.spring.first.entities.dtos.order.OrderForDeleteDto;
import com.turkcell.spring.first.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderManager implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrder(int orderId, Order order) {
        updateOrderIsExist(orderId);

        Order existingOrder = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Sipariş bulunamadı"));
        existingOrder.setCustomerId(order.getCustomerId());
        return orderRepository.save(existingOrder);
    }

    @Override
    public Order getOrder(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Sipariş bulunamadı"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    private void updateOrderIsExist(int orderId) {
        Optional<Order> isExistOrder = orderRepository.findById(orderId);
        if (isExistOrder == null) {
            throw new BusinessException("Girilen Id de güncellenecek sipariş bulıunamadı.");
        }
    }
    @Override
    public void addOrderForExceptions(@NotNull OrderForCreateDto orderForCreateDto) {
        shipAddressIsNotEmpty(orderForCreateDto);
        shipCountryShouldNotBeEmpty(orderForCreateDto.getShipCountry());
        Order order = new Order();
        order.setShipCountry(orderForCreateDto.getShipCountry());
    }


    private void shipCountryShouldNotBeEmpty(String shipCountry) {
        if (shipCountry == null || shipCountry.trim().isEmpty()) {
            throw new BusinessException("Gemi Ülke alanı hiçbir şekilde boş bırakılamaz.");
        }

    }

    private void shipAddressIsNotEmpty(OrderForCreateDto orderForCreateDto) {
        if (orderForCreateDto.getShipAddress() != null)
            throw new BusinessException("Şehir adresi boş olamaz.");
    }

}