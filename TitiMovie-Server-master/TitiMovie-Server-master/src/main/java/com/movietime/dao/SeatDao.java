package com.movietime.dao;

import com.movietime.entity.Seat;

import java.util.List;

public interface SeatDao {

    public void update(Seat seat);
    public boolean occupied(Seat seat);
    public List<Seat> findAllBooked(long id);
}