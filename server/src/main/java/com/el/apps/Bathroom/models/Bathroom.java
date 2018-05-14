package com.el.apps.Bathroom.models;

import org.springframework.data.annotation.Id;

public class Bathroom {

    @Id
    private Long id;
    private String name;

    public Bathroom() {}

    public Bathroom(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bathroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}