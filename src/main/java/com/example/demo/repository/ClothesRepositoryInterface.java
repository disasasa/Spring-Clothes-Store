package com.example.demo.repository;

import com.example.demo.models.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothesRepositoryInterface extends JpaRepository<Clothes, Integer> {
    List<Clothes> findByBrand(String brand);
    List<Clothes> findByModel(String model);
    List<Clothes> findByType(String type);
    List<Clothes> findByColor(String color);
    List<Clothes> findBySize(String size);
    List<Clothes> findClothesByPriceAfterAndPriceBefore(int lowerPrice, int higherPrice);
}
