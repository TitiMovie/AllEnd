package com.movietime.service;

import com.movietime.entity.Show;

import java.util.List;

public interface ShowService {

    public Show findOne(long showId);
    public List<Show> findAll();
    public List<Show> findByMovie(long movieId);
}
