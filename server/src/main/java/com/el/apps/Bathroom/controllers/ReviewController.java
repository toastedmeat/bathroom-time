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
import org.springframework.web.bind.annotation.RestController;

import com.el.apps.Bathroom.models.Review;
import com.el.apps.Bathroom.repositories.ReviewRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ReviewController {
    
    @Autowired
    private ReviewRepository repository;
    
    // Get all
    @GetMapping("/review/")
    public ResponseEntity<Collection<Review>> getAllUsers() {
        Collection<Review> reviews = repository.findAll().stream().collect(Collectors.toList());
        if(reviews.isEmpty())
            return new ResponseEntity<Collection<Review>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Collection<Review>>(reviews, HttpStatus.OK);
    }
    
    // get single
    @GetMapping("/review/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable("id") String id) {
        Optional<Review> review = repository.findById(id);
        if(!review.isPresent())
            return new ResponseEntity<String>("Review with id { " + id + " }" +
                    " not found", HttpStatus.NO_CONTENT);
        return new ResponseEntity<Review>(review.get(), HttpStatus.OK);
    }
    
    // post
    @PostMapping("/review/")
    public ResponseEntity<?> createReview(@RequestBody Review review){
        Review newReview = repository.save(review);

        return new ResponseEntity<Review>(newReview, HttpStatus.CREATED);
    }
    
    // update
    @PutMapping("/review/{id}")
    public ResponseEntity<?> updateReview(@PathVariable("id") String id, @RequestBody Review updates){
        Optional<Review> review = repository.findById(id);
        if(!review.isPresent())
            return new ResponseEntity<String>("Review with id { " + id + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        review.get().setRating(updates.getRating());
        review.get().setDescription(updates.getDescription());

        repository.save(review.get());
        return new ResponseEntity<Review>(review.get(), HttpStatus.OK);
    }
    
    // delete single
    @DeleteMapping("/review/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") String id){
        Optional<Review> review = repository.findById(id);
        if(!review.isPresent())
            return new ResponseEntity<String>("Review with id { " + id + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        repository.delete(review.get());
        return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
    }
    
    // delete all by bathroom id
    @DeleteMapping("/review/{bathroomId}")
    public ResponseEntity<?> deleteAllReviewByBathroomId(@PathVariable("bathroomId") String bathroomId){
        List<Review> reviews = repository.findByBathroomId(bathroomId);
        if(reviews.isEmpty())
            return new ResponseEntity<String>("Review with bathroomId { " + bathroomId + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        repository.deleteByBathroomId(bathroomId);
        return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
    }
}