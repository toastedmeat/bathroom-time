package com.el.apps.Bathroom.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.el.apps.Bathroom.models.Bathroom;

@RepositoryRestResource
public interface BathroomRepository extends MongoRepository<Bathroom, String> {
}
