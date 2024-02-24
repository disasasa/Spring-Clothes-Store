package com.example.demo.services;

import com.example.demo.models.Clothes;
import com.example.demo.repository.ClothesRepositoryInterface;
import com.example.demo.services.interfaces.ClothesServiceInterface;
import org.springframework.stereotype.Service;

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

}