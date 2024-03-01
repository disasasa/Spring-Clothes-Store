package com.example.demo.controllers;

import com.example.demo.models.Clothes;
import com.example.demo.services.interfaces.ClothesServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Order;

import java.util.List;

@RestController
@RequestMapping("clothes") // http://localhost:8080/clothes
public class ClothesController {
    private final ClothesServiceInterface service;

    public ClothesController(ClothesServiceInterface service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public List<Clothes> getAll() {
        return service.getAll();
    }

    @PostMapping({"/create","/create/"})
    public ResponseEntity<Clothes> createClothes(@RequestBody Clothes clothes) {
        Clothes createdClothes = service.create(clothes);
        if(createdClothes == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
        return new ResponseEntity<>(clothes,HttpStatus.CREATED); // 201
    }

    @GetMapping({"/{clothes_id}","/{clothes_id}/"})
    public ResponseEntity<Clothes> getById(@PathVariable("clothes_id") int id) {
        Clothes student = service.getById(id);
        return new ResponseEntity<>(student,HttpStatus.OK); // 200
    }

    @GetMapping({"/brand/{brand}","/brand/{brand}/"})
    public List<Clothes> getByBrand(@PathVariable("brand") String brand ) {
        return service.getByBrand(brand);
    }

    @GetMapping({"/model/{model}","/model/{model}/"})
    public List<Clothes> getByModel(@PathVariable("model") String model) {
        return service.getByModel(model);
    }

    @GetMapping({"/type/{type}","/type/{type}/"})
    public List<Clothes> getByType(@PathVariable("type") String type) {
        return service.getByType(type);
    }

    @GetMapping({"/color/{color}","/color/{color}/"})
    public List<Clothes> getByColor(@PathVariable("color") String color) {
        return service.getByColor(color);
    }

    @GetMapping({"/size/{size}","/size/{size}/"})
    public List<Clothes> getBySize(@PathVariable("size") String size) {
        return service.getBySize(size);
    }

    @PutMapping({"/update/{clothes_id}","/update/{clothes_id}/"})
    public Clothes updateClothes(@PathVariable("clothes_id") int id, @RequestBody Clothes clothes) {
        return service.updateClothes(id,clothes);
    }

    @DeleteMapping({"/delete/{clothes_id}","/delete/{clothes_id}/"})
    public void deleteClothes(@PathVariable("clothes_id") int id) {
        service.deleteClothes(id);
    }

    @GetMapping({"/price/{lower}/{higher}","/price/{lower}/{higher}/"})
    public List<Clothes> getClothesByPriceDiapason(@PathVariable("lower") int lowerPrice, @PathVariable("higher") int higherPrice) {
        return service.getPriceDiapason(lowerPrice, higherPrice);
    }

}