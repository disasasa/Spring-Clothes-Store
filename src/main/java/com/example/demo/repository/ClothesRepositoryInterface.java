package com.example.demo.repository;

import com.example.demo.models.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepositoryInterface extends JpaRepository<Clothes, Integer> {
}
