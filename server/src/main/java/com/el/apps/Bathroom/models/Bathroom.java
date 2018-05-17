package com.el.apps.Bathroom.models;

import org.springframework.data.annotation.Id;

public class Bathroom {

    @Id
    private String id;
    private String name;
    private String xCoordinate;
    private String yCoordinate;
    private Review[] reviews;
    private double rating;

    public Bathroom() {}

    public Bathroom(String name) {
        this.name = name;
    }

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

    public String getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public String getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Review[] getReviews() {
		return reviews;
	}

	public void setReviews(Review[] reviews) {
		this.reviews = reviews;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
    public String toString() {
        return "Bathroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}