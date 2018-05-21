package com.el.apps.Bathroom.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.el.apps.Bathroom.models.Bathroom;
import com.el.apps.Bathroom.repositories.BathroomRepository;

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
    
    @GetMapping("/nearby-bathrooms")
    public Collection<Bathroom> nearbyBathrooms(@RequestParam(value="xCoordinate") float xCoord,
    		@RequestParam(value="yCoordinate") float yCoord){
    	return repository.findByXCoordinateAndYCoordinate(xCoord, yCoord).stream()
    			.collect(Collectors.toList());
    }

    private boolean isGreat(Bathroom Bathroom) {
        return !Bathroom.getName().equals("Budweiser") &&
                !Bathroom.getName().equals("Coors Light") &&
                !Bathroom.getName().equals("PBR");
    }
}