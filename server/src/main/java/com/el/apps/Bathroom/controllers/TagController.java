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

import com.el.apps.Bathroom.models.Tag;
import com.el.apps.Bathroom.repositories.TagRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TagController {
    
    @Autowired
    private TagRepository repository;
    
    // Get all
    @GetMapping("/tag/")
    public ResponseEntity<Collection<Tag>> getAllUsers() {
        Collection<Tag> tags = repository.findAll().stream().collect(Collectors.toList());
        if(tags.isEmpty())
            return new ResponseEntity<Collection<Tag>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<Collection<Tag>>(tags, HttpStatus.OK);
    }
    
    // get single
    @GetMapping("/tag/{{id}}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("id") String id) {
        Optional<Tag> tag = repository.findById(id);
        if(!tag.isPresent())
            return new ResponseEntity<String>("Tag with {id} { " + id + " }" +
                    " not found", HttpStatus.NO_CONTENT);
        return new ResponseEntity<Tag>(tag.get(), HttpStatus.OK);
    }
    
    // post
    @PostMapping("/tag/")
    public ResponseEntity<?> createUser(@RequestBody Tag tag){
        if(repository.findById(tag.getId()) != null)
            return new ResponseEntity<String>("Unable to create tag, tag with id " +
                    "{ " + tag.getId() + " } already exists", HttpStatus.CONFLICT);
        Tag newUser = repository.save(tag);

        return new ResponseEntity<Tag>(newUser, HttpStatus.CREATED);
    }
    
    // update
    @PutMapping("/tag/{{id}}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody Tag updates){
        Optional<Tag> tag = repository.findById(id);
        if(tag == null)
            return new ResponseEntity<String>("Tag with id { " + id + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        tag.get().setName(updates.getName());

        repository.save(tag.get());
        return new ResponseEntity<Tag>(tag.get(), HttpStatus.OK);
    }
    
    // delete single
    @DeleteMapping("/tag/{{id}}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
        Optional<Tag> tag = repository.findById(id);
        if(!tag.isPresent())
            return new ResponseEntity<String>("Tag with {id} { " + id + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        repository.delete(tag.get());
        return new ResponseEntity<Tag>(HttpStatus.NO_CONTENT);
    }
    
    // delete all by bathroom id
    @DeleteMapping("/review/{bathroomId}")
    public ResponseEntity<?> deleteAllTagsByBathroomId(@PathVariable("bathroomId") String bathroomId){
        List<Tag> tags = repository.findByBathroomId(bathroomId);
        if(tags.isEmpty())
            return new ResponseEntity<String>("Tags with bathroomId { " + bathroomId + " }" +
                    " not found", HttpStatus.NOT_FOUND);
        repository.deleteByBathroomId(bathroomId);
        return new ResponseEntity<Tag>(HttpStatus.NO_CONTENT);
    }
}