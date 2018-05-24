package com.el.apps.Bathroom.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class User {
    
    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String username;
    private String salt;
    private String hashedPassword;
    private List<Review> reviews;

    public User() {}
    
    public User(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public User(String username, String first, String middle, String last, String email) {
        this.username = username;
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User { "+
            "\nid=" + id +
            "\nfirstName=" + firstName +
            "\nmiddleName=" + middleName +
            "\nlastName=" + lastName +
            "\nemail=" + email +
            "\nusername=" + username +
            "\nreviews=" + reviews +
            "\n}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    
}
