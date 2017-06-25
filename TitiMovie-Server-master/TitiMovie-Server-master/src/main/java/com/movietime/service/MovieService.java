package com.movietime.service;

import com.movietime.entity.Movie;

import java.util.List;

public interface MovieService {

    public Movie findOne(long id);
    public List<Movie> findAll();
    public List<Movie> findByTagName(String tagName);
}
