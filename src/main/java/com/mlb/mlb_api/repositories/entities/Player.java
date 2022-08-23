package com.mlb.mlb_api.repositories.entities;

import javax.persistence.*;


@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    private String name;
    private Integer age;
    @Column(name = "years_of_experience")
    private Double yearsOfExperience;
    private Double rating;

    public Player() {
    }

    public Player(String name, Integer age, double yearsOfExperience, double rating) {
        this.name = name;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
