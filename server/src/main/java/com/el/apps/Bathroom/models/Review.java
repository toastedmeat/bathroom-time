package com.el.apps.Bathroom.models;

import org.springframework.data.annotation.Id;

public class Review {
	
	@Id
    private String id;

	private String user_id;
    private String bathroom_id;
    private String rating;
    private String description;
    private Review[] children;

    public Review() {}

    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }
    
    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBathroom_id() {
		return bathroom_id;
	}

	public void setBathroom_id(String bathroom_id) {
		this.bathroom_id = bathroom_id;
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

	public Review[] getChildren() {
		return children;
	}

	public void setChildren(Review[] children) {
		this.children = children;
	}

    @Override
    public String toString() {
        return "Rating { TO DO }";
    }
}
