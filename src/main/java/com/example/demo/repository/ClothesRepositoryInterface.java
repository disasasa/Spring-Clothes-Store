package com.example.demo.repository;

import com.example.demo.models.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothesRepositoryInterface extends JpaRepository<Clothes, Integer> {
    List<Clothes> findByBrand(String brand);
}
