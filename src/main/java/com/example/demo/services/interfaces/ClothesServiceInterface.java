package com.example.demo.services.interfaces;
import com.example.demo.models.Clothes;

import java.util.List;

public interface ClothesServiceInterface  {
    List<Clothes> getAll(); // get all clothes
    Clothes create(Clothes clothes); // create new clothes
    Clothes getById(int id); // return clothes by id
    List<Clothes> getByBrand(String brand); // return clothes by brand
    List<Clothes> getByModel(String model); // return clothes by model
    List<Clothes> getByType(String Type); // return clothes by type
    List<Clothes> getByColor(String color); // return clothes by color
    List<Clothes> getBySize(String size); // return clothes by size
}