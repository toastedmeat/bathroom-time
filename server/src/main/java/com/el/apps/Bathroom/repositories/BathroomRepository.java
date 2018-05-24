package com.el.apps.Bathroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.el.apps.Bathroom.models.Bathroom;

@RepositoryRestResource
public interface BathroomRepository extends MongoRepository<Bathroom, String> {
    public Bathroom findByName(String name);
    public List<Bathroom> findByLatitudeAndLongitude(double latitude, double longitude);
    public List<Bathroom> findByLatitudeBetweenAndLongitudeBetween(
        double lowerLatitude, double upperLatitude, double lowerLongitude, double upperLongitude);
}
