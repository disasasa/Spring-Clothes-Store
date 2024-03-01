package com.example.demo.repository;

import com.example.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryInterface extends JpaRepository<Order,Integer> {
}
