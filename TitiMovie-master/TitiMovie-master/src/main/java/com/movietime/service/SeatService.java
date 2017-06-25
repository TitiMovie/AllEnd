package com.movietime.service;

import com.movietime.entity.Seat;

import java.util.List;

public interface SeatService {

    public String[] getSeatMap(long showId);
    public String[] getSoldSeat(long showId);
    public boolean book(List<Seat> seatList);
}
