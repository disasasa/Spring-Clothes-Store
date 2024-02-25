package com.example.demo.services;

import com.example.demo.models.Clothes;
import com.example.demo.repository.ClothesRepositoryInterface;
import com.example.demo.services.interfaces.ClothesServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClothesService implements ClothesServiceInterface {

    private final ClothesRepositoryInterface repo;

    public ClothesService(ClothesRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<Clothes> getAll() {
        return repo.findAll();
    }

    @Override
    public Clothes create(Clothes clothes) {
        return repo.save(clothes);
    }

    @Override
    public Clothes getById(int id) {
        // return clothes by id, otherwise throw 404 error
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // 404
    }

    public List<Clothes> getByBrand(String brand) {
        return repo.findByBrand(brand);
    }

    @Override
    public List<Clothes> getByModel(String model) {
        return repo.findByModel(model);
    }

    @Override
    public List<Clothes> getByType(String type) {
        return repo.findByType(type);
    }

    @Override
    public List<Clothes> getByColor(String color) {
        return repo.findByColor(color);
    }

    @Override
    public List<Clothes> getBySize(String size) {
        return repo.findBySize(size);
    }

    @Override
    public Clothes updateClothes(int id, Clothes clothes) {
        Clothes existedClothes = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // 404
        // extracting clothes by id and changing its properties
        existedClothes.setBrand(clothes.getBrand());
        existedClothes.setModel(clothes.getModel());
        existedClothes.setType(clothes.getType());
        existedClothes.setColor(clothes.getColor());
        existedClothes.setSize(clothes.getSize());
        existedClothes.setPrice(clothes.getPrice());
        // save clothes with new properties
        return repo.save(existedClothes);
    }

    @Override
    public void deleteClothes(int id) {
        // first check if the clothes exist
        repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // 404
        // then delete it
        repo.deleteById(id);
    }

    @Override
    public List<Clothes> getPriceDiapason(int lowerPrice, int higherPrice) {
        return repo.findClothesByPriceAfterAndPriceBefore(lowerPrice,higherPrice);
    }
}