package com.el.apps.Bathroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.el.apps.Bathroom.models.User;
import com.el.apps.Bathroom.repositories.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    // Get all
    @GetMapping("/user/")
    public ResponseEntity<Collection<User>> getAllUsers() {
        Collection<User> users = repository.findAll().stream().collect(Collectors.toList());
        if(users.isEmpty())
            return new ResponseEntity<Collection<User>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
    }
    
    // get single
    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
        User user = repository.findByUsernameAllIgnoreCase(username);
        if(user == null)
            return new ResponseEntity<String>("User with username { " + username + " }" +
                    " not found", HttpStatus.NO_CONTENT);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    // post
    @PostMapping("/user/")
    public ResponseEntity<?> createUser(@RequestBody User user){
        if(repository.findByUsernameAllIgnoreCase(user.getUsername()) != null)
            return new ResponseEntity<String>("Unable to create user, user with username " +
                    "{ " + user.getUsername() + " } already exists", HttpStatus.CONFLICT);
        User newUser = repository.save(user);

        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
    
    // update
    @PutMapping("/user/{username}")
    public ResponseEntity<?> updateUser(@PathVariable("username") String username, @RequestBody User updates){
        User user = repository.findByUsernameAllIgnoreCase(username);
        if(user == null)
            return new ResponseEntity<String>("User with username { " + username + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        user.setFirstName(updates.getFirstName());
        user.setMiddleName(updates.getMiddleName());
        user.setLastName(updates.getLastName());
        user.setEmail(updates.getEmail());

        repository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    // delete single
    @DeleteMapping("/user/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username){
        User user = repository.findByUsernameAllIgnoreCase(username);
        if(user == null)
            return new ResponseEntity<String>("User with username { " + username + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        repository.delete(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
    // delete all

    @GetMapping("/user/good-users")
    public Collection<User> goodUsers() {
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    @PostMapping("/user/login")
    public @ResponseBody ResponseEntity<String> login(@RequestParam("user") User user) {
        if(repository.findByUsernameAllIgnoreCase(user.getUsername()) != null) {
            return new ResponseEntity<String>("Login Response", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Login Response", HttpStatus.UNAUTHORIZED);
        }
    }
    
    @PostMapping("/user/register")
    public @ResponseBody ResponseEntity<String> register(@RequestParam("user") User user) {
        repository.save(user);
        return new ResponseEntity<String>("Login Response", HttpStatus.OK);
    }

    private boolean isGreat(User User) {
        return !User.getUsername().equals("Mike") &&
                !User.getUsername().equals("John") &&
                !User.getUsername().equals("Joe");
    }
}