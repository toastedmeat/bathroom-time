package com.el.apps.Bathroom.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Tag {
    
    @Id
    private String id;
    private String name;
    @DBRef
    private Bathroom bathroom;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public void setBathroom(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

}
