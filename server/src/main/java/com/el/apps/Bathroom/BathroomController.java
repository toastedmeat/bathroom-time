package com.el.apps.Bathroom;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class BathroomController {
    private BathroomRepository repository;

    public BathroomController(BathroomRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/good-bathrooms")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public Collection<Bathroom> goodBathrooms() {
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Bathroom Bathroom) {
        return !Bathroom.getName().equals("Budweiser") &&
                !Bathroom.getName().equals("Coors Light") &&
                !Bathroom.getName().equals("PBR");
    }
}