package com.example.demo.services.interfaces;

import com.example.demo.models.Order;

import java.util.List;

public interface OrderServiceInterface {
    Order createOrder(Order order);
    List<Order> getAll();
    void deleteOrderById(int id);
}
