package com.example.demo.services.interfaces;
import com.example.demo.models.Clothes;

import java.util.List;

public interface ClothesServiceInterface  {
    List<Clothes> getAll(); // get all clothes
    Clothes create(Clothes clothes); // create new clothes
    Clothes getById(int id); // return clothes by id
    List<Clothes> getByBrand(String brand); // return clothes by brand
}