package com.el.apps.Bathroom.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.apps.Bathroom.models.User;
import com.el.apps.Bathroom.repositories.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/good-users")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public Collection<User> goodUsers() {
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    @PostMapping
    ResponseEntity<?> add(@RequestBody User input) {
        return this.repository
                .map(() -> {
                    User result = repository.save(
                        new User(input.getUsername(), input.getFirstName(), input.getMiddleName()),
                            input.getLastName(), input.getEmail());

                    return ResponseEntity.created(user).build();
                })
                .orElse(ResponseEntity.noContent().build());

    }

    private boolean isGreat(User User) {
        return !User.getUsername().equals("Mike") &&
                !User.getUsername().equals("John") &&
                !User.getUsername().equals("Joe");
    }
}