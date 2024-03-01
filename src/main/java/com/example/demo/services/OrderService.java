package com.example.demo.services;

import com.example.demo.models.Order;
import com.example.demo.repository.OrderRepositoryInterface;
import com.example.demo.services.interfaces.OrderServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceInterface {
    private final OrderRepositoryInterface repo;

    public OrderService(OrderRepositoryInterface repo) {
        this.repo = repo;
    }

    public Order createOrder(Order order) {
        return repo.save(order);
    }

    @Override
    public List<Order> getAll() {
        return repo.findAll();
    }

    @Override
    public void deleteOrderById(int id) {
        repo.deleteById(id);
    }
}
