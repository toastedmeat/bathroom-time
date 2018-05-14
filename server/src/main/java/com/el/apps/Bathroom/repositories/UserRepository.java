package com.el.apps.Bathroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.el.apps.Bathroom.models.User;

@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String> {
	
	public User findByFirstName(String firstName);
	public List<User> findByLastName(String lastName);
}
