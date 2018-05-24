package com.el.apps.Bathroom.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Review {
    
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Bathroom bathroom;
    private String rating;
    private String description;
    private List<Review> children;

    public Review() {}

    public Review(String description, String rating) {
      this.description = description;
      this.rating = rating;
    }

    public Review(String description, String rating, User user, Bathroom bathroom) {
      this.description = description;
      this.rating = rating;
      this.user = user;
      this.bathroom = bathroom;
    }

    public Review(String description, String rating, User user, Bathroom bathroom, List<Review> children) {
      this.description = description;
      this.rating = rating;
      this.user = user;
      this.bathroom = bathroom;
      this.children = children;
    }

    @Override
    public String toString() {
      return "Rating { " +
      "id=" + id +
      "user=" + user +
      "bathroom=" + bathroom +
      "rating=" + rating +
      "description=" + description +
      "children=" + children +
      " }";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getChildren() {
        return children;
    }

    public void setChildren(List<Review> children) {
        this.children = children;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public void setBathroom(Bathroom bathroom) {
        this.bathroom = bathroom;
    }
}
