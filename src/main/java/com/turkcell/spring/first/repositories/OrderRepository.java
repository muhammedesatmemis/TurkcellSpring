package com.turkcell.spring.first.repositories;

import com.turkcell.spring.first.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}