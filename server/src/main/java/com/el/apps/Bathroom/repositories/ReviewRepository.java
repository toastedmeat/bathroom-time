package com.el.apps.Bathroom.repositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.el.apps.Bathroom.models.Review;

@RepositoryRestResource
public interface ReviewRepository extends MongoRepository<Review, String> {
    public List<Review> findByBathroomId(String bathroomId);
    public List<Review> deleteByBathroomId(String bathroomId);
}
