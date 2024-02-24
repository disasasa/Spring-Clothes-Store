package com.example.demo.controllers;

import com.example.demo.models.Clothes;
import com.example.demo.repository.ClothesRepositoryInterface;
import com.example.demo.services.interfaces.ClothesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clothes")
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
}