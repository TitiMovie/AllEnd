package com.movietime.service;

import com.movietime.dao.SeatDao;
import com.movietime.dao.ShowDao;
import com.movietime.entity.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowDao showDao;
    @Autowired
    SeatDao seatDao;

    public Show findOne(long showId) {
        return showDao.findOne(showId);
    }

    public List<Show> findAll() {
        return showDao.findAll();
    }

    public List<Show> findByMovie(long movieId) {
        return showDao.findByMovie(movieId);
    }
}
