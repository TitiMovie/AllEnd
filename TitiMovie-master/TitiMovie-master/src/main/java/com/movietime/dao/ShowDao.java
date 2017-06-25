package com.movietime.dao;

import com.movietime.entity.Show;

import java.util.List;

public interface ShowDao {

    public Show findOne(long showId);
    public List<Show> findAll();
    public List<Show> findByMovie(long movieId);
    public List<Show> findByTheaterId(long theaterId);
}
