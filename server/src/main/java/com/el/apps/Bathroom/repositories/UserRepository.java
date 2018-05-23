package com.el.apps.Bathroom.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.el.apps.Bathroom.models.User;

@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsernameAllIgnoreCase(String username);
    public List<User> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);
    public List<User> findByFirstNameAllIgnoreCase(String firstName);
    public List<User> findByLastNameAllIgnoreCase(String lastName);
    public List<User> findByEmailAllIgnoreCase(String email);
}
