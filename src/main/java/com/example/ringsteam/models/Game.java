package com.example.ringsteam.models;

import jakarta.persistence.*;

@Entity
@Table(name ="game")
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String title;
    private String year;
    private double rating;
    private double cost;

    public Game() {

    }

    public Game(String title, String year, double rating, double cost) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
