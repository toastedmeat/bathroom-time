package com.el.apps.Bathroom.repositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.el.apps.Bathroom.models.Tag;

@RepositoryRestResource
public interface TagRepository extends MongoRepository<Tag, String> {
    public List<Tag> findByBathroomId(String bathroomId);
    public List<Tag> deleteByBathroomId(String bathroomId);
}
