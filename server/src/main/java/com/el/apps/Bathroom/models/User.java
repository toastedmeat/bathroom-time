package com.el.apps.Bathroom.models;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String username;

    public User() {}

    public User(String username, String first, String middle, String last, String email) {
        this.username = username;
        this.firstName = first;
        this.middleName = middle;
        this.lastName = last;
        this.email = email;
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

    @Override
    public String toString() {
        return "User{ TO DO } ";
    }
}
