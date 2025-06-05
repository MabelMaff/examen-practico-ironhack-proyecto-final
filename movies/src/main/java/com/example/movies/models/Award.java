package com.example.movies.models;

import jakarta.persistence.*;

@Entity
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int year;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Award() {}

    public Award(String name, int year, Movie movie) {
        this.name = name;
        this.year = year;
        this.movie = movie;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
