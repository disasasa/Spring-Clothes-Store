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
}