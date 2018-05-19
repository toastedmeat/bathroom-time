package com.el.apps.Bathroom.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @PostMapping("/login")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public @ResponseBody ResponseEntity<String> login(@RequestParam("user") User user) {
        return new ResponseEntity<String>("Login Response", HttpStatus.OK);
    }

    private boolean isGreat(User User) {
        return !User.getUsername().equals("Mike") &&
                !User.getUsername().equals("John") &&
                !User.getUsername().equals("Joe");
    }
}