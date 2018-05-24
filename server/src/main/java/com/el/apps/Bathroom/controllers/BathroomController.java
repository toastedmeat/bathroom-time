package com.el.apps.Bathroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.el.apps.Bathroom.models.Bathroom;
import com.el.apps.Bathroom.repositories.BathroomRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BathroomController {
    
    @Autowired
    private BathroomRepository repository;

    // Get all
    @GetMapping("/bathroom/")
    public ResponseEntity<Collection<Bathroom>> getAllBathrooms() {
        Collection<Bathroom> bathrooms = repository.findAll().stream().collect(Collectors.toList());
        if(bathrooms.isEmpty())
            return new ResponseEntity<Collection<Bathroom>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Collection<Bathroom>>(bathrooms, HttpStatus.OK);
    }
    
    // get single
    @GetMapping("/bathroom/{id}")
    public ResponseEntity<?> getBathroomByBathroomname(@PathVariable("id") String id) {
        Optional<Bathroom> bathroom = repository.findById(id);
        if(!bathroom.isPresent())
            return new ResponseEntity<String>("Bathroom with id { " + id + " }" +
                    " not found", HttpStatus.NO_CONTENT);
        return new ResponseEntity<Bathroom>(bathroom.get(), HttpStatus.OK);
    }
    
    // post
    @PostMapping("/bathroom/")
    public ResponseEntity<?> createBathroom(@RequestBody Bathroom bathroom){
        if(repository.findById(bathroom.getId()) != null)
            return new ResponseEntity<String>("Unable to create bathroom, bathroom with id " +
                    "{ " + bathroom.getId() + " } already exists", HttpStatus.CONFLICT);
        Bathroom newBathroom = repository.save(bathroom);

        return new ResponseEntity<Bathroom>(newBathroom, HttpStatus.CREATED);
    }
    
    // update
    @PutMapping("/bathroom/{id}")
    public ResponseEntity<?> updateBathroom(@PathVariable("id") String id, @RequestBody Bathroom updates){
        Optional<Bathroom> bathroom = repository.findById(id);
        if(!bathroom.isPresent())
            return new ResponseEntity<String>("Bathroom with id { " + id + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        bathroom.get().setName(updates.getName());
        bathroom.get().setLatitude(updates.getLatitude());
        bathroom.get().setLongitude(updates.getLongitude());

        repository.save(bathroom.get());
        return new ResponseEntity<Bathroom>(bathroom.get(), HttpStatus.OK);
    }
    
    // delete single
    @DeleteMapping("/bathroom/{id}")
    public ResponseEntity<?> deleteBathroom(@PathVariable("id") String id){
        Optional<Bathroom> bathroom = repository.findById(id);
        if(!bathroom.isPresent())
            return new ResponseEntity<String>("Bathroom with id { " + id + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        repository.delete(bathroom.get());
        return new ResponseEntity<Bathroom>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/bathroom/nearby")
    public ResponseEntity<Collection<Bathroom>> nearbyBathrooms(@RequestParam(value="latitude") double latitude, 
            @RequestParam(value="longitude") double longitude, @RequestParam(value="range") double range){
        Collection<Bathroom> nearby = repository.findByLatitudeBetweenAndLongitudeBetween(latitude-milesToDegrees(range, true), 
                latitude+milesToDegrees(range,true), longitude-milesToDegrees(range, false), 
                longitude+milesToDegrees(range, false)).stream().collect(Collectors.toList());
        if(nearby.isEmpty())
            return new ResponseEntity<Collection<Bathroom>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Collection<Bathroom>>(nearby, HttpStatus.OK);
    }

    @GetMapping("/bathroom/good")
    public Collection<Bathroom> goodBathrooms() {
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }
    
    private double milesToDegrees(double miles, boolean longitude) {
        if (miles == 0.00) return 0.00;
        return longitude ? miles/55.2428 : miles/69;
    }

    private boolean isGreat(Bathroom Bathroom) {
        return !Bathroom.getName().equals("Budweiser") &&
                !Bathroom.getName().equals("Coors Light") &&
                !Bathroom.getName().equals("PBR");
    }
}